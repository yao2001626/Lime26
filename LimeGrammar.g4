grammar LimeGrammar;
@header {
    package lime.antlr4;
}
tokens {
    INDENT, DEDENT
}
@lexer::members {
  // A queue where extra tokens are pushed on (see the NEWLINE lexer rule).
  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
  // The stack that keeps track of the indentation level.
  private java.util.Stack<Integer> indents = new java.util.Stack<>();
  // The amount of opened braces, brackets and parenthesis.
  private int opened = 0;
  // The most recently produced token.
  private Token lastToken = null;
  @Override
  public void emit(Token t) {
    super.setToken(t);
    tokens.offer(t);
  }	
  @Override
  public Token nextToken() {
    // Check if the end-of-file is ahead and there are still some DEDENTS expected.
    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
      // Remove any trailing EOF tokens from our buffer.
      for (int i = tokens.size() - 1; i >= 0; i--) {
        if (tokens.get(i).getType() == EOF) {
          tokens.remove(i);
        }
      }
      // First emit an extra line break that serves as the end of the statement.
      this.emit(commonToken(LimeGrammarParser.NEWLINE, "\n"));

      // Now emit as much DEDENT tokens as needed.
      while (!indents.isEmpty()) {
        this.emit(createDedent());
        indents.pop();
      }
      // Put the EOF back on the token stream.
      this.emit(commonToken(LimeGrammarParser.EOF, "<EOF>"));
    }
    Token next = super.nextToken();

    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
      // Keep track of the last token on the default channel.
      this.lastToken = next;
    }
    return tokens.isEmpty() ? next : tokens.poll();
  }
  private Token createDedent() {
    CommonToken dedent = commonToken(LimeGrammarParser.DEDENT, "");
    dedent.setLine(this.lastToken.getLine());
    return dedent;
  }
  private CommonToken commonToken(int type, String text) {
    int stop = this.getCharIndex() - 1;
    int start = text.isEmpty() ? stop : stop - text.length() + 1;
    return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
  }
  // Calculates the indentation of the provided spaces, taking the
  // following rules into account:
  //
  // "Tabs are replaced (from left to right) by one to eight spaces
  //  such that the total number of characters up to and including
  //  the replacement is a multiple of eight [...]"
  //
  //  -- https://docs.python.org/3.1/reference/lexical_analysis.html#indentation
  static int getIndentationCount(String spaces) {
    int count = 0;
    for (char ch : spaces.toCharArray()) {
      switch (ch) {
        case '\t':
          count += 4 - (count % 4);
          break;
        default:
          // A normal space char.
          count++;
      }
    }
    return count;
  }
  boolean atStartOfInput() {
    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
  }
}
//Lime parser
compilationUnit
    : importStmts classDecls EOF ;
importStmts 
	: importstmt*; 
importstmt
	: 'import' ID'(' type_list ')' (':' type)? NEWLINE; 
classDecls
	: classDecl*;
classDecl returns [Scope scope]
	: 'class' ID NEWLINE INDENT classMember* DEDENT ;
classMember 
	: fieldDecl | initDecl | methodDecl | actionDecl ;	
fieldDecl 
	: 'var' id_list ':' type NEWLINE ;
initDecl returns [Scope scope]
	: 'init' parameters block;
methodDecl returns [Scope scope]
	: 'method' ID  parameters (':' type)?  (NEWLINE INDENT 'when' guard 'do')? block (DEDENT)?; 
actionDecl returns [Scope scope]
	: 'action' ID  (NEWLINE INDENT 'when' guard 'do')? block (DEDENT)? ;
parameters
	: '(' typeparslist? ')' ;
typeparslist
	: parsdef (',' parsdef)* ;
parsdef
	: id_list ':' type ;
type returns [Type typ]
	: 'int' | 'bool' | 'void' | ID | arrayDecl;
arrayDecl returns [ArrayType typ]
	:'array' 'of' ty=('int' | 'bool' | ID);
type_list
	: type (',' type)* ;
stmt
	: simple_stmt | compound_stmt ;
simple_stmt
	: small_stmt (';' small_stmt)* (';')? NEWLINE ;
small_stmt
	: multi_assign | expr_stmt | localDecl | return_stmt | method_call;
multi_assign
	: id_list ':=' expr_list;
single_assign
	: ID ':=' expr;
compound_stmt
	: if_stmt | while_stmt | for_stmt;
localDecl 
	: 'var' id_list ':' type ;
expr_stmt
	: src=expr_list;
if_stmt
 	: if_stat elif_stat* else_stat?;
if_stat
 	: 'if' expr 'then' block;
elif_stat
 	: 'elif' expr 'then' block ;
else_stat
 	: 'else' block;
while_stmt
	: 'while' expr 'do' block ; 
for_stmt
	: 'for' single_assign 'to' expr 'do' block;
