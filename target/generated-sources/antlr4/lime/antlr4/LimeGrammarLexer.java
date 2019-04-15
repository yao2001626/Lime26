// Generated from LimeGrammar.g4 by ANTLR 4.4

    package lime.antlr4;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LimeGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, Class=16, Method=17, 
		Action=18, Var=19, Init=20, New=21, When=22, Do=23, If=24, Else=25, Elif=26, 
		Then=27, While=28, Return=29, Null=30, Booltype=31, Inttype=32, Voidtype=33, 
		True=34, False=35, Assign=36, Or=37, And=38, Equals=39, NEquals=40, GTEquals=41, 
		LTEquals=42, GT=43, LT=44, Add=45, Subtract=46, Multiply=47, Divide=48, 
		Modulus=49, OBrace=50, CBrace=51, OBracket=52, CBracket=53, OParen=54, 
		CParen=55, NEWLINE=56, SKIP_=57, ID=58, INTEGER=59;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Class", "Method", "Action", 
		"Var", "Init", "New", "When", "Do", "If", "Else", "Elif", "Then", "While", 
		"Return", "Null", "Booltype", "Inttype", "Voidtype", "True", "False", 
		"Assign", "Or", "And", "Equals", "NEquals", "GTEquals", "LTEquals", "GT", 
		"LT", "Add", "Subtract", "Multiply", "Divide", "Modulus", "OBrace", "CBrace", 
		"OBracket", "CBracket", "OParen", "CParen", "SPACES", "NEWLINE", "SKIP_", 
		"LINE_JOINING", "ID", "LETTER", "INTEGER", "COMMENT"
	};


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


	public LimeGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LimeGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 49: OBrace_action((RuleContext)_localctx, actionIndex); break;
		case 50: CBrace_action((RuleContext)_localctx, actionIndex); break;
		case 51: OBracket_action((RuleContext)_localctx, actionIndex); break;
		case 52: CBracket_action((RuleContext)_localctx, actionIndex); break;
		case 53: OParen_action((RuleContext)_localctx, actionIndex); break;
		case 54: CParen_action((RuleContext)_localctx, actionIndex); break;
		case 56: NEWLINE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void OBrace_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: opened++; break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: 
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
		    break;
		}
	}
	private void CBrace_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: opened--; break;
		}
	}
	private void CBracket_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: opened--; break;
		}
	}
	private void CParen_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: opened--; break;
		}
	}
	private void OBracket_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: opened++; break;
		}
	}
	private void OParen_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: opened++; break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 56: return NEWLINE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean NEWLINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return atStartOfInput();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2=\u019b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%"+
		"\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3"+
		",\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\6"+
		"9\u0160\n9\r9\169\u0161\3:\3:\3:\5:\u0167\n:\3:\3:\5:\u016b\n:\3:\5:\u016e"+
		"\n:\5:\u0170\n:\3:\3:\3;\3;\3;\5;\u0177\n;\3;\3;\3<\3<\5<\u017d\n<\3<"+
		"\5<\u0180\n<\3<\3<\5<\u0184\n<\3=\3=\3=\7=\u0189\n=\f=\16=\u018c\13=\3"+
		">\3>\3?\6?\u0191\n?\r?\16?\u0192\3@\3@\7@\u0197\n@\f@\16@\u019a\13@\2"+
		"\2A\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q\2s:u;w\2y<{\2}=\177\2\3\2\5\4\2\13\13\"\"\5\2C\\aac|\4\2\f\f\16"+
		"\17\u01a4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2y\3\2\2\2\2}\3\2\2\2\3\u0081"+
		"\3\2\2\2\5\u0083\3\2\2\2\7\u0087\3\2\2\2\t\u008f\3\2\2\2\13\u0091\3\2"+
		"\2\2\r\u0098\3\2\2\2\17\u009e\3\2\2\2\21\u00a1\3\2\2\2\23\u00a3\3\2\2"+
		"\2\25\u00a9\3\2\2\2\27\u00ab\3\2\2\2\31\u00ae\3\2\2\2\33\u00b0\3\2\2\2"+
		"\35\u00b8\3\2\2\2\37\u00bc\3\2\2\2!\u00c3\3\2\2\2#\u00c9\3\2\2\2%\u00d0"+
		"\3\2\2\2\'\u00d7\3\2\2\2)\u00db\3\2\2\2+\u00e0\3\2\2\2-\u00e4\3\2\2\2"+
		"/\u00e9\3\2\2\2\61\u00ec\3\2\2\2\63\u00ef\3\2\2\2\65\u00f4\3\2\2\2\67"+
		"\u00f9\3\2\2\29\u00fe\3\2\2\2;\u0104\3\2\2\2=\u010b\3\2\2\2?\u010f\3\2"+
		"\2\2A\u0114\3\2\2\2C\u0118\3\2\2\2E\u011d\3\2\2\2G\u0122\3\2\2\2I\u0128"+
		"\3\2\2\2K\u012b\3\2\2\2M\u012e\3\2\2\2O\u0132\3\2\2\2Q\u0135\3\2\2\2S"+
		"\u0138\3\2\2\2U\u013b\3\2\2\2W\u013e\3\2\2\2Y\u0140\3\2\2\2[\u0142\3\2"+
		"\2\2]\u0144\3\2\2\2_\u0146\3\2\2\2a\u0148\3\2\2\2c\u014a\3\2\2\2e\u014c"+
		"\3\2\2\2g\u014f\3\2\2\2i\u0152\3\2\2\2k\u0155\3\2\2\2m\u0158\3\2\2\2o"+
		"\u015b\3\2\2\2q\u015f\3\2\2\2s\u016f\3\2\2\2u\u0176\3\2\2\2w\u017a\3\2"+
		"\2\2y\u0185\3\2\2\2{\u018d\3\2\2\2}\u0190\3\2\2\2\177\u0194\3\2\2\2\u0081"+
		"\u0082\7?\2\2\u0082\4\3\2\2\2\u0083\u0084\7h\2\2\u0084\u0085\7q\2\2\u0085"+
		"\u0086\7t\2\2\u0086\6\3\2\2\2\u0087\u0088\7i\2\2\u0088\u0089\7g\2\2\u0089"+
		"\u008a\7v\2\2\u008a\u008b\7T\2\2\u008b\u008c\7c\2\2\u008c\u008d\7p\2\2"+
		"\u008d\u008e\7f\2\2\u008e\b\3\2\2\2\u008f\u0090\7.\2\2\u0090\n\3\2\2\2"+
		"\u0091\u0092\7i\2\2\u0092\u0093\7g\2\2\u0093\u0094\7v\2\2\u0094\u0095"+
		"\7C\2\2\u0095\u0096\7t\2\2\u0096\u0097\7i\2\2\u0097\f\3\2\2\2\u0098\u0099"+
		"\7c\2\2\u0099\u009a\7t\2\2\u009a\u009b\7t\2\2\u009b\u009c\7c\2\2\u009c"+
		"\u009d\7{\2\2\u009d\16\3\2\2\2\u009e\u009f\7q\2\2\u009f\u00a0\7h\2\2\u00a0"+
		"\20\3\2\2\2\u00a1\u00a2\7=\2\2\u00a2\22\3\2\2\2\u00a3\u00a4\7r\2\2\u00a4"+
		"\u00a5\7t\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7p\2\2\u00a7\u00a8\7v\2\2"+
		"\u00a8\24\3\2\2\2\u00a9\u00aa\7\60\2\2\u00aa\26\3\2\2\2\u00ab\u00ac\7"+
		"v\2\2\u00ac\u00ad\7q\2\2\u00ad\30\3\2\2\2\u00ae\u00af\7<\2\2\u00af\32"+
		"\3\2\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7v\2\2\u00b3"+
		"\u00b4\7T\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6\7p\2\2\u00b6\u00b7\7f\2\2"+
		"\u00b7\34\3\2\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7"+
		"v\2\2\u00bb\36\3\2\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7o\2\2\u00be\u00bf"+
		"\7r\2\2\u00bf\u00c0\7q\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7v\2\2\u00c2"+
		" \3\2\2\2\u00c3\u00c4\7e\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7c\2\2\u00c6"+
		"\u00c7\7u\2\2\u00c7\u00c8\7u\2\2\u00c8\"\3\2\2\2\u00c9\u00ca\7o\2\2\u00ca"+
		"\u00cb\7g\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7j\2\2\u00cd\u00ce\7q\2\2"+
		"\u00ce\u00cf\7f\2\2\u00cf$\3\2\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7e\2"+
		"\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6"+
		"\7p\2\2\u00d6&\3\2\2\2\u00d7\u00d8\7x\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da"+
		"\7t\2\2\u00da(\3\2\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7p\2\2\u00dd\u00de"+
		"\7k\2\2\u00de\u00df\7v\2\2\u00df*\3\2\2\2\u00e0\u00e1\7p\2\2\u00e1\u00e2"+
		"\7g\2\2\u00e2\u00e3\7y\2\2\u00e3,\3\2\2\2\u00e4\u00e5\7y\2\2\u00e5\u00e6"+
		"\7j\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8\7p\2\2\u00e8.\3\2\2\2\u00e9\u00ea"+
		"\7f\2\2\u00ea\u00eb\7q\2\2\u00eb\60\3\2\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee"+
		"\7h\2\2\u00ee\62\3\2\2\2\u00ef\u00f0\7g\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2"+
		"\7u\2\2\u00f2\u00f3\7g\2\2\u00f3\64\3\2\2\2\u00f4\u00f5\7g\2\2\u00f5\u00f6"+
		"\7n\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7h\2\2\u00f8\66\3\2\2\2\u00f9\u00fa"+
		"\7v\2\2\u00fa\u00fb\7j\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7p\2\2\u00fd"+
		"8\3\2\2\2\u00fe\u00ff\7y\2\2\u00ff\u0100\7j\2\2\u0100\u0101\7k\2\2\u0101"+
		"\u0102\7n\2\2\u0102\u0103\7g\2\2\u0103:\3\2\2\2\u0104\u0105\7t\2\2\u0105"+
		"\u0106\7g\2\2\u0106\u0107\7v\2\2\u0107\u0108\7w\2\2\u0108\u0109\7t\2\2"+
		"\u0109\u010a\7p\2\2\u010a<\3\2\2\2\u010b\u010c\7p\2\2\u010c\u010d\7k\2"+
		"\2\u010d\u010e\7n\2\2\u010e>\3\2\2\2\u010f\u0110\7d\2\2\u0110\u0111\7"+
		"q\2\2\u0111\u0112\7q\2\2\u0112\u0113\7n\2\2\u0113@\3\2\2\2\u0114\u0115"+
		"\7k\2\2\u0115\u0116\7p\2\2\u0116\u0117\7v\2\2\u0117B\3\2\2\2\u0118\u0119"+
		"\7x\2\2\u0119\u011a\7q\2\2\u011a\u011b\7k\2\2\u011b\u011c\7f\2\2\u011c"+
		"D\3\2\2\2\u011d\u011e\7v\2\2\u011e\u011f\7t\2\2\u011f\u0120\7w\2\2\u0120"+
		"\u0121\7g\2\2\u0121F\3\2\2\2\u0122\u0123\7h\2\2\u0123\u0124\7c\2\2\u0124"+
		"\u0125\7n\2\2\u0125\u0126\7u\2\2\u0126\u0127\7g\2\2\u0127H\3\2\2\2\u0128"+
		"\u0129\7<\2\2\u0129\u012a\7?\2\2\u012aJ\3\2\2\2\u012b\u012c\7q\2\2\u012c"+
		"\u012d\7t\2\2\u012dL\3\2\2\2\u012e\u012f\7c\2\2\u012f\u0130\7p\2\2\u0130"+
		"\u0131\7f\2\2\u0131N\3\2\2\2\u0132\u0133\7?\2\2\u0133\u0134\7?\2\2\u0134"+
		"P\3\2\2\2\u0135\u0136\7#\2\2\u0136\u0137\7?\2\2\u0137R\3\2\2\2\u0138\u0139"+
		"\7@\2\2\u0139\u013a\7?\2\2\u013aT\3\2\2\2\u013b\u013c\7>\2\2\u013c\u013d"+
		"\7?\2\2\u013dV\3\2\2\2\u013e\u013f\7@\2\2\u013fX\3\2\2\2\u0140\u0141\7"+
		">\2\2\u0141Z\3\2\2\2\u0142\u0143\7-\2\2\u0143\\\3\2\2\2\u0144\u0145\7"+
		"/\2\2\u0145^\3\2\2\2\u0146\u0147\7,\2\2\u0147`\3\2\2\2\u0148\u0149\7\61"+
		"\2\2\u0149b\3\2\2\2\u014a\u014b\7\'\2\2\u014bd\3\2\2\2\u014c\u014d\7}"+
		"\2\2\u014d\u014e\b\63\2\2\u014ef\3\2\2\2\u014f\u0150\7\177\2\2\u0150\u0151"+
		"\b\64\3\2\u0151h\3\2\2\2\u0152\u0153\7]\2\2\u0153\u0154\b\65\4\2\u0154"+
		"j\3\2\2\2\u0155\u0156\7_\2\2\u0156\u0157\b\66\5\2\u0157l\3\2\2\2\u0158"+
		"\u0159\7*\2\2\u0159\u015a\b\67\6\2\u015an\3\2\2\2\u015b\u015c\7+\2\2\u015c"+
		"\u015d\b8\7\2\u015dp\3\2\2\2\u015e\u0160\t\2\2\2\u015f\u015e\3\2\2\2\u0160"+
		"\u0161\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162r\3\2\2\2"+
		"\u0163\u0164\6:\2\2\u0164\u0170\5q9\2\u0165\u0167\7\17\2\2\u0166\u0165"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016b\7\f\2\2\u0169"+
		"\u016b\4\16\17\2\u016a\u0166\3\2\2\2\u016a\u0169\3\2\2\2\u016b\u016d\3"+
		"\2\2\2\u016c\u016e\5q9\2\u016d\u016c\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\u0170\3\2\2\2\u016f\u0163\3\2\2\2\u016f\u016a\3\2\2\2\u0170\u0171\3\2"+
		"\2\2\u0171\u0172\b:\b\2\u0172t\3\2\2\2\u0173\u0177\5q9\2\u0174\u0177\5"+
		"\177@\2\u0175\u0177\5w<\2\u0176\u0173\3\2\2\2\u0176\u0174\3\2\2\2\u0176"+
		"\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\b;\t\2\u0179v\3\2\2\2\u017a"+
		"\u017c\7^\2\2\u017b\u017d\5q9\2\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2"+
		"\2\u017d\u0183\3\2\2\2\u017e\u0180\7\17\2\2\u017f\u017e\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0184\7\f\2\2\u0182\u0184\4\16"+
		"\17\2\u0183\u017f\3\2\2\2\u0183\u0182\3\2\2\2\u0184x\3\2\2\2\u0185\u018a"+
		"\5{>\2\u0186\u0189\5{>\2\u0187\u0189\4\62;\2\u0188\u0186\3\2\2\2\u0188"+
		"\u0187\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2"+
		"\2\2\u018bz\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u018e\t\3\2\2\u018e|\3\2"+
		"\2\2\u018f\u0191\4\62;\2\u0190\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193~\3\2\2\2\u0194\u0198\7%\2\2\u0195"+
		"\u0197\n\4\2\2\u0196\u0195\3\2\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2"+
		"\2\2\u0198\u0199\3\2\2\2\u0199\u0080\3\2\2\2\u019a\u0198\3\2\2\2\20\2"+
		"\u0161\u0166\u016a\u016d\u016f\u0176\u017c\u017f\u0183\u0188\u018a\u0192"+
		"\u0198\n\3\63\2\3\64\3\3\65\4\3\66\5\3\67\6\38\7\3:\b\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}