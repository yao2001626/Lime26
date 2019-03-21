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
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, Class=7, Method=8, Action=9, 
		Var=10, Init=11, New=12, When=13, Do=14, If=15, Else=16, Elif=17, Then=18, 
		While=19, Return=20, Null=21, Booltype=22, Inttype=23, Voidtype=24, True=25, 
		False=26, Assign=27, Or=28, And=29, Equals=30, NEquals=31, GTEquals=32, 
		LTEquals=33, GT=34, LT=35, Add=36, Subtract=37, Multiply=38, Divide=39, 
		Modulus=40, OBrace=41, CBrace=42, OBracket=43, CBracket=44, OParen=45, 
		CParen=46, NEWLINE=47, SKIP_=48, ID=49, INTEGER=50;
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
		"'2'"
	};
	public static final String[] ruleNames = {
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
		case 40: OBrace_action((RuleContext)_localctx, actionIndex); break;
		case 41: CBrace_action((RuleContext)_localctx, actionIndex); break;
		case 42: OBracket_action((RuleContext)_localctx, actionIndex); break;
		case 43: CBracket_action((RuleContext)_localctx, actionIndex); break;
		case 44: OParen_action((RuleContext)_localctx, actionIndex); break;
		case 45: CParen_action((RuleContext)_localctx, actionIndex); break;
		case 47: NEWLINE_action((RuleContext)_localctx, actionIndex); break;
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
		case 47: return NEWLINE_sempred((RuleContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\64\u0155\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3"+
		"(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\6\60"+
		"\u011a\n\60\r\60\16\60\u011b\3\61\3\61\3\61\5\61\u0121\n\61\3\61\3\61"+
		"\5\61\u0125\n\61\3\61\5\61\u0128\n\61\5\61\u012a\n\61\3\61\3\61\3\62\3"+
		"\62\3\62\5\62\u0131\n\62\3\62\3\62\3\63\3\63\5\63\u0137\n\63\3\63\5\63"+
		"\u013a\n\63\3\63\3\63\5\63\u013e\n\63\3\64\3\64\3\64\7\64\u0143\n\64\f"+
		"\64\16\64\u0146\13\64\3\65\3\65\3\66\6\66\u014b\n\66\r\66\16\66\u014c"+
		"\3\67\3\67\7\67\u0151\n\67\f\67\16\67\u0154\13\67\2\28\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)Q*S+U,W-Y.[/]\60_\2a\61c\62e\2g\63i\2k\64m\2\3\2\5\4\2\13\13\"\""+
		"\5\2C\\aac|\4\2\f\f\16\17\u015e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2g\3\2\2\2\2k\3\2\2\2\3o\3\2\2\2"+
		"\5q\3\2\2\2\7s\3\2\2\2\tu\3\2\2\2\13w\3\2\2\2\ry\3\2\2\2\17}\3\2\2\2\21"+
		"\u0083\3\2\2\2\23\u008a\3\2\2\2\25\u0091\3\2\2\2\27\u0095\3\2\2\2\31\u009a"+
		"\3\2\2\2\33\u009e\3\2\2\2\35\u00a3\3\2\2\2\37\u00a6\3\2\2\2!\u00a9\3\2"+
		"\2\2#\u00ae\3\2\2\2%\u00b3\3\2\2\2\'\u00b8\3\2\2\2)\u00be\3\2\2\2+\u00c5"+
		"\3\2\2\2-\u00c9\3\2\2\2/\u00ce\3\2\2\2\61\u00d2\3\2\2\2\63\u00d7\3\2\2"+
		"\2\65\u00dc\3\2\2\2\67\u00e2\3\2\2\29\u00e5\3\2\2\2;\u00e8\3\2\2\2=\u00ec"+
		"\3\2\2\2?\u00ef\3\2\2\2A\u00f2\3\2\2\2C\u00f5\3\2\2\2E\u00f8\3\2\2\2G"+
		"\u00fa\3\2\2\2I\u00fc\3\2\2\2K\u00fe\3\2\2\2M\u0100\3\2\2\2O\u0102\3\2"+
		"\2\2Q\u0104\3\2\2\2S\u0106\3\2\2\2U\u0109\3\2\2\2W\u010c\3\2\2\2Y\u010f"+
		"\3\2\2\2[\u0112\3\2\2\2]\u0115\3\2\2\2_\u0119\3\2\2\2a\u0129\3\2\2\2c"+
		"\u0130\3\2\2\2e\u0134\3\2\2\2g\u013f\3\2\2\2i\u0147\3\2\2\2k\u014a\3\2"+
		"\2\2m\u014e\3\2\2\2op\7=\2\2p\4\3\2\2\2qr\7?\2\2r\6\3\2\2\2st\7.\2\2t"+
		"\b\3\2\2\2uv\7\60\2\2v\n\3\2\2\2wx\7<\2\2x\f\3\2\2\2yz\7p\2\2z{\7q\2\2"+
		"{|\7v\2\2|\16\3\2\2\2}~\7e\2\2~\177\7n\2\2\177\u0080\7c\2\2\u0080\u0081"+
		"\7u\2\2\u0081\u0082\7u\2\2\u0082\20\3\2\2\2\u0083\u0084\7o\2\2\u0084\u0085"+
		"\7g\2\2\u0085\u0086\7v\2\2\u0086\u0087\7j\2\2\u0087\u0088\7q\2\2\u0088"+
		"\u0089\7f\2\2\u0089\22\3\2\2\2\u008a\u008b\7c\2\2\u008b\u008c\7e\2\2\u008c"+
		"\u008d\7v\2\2\u008d\u008e\7k\2\2\u008e\u008f\7q\2\2\u008f\u0090\7p\2\2"+
		"\u0090\24\3\2\2\2\u0091\u0092\7x\2\2\u0092\u0093\7c\2\2\u0093\u0094\7"+
		"t\2\2\u0094\26\3\2\2\2\u0095\u0096\7k\2\2\u0096\u0097\7p\2\2\u0097\u0098"+
		"\7k\2\2\u0098\u0099\7v\2\2\u0099\30\3\2\2\2\u009a\u009b\7p\2\2\u009b\u009c"+
		"\7g\2\2\u009c\u009d\7y\2\2\u009d\32\3\2\2\2\u009e\u009f\7y\2\2\u009f\u00a0"+
		"\7j\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7p\2\2\u00a2\34\3\2\2\2\u00a3\u00a4"+
		"\7f\2\2\u00a4\u00a5\7q\2\2\u00a5\36\3\2\2\2\u00a6\u00a7\7k\2\2\u00a7\u00a8"+
		"\7h\2\2\u00a8 \3\2\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac"+
		"\7u\2\2\u00ac\u00ad\7g\2\2\u00ad\"\3\2\2\2\u00ae\u00af\7g\2\2\u00af\u00b0"+
		"\7n\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7h\2\2\u00b2$\3\2\2\2\u00b3\u00b4"+
		"\7v\2\2\u00b4\u00b5\7j\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7p\2\2\u00b7"+
		"&\3\2\2\2\u00b8\u00b9\7y\2\2\u00b9\u00ba\7j\2\2\u00ba\u00bb\7k\2\2\u00bb"+
		"\u00bc\7n\2\2\u00bc\u00bd\7g\2\2\u00bd(\3\2\2\2\u00be\u00bf\7t\2\2\u00bf"+
		"\u00c0\7g\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7w\2\2\u00c2\u00c3\7t\2\2"+
		"\u00c3\u00c4\7p\2\2\u00c4*\3\2\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7k\2"+
		"\2\u00c7\u00c8\7n\2\2\u00c8,\3\2\2\2\u00c9\u00ca\7d\2\2\u00ca\u00cb\7"+
		"q\2\2\u00cb\u00cc\7q\2\2\u00cc\u00cd\7n\2\2\u00cd.\3\2\2\2\u00ce\u00cf"+
		"\7k\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7v\2\2\u00d1\60\3\2\2\2\u00d2\u00d3"+
		"\7x\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6\7f\2\2\u00d6"+
		"\62\3\2\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da\7w\2\2\u00da"+
		"\u00db\7g\2\2\u00db\64\3\2\2\2\u00dc\u00dd\7h\2\2\u00dd\u00de\7c\2\2\u00de"+
		"\u00df\7n\2\2\u00df\u00e0\7u\2\2\u00e0\u00e1\7g\2\2\u00e1\66\3\2\2\2\u00e2"+
		"\u00e3\7<\2\2\u00e3\u00e4\7?\2\2\u00e48\3\2\2\2\u00e5\u00e6\7q\2\2\u00e6"+
		"\u00e7\7t\2\2\u00e7:\3\2\2\2\u00e8\u00e9\7c\2\2\u00e9\u00ea\7p\2\2\u00ea"+
		"\u00eb\7f\2\2\u00eb<\3\2\2\2\u00ec\u00ed\7?\2\2\u00ed\u00ee\7?\2\2\u00ee"+
		">\3\2\2\2\u00ef\u00f0\7#\2\2\u00f0\u00f1\7?\2\2\u00f1@\3\2\2\2\u00f2\u00f3"+
		"\7@\2\2\u00f3\u00f4\7?\2\2\u00f4B\3\2\2\2\u00f5\u00f6\7>\2\2\u00f6\u00f7"+
		"\7?\2\2\u00f7D\3\2\2\2\u00f8\u00f9\7@\2\2\u00f9F\3\2\2\2\u00fa\u00fb\7"+
		">\2\2\u00fbH\3\2\2\2\u00fc\u00fd\7-\2\2\u00fdJ\3\2\2\2\u00fe\u00ff\7/"+
		"\2\2\u00ffL\3\2\2\2\u0100\u0101\7,\2\2\u0101N\3\2\2\2\u0102\u0103\7\61"+
		"\2\2\u0103P\3\2\2\2\u0104\u0105\7\'\2\2\u0105R\3\2\2\2\u0106\u0107\7}"+
		"\2\2\u0107\u0108\b*\2\2\u0108T\3\2\2\2\u0109\u010a\7\177\2\2\u010a\u010b"+
		"\b+\3\2\u010bV\3\2\2\2\u010c\u010d\7]\2\2\u010d\u010e\b,\4\2\u010eX\3"+
		"\2\2\2\u010f\u0110\7_\2\2\u0110\u0111\b-\5\2\u0111Z\3\2\2\2\u0112\u0113"+
		"\7*\2\2\u0113\u0114\b.\6\2\u0114\\\3\2\2\2\u0115\u0116\7+\2\2\u0116\u0117"+
		"\b/\7\2\u0117^\3\2\2\2\u0118\u011a\t\2\2\2\u0119\u0118\3\2\2\2\u011a\u011b"+
		"\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c`\3\2\2\2\u011d"+
		"\u011e\6\61\2\2\u011e\u012a\5_\60\2\u011f\u0121\7\17\2\2\u0120\u011f\3"+
		"\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0125\7\f\2\2\u0123"+
		"\u0125\4\16\17\2\u0124\u0120\3\2\2\2\u0124\u0123\3\2\2\2\u0125\u0127\3"+
		"\2\2\2\u0126\u0128\5_\60\2\u0127\u0126\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\u012a\3\2\2\2\u0129\u011d\3\2\2\2\u0129\u0124\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\u012c\b\61\b\2\u012cb\3\2\2\2\u012d\u0131\5_\60\2\u012e\u0131"+
		"\5m\67\2\u012f\u0131\5e\63\2\u0130\u012d\3\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\b\62\t\2\u0133d\3\2\2\2"+
		"\u0134\u0136\7^\2\2\u0135\u0137\5_\60\2\u0136\u0135\3\2\2\2\u0136\u0137"+
		"\3\2\2\2\u0137\u013d\3\2\2\2\u0138\u013a\7\17\2\2\u0139\u0138\3\2\2\2"+
		"\u0139\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013e\7\f\2\2\u013c\u013e"+
		"\4\16\17\2\u013d\u0139\3\2\2\2\u013d\u013c\3\2\2\2\u013ef\3\2\2\2\u013f"+
		"\u0144\5i\65\2\u0140\u0143\5i\65\2\u0141\u0143\4\62;\2\u0142\u0140\3\2"+
		"\2\2\u0142\u0141\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144"+
		"\u0145\3\2\2\2\u0145h\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\t\3\2\2"+
		"\u0148j\3\2\2\2\u0149\u014b\4\62;\2\u014a\u0149\3\2\2\2\u014b\u014c\3"+
		"\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014dl\3\2\2\2\u014e\u0152"+
		"\7%\2\2\u014f\u0151\n\4\2\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2\2\2\u0152"+
		"\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153n\3\2\2\2\u0154\u0152\3\2\2\2"+
		"\20\2\u011b\u0120\u0124\u0127\u0129\u0130\u0136\u0139\u013d\u0142\u0144"+
		"\u014c\u0152\n\3*\2\3+\3\3,\4\3-\5\3.\6\3/\7\3\61\b\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}