return_stmt
	: 'return' (expr)? ;
block
	: simple_stmt | NEWLINE INDENT stmt+ DEDENT ;
guard 
	: '(' guard ')'												#guardparen
	| 'not' guard								   				#guardatomnot
	| guard op=( '>=' | '<=' | '>' | '<' | '=' | '!=') guard   	#guardcompexpr
	| guard 'and' guard                          				#guardandexpr
	| guard 'or' guard                          				#guardorexpr
	| ID 									   					#guardatomid
	| INTEGER 								   					#guardatomint
	;

id_list
	: id_ele (',' id_ele)* ;
id_ele
	: ID selector? ;	
expr_list
	: expr (',' expr)* ;
expr
	: '(' expr ')'							   #parenexpr
	| '-' expr                                 #unaryMinusexpr
	| 'not' expr                               #notexpr
	| expr op=( '*' | '/' | '%' ) expr         #multexpr
	| expr op=( '+' | '-' ) expr               #addexpr
	| expr op=( '>=' | '<=' | '>' | '<' ) expr #compexpr
	| expr op=( '=' | '!=' ) expr              #eqexpr
	| expr 'and' expr                          #andexpr
	| expr 'or' expr                           #orexpr
	| atom									   #atomexpr
	;
atom
	:  INTEGER | True | False | Null | ID | method_call | arrayCreate | arrayElement;	
method_call
	: 'new' n=ID args 						   #newcall
	| c=ID '.' m=ID args 					   #methodcall
	| arrayElement '.' m=ID args			   #arrayElementmethodcall
	| 'print' args 			   		   		   #print
	| 'getRand'  args						   #getRand
	| 'setRand'  args						   #setRand
	| 'getArg' args 		   		   		   #getArg
	| ID args 								   #userDefined
	;
arrayCreate
	: 'new' ty=('int' | 'bool' | ID) selector;
arrayElement
	: ID selector;	
selector
	: '[' expr ']';
args
	: '(' expr_list? ')';

/*
 * lime lexer rules
 */

Class 			: 'class';
Method   		: 'method';
Action			: 'action';
Var				: 'var';
Init			: 'init';
New      		: 'new';
When     		: 'when';
Do  			: 'do';
If       		: 'if';
Else     		: 'else';
Elif			: 'elif';
Then     		: 'then';
While    		: 'while';
Return   		: 'return';

Null    		: 'nil';
Booltype		: 'bool';
Inttype			: 'int';
Voidtype		: 'void';
True			: 'true';
False			: 'false';

Assign   : ':=';
Or       : 'or';
And      : 'and';
Equals   : '==';
NEquals  : '!=';
GTEquals : '>=';
LTEquals : '<=';

GT       : '>';
LT       : '<';
Add      : '+';
Subtract : '-';
Multiply : '*';
Divide   : '/';
Modulus  : '%';

OBrace   : '{' {opened++;};
CBrace   : '}' {opened--;};
OBracket : '[' {opened++;};
CBracket : ']' {opened--;};
OParen   : '(' {opened++;};
CParen   : ')' {opened--;};

fragment SPACES
 	: [ \t]+ ;
NEWLINE
 : ( {atStartOfInput()}?   SPACES
   | ( '\r'? '\n' | '\r' | '\f' ) SPACES?
   )
   {
     String newLine = getText().replaceAll("[^\r\n\f]+", "");
     String spaces = getText().replaceAll("[\r\n\f]+", "");
     int next = _input.LA(1);
     if (opened > 0 || next == '\r' || next == '\n' || next == '\f' || next == '#') {
       // If we're inside a list or on a blank line, ignore all indents, 
       // dedents and line breaks.
       skip();
     }
     else {
       emit(commonToken(NEWLINE, newLine));
       int indent = getIndentationCount(spaces);
       int previous = indents.isEmpty() ? 0 : indents.peek();
       if (indent == previous) {
         // skip indents of the same size as the present indent-size
         skip();
       }
       else if (indent > previous) {
         indents.push(indent);
         emit(commonToken(LimeGrammarParser.INDENT, spaces));
       }
       else {
         // Possibly emit more than 1 DEDENT token.
         while(!indents.isEmpty() && indents.peek() > indent) {
           this.emit(createDedent());
           indents.pop();
         }
       }
     }
   }
;

SKIP_
	: ( SPACES| COMMENT | LINE_JOINING) -> skip ;
fragment LINE_JOINING
 	: '\\' SPACES? ( '\r'? '\n' | '\r' | '\f') ;
ID
	: LETTER (LETTER|'0'..'9')* ;
fragment
LETTER
	: 'A'..'Z' | 'a'..'z' | '_' ;
INTEGER 
	: '0'..'9'+ ;
	
fragment COMMENT
 : '#' ~[\r\n\f]* ;
