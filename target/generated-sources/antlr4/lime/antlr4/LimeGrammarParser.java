// Generated from LimeGrammar.g4 by ANTLR 4.4

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
		CParen=46, NEWLINE=47, SKIP_=48, ID=49, INTEGER=50, INDENT=51, DEDENT=52;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "'='", "','", "'.'", "':'", "'not'", "'class'", "'method'", 
		"'action'", "'var'", "'init'", "'new'", "'when'", "'do'", "'if'", "'else'", 
		"'elif'", "'then'", "'while'", "'return'", "'nil'", "'bool'", "'int'", 
		"'void'", "'true'", "'false'", "':='", "'or'", "'and'", "'=='", "'!='", 
		"'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'%'", "'{'", 
		"'}'", "'['", "']'", "'('", "')'", "NEWLINE", "SKIP_", "ID", "INTEGER", 
		"INDENT", "DEDENT"
	};
	public static final int
		RULE_compilationUnit = 0, RULE_classDecl = 1, RULE_classMember = 2, RULE_fieldDecl = 3, 
		RULE_initDecl = 4, RULE_methodDecl = 5, RULE_actionDecl = 6, RULE_parameters = 7, 
		RULE_typeparslist = 8, RULE_parsdef = 9, RULE_type = 10, RULE_stmt = 11, 
		RULE_simple_stmt = 12, RULE_small_stmt = 13, RULE_multi_assign = 14, RULE_compound_stmt = 15, 
		RULE_localDecl = 16, RULE_expr_stmt = 17, RULE_if_stmt = 18, RULE_if_stat = 19, 
		RULE_elif_stat = 20, RULE_else_stat = 21, RULE_while_stmt = 22, RULE_return_stmt = 23, 
		RULE_block = 24, RULE_guard = 25, RULE_guardAtom = 26, RULE_id_list = 27, 
		RULE_expr_list = 28, RULE_expr = 29, RULE_atom = 30, RULE_method_call = 31, 
		RULE_args = 32;
	public static final String[] ruleNames = {
		"compilationUnit", "classDecl", "classMember", "fieldDecl", "initDecl", 
		"methodDecl", "actionDecl", "parameters", "typeparslist", "parsdef", "type", 
		"stmt", "simple_stmt", "small_stmt", "multi_assign", "compound_stmt", 
		"localDecl", "expr_stmt", "if_stmt", "if_stat", "elif_stat", "else_stat", 
		"while_stmt", "return_stmt", "block", "guard", "guardAtom", "id_list", 
		"expr_list", "expr", "atom", "method_call", "args"
	};

	@Override
	public String getGrammarFileName() { return "LimeGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public TerminalNode EOF() { return getToken(LimeGrammarParser.EOF, 0); }
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(66); classDecl();
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Class );
			}
			setState(71); match(EOF);
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
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public ClassMemberContext classMember(int i) {
			return getRuleContext(ClassMemberContext.class,i);
		}
		public TerminalNode DEDENT() { return getToken(LimeGrammarParser.DEDENT, 0); }
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(LimeGrammarParser.INDENT, 0); }
		public List<ClassMemberContext> classMember() {
			return getRuleContexts(ClassMemberContext.class);
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
			setState(73); match(Class);
			setState(74); match(ID);
			setState(75); match(NEWLINE);
			setState(76); match(INDENT);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Method) | (1L << Action) | (1L << Var) | (1L << Init))) != 0)) {
				{
				{
				setState(77); classMember();
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83); match(DEDENT);
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
		public MethodDeclContext methodDecl() {
			return getRuleContext(MethodDeclContext.class,0);
		}
		public FieldDeclContext fieldDecl() {
			return getRuleContext(FieldDeclContext.class,0);
		}
		public InitDeclContext initDecl() {
			return getRuleContext(InitDeclContext.class,0);
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
			setState(89);
			switch (_input.LA(1)) {
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(85); fieldDecl();
				}
				break;
			case Init:
				enterOuterAlt(_localctx, 2);
				{
				setState(86); initDecl();
				}
				break;
			case Method:
				enterOuterAlt(_localctx, 3);
				{
				setState(87); methodDecl();
				}
				break;
			case Action:
				enterOuterAlt(_localctx, 4);
				{
				setState(88); actionDecl();
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

	public static class FieldDeclContext extends ParserRuleContext {
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitFieldDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitFieldDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fieldDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); match(Var);
			setState(92); id_list();
			setState(93); match(T__1);
			setState(94); type();
			setState(95); match(NEWLINE);
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
		public TerminalNode DEDENT() { return getToken(LimeGrammarParser.DEDENT, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(LimeGrammarParser.INDENT, 0); }
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
			setState(97); match(Init);
			setState(98); parameters();
			setState(99); match(NEWLINE);
			setState(100); match(INDENT);
			setState(101); block();
			setState(102); match(DEDENT);
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
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(LimeGrammarParser.DEDENT, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(LimeGrammarParser.INDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
			setState(104); match(Method);
			setState(105); match(ID);
			setState(106); parameters();
			setState(109);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(107); match(T__1);
				setState(108); type();
				}
			}

			setState(117);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(111); match(NEWLINE);
				setState(112); match(INDENT);
				setState(113); match(When);
				setState(114); guard();
				setState(115); match(Do);
				}
				break;
			}
			setState(119); block();
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(120); match(DEDENT);
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

	public static class ActionDeclContext extends ParserRuleContext {
		public Scope scope;
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(LimeGrammarParser.DEDENT, 0); }
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(LimeGrammarParser.INDENT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(Action);
			setState(124); match(ID);
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(125); match(NEWLINE);
				setState(126); match(INDENT);
				setState(127); match(When);
				setState(128); guard();
				setState(129); match(Do);
				}
				break;
			}
			setState(133); block();
			setState(135);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(134); match(DEDENT);
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

	public static class ParametersContext extends ParserRuleContext {
		public TypeparslistContext typeparslist() {
			return getRuleContext(TypeparslistContext.class,0);
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
			setState(137); match(OParen);
			setState(139);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(138); typeparslist();
				}
			}

			setState(141); match(CParen);
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

	public static class TypeparslistContext extends ParserRuleContext {
		public ParsdefContext parsdef(int i) {
			return getRuleContext(ParsdefContext.class,i);
		}
		public List<ParsdefContext> parsdef() {
			return getRuleContexts(ParsdefContext.class);
		}
		public TypeparslistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeparslist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterTypeparslist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitTypeparslist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitTypeparslist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeparslistContext typeparslist() throws RecognitionException {
		TypeparslistContext _localctx = new TypeparslistContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeparslist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); parsdef();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(144); match(T__3);
				setState(145); parsdef();
				}
				}
				setState(150);
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

	public static class ParsdefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParsdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parsdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterParsdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitParsdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitParsdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParsdefContext parsdef() throws RecognitionException {
		ParsdefContext _localctx = new ParsdefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parsdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(ID);
			setState(152); match(T__1);
			setState(153); type();
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
			setState(155);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Booltype) | (1L << Inttype) | (1L << Voidtype) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
			setState(159);
			switch (_input.LA(1)) {
			case T__0:
			case Var:
			case New:
			case Return:
			case Null:
			case True:
			case False:
			case Subtract:
			case ID:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(157); simple_stmt();
				}
				break;
			case If:
			case While:
				enterOuterAlt(_localctx, 2);
				{
				setState(158); compound_stmt();
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
			setState(161); small_stmt();
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(162); match(T__5);
					setState(163); small_stmt();
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(170);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(169); match(T__5);
				}
			}

			setState(172); match(NEWLINE);
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
		public LocalDeclContext localDecl() {
			return getRuleContext(LocalDeclContext.class,0);
		}
		public Multi_assignContext multi_assign() {
			return getRuleContext(Multi_assignContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
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
			setState(179);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174); multi_assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175); expr_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(176); localDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(177); return_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(178); method_call();
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

	public static class Multi_assignContext extends ParserRuleContext {
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public Multi_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterMulti_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitMulti_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitMulti_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multi_assignContext multi_assign() throws RecognitionException {
		Multi_assignContext _localctx = new Multi_assignContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_multi_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); id_list();
			setState(182); match(Assign);
			setState(183); expr_list();
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
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
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
		enterRule(_localctx, 30, RULE_compound_stmt);
		try {
			setState(187);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(185); if_stmt();
				}
				break;
			case While:
				enterOuterAlt(_localctx, 2);
				{
				setState(186); while_stmt();
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

	public static class LocalDeclContext extends ParserRuleContext {
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LocalDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterLocalDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitLocalDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitLocalDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalDeclContext localDecl() throws RecognitionException {
		LocalDeclContext _localctx = new LocalDeclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_localDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); match(Var);
			setState(190); id_list();
			setState(191); match(T__1);
			setState(192); type();
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
		public Expr_listContext src;
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
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
		enterRule(_localctx, 34, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); ((Expr_stmtContext)_localctx).src = expr_list();
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
		public If_statContext if_stat() {
			return getRuleContext(If_statContext.class,0);
		}
		public Elif_statContext elif_stat(int i) {
			return getRuleContext(Elif_statContext.class,i);
		}
		public List<Elif_statContext> elif_stat() {
			return getRuleContexts(Elif_statContext.class);
		}
		public Else_statContext else_stat() {
			return getRuleContext(Else_statContext.class,0);
		}
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
		enterRule(_localctx, 36, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); if_stat();
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Elif) {
				{
				{
				setState(197); elif_stat();
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(203); else_stat();
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

	public static class If_statContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterIf_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitIf_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitIf_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_if_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206); match(If);
			setState(207); expr(0);
			setState(208); match(Then);
			setState(209); block();
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

	public static class Elif_statContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Elif_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterElif_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitElif_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitElif_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Elif_statContext elif_stat() throws RecognitionException {
		Elif_statContext _localctx = new Elif_statContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_elif_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); match(Elif);
			setState(212); expr(0);
			setState(213); match(Then);
			setState(214); block();
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

	public static class Else_statContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterElse_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitElse_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitElse_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statContext else_stat() throws RecognitionException {
		Else_statContext _localctx = new Else_statContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_else_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); match(Else);
			setState(217); block();
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		enterRule(_localctx, 44, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); match(While);
			setState(220); expr(0);
			setState(221); match(Do);
			setState(222); block();
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		enterRule(_localctx, 46, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224); match(Return);
			setState(226);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << Subtract) | (1L << ID) | (1L << INTEGER))) != 0)) {
				{
				setState(225); expr(0);
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
		public TerminalNode DEDENT() { return getToken(LimeGrammarParser.DEDENT, 0); }
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(LimeGrammarParser.INDENT, 0); }
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Simple_stmtContext simple_stmt() {
			return getRuleContext(Simple_stmtContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
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
		enterRule(_localctx, 48, RULE_block);
		int _la;
		try {
			setState(238);
			switch (_input.LA(1)) {
			case T__0:
			case Var:
			case New:
			case Return:
			case Null:
			case True:
			case False:
			case Subtract:
			case ID:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(228); simple_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(229); match(NEWLINE);
				setState(230); match(INDENT);
				setState(232); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(231); stmt();
					}
					}
					setState(234); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Var) | (1L << New) | (1L << If) | (1L << While) | (1L << Return) | (1L << Null) | (1L << True) | (1L << False) | (1L << Subtract) | (1L << ID) | (1L << INTEGER))) != 0) );
				setState(236); match(DEDENT);
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

	public static class GuardContext extends ParserRuleContext {
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
	 
		public GuardContext() { }
		public void copyFrom(GuardContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GuardandexprContext extends GuardContext {
		public GuardAtomContext guardAtom(int i) {
			return getRuleContext(GuardAtomContext.class,i);
		}
		public List<GuardAtomContext> guardAtom() {
			return getRuleContexts(GuardAtomContext.class);
		}
		public GuardandexprContext(GuardContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterGuardandexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitGuardandexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitGuardandexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GuardatomexprContext extends GuardContext {
		public GuardAtomContext guardAtom() {
			return getRuleContext(GuardAtomContext.class,0);
		}
		public GuardatomexprContext(GuardContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterGuardatomexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitGuardatomexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitGuardatomexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GuardcompexprContext extends GuardContext {
		public Token op;
		public GuardAtomContext guardAtom(int i) {
			return getRuleContext(GuardAtomContext.class,i);
		}
		public List<GuardAtomContext> guardAtom() {
			return getRuleContexts(GuardAtomContext.class);
		}
		public GuardcompexprContext(GuardContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterGuardcompexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitGuardcompexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitGuardcompexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GuardorexprContext extends GuardContext {
		public GuardAtomContext guardAtom(int i) {
			return getRuleContext(GuardAtomContext.class,i);
		}
		public List<GuardAtomContext> guardAtom() {
			return getRuleContexts(GuardAtomContext.class);
		}
		public GuardorexprContext(GuardContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterGuardorexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitGuardorexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitGuardorexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GuardeqexprContext extends GuardContext {
		public Token op;
		public GuardAtomContext guardAtom(int i) {
			return getRuleContext(GuardAtomContext.class,i);
		}
		public List<GuardAtomContext> guardAtom() {
			return getRuleContexts(GuardAtomContext.class);
		}
		public GuardeqexprContext(GuardContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterGuardeqexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitGuardeqexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitGuardeqexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_guard);
		int _la;
		try {
			setState(257);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new GuardcompexprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(240); guardAtom();
				setState(241);
				((GuardcompexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GTEquals) | (1L << LTEquals) | (1L << GT) | (1L << LT))) != 0)) ) {
					((GuardcompexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(242); guardAtom();
				}
				break;
			case 2:
				_localctx = new GuardeqexprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244); guardAtom();
				setState(245);
				((GuardeqexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==NEquals) ) {
					((GuardeqexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(246); guardAtom();
				}
				break;
			case 3:
				_localctx = new GuardandexprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(248); guardAtom();
				setState(249); match(And);
				setState(250); guardAtom();
				}
				break;
			case 4:
				_localctx = new GuardorexprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(252); guardAtom();
				setState(253); match(Or);
				setState(254); guardAtom();
				}
				break;
			case 5:
				_localctx = new GuardatomexprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(256); guardAtom();
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

	public static class GuardAtomContext extends ParserRuleContext {
		public GuardAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardAtom; }
	 
		public GuardAtomContext() { }
		public void copyFrom(GuardAtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdguardatomContext extends GuardAtomContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public IdguardatomContext(GuardAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterIdguardatom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitIdguardatom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitIdguardatom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntguardatomContext extends GuardAtomContext {
		public TerminalNode INTEGER() { return getToken(LimeGrammarParser.INTEGER, 0); }
		public IntguardatomContext(GuardAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterIntguardatom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitIntguardatom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitIntguardatom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotguardtomContext extends GuardAtomContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public NotguardtomContext(GuardAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterNotguardtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitNotguardtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitNotguardtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardAtomContext guardAtom() throws RecognitionException {
		GuardAtomContext _localctx = new GuardAtomContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_guardAtom);
		try {
			setState(263);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new IdguardatomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259); match(ID);
				}
				break;
			case INTEGER:
				_localctx = new IntguardatomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(260); match(INTEGER);
				}
				break;
			case T__0:
				_localctx = new NotguardtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(261); match(T__0);
				setState(262); match(ID);
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
		enterRule(_localctx, 54, RULE_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); match(ID);
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(266); match(T__3);
				setState(267); match(ID);
				}
				}
				setState(272);
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
		enterRule(_localctx, 56, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); expr(0);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(274); match(T__3);
				setState(275); expr(0);
				}
				}
				setState(280);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqexprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterEqexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitEqexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitEqexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterNotexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitNotexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitNotexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultexprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterMultexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitMultexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitMultexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompexprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterCompexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitCompexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitCompexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryMinusexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinusexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterUnaryMinusexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitUnaryMinusexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitUnaryMinusexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddexprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterAddexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitAddexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitAddexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomexprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterAtomexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitAtomexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitAtomexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterOrexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitOrexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitOrexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndexprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterAndexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitAndexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitAndexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			switch (_input.LA(1)) {
			case Subtract:
				{
				_localctx = new UnaryMinusexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(282); match(Subtract);
				setState(283); expr(9);
				}
				break;
			case T__0:
				{
				_localctx = new NotexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(284); match(T__0);
				setState(285); expr(8);
				}
				break;
			case New:
			case Null:
			case True:
			case False:
			case ID:
			case INTEGER:
				{
				_localctx = new AtomexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(286); atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(307);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new MultexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(289);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(290);
						((MultexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multiply) | (1L << Divide) | (1L << Modulus))) != 0)) ) {
							((MultexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(291); expr(8);
						}
						break;
					case 2:
						{
						_localctx = new AddexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(292);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(293);
						((AddexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Subtract) ) {
							((AddexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(294); expr(7);
						}
						break;
					case 3:
						{
						_localctx = new CompexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(295);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(296);
						((CompexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GTEquals) | (1L << LTEquals) | (1L << GT) | (1L << LT))) != 0)) ) {
							((CompexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(297); expr(6);
						}
						break;
					case 4:
						{
						_localctx = new EqexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(298);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(299);
						((EqexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==NEquals) ) {
							((EqexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(300); expr(5);
						}
						break;
					case 5:
						{
						_localctx = new AndexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(301);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(302); match(And);
						setState(303); expr(4);
						}
						break;
					case 6:
						{
						_localctx = new OrexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(304);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(305); match(Or);
						setState(306); expr(3);
						}
						break;
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public TerminalNode INTEGER() { return getToken(LimeGrammarParser.INTEGER, 0); }
		public TerminalNode False() { return getToken(LimeGrammarParser.False, 0); }
		public TerminalNode True() { return getToken(LimeGrammarParser.True, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
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
		enterRule(_localctx, 60, RULE_atom);
		try {
			setState(318);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(312); match(INTEGER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(313); match(True);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(314); match(False);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(315); match(Null);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(316); match(ID);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(317); method_call();
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

	public static class Method_callContext extends ParserRuleContext {
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
	 
		public Method_callContext() { }
		public void copyFrom(Method_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MethodcallContext extends Method_callContext {
		public Token c;
		public Token m;
		public List<TerminalNode> ID() { return getTokens(LimeGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LimeGrammarParser.ID, i);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public MethodcallContext(Method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterMethodcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitMethodcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitMethodcall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewcallContext extends Method_callContext {
		public Token n;
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public NewcallContext(Method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterNewcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitNewcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitNewcall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_method_call);
		try {
			setState(327);
			switch (_input.LA(1)) {
			case New:
				_localctx = new NewcallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(320); match(New);
				setState(321); ((NewcallContext)_localctx).n = match(ID);
				setState(322); args();
				}
				break;
			case ID:
				_localctx = new MethodcallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(323); ((MethodcallContext)_localctx).c = match(ID);
				setState(324); match(T__2);
				setState(325); ((MethodcallContext)_localctx).m = match(ID);
				setState(326); args();
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

	public static class ArgsContext extends ParserRuleContext {
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329); match(OParen);
			setState(331);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << Subtract) | (1L << ID) | (1L << INTEGER))) != 0)) {
				{
				setState(330); expr_list();
				}
			}

			setState(333); match(CParen);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 29: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 7);
		case 1: return precpred(_ctx, 6);
		case 2: return precpred(_ctx, 5);
		case 3: return precpred(_ctx, 4);
		case 4: return precpred(_ctx, 3);
		case 5: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\66\u0152\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\6\2F\n\2\r\2\16\2G\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3Q\n"+
		"\3\f\3\16\3T\13\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4\\\n\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7p\n\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7x\n\7\3\7\3\7\5\7|\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u0086\n\b\3\b\3\b\5\b\u008a\n\b\3\t\3\t\5\t\u008e\n\t\3\t\3"+
		"\t\3\n\3\n\3\n\7\n\u0095\n\n\f\n\16\n\u0098\13\n\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\5\r\u00a2\n\r\3\16\3\16\3\16\7\16\u00a7\n\16\f\16\16\16"+
		"\u00aa\13\16\3\16\5\16\u00ad\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5"+
		"\17\u00b6\n\17\3\20\3\20\3\20\3\20\3\21\3\21\5\21\u00be\n\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\24\3\24\7\24\u00c9\n\24\f\24\16\24\u00cc\13"+
		"\24\3\24\5\24\u00cf\n\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\5\31\u00e5\n\31"+
		"\3\32\3\32\3\32\3\32\6\32\u00eb\n\32\r\32\16\32\u00ec\3\32\3\32\5\32\u00f1"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u0104\n\33\3\34\3\34\3\34\3\34\5\34\u010a\n"+
		"\34\3\35\3\35\3\35\7\35\u010f\n\35\f\35\16\35\u0112\13\35\3\36\3\36\3"+
		"\36\7\36\u0117\n\36\f\36\16\36\u011a\13\36\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\5\37\u0122\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0136\n\37\f\37\16\37\u0139"+
		"\13\37\3 \3 \3 \3 \3 \3 \5 \u0141\n \3!\3!\3!\3!\3!\3!\3!\5!\u014a\n!"+
		"\3\"\3\"\5\"\u014e\n\"\3\"\3\"\3\"\2\3<#\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\7\4\2\30\32\63\63\3\2\"%\4\2\4"+
		"\4!!\3\2(*\3\2&\'\u0160\2E\3\2\2\2\4K\3\2\2\2\6[\3\2\2\2\b]\3\2\2\2\n"+
		"c\3\2\2\2\fj\3\2\2\2\16}\3\2\2\2\20\u008b\3\2\2\2\22\u0091\3\2\2\2\24"+
		"\u0099\3\2\2\2\26\u009d\3\2\2\2\30\u00a1\3\2\2\2\32\u00a3\3\2\2\2\34\u00b5"+
		"\3\2\2\2\36\u00b7\3\2\2\2 \u00bd\3\2\2\2\"\u00bf\3\2\2\2$\u00c4\3\2\2"+
		"\2&\u00c6\3\2\2\2(\u00d0\3\2\2\2*\u00d5\3\2\2\2,\u00da\3\2\2\2.\u00dd"+
		"\3\2\2\2\60\u00e2\3\2\2\2\62\u00f0\3\2\2\2\64\u0103\3\2\2\2\66\u0109\3"+
		"\2\2\28\u010b\3\2\2\2:\u0113\3\2\2\2<\u0121\3\2\2\2>\u0140\3\2\2\2@\u0149"+
		"\3\2\2\2B\u014b\3\2\2\2DF\5\4\3\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2"+
		"\2\2HI\3\2\2\2IJ\7\2\2\3J\3\3\2\2\2KL\7\t\2\2LM\7\63\2\2MN\7\61\2\2NR"+
		"\7\65\2\2OQ\5\6\4\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2"+
		"TR\3\2\2\2UV\7\66\2\2V\5\3\2\2\2W\\\5\b\5\2X\\\5\n\6\2Y\\\5\f\7\2Z\\\5"+
		"\16\b\2[W\3\2\2\2[X\3\2\2\2[Y\3\2\2\2[Z\3\2\2\2\\\7\3\2\2\2]^\7\f\2\2"+
		"^_\58\35\2_`\7\7\2\2`a\5\26\f\2ab\7\61\2\2b\t\3\2\2\2cd\7\r\2\2de\5\20"+
		"\t\2ef\7\61\2\2fg\7\65\2\2gh\5\62\32\2hi\7\66\2\2i\13\3\2\2\2jk\7\n\2"+
		"\2kl\7\63\2\2lo\5\20\t\2mn\7\7\2\2np\5\26\f\2om\3\2\2\2op\3\2\2\2pw\3"+
		"\2\2\2qr\7\61\2\2rs\7\65\2\2st\7\17\2\2tu\5\64\33\2uv\7\20\2\2vx\3\2\2"+
		"\2wq\3\2\2\2wx\3\2\2\2xy\3\2\2\2y{\5\62\32\2z|\7\66\2\2{z\3\2\2\2{|\3"+
		"\2\2\2|\r\3\2\2\2}~\7\13\2\2~\u0085\7\63\2\2\177\u0080\7\61\2\2\u0080"+
		"\u0081\7\65\2\2\u0081\u0082\7\17\2\2\u0082\u0083\5\64\33\2\u0083\u0084"+
		"\7\20\2\2\u0084\u0086\3\2\2\2\u0085\177\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0089\5\62\32\2\u0088\u008a\7\66\2\2\u0089\u0088"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\17\3\2\2\2\u008b\u008d\7/\2\2\u008c"+
		"\u008e\5\22\n\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3"+
		"\2\2\2\u008f\u0090\7\60\2\2\u0090\21\3\2\2\2\u0091\u0096\5\24\13\2\u0092"+
		"\u0093\7\5\2\2\u0093\u0095\5\24\13\2\u0094\u0092\3\2\2\2\u0095\u0098\3"+
		"\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\23\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009a\7\63\2\2\u009a\u009b\7\7\2\2\u009b\u009c\5"+
		"\26\f\2\u009c\25\3\2\2\2\u009d\u009e\t\2\2\2\u009e\27\3\2\2\2\u009f\u00a2"+
		"\5\32\16\2\u00a0\u00a2\5 \21\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2"+
		"\u00a2\31\3\2\2\2\u00a3\u00a8\5\34\17\2\u00a4\u00a5\7\3\2\2\u00a5\u00a7"+
		"\5\34\17\2\u00a6\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2"+
		"\u00a8\u00a9\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ad"+
		"\7\3\2\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00af\7\61\2\2\u00af\33\3\2\2\2\u00b0\u00b6\5\36\20\2\u00b1\u00b6\5$"+
		"\23\2\u00b2\u00b6\5\"\22\2\u00b3\u00b6\5\60\31\2\u00b4\u00b6\5@!\2\u00b5"+
		"\u00b0\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b5\u00b4\3\2\2\2\u00b6\35\3\2\2\2\u00b7\u00b8\58\35\2\u00b8\u00b9"+
		"\7\35\2\2\u00b9\u00ba\5:\36\2\u00ba\37\3\2\2\2\u00bb\u00be\5&\24\2\u00bc"+
		"\u00be\5.\30\2\u00bd\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be!\3\2\2\2"+
		"\u00bf\u00c0\7\f\2\2\u00c0\u00c1\58\35\2\u00c1\u00c2\7\7\2\2\u00c2\u00c3"+
		"\5\26\f\2\u00c3#\3\2\2\2\u00c4\u00c5\5:\36\2\u00c5%\3\2\2\2\u00c6\u00ca"+
		"\5(\25\2\u00c7\u00c9\5*\26\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2"+
		"\2\2\u00cd\u00cf\5,\27\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\'\3\2\2\2\u00d0\u00d1\7\21\2\2\u00d1\u00d2\5<\37\2\u00d2\u00d3\7\24\2"+
		"\2\u00d3\u00d4\5\62\32\2\u00d4)\3\2\2\2\u00d5\u00d6\7\23\2\2\u00d6\u00d7"+
		"\5<\37\2\u00d7\u00d8\7\24\2\2\u00d8\u00d9\5\62\32\2\u00d9+\3\2\2\2\u00da"+
		"\u00db\7\22\2\2\u00db\u00dc\5\62\32\2\u00dc-\3\2\2\2\u00dd\u00de\7\25"+
		"\2\2\u00de\u00df\5<\37\2\u00df\u00e0\7\20\2\2\u00e0\u00e1\5\62\32\2\u00e1"+
		"/\3\2\2\2\u00e2\u00e4\7\26\2\2\u00e3\u00e5\5<\37\2\u00e4\u00e3\3\2\2\2"+
		"\u00e4\u00e5\3\2\2\2\u00e5\61\3\2\2\2\u00e6\u00f1\5\32\16\2\u00e7\u00e8"+
		"\7\61\2\2\u00e8\u00ea\7\65\2\2\u00e9\u00eb\5\30\r\2\u00ea\u00e9\3\2\2"+
		"\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee\u00ef\7\66\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00e6\3\2\2\2"+
		"\u00f0\u00e7\3\2\2\2\u00f1\63\3\2\2\2\u00f2\u00f3\5\66\34\2\u00f3\u00f4"+
		"\t\3\2\2\u00f4\u00f5\5\66\34\2\u00f5\u0104\3\2\2\2\u00f6\u00f7\5\66\34"+
		"\2\u00f7\u00f8\t\4\2\2\u00f8\u00f9\5\66\34\2\u00f9\u0104\3\2\2\2\u00fa"+
		"\u00fb\5\66\34\2\u00fb\u00fc\7\37\2\2\u00fc\u00fd\5\66\34\2\u00fd\u0104"+
		"\3\2\2\2\u00fe\u00ff\5\66\34\2\u00ff\u0100\7\36\2\2\u0100\u0101\5\66\34"+
		"\2\u0101\u0104\3\2\2\2\u0102\u0104\5\66\34\2\u0103\u00f2\3\2\2\2\u0103"+
		"\u00f6\3\2\2\2\u0103\u00fa\3\2\2\2\u0103\u00fe\3\2\2\2\u0103\u0102\3\2"+
		"\2\2\u0104\65\3\2\2\2\u0105\u010a\7\63\2\2\u0106\u010a\7\64\2\2\u0107"+
		"\u0108\7\b\2\2\u0108\u010a\7\63\2\2\u0109\u0105\3\2\2\2\u0109\u0106\3"+
		"\2\2\2\u0109\u0107\3\2\2\2\u010a\67\3\2\2\2\u010b\u0110\7\63\2\2\u010c"+
		"\u010d\7\5\2\2\u010d\u010f\7\63\2\2\u010e\u010c\3\2\2\2\u010f\u0112\3"+
		"\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u01119\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0113\u0118\5<\37\2\u0114\u0115\7\5\2\2\u0115\u0117\5<\37\2\u0116"+
		"\u0114\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2"+
		"\2\2\u0119;\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\b\37\1\2\u011c\u011d"+
		"\7\'\2\2\u011d\u0122\5<\37\13\u011e\u011f\7\b\2\2\u011f\u0122\5<\37\n"+
		"\u0120\u0122\5> \2\u0121\u011b\3\2\2\2\u0121\u011e\3\2\2\2\u0121\u0120"+
		"\3\2\2\2\u0122\u0137\3\2\2\2\u0123\u0124\f\t\2\2\u0124\u0125\t\5\2\2\u0125"+
		"\u0136\5<\37\n\u0126\u0127\f\b\2\2\u0127\u0128\t\6\2\2\u0128\u0136\5<"+
		"\37\t\u0129\u012a\f\7\2\2\u012a\u012b\t\3\2\2\u012b\u0136\5<\37\b\u012c"+
		"\u012d\f\6\2\2\u012d\u012e\t\4\2\2\u012e\u0136\5<\37\7\u012f\u0130\f\5"+
		"\2\2\u0130\u0131\7\37\2\2\u0131\u0136\5<\37\6\u0132\u0133\f\4\2\2\u0133"+
		"\u0134\7\36\2\2\u0134\u0136\5<\37\5\u0135\u0123\3\2\2\2\u0135\u0126\3"+
		"\2\2\2\u0135\u0129\3\2\2\2\u0135\u012c\3\2\2\2\u0135\u012f\3\2\2\2\u0135"+
		"\u0132\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2"+
		"\2\2\u0138=\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u0141\7\64\2\2\u013b\u0141"+
		"\7\33\2\2\u013c\u0141\7\34\2\2\u013d\u0141\7\27\2\2\u013e\u0141\7\63\2"+
		"\2\u013f\u0141\5@!\2\u0140\u013a\3\2\2\2\u0140\u013b\3\2\2\2\u0140\u013c"+
		"\3\2\2\2\u0140\u013d\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u013f\3\2\2\2\u0141"+
		"?\3\2\2\2\u0142\u0143\7\16\2\2\u0143\u0144\7\63\2\2\u0144\u014a\5B\"\2"+
		"\u0145\u0146\7\63\2\2\u0146\u0147\7\6\2\2\u0147\u0148\7\63\2\2\u0148\u014a"+
		"\5B\"\2\u0149\u0142\3\2\2\2\u0149\u0145\3\2\2\2\u014aA\3\2\2\2\u014b\u014d"+
		"\7/\2\2\u014c\u014e\5:\36\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014f\u0150\7\60\2\2\u0150C\3\2\2\2 GR[ow{\u0085\u0089"+
		"\u008d\u0096\u00a1\u00a8\u00ac\u00b5\u00bd\u00ca\u00ce\u00e4\u00ec\u00f0"+
		"\u0103\u0109\u0110\u0118\u0121\u0135\u0137\u0140\u0149\u014d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}