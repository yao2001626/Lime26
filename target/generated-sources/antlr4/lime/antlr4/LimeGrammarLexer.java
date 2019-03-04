// Generated from LimeGrammar.g4 by ANTLR 4.7.2

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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, Class=7, Method=8, Action=9, 
		Var=10, Init=11, New=12, When=13, Do=14, If=15, Else=16, Elif=17, Then=18, 
		While=19, Return=20, Null=21, Booltype=22, Inttype=23, Voidtype=24, True=25, 
		False=26, Assign=27, Or=28, And=29, Equals=30, NEquals=31, GTEquals=32, 
		LTEquals=33, GT=34, LT=35, Add=36, Subtract=37, Multiply=38, Divide=39, 
		Modulus=40, OBrace=41, CBrace=42, OBracket=43, CBracket=44, OParen=45, 
		CParen=46, NEWLINE=47, SKIP_=48, ID=49, INTEGER=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "Class", "Method", "Action", 
			"Var", "Init", "New", "When", "Do", "If", "Else", "Elif", "Then", "While", 
			"Return", "Null", "Booltype", "Inttype", "Voidtype", "True", "False", 
			"Assign", "Or", "And", "Equals", "NEquals", "GTEquals", "LTEquals", "GT", 
			"LT", "Add", "Subtract", "Multiply", "Divide", "Modulus", "OBrace", "CBrace", 
			"OBracket", "CBracket", "OParen", "CParen", "SPACES", "NEWLINE", "SKIP_", 
			"LINE_JOINING", "ID", "LETTER", "INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "','", "';'", "'='", "'not'", "'.'", "'class'", "'method'", 
			"'action'", "'var'", "'init'", "'new'", "'when'", "'do'", "'if'", "'else'", 
			"'elif'", "'then'", "'while'", "'return'", "'nil'", "'bool'", "'int'", 
			"'void'", "'true'", "'false'", "':='", "'or'", "'and'", "'=='", "'!='", 
			"'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'%'", "'{'", 
			"'}'", "'['", "']'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "Class", "Method", "Action", 
			"Var", "Init", "New", "When", "Do", "If", "Else", "Elif", "Then", "While", 
			"Return", "Null", "Booltype", "Inttype", "Voidtype", "True", "False", 
			"Assign", "Or", "And", "Equals", "NEquals", "GTEquals", "LTEquals", "GT", 
			"LT", "Add", "Subtract", "Multiply", "Divide", "Modulus", "OBrace", "CBrace", 
			"OBracket", "CBracket", "OParen", "CParen", "NEWLINE", "SKIP_", "ID", 
			"INTEGER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


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
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 40:
			OBrace_action((RuleContext)_localctx, actionIndex);
			break;
		case 41:
			CBrace_action((RuleContext)_localctx, actionIndex);
			break;
		case 42:
			OBracket_action((RuleContext)_localctx, actionIndex);
			break;
		case 43:
			CBracket_action((RuleContext)_localctx, actionIndex);
			break;
		case 44:
			OParen_action((RuleContext)_localctx, actionIndex);
			break;
		case 45:
			CParen_action((RuleContext)_localctx, actionIndex);
			break;
		case 47:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void OBrace_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			opened++;
			break;
		}
	}
	private void CBrace_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			opened--;
			break;
		}
	}
	private void OBracket_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			opened++;
			break;
		}
	}
	private void CBracket_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			opened--;
			break;
		}
	}
	private void OParen_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			opened++;
			break;
		}
	}
	private void CParen_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			opened--;
			break;
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
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 47:
			return NEWLINE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean NEWLINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return atStartOfInput();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u014b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 "+
		"\3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3"+
		"*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\6\60\u0118\n"+
		"\60\r\60\16\60\u0119\3\61\3\61\3\61\5\61\u011f\n\61\3\61\3\61\5\61\u0123"+
		"\n\61\3\61\5\61\u0126\n\61\5\61\u0128\n\61\3\61\3\61\3\62\3\62\5\62\u012e"+
		"\n\62\3\62\3\62\3\63\3\63\5\63\u0134\n\63\3\63\5\63\u0137\n\63\3\63\3"+
		"\63\5\63\u013b\n\63\3\64\3\64\3\64\7\64\u0140\n\64\f\64\16\64\u0143\13"+
		"\64\3\65\3\65\3\66\6\66\u0148\n\66\r\66\16\66\u0149\2\2\67\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\2a\61c\62e\2g\63i\2k\64\3\2\4\4\2\13\13\""+
		"\"\5\2C\\aac|\2\u0153\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2g\3\2\2\2\2k\3\2\2\2\3m\3\2\2\2\5o\3\2\2"+
		"\2\7q\3\2\2\2\ts\3\2\2\2\13u\3\2\2\2\ry\3\2\2\2\17{\3\2\2\2\21\u0081\3"+
		"\2\2\2\23\u0088\3\2\2\2\25\u008f\3\2\2\2\27\u0093\3\2\2\2\31\u0098\3\2"+
		"\2\2\33\u009c\3\2\2\2\35\u00a1\3\2\2\2\37\u00a4\3\2\2\2!\u00a7\3\2\2\2"+
		"#\u00ac\3\2\2\2%\u00b1\3\2\2\2\'\u00b6\3\2\2\2)\u00bc\3\2\2\2+\u00c3\3"+
		"\2\2\2-\u00c7\3\2\2\2/\u00cc\3\2\2\2\61\u00d0\3\2\2\2\63\u00d5\3\2\2\2"+
		"\65\u00da\3\2\2\2\67\u00e0\3\2\2\29\u00e3\3\2\2\2;\u00e6\3\2\2\2=\u00ea"+
		"\3\2\2\2?\u00ed\3\2\2\2A\u00f0\3\2\2\2C\u00f3\3\2\2\2E\u00f6\3\2\2\2G"+
		"\u00f8\3\2\2\2I\u00fa\3\2\2\2K\u00fc\3\2\2\2M\u00fe\3\2\2\2O\u0100\3\2"+
		"\2\2Q\u0102\3\2\2\2S\u0104\3\2\2\2U\u0107\3\2\2\2W\u010a\3\2\2\2Y\u010d"+
		"\3\2\2\2[\u0110\3\2\2\2]\u0113\3\2\2\2_\u0117\3\2\2\2a\u0127\3\2\2\2c"+
		"\u012d\3\2\2\2e\u0131\3\2\2\2g\u013c\3\2\2\2i\u0144\3\2\2\2k\u0147\3\2"+
		"\2\2mn\7<\2\2n\4\3\2\2\2op\7.\2\2p\6\3\2\2\2qr\7=\2\2r\b\3\2\2\2st\7?"+
		"\2\2t\n\3\2\2\2uv\7p\2\2vw\7q\2\2wx\7v\2\2x\f\3\2\2\2yz\7\60\2\2z\16\3"+
		"\2\2\2{|\7e\2\2|}\7n\2\2}~\7c\2\2~\177\7u\2\2\177\u0080\7u\2\2\u0080\20"+
		"\3\2\2\2\u0081\u0082\7o\2\2\u0082\u0083\7g\2\2\u0083\u0084\7v\2\2\u0084"+
		"\u0085\7j\2\2\u0085\u0086\7q\2\2\u0086\u0087\7f\2\2\u0087\22\3\2\2\2\u0088"+
		"\u0089\7c\2\2\u0089\u008a\7e\2\2\u008a\u008b\7v\2\2\u008b\u008c\7k\2\2"+
		"\u008c\u008d\7q\2\2\u008d\u008e\7p\2\2\u008e\24\3\2\2\2\u008f\u0090\7"+
		"x\2\2\u0090\u0091\7c\2\2\u0091\u0092\7t\2\2\u0092\26\3\2\2\2\u0093\u0094"+
		"\7k\2\2\u0094\u0095\7p\2\2\u0095\u0096\7k\2\2\u0096\u0097\7v\2\2\u0097"+
		"\30\3\2\2\2\u0098\u0099\7p\2\2\u0099\u009a\7g\2\2\u009a\u009b\7y\2\2\u009b"+
		"\32\3\2\2\2\u009c\u009d\7y\2\2\u009d\u009e\7j\2\2\u009e\u009f\7g\2\2\u009f"+
		"\u00a0\7p\2\2\u00a0\34\3\2\2\2\u00a1\u00a2\7f\2\2\u00a2\u00a3\7q\2\2\u00a3"+
		"\36\3\2\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7h\2\2\u00a6 \3\2\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7g\2\2"+
		"\u00ab\"\3\2\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7k"+
		"\2\2\u00af\u00b0\7h\2\2\u00b0$\3\2\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3"+
		"\7j\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7p\2\2\u00b5&\3\2\2\2\u00b6\u00b7"+
		"\7y\2\2\u00b7\u00b8\7j\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7n\2\2\u00ba"+
		"\u00bb\7g\2\2\u00bb(\3\2\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7g\2\2\u00be"+
		"\u00bf\7v\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7p\2\2"+
		"\u00c2*\3\2\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6\7n\2"+
		"\2\u00c6,\3\2\2\2\u00c7\u00c8\7d\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7"+
		"q\2\2\u00ca\u00cb\7n\2\2\u00cb.\3\2\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce"+
		"\7p\2\2\u00ce\u00cf\7v\2\2\u00cf\60\3\2\2\2\u00d0\u00d1\7x\2\2\u00d1\u00d2"+
		"\7q\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7f\2\2\u00d4\62\3\2\2\2\u00d5\u00d6"+
		"\7v\2\2\u00d6\u00d7\7t\2\2\u00d7\u00d8\7w\2\2\u00d8\u00d9\7g\2\2\u00d9"+
		"\64\3\2\2\2\u00da\u00db\7h\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd\7n\2\2\u00dd"+
		"\u00de\7u\2\2\u00de\u00df\7g\2\2\u00df\66\3\2\2\2\u00e0\u00e1\7<\2\2\u00e1"+
		"\u00e2\7?\2\2\u00e28\3\2\2\2\u00e3\u00e4\7q\2\2\u00e4\u00e5\7t\2\2\u00e5"+
		":\3\2\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7f\2\2\u00e9"+
		"<\3\2\2\2\u00ea\u00eb\7?\2\2\u00eb\u00ec\7?\2\2\u00ec>\3\2\2\2\u00ed\u00ee"+
		"\7#\2\2\u00ee\u00ef\7?\2\2\u00ef@\3\2\2\2\u00f0\u00f1\7@\2\2\u00f1\u00f2"+
		"\7?\2\2\u00f2B\3\2\2\2\u00f3\u00f4\7>\2\2\u00f4\u00f5\7?\2\2\u00f5D\3"+
		"\2\2\2\u00f6\u00f7\7@\2\2\u00f7F\3\2\2\2\u00f8\u00f9\7>\2\2\u00f9H\3\2"+
		"\2\2\u00fa\u00fb\7-\2\2\u00fbJ\3\2\2\2\u00fc\u00fd\7/\2\2\u00fdL\3\2\2"+
		"\2\u00fe\u00ff\7,\2\2\u00ffN\3\2\2\2\u0100\u0101\7\61\2\2\u0101P\3\2\2"+
		"\2\u0102\u0103\7\'\2\2\u0103R\3\2\2\2\u0104\u0105\7}\2\2\u0105\u0106\b"+
		"*\2\2\u0106T\3\2\2\2\u0107\u0108\7\177\2\2\u0108\u0109\b+\3\2\u0109V\3"+
		"\2\2\2\u010a\u010b\7]\2\2\u010b\u010c\b,\4\2\u010cX\3\2\2\2\u010d\u010e"+
		"\7_\2\2\u010e\u010f\b-\5\2\u010fZ\3\2\2\2\u0110\u0111\7*\2\2\u0111\u0112"+
		"\b.\6\2\u0112\\\3\2\2\2\u0113\u0114\7+\2\2\u0114\u0115\b/\7\2\u0115^\3"+
		"\2\2\2\u0116\u0118\t\2\2\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a`\3\2\2\2\u011b\u011c\6\61\2\2"+
		"\u011c\u0128\5_\60\2\u011d\u011f\7\17\2\2\u011e\u011d\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0123\7\f\2\2\u0121\u0123\4\16\17\2"+
		"\u0122\u011e\3\2\2\2\u0122\u0121\3\2\2\2\u0123\u0125\3\2\2\2\u0124\u0126"+
		"\5_\60\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127"+
		"\u011b\3\2\2\2\u0127\u0122\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\b\61"+
		"\b\2\u012ab\3\2\2\2\u012b\u012e\5_\60\2\u012c\u012e\5e\63\2\u012d\u012b"+
		"\3\2\2\2\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\b\62\t\2"+
		"\u0130d\3\2\2\2\u0131\u0133\7^\2\2\u0132\u0134\5_\60\2\u0133\u0132\3\2"+
		"\2\2\u0133\u0134\3\2\2\2\u0134\u013a\3\2\2\2\u0135\u0137\7\17\2\2\u0136"+
		"\u0135\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013b\7\f"+
		"\2\2\u0139\u013b\4\16\17\2\u013a\u0136\3\2\2\2\u013a\u0139\3\2\2\2\u013b"+
		"f\3\2\2\2\u013c\u0141\5i\65\2\u013d\u0140\5i\65\2\u013e\u0140\4\62;\2"+
		"\u013f\u013d\3\2\2\2\u013f\u013e\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f"+
		"\3\2\2\2\u0141\u0142\3\2\2\2\u0142h\3\2\2\2\u0143\u0141\3\2\2\2\u0144"+
		"\u0145\t\3\2\2\u0145j\3\2\2\2\u0146\u0148\4\62;\2\u0147\u0146\3\2\2\2"+
		"\u0148\u0149\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014al\3"+
		"\2\2\2\17\2\u0119\u011e\u0122\u0125\u0127\u012d\u0133\u0136\u013a\u013f"+
		"\u0141\u0149\n\3*\2\3+\3\3,\4\3-\5\3.\6\3/\7\3\61\b\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}