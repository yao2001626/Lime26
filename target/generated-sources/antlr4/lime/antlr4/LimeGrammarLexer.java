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
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, Class=14, Method=15, Action=16, Var=17, 
		Init=18, New=19, When=20, Do=21, If=22, Else=23, Elif=24, Then=25, While=26, 
		Return=27, Null=28, Booltype=29, Inttype=30, Voidtype=31, True=32, False=33, 
		Assign=34, Or=35, And=36, Equals=37, NEquals=38, GTEquals=39, LTEquals=40, 
		GT=41, LT=42, Add=43, Subtract=44, Multiply=45, Divide=46, Modulus=47, 
		OBrace=48, CBrace=49, OBracket=50, CBracket=51, OParen=52, CParen=53, 
		NEWLINE=54, SKIP_=55, ID=56, INTEGER=57;
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
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'"
	};
	public static final String[] ruleNames = {
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "Class", "Method", "Action", "Var", "Init", 
		"New", "When", "Do", "If", "Else", "Elif", "Then", "While", "Return", 
		"Null", "Booltype", "Inttype", "Voidtype", "True", "False", "Assign", 
		"Or", "And", "Equals", "NEquals", "GTEquals", "LTEquals", "GT", "LT", 
		"Add", "Subtract", "Multiply", "Divide", "Modulus", "OBrace", "CBrace", 
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
		case 47: OBrace_action((RuleContext)_localctx, actionIndex); break;
		case 48: CBrace_action((RuleContext)_localctx, actionIndex); break;
		case 49: OBracket_action((RuleContext)_localctx, actionIndex); break;
		case 50: CBracket_action((RuleContext)_localctx, actionIndex); break;
		case 51: OParen_action((RuleContext)_localctx, actionIndex); break;
		case 52: CParen_action((RuleContext)_localctx, actionIndex); break;
		case 54: NEWLINE_action((RuleContext)_localctx, actionIndex); break;
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
		case 54: return NEWLINE_sempred((RuleContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2;\u018e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!"+
		"\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&"+
		"\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60"+
		"\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65"+
		"\3\65\3\65\3\66\3\66\3\66\3\67\6\67\u0153\n\67\r\67\16\67\u0154\38\38"+
		"\38\58\u015a\n8\38\38\58\u015e\n8\38\58\u0161\n8\58\u0163\n8\38\38\39"+
		"\39\39\59\u016a\n9\39\39\3:\3:\5:\u0170\n:\3:\5:\u0173\n:\3:\3:\5:\u0177"+
		"\n:\3;\3;\3;\7;\u017c\n;\f;\16;\u017f\13;\3<\3<\3=\6=\u0184\n=\r=\16="+
		"\u0185\3>\3>\7>\u018a\n>\f>\16>\u018d\13>\2\2?\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m\2o8q9s\2u:w\2y;{\2\3\2"+
		"\5\4\2\13\13\"\"\5\2C\\aac|\4\2\f\f\16\17\u0197\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2u\3\2\2"+
		"\2\2y\3\2\2\2\3}\3\2\2\2\5\177\3\2\2\2\7\u0081\3\2\2\2\t\u0085\3\2\2\2"+
		"\13\u008d\3\2\2\2\r\u0093\3\2\2\2\17\u0095\3\2\2\2\21\u0097\3\2\2\2\23"+
		"\u009a\3\2\2\2\25\u009c\3\2\2\2\27\u00a3\3\2\2\2\31\u00ab\3\2\2\2\33\u00af"+
		"\3\2\2\2\35\u00b6\3\2\2\2\37\u00bc\3\2\2\2!\u00c3\3\2\2\2#\u00ca\3\2\2"+
		"\2%\u00ce\3\2\2\2\'\u00d3\3\2\2\2)\u00d7\3\2\2\2+\u00dc\3\2\2\2-\u00df"+
		"\3\2\2\2/\u00e2\3\2\2\2\61\u00e7\3\2\2\2\63\u00ec\3\2\2\2\65\u00f1\3\2"+
		"\2\2\67\u00f7\3\2\2\29\u00fe\3\2\2\2;\u0102\3\2\2\2=\u0107\3\2\2\2?\u010b"+
		"\3\2\2\2A\u0110\3\2\2\2C\u0115\3\2\2\2E\u011b\3\2\2\2G\u011e\3\2\2\2I"+
		"\u0121\3\2\2\2K\u0125\3\2\2\2M\u0128\3\2\2\2O\u012b\3\2\2\2Q\u012e\3\2"+
		"\2\2S\u0131\3\2\2\2U\u0133\3\2\2\2W\u0135\3\2\2\2Y\u0137\3\2\2\2[\u0139"+
		"\3\2\2\2]\u013b\3\2\2\2_\u013d\3\2\2\2a\u013f\3\2\2\2c\u0142\3\2\2\2e"+
		"\u0145\3\2\2\2g\u0148\3\2\2\2i\u014b\3\2\2\2k\u014e\3\2\2\2m\u0152\3\2"+
		"\2\2o\u0162\3\2\2\2q\u0169\3\2\2\2s\u016d\3\2\2\2u\u0178\3\2\2\2w\u0180"+
		"\3\2\2\2y\u0183\3\2\2\2{\u0187\3\2\2\2}~\7=\2\2~\4\3\2\2\2\177\u0080\7"+
		"?\2\2\u0080\6\3\2\2\2\u0081\u0082\7h\2\2\u0082\u0083\7q\2\2\u0083\u0084"+
		"\7t\2\2\u0084\b\3\2\2\2\u0085\u0086\7i\2\2\u0086\u0087\7g\2\2\u0087\u0088"+
		"\7v\2\2\u0088\u0089\7T\2\2\u0089\u008a\7c\2\2\u008a\u008b\7p\2\2\u008b"+
		"\u008c\7f\2\2\u008c\n\3\2\2\2\u008d\u008e\7r\2\2\u008e\u008f\7t\2\2\u008f"+
		"\u0090\7k\2\2\u0090\u0091\7p\2\2\u0091\u0092\7v\2\2\u0092\f\3\2\2\2\u0093"+
		"\u0094\7.\2\2\u0094\16\3\2\2\2\u0095\u0096\7\60\2\2\u0096\20\3\2\2\2\u0097"+
		"\u0098\7v\2\2\u0098\u0099\7q\2\2\u0099\22\3\2\2\2\u009a\u009b\7<\2\2\u009b"+
		"\24\3\2\2\2\u009c\u009d\7i\2\2\u009d\u009e\7g\2\2\u009e\u009f\7v\2\2\u009f"+
		"\u00a0\7C\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7i\2\2\u00a2\26\3\2\2\2\u00a3"+
		"\u00a4\7u\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7v\2\2\u00a6\u00a7\7T\2\2"+
		"\u00a7\u00a8\7c\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7f\2\2\u00aa\30\3\2"+
		"\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7v\2\2\u00ae\32"+
		"\3\2\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7o\2\2\u00b1\u00b2\7r\2\2\u00b2"+
		"\u00b3\7q\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7v\2\2\u00b5\34\3\2\2\2\u00b6"+
		"\u00b7\7e\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7u\2\2"+
		"\u00ba\u00bb\7u\2\2\u00bb\36\3\2\2\2\u00bc\u00bd\7o\2\2\u00bd\u00be\7"+
		"g\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0\7j\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c2"+
		"\7f\2\2\u00c2 \3\2\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7e\2\2\u00c5\u00c6"+
		"\7v\2\2\u00c6\u00c7\7k\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7p\2\2\u00c9"+
		"\"\3\2\2\2\u00ca\u00cb\7x\2\2\u00cb\u00cc\7c\2\2\u00cc\u00cd\7t\2\2\u00cd"+
		"$\3\2\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7k\2\2\u00d1"+
		"\u00d2\7v\2\2\u00d2&\3\2\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d5\7g\2\2\u00d5"+
		"\u00d6\7y\2\2\u00d6(\3\2\2\2\u00d7\u00d8\7y\2\2\u00d8\u00d9\7j\2\2\u00d9"+
		"\u00da\7g\2\2\u00da\u00db\7p\2\2\u00db*\3\2\2\2\u00dc\u00dd\7f\2\2\u00dd"+
		"\u00de\7q\2\2\u00de,\3\2\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7h\2\2\u00e1"+
		".\3\2\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7n\2\2\u00e4\u00e5\7u\2\2\u00e5"+
		"\u00e6\7g\2\2\u00e6\60\3\2\2\2\u00e7\u00e8\7g\2\2\u00e8\u00e9\7n\2\2\u00e9"+
		"\u00ea\7k\2\2\u00ea\u00eb\7h\2\2\u00eb\62\3\2\2\2\u00ec\u00ed\7v\2\2\u00ed"+
		"\u00ee\7j\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0\7p\2\2\u00f0\64\3\2\2\2\u00f1"+
		"\u00f2\7y\2\2\u00f2\u00f3\7j\2\2\u00f3\u00f4\7k\2\2\u00f4\u00f5\7n\2\2"+
		"\u00f5\u00f6\7g\2\2\u00f6\66\3\2\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7"+
		"g\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb\7w\2\2\u00fb\u00fc\7t\2\2\u00fc\u00fd"+
		"\7p\2\2\u00fd8\3\2\2\2\u00fe\u00ff\7p\2\2\u00ff\u0100\7k\2\2\u0100\u0101"+
		"\7n\2\2\u0101:\3\2\2\2\u0102\u0103\7d\2\2\u0103\u0104\7q\2\2\u0104\u0105"+
		"\7q\2\2\u0105\u0106\7n\2\2\u0106<\3\2\2\2\u0107\u0108\7k\2\2\u0108\u0109"+
		"\7p\2\2\u0109\u010a\7v\2\2\u010a>\3\2\2\2\u010b\u010c\7x\2\2\u010c\u010d"+
		"\7q\2\2\u010d\u010e\7k\2\2\u010e\u010f\7f\2\2\u010f@\3\2\2\2\u0110\u0111"+
		"\7v\2\2\u0111\u0112\7t\2\2\u0112\u0113\7w\2\2\u0113\u0114\7g\2\2\u0114"+
		"B\3\2\2\2\u0115\u0116\7h\2\2\u0116\u0117\7c\2\2\u0117\u0118\7n\2\2\u0118"+
		"\u0119\7u\2\2\u0119\u011a\7g\2\2\u011aD\3\2\2\2\u011b\u011c\7<\2\2\u011c"+
		"\u011d\7?\2\2\u011dF\3\2\2\2\u011e\u011f\7q\2\2\u011f\u0120\7t\2\2\u0120"+
		"H\3\2\2\2\u0121\u0122\7c\2\2\u0122\u0123\7p\2\2\u0123\u0124\7f\2\2\u0124"+
		"J\3\2\2\2\u0125\u0126\7?\2\2\u0126\u0127\7?\2\2\u0127L\3\2\2\2\u0128\u0129"+
		"\7#\2\2\u0129\u012a\7?\2\2\u012aN\3\2\2\2\u012b\u012c\7@\2\2\u012c\u012d"+
		"\7?\2\2\u012dP\3\2\2\2\u012e\u012f\7>\2\2\u012f\u0130\7?\2\2\u0130R\3"+
		"\2\2\2\u0131\u0132\7@\2\2\u0132T\3\2\2\2\u0133\u0134\7>\2\2\u0134V\3\2"+
		"\2\2\u0135\u0136\7-\2\2\u0136X\3\2\2\2\u0137\u0138\7/\2\2\u0138Z\3\2\2"+
		"\2\u0139\u013a\7,\2\2\u013a\\\3\2\2\2\u013b\u013c\7\61\2\2\u013c^\3\2"+
		"\2\2\u013d\u013e\7\'\2\2\u013e`\3\2\2\2\u013f\u0140\7}\2\2\u0140\u0141"+
		"\b\61\2\2\u0141b\3\2\2\2\u0142\u0143\7\177\2\2\u0143\u0144\b\62\3\2\u0144"+
		"d\3\2\2\2\u0145\u0146\7]\2\2\u0146\u0147\b\63\4\2\u0147f\3\2\2\2\u0148"+
		"\u0149\7_\2\2\u0149\u014a\b\64\5\2\u014ah\3\2\2\2\u014b\u014c\7*\2\2\u014c"+
		"\u014d\b\65\6\2\u014dj\3\2\2\2\u014e\u014f\7+\2\2\u014f\u0150\b\66\7\2"+
		"\u0150l\3\2\2\2\u0151\u0153\t\2\2\2\u0152\u0151\3\2\2\2\u0153\u0154\3"+
		"\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155n\3\2\2\2\u0156\u0157"+
		"\68\2\2\u0157\u0163\5m\67\2\u0158\u015a\7\17\2\2\u0159\u0158\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015e\7\f\2\2\u015c\u015e\4\16"+
		"\17\2\u015d\u0159\3\2\2\2\u015d\u015c\3\2\2\2\u015e\u0160\3\2\2\2\u015f"+
		"\u0161\5m\67\2\u0160\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0163\3\2"+
		"\2\2\u0162\u0156\3\2\2\2\u0162\u015d\3\2\2\2\u0163\u0164\3\2\2\2\u0164"+
		"\u0165\b8\b\2\u0165p\3\2\2\2\u0166\u016a\5m\67\2\u0167\u016a\5{>\2\u0168"+
		"\u016a\5s:\2\u0169\u0166\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u0168\3\2\2"+
		"\2\u016a\u016b\3\2\2\2\u016b\u016c\b9\t\2\u016cr\3\2\2\2\u016d\u016f\7"+
		"^\2\2\u016e\u0170\5m\67\2\u016f\u016e\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u0176\3\2\2\2\u0171\u0173\7\17\2\2\u0172\u0171\3\2\2\2\u0172\u0173\3"+
		"\2\2\2\u0173\u0174\3\2\2\2\u0174\u0177\7\f\2\2\u0175\u0177\4\16\17\2\u0176"+
		"\u0172\3\2\2\2\u0176\u0175\3\2\2\2\u0177t\3\2\2\2\u0178\u017d\5w<\2\u0179"+
		"\u017c\5w<\2\u017a\u017c\4\62;\2\u017b\u0179\3\2\2\2\u017b\u017a\3\2\2"+
		"\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017ev"+
		"\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0181\t\3\2\2\u0181x\3\2\2\2\u0182"+
		"\u0184\4\62;\2\u0183\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0183\3\2"+
		"\2\2\u0185\u0186\3\2\2\2\u0186z\3\2\2\2\u0187\u018b\7%\2\2\u0188\u018a"+
		"\n\4\2\2\u0189\u0188\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b"+
		"\u018c\3\2\2\2\u018c|\3\2\2\2\u018d\u018b\3\2\2\2\20\2\u0154\u0159\u015d"+
		"\u0160\u0162\u0169\u016f\u0172\u0176\u017b\u017d\u0185\u018b\n\3\61\2"+
		"\3\62\3\3\63\4\3\64\5\3\65\6\3\66\7\38\b\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}