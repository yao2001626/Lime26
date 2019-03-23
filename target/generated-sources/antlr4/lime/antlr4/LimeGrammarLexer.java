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
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, Class=13, Method=14, Action=15, Var=16, Init=17, 
		New=18, When=19, Do=20, If=21, Else=22, Elif=23, Then=24, While=25, Return=26, 
		Null=27, Booltype=28, Inttype=29, Voidtype=30, True=31, False=32, Assign=33, 
		Or=34, And=35, Equals=36, NEquals=37, GTEquals=38, LTEquals=39, GT=40, 
		LT=41, Add=42, Subtract=43, Multiply=44, Divide=45, Modulus=46, OBrace=47, 
		CBrace=48, OBracket=49, CBracket=50, OParen=51, CParen=52, NEWLINE=53, 
		SKIP_=54, ID=55, INTEGER=56;
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
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'"
	};
	public static final String[] ruleNames = {
		"T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", 
		"T__2", "T__1", "T__0", "Class", "Method", "Action", "Var", "Init", "New", 
		"When", "Do", "If", "Else", "Elif", "Then", "While", "Return", "Null", 
		"Booltype", "Inttype", "Voidtype", "True", "False", "Assign", "Or", "And", 
		"Equals", "NEquals", "GTEquals", "LTEquals", "GT", "LT", "Add", "Subtract", 
		"Multiply", "Divide", "Modulus", "OBrace", "CBrace", "OBracket", "CBracket", 
		"OParen", "CParen", "SPACES", "NEWLINE", "SKIP_", "LINE_JOINING", "ID", 
		"LETTER", "INTEGER", "COMMENT"
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
		case 46: OBrace_action((RuleContext)_localctx, actionIndex); break;
		case 47: CBrace_action((RuleContext)_localctx, actionIndex); break;
		case 48: OBracket_action((RuleContext)_localctx, actionIndex); break;
		case 49: CBracket_action((RuleContext)_localctx, actionIndex); break;
		case 50: OParen_action((RuleContext)_localctx, actionIndex); break;
		case 51: CParen_action((RuleContext)_localctx, actionIndex); break;
		case 53: NEWLINE_action((RuleContext)_localctx, actionIndex); break;
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
		case 53: return NEWLINE_sempred((RuleContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2:\u0181\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3"+
		"$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3+\3"+
		",\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3"+
		"\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\6\66\u0146\n\66\r\66"+
		"\16\66\u0147\3\67\3\67\3\67\5\67\u014d\n\67\3\67\3\67\5\67\u0151\n\67"+
		"\3\67\5\67\u0154\n\67\5\67\u0156\n\67\3\67\3\67\38\38\38\58\u015d\n8\3"+
		"8\38\39\39\59\u0163\n9\39\59\u0166\n9\39\39\59\u016a\n9\3:\3:\3:\7:\u016f"+
		"\n:\f:\16:\u0172\13:\3;\3;\3<\6<\u0177\n<\r<\16<\u0178\3=\3=\7=\u017d"+
		"\n=\f=\16=\u0180\13=\2\2>\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a"+
		"\62c\63e\64g\65i\66k\2m\67o8q\2s9u\2w:y\2\3\2\5\4\2\13\13\"\"\5\2C\\a"+
		"ac|\4\2\f\f\16\17\u018a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2m\3\2\2\2\2o\3\2\2\2\2s\3\2\2\2\2w\3\2\2\2\3{\3\2\2\2\5}\3\2\2\2\7"+
		"\177\3\2\2\2\t\u0083\3\2\2\2\13\u0089\3\2\2\2\r\u008b\3\2\2\2\17\u008d"+
		"\3\2\2\2\21\u0092\3\2\2\2\23\u0095\3\2\2\2\25\u0097\3\2\2\2\27\u009e\3"+
		"\2\2\2\31\u00a2\3\2\2\2\33\u00a9\3\2\2\2\35\u00af\3\2\2\2\37\u00b6\3\2"+
		"\2\2!\u00bd\3\2\2\2#\u00c1\3\2\2\2%\u00c6\3\2\2\2\'\u00ca\3\2\2\2)\u00cf"+
		"\3\2\2\2+\u00d2\3\2\2\2-\u00d5\3\2\2\2/\u00da\3\2\2\2\61\u00df\3\2\2\2"+
		"\63\u00e4\3\2\2\2\65\u00ea\3\2\2\2\67\u00f1\3\2\2\29\u00f5\3\2\2\2;\u00fa"+
		"\3\2\2\2=\u00fe\3\2\2\2?\u0103\3\2\2\2A\u0108\3\2\2\2C\u010e\3\2\2\2E"+
		"\u0111\3\2\2\2G\u0114\3\2\2\2I\u0118\3\2\2\2K\u011b\3\2\2\2M\u011e\3\2"+
		"\2\2O\u0121\3\2\2\2Q\u0124\3\2\2\2S\u0126\3\2\2\2U\u0128\3\2\2\2W\u012a"+
		"\3\2\2\2Y\u012c\3\2\2\2[\u012e\3\2\2\2]\u0130\3\2\2\2_\u0132\3\2\2\2a"+
		"\u0135\3\2\2\2c\u0138\3\2\2\2e\u013b\3\2\2\2g\u013e\3\2\2\2i\u0141\3\2"+
		"\2\2k\u0145\3\2\2\2m\u0155\3\2\2\2o\u015c\3\2\2\2q\u0160\3\2\2\2s\u016b"+
		"\3\2\2\2u\u0173\3\2\2\2w\u0176\3\2\2\2y\u017a\3\2\2\2{|\7=\2\2|\4\3\2"+
		"\2\2}~\7?\2\2~\6\3\2\2\2\177\u0080\7h\2\2\u0080\u0081\7q\2\2\u0081\u0082"+
		"\7t\2\2\u0082\b\3\2\2\2\u0083\u0084\7r\2\2\u0084\u0085\7t\2\2\u0085\u0086"+
		"\7k\2\2\u0086\u0087\7p\2\2\u0087\u0088\7v\2\2\u0088\n\3\2\2\2\u0089\u008a"+
		"\7.\2\2\u008a\f\3\2\2\2\u008b\u008c\7\60\2\2\u008c\16\3\2\2\2\u008d\u008e"+
		"\7t\2\2\u008e\u008f\7c\2\2\u008f\u0090\7p\2\2\u0090\u0091\7f\2\2\u0091"+
		"\20\3\2\2\2\u0092\u0093\7v\2\2\u0093\u0094\7q\2\2\u0094\22\3\2\2\2\u0095"+
		"\u0096\7<\2\2\u0096\24\3\2\2\2\u0097\u0098\7i\2\2\u0098\u0099\7g\2\2\u0099"+
		"\u009a\7v\2\2\u009a\u009b\7C\2\2\u009b\u009c\7t\2\2\u009c\u009d\7i\2\2"+
		"\u009d\26\3\2\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7q\2\2\u00a0\u00a1\7"+
		"v\2\2\u00a1\30\3\2\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7o\2\2\u00a4\u00a5"+
		"\7r\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7v\2\2\u00a8"+
		"\32\3\2\2\2\u00a9\u00aa\7e\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7c\2\2\u00ac"+
		"\u00ad\7u\2\2\u00ad\u00ae\7u\2\2\u00ae\34\3\2\2\2\u00af\u00b0\7o\2\2\u00b0"+
		"\u00b1\7g\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7j\2\2\u00b3\u00b4\7q\2\2"+
		"\u00b4\u00b5\7f\2\2\u00b5\36\3\2\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7"+
		"e\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb\7q\2\2\u00bb\u00bc"+
		"\7p\2\2\u00bc \3\2\2\2\u00bd\u00be\7x\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0"+
		"\7t\2\2\u00c0\"\3\2\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4"+
		"\7k\2\2\u00c4\u00c5\7v\2\2\u00c5$\3\2\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8"+
		"\7g\2\2\u00c8\u00c9\7y\2\2\u00c9&\3\2\2\2\u00ca\u00cb\7y\2\2\u00cb\u00cc"+
		"\7j\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7p\2\2\u00ce(\3\2\2\2\u00cf\u00d0"+
		"\7f\2\2\u00d0\u00d1\7q\2\2\u00d1*\3\2\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4"+
		"\7h\2\2\u00d4,\3\2\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7n\2\2\u00d7\u00d8"+
		"\7u\2\2\u00d8\u00d9\7g\2\2\u00d9.\3\2\2\2\u00da\u00db\7g\2\2\u00db\u00dc"+
		"\7n\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7h\2\2\u00de\60\3\2\2\2\u00df\u00e0"+
		"\7v\2\2\u00e0\u00e1\7j\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7p\2\2\u00e3"+
		"\62\3\2\2\2\u00e4\u00e5\7y\2\2\u00e5\u00e6\7j\2\2\u00e6\u00e7\7k\2\2\u00e7"+
		"\u00e8\7n\2\2\u00e8\u00e9\7g\2\2\u00e9\64\3\2\2\2\u00ea\u00eb\7t\2\2\u00eb"+
		"\u00ec\7g\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7w\2\2\u00ee\u00ef\7t\2\2"+
		"\u00ef\u00f0\7p\2\2\u00f0\66\3\2\2\2\u00f1\u00f2\7p\2\2\u00f2\u00f3\7"+
		"k\2\2\u00f3\u00f4\7n\2\2\u00f48\3\2\2\2\u00f5\u00f6\7d\2\2\u00f6\u00f7"+
		"\7q\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7n\2\2\u00f9:\3\2\2\2\u00fa\u00fb"+
		"\7k\2\2\u00fb\u00fc\7p\2\2\u00fc\u00fd\7v\2\2\u00fd<\3\2\2\2\u00fe\u00ff"+
		"\7x\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7k\2\2\u0101\u0102\7f\2\2\u0102"+
		">\3\2\2\2\u0103\u0104\7v\2\2\u0104\u0105\7t\2\2\u0105\u0106\7w\2\2\u0106"+
		"\u0107\7g\2\2\u0107@\3\2\2\2\u0108\u0109\7h\2\2\u0109\u010a\7c\2\2\u010a"+
		"\u010b\7n\2\2\u010b\u010c\7u\2\2\u010c\u010d\7g\2\2\u010dB\3\2\2\2\u010e"+
		"\u010f\7<\2\2\u010f\u0110\7?\2\2\u0110D\3\2\2\2\u0111\u0112\7q\2\2\u0112"+
		"\u0113\7t\2\2\u0113F\3\2\2\2\u0114\u0115\7c\2\2\u0115\u0116\7p\2\2\u0116"+
		"\u0117\7f\2\2\u0117H\3\2\2\2\u0118\u0119\7?\2\2\u0119\u011a\7?\2\2\u011a"+
		"J\3\2\2\2\u011b\u011c\7#\2\2\u011c\u011d\7?\2\2\u011dL\3\2\2\2\u011e\u011f"+
		"\7@\2\2\u011f\u0120\7?\2\2\u0120N\3\2\2\2\u0121\u0122\7>\2\2\u0122\u0123"+
		"\7?\2\2\u0123P\3\2\2\2\u0124\u0125\7@\2\2\u0125R\3\2\2\2\u0126\u0127\7"+
		">\2\2\u0127T\3\2\2\2\u0128\u0129\7-\2\2\u0129V\3\2\2\2\u012a\u012b\7/"+
		"\2\2\u012bX\3\2\2\2\u012c\u012d\7,\2\2\u012dZ\3\2\2\2\u012e\u012f\7\61"+
		"\2\2\u012f\\\3\2\2\2\u0130\u0131\7\'\2\2\u0131^\3\2\2\2\u0132\u0133\7"+
		"}\2\2\u0133\u0134\b\60\2\2\u0134`\3\2\2\2\u0135\u0136\7\177\2\2\u0136"+
		"\u0137\b\61\3\2\u0137b\3\2\2\2\u0138\u0139\7]\2\2\u0139\u013a\b\62\4\2"+
		"\u013ad\3\2\2\2\u013b\u013c\7_\2\2\u013c\u013d\b\63\5\2\u013df\3\2\2\2"+
		"\u013e\u013f\7*\2\2\u013f\u0140\b\64\6\2\u0140h\3\2\2\2\u0141\u0142\7"+
		"+\2\2\u0142\u0143\b\65\7\2\u0143j\3\2\2\2\u0144\u0146\t\2\2\2\u0145\u0144"+
		"\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"l\3\2\2\2\u0149\u014a\6\67\2\2\u014a\u0156\5k\66\2\u014b\u014d\7\17\2"+
		"\2\u014c\u014b\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0151"+
		"\7\f\2\2\u014f\u0151\4\16\17\2\u0150\u014c\3\2\2\2\u0150\u014f\3\2\2\2"+
		"\u0151\u0153\3\2\2\2\u0152\u0154\5k\66\2\u0153\u0152\3\2\2\2\u0153\u0154"+
		"\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0149\3\2\2\2\u0155\u0150\3\2\2\2\u0156"+
		"\u0157\3\2\2\2\u0157\u0158\b\67\b\2\u0158n\3\2\2\2\u0159\u015d\5k\66\2"+
		"\u015a\u015d\5y=\2\u015b\u015d\5q9\2\u015c\u0159\3\2\2\2\u015c\u015a\3"+
		"\2\2\2\u015c\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\b8\t\2\u015f"+
		"p\3\2\2\2\u0160\u0162\7^\2\2\u0161\u0163\5k\66\2\u0162\u0161\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0169\3\2\2\2\u0164\u0166\7\17\2\2\u0165\u0164\3"+
		"\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u016a\7\f\2\2\u0168"+
		"\u016a\4\16\17\2\u0169\u0165\3\2\2\2\u0169\u0168\3\2\2\2\u016ar\3\2\2"+
		"\2\u016b\u0170\5u;\2\u016c\u016f\5u;\2\u016d\u016f\4\62;\2\u016e\u016c"+
		"\3\2\2\2\u016e\u016d\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170"+
		"\u0171\3\2\2\2\u0171t\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0174\t\3\2\2"+
		"\u0174v\3\2\2\2\u0175\u0177\4\62;\2\u0176\u0175\3\2\2\2\u0177\u0178\3"+
		"\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179x\3\2\2\2\u017a\u017e"+
		"\7%\2\2\u017b\u017d\n\4\2\2\u017c\u017b\3\2\2\2\u017d\u0180\3\2\2\2\u017e"+
		"\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017fz\3\2\2\2\u0180\u017e\3\2\2\2"+
		"\20\2\u0147\u014c\u0150\u0153\u0155\u015c\u0162\u0165\u0169\u016e\u0170"+
		"\u0178\u017e\n\3\60\2\3\61\3\3\62\4\3\63\5\3\64\6\3\65\7\3\67\b\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}