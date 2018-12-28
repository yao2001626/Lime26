// Generated from LimeGrammar.g4 by ANTLR 4.7.2

    package lime.antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LimeGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, Class=14, Method=15, Action=16, 
		Var=17, Init=18, New=19, When=20, Do=21, If=22, Else=23, Elif=24, Then=25, 
		While=26, Return=27, Null=28, Booltype=29, Inttype=30, Voidtype=31, Assign=32, 
		Or=33, And=34, Equals=35, NEquals=36, GTEquals=37, LTEquals=38, GT=39, 
		LT=40, Add=41, Subtract=42, Multiply=43, Divide=44, Modulus=45, OBrace=46, 
		CBrace=47, OBracket=48, CBracket=49, OParen=50, CParen=51, NEWLINE=52, 
		SKIP_=53, ID=54, INTEGER=55, INDENT=56, DEDENT=57;
	public static final int
		RULE_compilationUnit = 0, RULE_classDecl = 1, RULE_classMember = 2, RULE_attrDecl = 3, 
		RULE_initDecl = 4, RULE_methodDecl = 5, RULE_actionDecl = 6, RULE_parameters = 7, 
		RULE_typedargslist = 8, RULE_argsdef = 9, RULE_type = 10, RULE_stmt = 11, 
		RULE_simple_stmt = 12, RULE_small_stmt = 13, RULE_compound_stmt = 14, 
		RULE_expr_stmt = 15, RULE_if_stmt = 16, RULE_while_stmt = 17, RULE_return_stmt = 18, 
		RULE_block = 19, RULE_test = 20, RULE_or_test = 21, RULE_and_test = 22, 
		RULE_not_test = 23, RULE_comp = 24, RULE_comp_op = 25, RULE_id_list = 26, 
		RULE_expr_list = 27, RULE_expr = 28, RULE_xor_expr = 29, RULE_and_expr = 30, 
		RULE_shift_expr = 31, RULE_arith_expr = 32, RULE_term = 33, RULE_factor = 34, 
		RULE_atom = 35, RULE_exprlist = 36, RULE_testlist = 37, RULE_arglist = 38, 
		RULE_argument = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "classDecl", "classMember", "attrDecl", "initDecl", 
			"methodDecl", "actionDecl", "parameters", "typedargslist", "argsdef", 
			"type", "stmt", "simple_stmt", "small_stmt", "compound_stmt", "expr_stmt", 
			"if_stmt", "while_stmt", "return_stmt", "block", "test", "or_test", "and_test", 
			"not_test", "comp", "comp_op", "id_list", "expr_list", "expr", "xor_expr", 
			"and_expr", "shift_expr", "arith_expr", "term", "factor", "atom", "exprlist", 
			"testlist", "arglist", "argument"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "','", "';'", "'not'", "'='", "'|'", "'^'", "'&'", "'<<'", 
			"'>>'", "'~'", "'false'", "'true'", "'class'", "'method'", "'action'", 
			"'var'", "'init'", "'new'", "'when'", "'do'", "'if'", "'else'", "'elif'", 
			"'then'", "'while'", "'return'", "'nil'", "'bool'", "'int'", "'void'", 
			"':='", "'or'", "'and'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'{'", "'}'", "'['", "']'", "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "Class", "Method", "Action", "Var", "Init", "New", "When", 
			"Do", "If", "Else", "Elif", "Then", "While", "Return", "Null", "Booltype", 
			"Inttype", "Voidtype", "Assign", "Or", "And", "Equals", "NEquals", "GTEquals", 
			"LTEquals", "GT", "LT", "Add", "Subtract", "Multiply", "Divide", "Modulus", 
			"OBrace", "CBrace", "OBracket", "CBracket", "OParen", "CParen", "NEWLINE", 
			"SKIP_", "ID", "INTEGER", "INDENT", "DEDENT"
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

	@Override
	public String getGrammarFileName() { return "LimeGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LimeGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompilationUnitContext extends ParserRuleContext {
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LimeGrammarParser.EOF, 0); }
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			classDecl();
			setState(81);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public Scope scope;
		public TerminalNode Class() { return getToken(LimeGrammarParser.Class, 0); }
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(LimeGrammarParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(LimeGrammarParser.DEDENT, 0); }
		public List<ClassMemberContext> classMember() {
			return getRuleContexts(ClassMemberContext.class);
		}
		public ClassMemberContext classMember(int i) {
			return getRuleContext(ClassMemberContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(Class);
			setState(84);
			match(ID);
			setState(85);
			match(NEWLINE);
			setState(86);
			match(INDENT);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Method) | (1L << Action) | (1L << Var) | (1L << Init))) != 0)) {
				{
				{
				setState(87);
				classMember();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassMemberContext extends ParserRuleContext {
		public AttrDeclContext attrDecl() {
			return getRuleContext(AttrDeclContext.class,0);
		}
		public InitDeclContext initDecl() {
			return getRuleContext(InitDeclContext.class,0);
		}
		public MethodDeclContext methodDecl() {
			return getRuleContext(MethodDeclContext.class,0);
		}
		public ActionDeclContext actionDecl() {
			return getRuleContext(ActionDeclContext.class,0);
		}
		public ClassMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterClassMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitClassMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitClassMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberContext classMember() throws RecognitionException {
		ClassMemberContext _localctx = new ClassMemberContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classMember);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				attrDecl();
				}
				break;
			case Init:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				initDecl();
				}
				break;
			case Method:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				methodDecl();
				}
				break;
			case Action:
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				actionDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrDeclContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(LimeGrammarParser.Var, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public AttrDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterAttrDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitAttrDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitAttrDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrDeclContext attrDecl() throws RecognitionException {
		AttrDeclContext _localctx = new AttrDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attrDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(Var);
			setState(102);
			id_list();
			setState(103);
			match(T__0);
			setState(104);
			type();
			setState(105);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitDeclContext extends ParserRuleContext {
		public Scope scope;
		public TerminalNode Init() { return getToken(LimeGrammarParser.Init, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public InitDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterInitDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitInitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitInitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclContext initDecl() throws RecognitionException {
		InitDeclContext _localctx = new InitDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_initDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(Init);
			setState(108);
			parameters();
			setState(109);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclContext extends ParserRuleContext {
		public Scope scope;
		public TerminalNode Method() { return getToken(LimeGrammarParser.Method, 0); }
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(LimeGrammarParser.INDENT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(LimeGrammarParser.DEDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode When() { return getToken(LimeGrammarParser.When, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode Do() { return getToken(LimeGrammarParser.Do, 0); }
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(Method);
			setState(112);
			match(ID);
			setState(113);
			parameters();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(114);
				match(T__0);
				setState(115);
				type();
				}
			}

			setState(118);
			match(NEWLINE);
			setState(119);
			match(INDENT);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==When) {
				{
				setState(120);
				match(When);
				setState(121);
				test();
				setState(122);
				match(Do);
				}
			}

			setState(126);
			block();
			setState(127);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionDeclContext extends ParserRuleContext {
		public Scope scope;
		public TerminalNode Action() { return getToken(LimeGrammarParser.Action, 0); }
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(LimeGrammarParser.INDENT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(LimeGrammarParser.DEDENT, 0); }
		public TerminalNode When() { return getToken(LimeGrammarParser.When, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode Do() { return getToken(LimeGrammarParser.Do, 0); }
		public ActionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterActionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitActionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitActionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionDeclContext actionDecl() throws RecognitionException {
		ActionDeclContext _localctx = new ActionDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_actionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(Action);
			setState(130);
			match(ID);
			setState(131);
			match(NEWLINE);
			setState(132);
			match(INDENT);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==When) {
				{
				setState(133);
				match(When);
				setState(134);
				test();
				setState(135);
				match(Do);
				}
			}

			setState(139);
			block();
			setState(140);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public TerminalNode OParen() { return getToken(LimeGrammarParser.OParen, 0); }
		public TerminalNode CParen() { return getToken(LimeGrammarParser.CParen, 0); }
		public TypedargslistContext typedargslist() {
			return getRuleContext(TypedargslistContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(OParen);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(143);
				typedargslist();
				}
			}

			setState(146);
			match(CParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedargslistContext extends ParserRuleContext {
		public List<ArgsdefContext> argsdef() {
			return getRuleContexts(ArgsdefContext.class);
		}
		public ArgsdefContext argsdef(int i) {
			return getRuleContext(ArgsdefContext.class,i);
		}
		public TypedargslistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedargslist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterTypedargslist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitTypedargslist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitTypedargslist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedargslistContext typedargslist() throws RecognitionException {
		TypedargslistContext _localctx = new TypedargslistContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typedargslist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			argsdef();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(149);
				match(T__1);
				setState(150);
				argsdef();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsdefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgsdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterArgsdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitArgsdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitArgsdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsdefContext argsdef() throws RecognitionException {
		ArgsdefContext _localctx = new ArgsdefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_argsdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(ID);
			setState(157);
			match(T__0);
			setState(158);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Inttype() { return getToken(LimeGrammarParser.Inttype, 0); }
		public TerminalNode Booltype() { return getToken(LimeGrammarParser.Booltype, 0); }
		public TerminalNode Voidtype() { return getToken(LimeGrammarParser.Voidtype, 0); }
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Booltype) | (1L << Inttype) | (1L << Voidtype) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stmt);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				simple_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				compound_stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_stmtContext extends ParserRuleContext {
		public List<Small_stmtContext> small_stmt() {
			return getRuleContexts(Small_stmtContext.class);
		}
		public Small_stmtContext small_stmt(int i) {
			return getRuleContext(Small_stmtContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public Simple_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterSimple_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitSimple_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitSimple_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_simple_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			small_stmt();
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(167);
					match(T__2);
					setState(168);
					small_stmt();
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(174);
				match(T__2);
				}
			}

			setState(177);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Small_stmtContext extends ParserRuleContext {
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public AttrDeclContext attrDecl() {
			return getRuleContext(AttrDeclContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Small_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_small_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterSmall_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitSmall_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitSmall_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Small_stmtContext small_stmt() throws RecognitionException {
		Small_stmtContext _localctx = new Small_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_small_stmt);
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
			case T__12:
			case Null:
			case Add:
			case Subtract:
			case ID:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				expr_stmt();
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				attrDecl();
				}
				break;
			case Return:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				return_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_stmtContext extends ParserRuleContext {
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public MethodDeclContext methodDecl() {
			return getRuleContext(MethodDeclContext.class,0);
		}
		public ActionDeclContext actionDecl() {
			return getRuleContext(ActionDeclContext.class,0);
		}
		public InitDeclContext initDecl() {
			return getRuleContext(InitDeclContext.class,0);
		}
		public AttrDeclContext attrDecl() {
			return getRuleContext(AttrDeclContext.class,0);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitCompound_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitCompound_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_compound_stmt);
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				if_stmt();
				}
				break;
			case While:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				while_stmt();
				}
				break;
			case Method:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				methodDecl();
				}
				break;
			case Action:
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
				actionDecl();
				}
				break;
			case Init:
				enterOuterAlt(_localctx, 5);
				{
				setState(188);
				initDecl();
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 6);
				{
				setState(189);
				attrDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_stmtContext extends ParserRuleContext {
		public List<Expr_listContext> expr_list() {
			return getRuleContexts(Expr_listContext.class);
		}
		public Expr_listContext expr_list(int i) {
			return getRuleContext(Expr_listContext.class,i);
		}
		public TerminalNode Assign() { return getToken(LimeGrammarParser.Assign, 0); }
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitExpr_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitExpr_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			expr_list();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(193);
				match(Assign);
				setState(194);
				expr_list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(LimeGrammarParser.If, 0); }
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TerminalNode Then() { return getToken(LimeGrammarParser.Then, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> Elif() { return getTokens(LimeGrammarParser.Elif); }
		public TerminalNode Elif(int i) {
			return getToken(LimeGrammarParser.Elif, i);
		}
		public TerminalNode Else() { return getToken(LimeGrammarParser.Else, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(If);
			setState(198);
			test();
			setState(199);
			match(Then);
			setState(200);
			block();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Elif) {
				{
				{
				setState(201);
				match(Elif);
				setState(202);
				test();
				setState(203);
				match(T__0);
				setState(204);
				block();
				}
				}
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(211);
				match(Else);
				setState(212);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(LimeGrammarParser.While, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public TerminalNode Do() { return getToken(LimeGrammarParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(While);
			setState(216);
			test();
			setState(217);
			match(Do);
			setState(218);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(LimeGrammarParser.Return, 0); }
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitReturn_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(Return);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << Null) | (1L << Add) | (1L << Subtract) | (1L << ID) | (1L << INTEGER))) != 0)) {
				{
				setState(221);
				test();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public Scope scope;
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(LimeGrammarParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(LimeGrammarParser.DEDENT, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_block);
		int _la;
		try {
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
			case T__12:
			case Var:
			case Return:
			case Null:
			case Add:
			case Subtract:
			case ID:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				simple_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				match(NEWLINE);
				setState(226);
				match(INDENT);
				setState(228); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(227);
					stmt();
					}
					}
					setState(230); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << Method) | (1L << Action) | (1L << Var) | (1L << Init) | (1L << If) | (1L << While) | (1L << Return) | (1L << Null) | (1L << Add) | (1L << Subtract) | (1L << ID) | (1L << INTEGER))) != 0) );
				setState(232);
				match(DEDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TestContext extends ParserRuleContext {
		public Or_testContext or_test() {
			return getRuleContext(Or_testContext.class,0);
		}
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_test);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			or_test();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_testContext extends ParserRuleContext {
		public List<And_testContext> and_test() {
			return getRuleContexts(And_testContext.class);
		}
		public And_testContext and_test(int i) {
			return getRuleContext(And_testContext.class,i);
		}
		public List<TerminalNode> Or() { return getTokens(LimeGrammarParser.Or); }
		public TerminalNode Or(int i) {
			return getToken(LimeGrammarParser.Or, i);
		}
		public Or_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterOr_test(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitOr_test(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitOr_test(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_testContext or_test() throws RecognitionException {
		Or_testContext _localctx = new Or_testContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_or_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			and_test();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Or) {
				{
				{
				setState(239);
				match(Or);
				setState(240);
				and_test();
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class And_testContext extends ParserRuleContext {
		public List<Not_testContext> not_test() {
			return getRuleContexts(Not_testContext.class);
		}
		public Not_testContext not_test(int i) {
			return getRuleContext(Not_testContext.class,i);
		}
		public List<TerminalNode> And() { return getTokens(LimeGrammarParser.And); }
		public TerminalNode And(int i) {
			return getToken(LimeGrammarParser.And, i);
		}
		public And_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterAnd_test(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitAnd_test(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitAnd_test(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_testContext and_test() throws RecognitionException {
		And_testContext _localctx = new And_testContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_and_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			not_test();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==And) {
				{
				{
				setState(247);
				match(And);
				setState(248);
				not_test();
				}
				}
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Not_testContext extends ParserRuleContext {
		public Not_testContext not_test() {
			return getRuleContext(Not_testContext.class,0);
		}
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public Not_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterNot_test(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitNot_test(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitNot_test(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Not_testContext not_test() throws RecognitionException {
		Not_testContext _localctx = new Not_testContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_not_test);
		try {
			setState(257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(T__3);
				setState(255);
				not_test();
				}
				break;
			case T__10:
			case T__11:
			case T__12:
			case Null:
			case Add:
			case Subtract:
			case ID:
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				comp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<Comp_opContext> comp_op() {
			return getRuleContexts(Comp_opContext.class);
		}
		public Comp_opContext comp_op(int i) {
			return getRuleContext(Comp_opContext.class,i);
		}
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_comp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			expr();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << NEquals) | (1L << GTEquals) | (1L << LTEquals) | (1L << GT) | (1L << LT))) != 0)) {
				{
				{
				setState(260);
				comp_op();
				setState(261);
				expr();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_opContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(LimeGrammarParser.LT, 0); }
		public TerminalNode GT() { return getToken(LimeGrammarParser.GT, 0); }
		public TerminalNode GTEquals() { return getToken(LimeGrammarParser.GTEquals, 0); }
		public TerminalNode LTEquals() { return getToken(LimeGrammarParser.LTEquals, 0); }
		public TerminalNode NEquals() { return getToken(LimeGrammarParser.NEquals, 0); }
		public Comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterComp_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitComp_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitComp_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_opContext comp_op() throws RecognitionException {
		Comp_opContext _localctx = new Comp_opContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << NEquals) | (1L << GTEquals) | (1L << LTEquals) | (1L << GT) | (1L << LT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_listContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LimeGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LimeGrammarParser.ID, i);
		}
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterId_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitId_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitId_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(ID);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(271);
				match(T__1);
				setState(272);
				match(ID);
				}
				}
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterExpr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitExpr_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitExpr_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			expr();
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(279);
				match(T__1);
				setState(280);
				expr();
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<Xor_exprContext> xor_expr() {
			return getRuleContexts(Xor_exprContext.class);
		}
		public Xor_exprContext xor_expr(int i) {
			return getRuleContext(Xor_exprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			xor_expr();
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(287);
				match(T__5);
				setState(288);
				xor_expr();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Xor_exprContext extends ParserRuleContext {
		public List<And_exprContext> and_expr() {
			return getRuleContexts(And_exprContext.class);
		}
		public And_exprContext and_expr(int i) {
			return getRuleContext(And_exprContext.class,i);
		}
		public Xor_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xor_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterXor_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitXor_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitXor_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Xor_exprContext xor_expr() throws RecognitionException {
		Xor_exprContext _localctx = new Xor_exprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_xor_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			and_expr();
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(295);
				match(T__6);
				setState(296);
				and_expr();
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class And_exprContext extends ParserRuleContext {
		public List<Shift_exprContext> shift_expr() {
			return getRuleContexts(Shift_exprContext.class);
		}
		public Shift_exprContext shift_expr(int i) {
			return getRuleContext(Shift_exprContext.class,i);
		}
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterAnd_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitAnd_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitAnd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_exprContext and_expr() throws RecognitionException {
		And_exprContext _localctx = new And_exprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			shift_expr();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(303);
				match(T__7);
				setState(304);
				shift_expr();
				}
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Shift_exprContext extends ParserRuleContext {
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public Shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterShift_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitShift_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitShift_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_exprContext shift_expr() throws RecognitionException {
		Shift_exprContext _localctx = new Shift_exprContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_shift_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			arith_expr();
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8 || _la==T__9) {
				{
				{
				setState(311);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(312);
				arith_expr();
				}
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arith_exprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> Add() { return getTokens(LimeGrammarParser.Add); }
		public TerminalNode Add(int i) {
			return getToken(LimeGrammarParser.Add, i);
		}
		public List<TerminalNode> Subtract() { return getTokens(LimeGrammarParser.Subtract); }
		public TerminalNode Subtract(int i) {
			return getToken(LimeGrammarParser.Subtract, i);
		}
		public Arith_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterArith_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitArith_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitArith_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arith_exprContext arith_expr() throws RecognitionException {
		Arith_exprContext _localctx = new Arith_exprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_arith_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			term();
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Add || _la==Subtract) {
				{
				{
				setState(319);
				_la = _input.LA(1);
				if ( !(_la==Add || _la==Subtract) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(320);
				term();
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> Multiply() { return getTokens(LimeGrammarParser.Multiply); }
		public TerminalNode Multiply(int i) {
			return getToken(LimeGrammarParser.Multiply, i);
		}
		public List<TerminalNode> Divide() { return getTokens(LimeGrammarParser.Divide); }
		public TerminalNode Divide(int i) {
			return getToken(LimeGrammarParser.Divide, i);
		}
		public List<TerminalNode> Modulus() { return getTokens(LimeGrammarParser.Modulus); }
		public TerminalNode Modulus(int i) {
			return getToken(LimeGrammarParser.Modulus, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			factor();
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multiply) | (1L << Divide) | (1L << Modulus))) != 0)) {
				{
				{
				setState(327);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multiply) | (1L << Divide) | (1L << Modulus))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(328);
				factor();
				}
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode Add() { return getToken(LimeGrammarParser.Add, 0); }
		public TerminalNode Subtract() { return getToken(LimeGrammarParser.Subtract, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_factor);
		int _la;
		try {
			setState(337);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case Add:
			case Subtract:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << Add) | (1L << Subtract))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(335);
				factor();
				}
				break;
			case T__11:
			case T__12:
			case Null:
			case ID:
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(336);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public TerminalNode INTEGER() { return getToken(LimeGrammarParser.INTEGER, 0); }
		public TerminalNode Null() { return getToken(LimeGrammarParser.Null, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << Null) | (1L << ID) | (1L << INTEGER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprlistContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterExprlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitExprlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitExprlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprlistContext exprlist() throws RecognitionException {
		ExprlistContext _localctx = new ExprlistContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_exprlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			expr();
			setState(346);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(342);
					match(T__1);
					setState(343);
					expr();
					}
					} 
				}
				setState(348);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(349);
				match(T__1);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TestlistContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TestlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterTestlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitTestlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitTestlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestlistContext testlist() throws RecognitionException {
		TestlistContext _localctx = new TestlistContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_testlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			test();
			setState(357);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(353);
					match(T__1);
					setState(354);
					test();
					}
					} 
				}
				setState(359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(360);
				match(T__1);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArglistContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterArglist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitArglist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitArglist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_arglist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			argument();
			setState(368);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(364);
					match(T__1);
					setState(365);
					argument();
					}
					} 
				}
				setState(370);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(371);
				match(T__1);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public TerminalNode Assign() { return getToken(LimeGrammarParser.Assign, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(374);
				test();
				}
				break;
			case 2:
				{
				setState(375);
				test();
				setState(376);
				match(Assign);
				setState(377);
				test();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u0180\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\7\3[\n\3\f\3\16\3^\13\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4"+
		"f\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7"+
		"w\n\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\177\n\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\b\u008c\n\b\3\b\3\b\3\b\3\t\3\t\5\t\u0093\n\t\3\t\3"+
		"\t\3\n\3\n\3\n\7\n\u009a\n\n\f\n\16\n\u009d\13\n\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\5\r\u00a7\n\r\3\16\3\16\3\16\7\16\u00ac\n\16\f\16\16\16"+
		"\u00af\13\16\3\16\5\16\u00b2\n\16\3\16\3\16\3\17\3\17\3\17\5\17\u00b9"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c1\n\20\3\21\3\21\3\21\5\21"+
		"\u00c6\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00d1\n"+
		"\22\f\22\16\22\u00d4\13\22\3\22\3\22\5\22\u00d8\n\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\5\24\u00e1\n\24\3\25\3\25\3\25\3\25\6\25\u00e7\n\25"+
		"\r\25\16\25\u00e8\3\25\3\25\5\25\u00ed\n\25\3\26\3\26\3\27\3\27\3\27\7"+
		"\27\u00f4\n\27\f\27\16\27\u00f7\13\27\3\30\3\30\3\30\7\30\u00fc\n\30\f"+
		"\30\16\30\u00ff\13\30\3\31\3\31\3\31\5\31\u0104\n\31\3\32\3\32\3\32\3"+
		"\32\7\32\u010a\n\32\f\32\16\32\u010d\13\32\3\33\3\33\3\34\3\34\3\34\7"+
		"\34\u0114\n\34\f\34\16\34\u0117\13\34\3\35\3\35\3\35\7\35\u011c\n\35\f"+
		"\35\16\35\u011f\13\35\3\36\3\36\3\36\7\36\u0124\n\36\f\36\16\36\u0127"+
		"\13\36\3\37\3\37\3\37\7\37\u012c\n\37\f\37\16\37\u012f\13\37\3 \3 \3 "+
		"\7 \u0134\n \f \16 \u0137\13 \3!\3!\3!\7!\u013c\n!\f!\16!\u013f\13!\3"+
		"\"\3\"\3\"\7\"\u0144\n\"\f\"\16\"\u0147\13\"\3#\3#\3#\7#\u014c\n#\f#\16"+
		"#\u014f\13#\3$\3$\3$\5$\u0154\n$\3%\3%\3&\3&\3&\7&\u015b\n&\f&\16&\u015e"+
		"\13&\3&\5&\u0161\n&\3\'\3\'\3\'\7\'\u0166\n\'\f\'\16\'\u0169\13\'\3\'"+
		"\5\'\u016c\n\'\3(\3(\3(\7(\u0171\n(\f(\16(\u0174\13(\3(\5(\u0177\n(\3"+
		")\3)\3)\3)\3)\5)\u017e\n)\3)\2\2*\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP\2\t\4\2\37!88\4\2\7\7&*\3\2\13\f"+
		"\3\2+,\3\2-/\4\2\r\r+,\5\2\16\17\36\3689\2\u0184\2R\3\2\2\2\4U\3\2\2\2"+
		"\6e\3\2\2\2\bg\3\2\2\2\nm\3\2\2\2\fq\3\2\2\2\16\u0083\3\2\2\2\20\u0090"+
		"\3\2\2\2\22\u0096\3\2\2\2\24\u009e\3\2\2\2\26\u00a2\3\2\2\2\30\u00a6\3"+
		"\2\2\2\32\u00a8\3\2\2\2\34\u00b8\3\2\2\2\36\u00c0\3\2\2\2 \u00c2\3\2\2"+
		"\2\"\u00c7\3\2\2\2$\u00d9\3\2\2\2&\u00de\3\2\2\2(\u00ec\3\2\2\2*\u00ee"+
		"\3\2\2\2,\u00f0\3\2\2\2.\u00f8\3\2\2\2\60\u0103\3\2\2\2\62\u0105\3\2\2"+
		"\2\64\u010e\3\2\2\2\66\u0110\3\2\2\28\u0118\3\2\2\2:\u0120\3\2\2\2<\u0128"+
		"\3\2\2\2>\u0130\3\2\2\2@\u0138\3\2\2\2B\u0140\3\2\2\2D\u0148\3\2\2\2F"+
		"\u0153\3\2\2\2H\u0155\3\2\2\2J\u0157\3\2\2\2L\u0162\3\2\2\2N\u016d\3\2"+
		"\2\2P\u017d\3\2\2\2RS\5\4\3\2ST\7\2\2\3T\3\3\2\2\2UV\7\20\2\2VW\78\2\2"+
		"WX\7\66\2\2X\\\7:\2\2Y[\5\6\4\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2"+
		"\2\2]_\3\2\2\2^\\\3\2\2\2_`\7;\2\2`\5\3\2\2\2af\5\b\5\2bf\5\n\6\2cf\5"+
		"\f\7\2df\5\16\b\2ea\3\2\2\2eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2f\7\3\2\2\2g"+
		"h\7\23\2\2hi\5\66\34\2ij\7\3\2\2jk\5\26\f\2kl\7\66\2\2l\t\3\2\2\2mn\7"+
		"\24\2\2no\5\20\t\2op\5(\25\2p\13\3\2\2\2qr\7\21\2\2rs\78\2\2sv\5\20\t"+
		"\2tu\7\3\2\2uw\5\26\f\2vt\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7\66\2\2y~\7:"+
		"\2\2z{\7\26\2\2{|\5*\26\2|}\7\27\2\2}\177\3\2\2\2~z\3\2\2\2~\177\3\2\2"+
		"\2\177\u0080\3\2\2\2\u0080\u0081\5(\25\2\u0081\u0082\7;\2\2\u0082\r\3"+
		"\2\2\2\u0083\u0084\7\22\2\2\u0084\u0085\78\2\2\u0085\u0086\7\66\2\2\u0086"+
		"\u008b\7:\2\2\u0087\u0088\7\26\2\2\u0088\u0089\5*\26\2\u0089\u008a\7\27"+
		"\2\2\u008a\u008c\3\2\2\2\u008b\u0087\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008e\5(\25\2\u008e\u008f\7;\2\2\u008f\17\3\2\2\2"+
		"\u0090\u0092\7\64\2\2\u0091\u0093\5\22\n\2\u0092\u0091\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\7\65\2\2\u0095\21\3\2\2\2\u0096"+
		"\u009b\5\24\13\2\u0097\u0098\7\4\2\2\u0098\u009a\5\24\13\2\u0099\u0097"+
		"\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\23\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\78\2\2\u009f\u00a0\7\3\2\2"+
		"\u00a0\u00a1\5\26\f\2\u00a1\25\3\2\2\2\u00a2\u00a3\t\2\2\2\u00a3\27\3"+
		"\2\2\2\u00a4\u00a7\5\32\16\2\u00a5\u00a7\5\36\20\2\u00a6\u00a4\3\2\2\2"+
		"\u00a6\u00a5\3\2\2\2\u00a7\31\3\2\2\2\u00a8\u00ad\5\34\17\2\u00a9\u00aa"+
		"\7\5\2\2\u00aa\u00ac\5\34\17\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\3\2\2\2"+
		"\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad"+
		"\3\2\2\2\u00b0\u00b2\7\5\2\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b4\7\66\2\2\u00b4\33\3\2\2\2\u00b5\u00b9\5 \21"+
		"\2\u00b6\u00b9\5\b\5\2\u00b7\u00b9\5&\24\2\u00b8\u00b5\3\2\2\2\u00b8\u00b6"+
		"\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\35\3\2\2\2\u00ba\u00c1\5\"\22\2\u00bb"+
		"\u00c1\5$\23\2\u00bc\u00c1\5\f\7\2\u00bd\u00c1\5\16\b\2\u00be\u00c1\5"+
		"\n\6\2\u00bf\u00c1\5\b\5\2\u00c0\u00ba\3\2\2\2\u00c0\u00bb\3\2\2\2\u00c0"+
		"\u00bc\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2"+
		"\2\2\u00c1\37\3\2\2\2\u00c2\u00c5\58\35\2\u00c3\u00c4\7\"\2\2\u00c4\u00c6"+
		"\58\35\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6!\3\2\2\2\u00c7"+
		"\u00c8\7\30\2\2\u00c8\u00c9\5*\26\2\u00c9\u00ca\7\33\2\2\u00ca\u00d2\5"+
		"(\25\2\u00cb\u00cc\7\32\2\2\u00cc\u00cd\5*\26\2\u00cd\u00ce\7\3\2\2\u00ce"+
		"\u00cf\5(\25\2\u00cf\u00d1\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d1\u00d4\3\2"+
		"\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d7\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d5\u00d6\7\31\2\2\u00d6\u00d8\5(\25\2\u00d7\u00d5\3"+
		"\2\2\2\u00d7\u00d8\3\2\2\2\u00d8#\3\2\2\2\u00d9\u00da\7\34\2\2\u00da\u00db"+
		"\5*\26\2\u00db\u00dc\7\27\2\2\u00dc\u00dd\5(\25\2\u00dd%\3\2\2\2\u00de"+
		"\u00e0\7\35\2\2\u00df\u00e1\5*\26\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3"+
		"\2\2\2\u00e1\'\3\2\2\2\u00e2\u00ed\5\32\16\2\u00e3\u00e4\7\66\2\2\u00e4"+
		"\u00e6\7:\2\2\u00e5\u00e7\5\30\r\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00eb\7;\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00e2\3\2\2\2\u00ec\u00e3\3\2"+
		"\2\2\u00ed)\3\2\2\2\u00ee\u00ef\5,\27\2\u00ef+\3\2\2\2\u00f0\u00f5\5."+
		"\30\2\u00f1\u00f2\7#\2\2\u00f2\u00f4\5.\30\2\u00f3\u00f1\3\2\2\2\u00f4"+
		"\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6-\3\2\2\2"+
		"\u00f7\u00f5\3\2\2\2\u00f8\u00fd\5\60\31\2\u00f9\u00fa\7$\2\2\u00fa\u00fc"+
		"\5\60\31\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2"+
		"\u00fd\u00fe\3\2\2\2\u00fe/\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\7"+
		"\6\2\2\u0101\u0104\5\60\31\2\u0102\u0104\5\62\32\2\u0103\u0100\3\2\2\2"+
		"\u0103\u0102\3\2\2\2\u0104\61\3\2\2\2\u0105\u010b\5:\36\2\u0106\u0107"+
		"\5\64\33\2\u0107\u0108\5:\36\2\u0108\u010a\3\2\2\2\u0109\u0106\3\2\2\2"+
		"\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\63"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f\t\3\2\2\u010f\65\3\2\2\2\u0110"+
		"\u0115\78\2\2\u0111\u0112\7\4\2\2\u0112\u0114\78\2\2\u0113\u0111\3\2\2"+
		"\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\67"+
		"\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011d\5:\36\2\u0119\u011a\7\4\2\2\u011a"+
		"\u011c\5:\36\2\u011b\u0119\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011d\u011e\3\2\2\2\u011e9\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0125"+
		"\5<\37\2\u0121\u0122\7\b\2\2\u0122\u0124\5<\37\2\u0123\u0121\3\2\2\2\u0124"+
		"\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126;\3\2\2\2"+
		"\u0127\u0125\3\2\2\2\u0128\u012d\5> \2\u0129\u012a\7\t\2\2\u012a\u012c"+
		"\5> \2\u012b\u0129\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e=\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0135\5@!\2\u0131"+
		"\u0132\7\n\2\2\u0132\u0134\5@!\2\u0133\u0131\3\2\2\2\u0134\u0137\3\2\2"+
		"\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136?\3\2\2\2\u0137\u0135"+
		"\3\2\2\2\u0138\u013d\5B\"\2\u0139\u013a\t\4\2\2\u013a\u013c\5B\"\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2"+
		"\2\2\u013eA\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0145\5D#\2\u0141\u0142"+
		"\t\5\2\2\u0142\u0144\5D#\2\u0143\u0141\3\2\2\2\u0144\u0147\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146C\3\2\2\2\u0147\u0145\3\2\2\2"+
		"\u0148\u014d\5F$\2\u0149\u014a\t\6\2\2\u014a\u014c\5F$\2\u014b\u0149\3"+
		"\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"E\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151\t\7\2\2\u0151\u0154\5F$\2\u0152"+
		"\u0154\5H%\2\u0153\u0150\3\2\2\2\u0153\u0152\3\2\2\2\u0154G\3\2\2\2\u0155"+
		"\u0156\t\b\2\2\u0156I\3\2\2\2\u0157\u015c\5:\36\2\u0158\u0159\7\4\2\2"+
		"\u0159\u015b\5:\36\2\u015a\u0158\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a"+
		"\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015f"+
		"\u0161\7\4\2\2\u0160\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161K\3\2\2\2"+
		"\u0162\u0167\5*\26\2\u0163\u0164\7\4\2\2\u0164\u0166\5*\26\2\u0165\u0163"+
		"\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168"+
		"\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016c\7\4\2\2\u016b\u016a\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016cM\3\2\2\2\u016d\u0172\5P)\2\u016e\u016f"+
		"\7\4\2\2\u016f\u0171\5P)\2\u0170\u016e\3\2\2\2\u0171\u0174\3\2\2\2\u0172"+
		"\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2"+
		"\2\2\u0175\u0177\7\4\2\2\u0176\u0175\3\2\2\2\u0176\u0177\3\2\2\2\u0177"+
		"O\3\2\2\2\u0178\u017e\5*\26\2\u0179\u017a\5*\26\2\u017a\u017b\7\"\2\2"+
		"\u017b\u017c\5*\26\2\u017c\u017e\3\2\2\2\u017d\u0178\3\2\2\2\u017d\u0179"+
		"\3\2\2\2\u017eQ\3\2\2\2(\\ev~\u008b\u0092\u009b\u00a6\u00ad\u00b1\u00b8"+
		"\u00c0\u00c5\u00d2\u00d7\u00e0\u00e8\u00ec\u00f5\u00fd\u0103\u010b\u0115"+
		"\u011d\u0125\u012d\u0135\u013d\u0145\u014d\u0153\u015c\u0160\u0167\u016b"+
		"\u0172\u0176\u017d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}