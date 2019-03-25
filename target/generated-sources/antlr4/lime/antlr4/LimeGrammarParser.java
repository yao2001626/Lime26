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
		T__11=1, T__10=2, T__9=3, T__8=4, T__7=5, T__6=6, T__5=7, T__4=8, T__3=9, 
		T__2=10, T__1=11, T__0=12, Class=13, Method=14, Action=15, Var=16, Init=17, 
		New=18, When=19, Do=20, If=21, Else=22, Elif=23, Then=24, While=25, Return=26, 
		Null=27, Booltype=28, Inttype=29, Voidtype=30, True=31, False=32, Assign=33, 
		Or=34, And=35, Equals=36, NEquals=37, GTEquals=38, LTEquals=39, GT=40, 
		LT=41, Add=42, Subtract=43, Multiply=44, Divide=45, Modulus=46, OBrace=47, 
		CBrace=48, OBracket=49, CBracket=50, OParen=51, CParen=52, NEWLINE=53, 
		SKIP_=54, ID=55, INTEGER=56, INDENT=57, DEDENT=58;
	public static final String[] tokenNames = {
		"<INVALID>", "';'", "'='", "'for'", "'print'", "','", "'.'", "'rand'", 
		"'to'", "':'", "'getArg'", "'not'", "'import'", "'class'", "'method'", 
		"'action'", "'var'", "'init'", "'new'", "'when'", "'do'", "'if'", "'else'", 
		"'elif'", "'then'", "'while'", "'return'", "'nil'", "'bool'", "'int'", 
		"'void'", "'true'", "'false'", "':='", "'or'", "'and'", "'=='", "'!='", 
		"'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'%'", "'{'", 
		"'}'", "'['", "']'", "'('", "')'", "NEWLINE", "SKIP_", "ID", "INTEGER", 
		"INDENT", "DEDENT"
	};
	public static final int
		RULE_compilationUnit = 0, RULE_import_stmt = 1, RULE_classDecl = 2, RULE_classMember = 3, 
		RULE_fieldDecl = 4, RULE_initDecl = 5, RULE_methodDecl = 6, RULE_actionDecl = 7, 
		RULE_parameters = 8, RULE_typeparslist = 9, RULE_parsdef = 10, RULE_type = 11, 
		RULE_type_list = 12, RULE_stmt = 13, RULE_simple_stmt = 14, RULE_small_stmt = 15, 
		RULE_multi_assign = 16, RULE_single_assign = 17, RULE_compound_stmt = 18, 
		RULE_localDecl = 19, RULE_expr_stmt = 20, RULE_if_stmt = 21, RULE_if_stat = 22, 
		RULE_elif_stat = 23, RULE_else_stat = 24, RULE_while_stmt = 25, RULE_for_stmt = 26, 
		RULE_return_stmt = 27, RULE_block = 28, RULE_guard = 29, RULE_guardAtom = 30, 
		RULE_id_list = 31, RULE_expr_list = 32, RULE_expr = 33, RULE_atom = 34, 
		RULE_method_call = 35, RULE_args = 36;
	public static final String[] ruleNames = {
		"compilationUnit", "import_stmt", "classDecl", "classMember", "fieldDecl", 
		"initDecl", "methodDecl", "actionDecl", "parameters", "typeparslist", 
		"parsdef", "type", "type_list", "stmt", "simple_stmt", "small_stmt", "multi_assign", 
		"single_assign", "compound_stmt", "localDecl", "expr_stmt", "if_stmt", 
		"if_stat", "elif_stat", "else_stat", "while_stmt", "for_stmt", "return_stmt", 
		"block", "guard", "guardAtom", "id_list", "expr_list", "expr", "atom", 
		"method_call", "args"
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
		public List<Import_stmtContext> import_stmt() {
			return getRuleContexts(Import_stmtContext.class);
		}
		public TerminalNode EOF() { return getToken(LimeGrammarParser.EOF, 0); }
		public Import_stmtContext import_stmt(int i) {
			return getRuleContext(Import_stmtContext.class,i);
		}
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
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(74); import_stmt();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(80); classDecl();
				}
				}
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Class );
			setState(85); match(EOF);
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

	public static class Import_stmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public Type_listContext type_list() {
			return getRuleContext(Type_listContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Import_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterImport_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitImport_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitImport_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_stmtContext import_stmt() throws RecognitionException {
		Import_stmtContext _localctx = new Import_stmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_import_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); match(T__0);
			setState(88); match(ID);
			setState(89); match(OParen);
			setState(90); type_list();
			setState(91); match(CParen);
			setState(94);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(92); match(T__3);
				setState(93); type();
				}
			}

			setState(96); match(NEWLINE);
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
		enterRule(_localctx, 4, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); match(Class);
			setState(99); match(ID);
			setState(100); match(NEWLINE);
			setState(101); match(INDENT);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Method) | (1L << Action) | (1L << Var) | (1L << Init))) != 0)) {
				{
				{
				setState(102); classMember();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108); match(DEDENT);
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
		enterRule(_localctx, 6, RULE_classMember);
		try {
			setState(114);
			switch (_input.LA(1)) {
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(110); fieldDecl();
				}
				break;
			case Init:
				enterOuterAlt(_localctx, 2);
				{
				setState(111); initDecl();
				}
				break;
			case Method:
				enterOuterAlt(_localctx, 3);
				{
				setState(112); methodDecl();
				}
				break;
			case Action:
				enterOuterAlt(_localctx, 4);
				{
				setState(113); actionDecl();
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
		enterRule(_localctx, 8, RULE_fieldDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(Var);
			setState(117); id_list();
			setState(118); match(T__3);
			setState(119); type();
			setState(120); match(NEWLINE);
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
		enterRule(_localctx, 10, RULE_initDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(Init);
			setState(123); parameters();
			setState(124); block();
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
		enterRule(_localctx, 12, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); match(Method);
			setState(127); match(ID);
			setState(128); parameters();
			setState(131);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(129); match(T__3);
				setState(130); type();
				}
			}

			setState(139);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(133); match(NEWLINE);
				setState(134); match(INDENT);
				setState(135); match(When);
				setState(136); guard();
				setState(137); match(Do);
				}
				break;
			}
			setState(141); block();
			setState(143);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(142); match(DEDENT);
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
		enterRule(_localctx, 14, RULE_actionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(Action);
			setState(146); match(ID);
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(147); match(NEWLINE);
				setState(148); match(INDENT);
				setState(149); match(When);
				setState(150); guard();
				setState(151); match(Do);
				}
				break;
			}
			setState(155); block();
			setState(157);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(156); match(DEDENT);
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
		enterRule(_localctx, 16, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); match(OParen);
			setState(161);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(160); typeparslist();
				}
			}

			setState(163); match(CParen);
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
		enterRule(_localctx, 18, RULE_typeparslist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); parsdef();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(166); match(T__7);
				setState(167); parsdef();
				}
				}
				setState(172);
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
		enterRule(_localctx, 20, RULE_parsdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); match(ID);
			setState(174); match(T__3);
			setState(175); type();
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
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
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

	public static class Type_listContext extends ParserRuleContext {
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public Type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterType_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitType_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitType_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_listContext type_list() throws RecognitionException {
		Type_listContext _localctx = new Type_listContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); type();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(180); match(T__7);
				setState(181); type();
				}
				}
				setState(186);
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
		enterRule(_localctx, 26, RULE_stmt);
		try {
			setState(189);
			switch (_input.LA(1)) {
			case T__8:
			case T__5:
			case T__2:
			case T__1:
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
				setState(187); simple_stmt();
				}
				break;
			case T__9:
			case If:
			case While:
				enterOuterAlt(_localctx, 2);
				{
				setState(188); compound_stmt();
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
		enterRule(_localctx, 28, RULE_simple_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191); small_stmt();
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(192); match(T__11);
					setState(193); small_stmt();
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(200);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(199); match(T__11);
				}
			}

			setState(202); match(NEWLINE);
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
		enterRule(_localctx, 30, RULE_small_stmt);
		try {
			setState(209);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204); multi_assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205); expr_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(206); localDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(207); return_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(208); method_call();
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
		enterRule(_localctx, 32, RULE_multi_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); id_list();
			setState(212); match(Assign);
			setState(213); expr_list();
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

	public static class Single_assignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Single_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterSingle_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitSingle_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitSingle_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_assignContext single_assign() throws RecognitionException {
		Single_assignContext _localctx = new Single_assignContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_single_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); match(ID);
			setState(216); match(Assign);
			setState(217); expr(0);
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
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
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
		enterRule(_localctx, 36, RULE_compound_stmt);
		try {
			setState(222);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(219); if_stmt();
				}
				break;
			case While:
				enterOuterAlt(_localctx, 2);
				{
				setState(220); while_stmt();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(221); for_stmt();
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
		enterRule(_localctx, 38, RULE_localDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224); match(Var);
			setState(225); id_list();
			setState(226); match(T__3);
			setState(227); type();
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
		enterRule(_localctx, 40, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); ((Expr_stmtContext)_localctx).src = expr_list();
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
		enterRule(_localctx, 42, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231); if_stat();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Elif) {
				{
				{
				setState(232); elif_stat();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(239);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(238); else_stat();
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
		enterRule(_localctx, 44, RULE_if_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241); match(If);
			setState(242); expr(0);
			setState(243); match(Then);
			setState(244); block();
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
		enterRule(_localctx, 46, RULE_elif_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(Elif);
			setState(247); expr(0);
			setState(248); match(Then);
			setState(249); block();
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
		enterRule(_localctx, 48, RULE_else_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(Else);
			setState(252); block();
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
		enterRule(_localctx, 50, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); match(While);
			setState(255); expr(0);
			setState(256); match(Do);
			setState(257); block();
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

	public static class For_stmtContext extends ParserRuleContext {
		public Single_assignContext single_assign() {
			return getRuleContext(Single_assignContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitFor_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_for_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(T__9);
			setState(260); single_assign();
			setState(261); match(T__4);
			setState(262); expr(0);
			setState(263); match(Do);
			setState(264); block();
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
		enterRule(_localctx, 54, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); match(Return);
			setState(268);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__5) | (1L << T__2) | (1L << T__1) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << Subtract) | (1L << ID) | (1L << INTEGER))) != 0)) {
				{
				setState(267); expr(0);
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
		enterRule(_localctx, 56, RULE_block);
		int _la;
		try {
			setState(280);
			switch (_input.LA(1)) {
			case T__8:
			case T__5:
			case T__2:
			case T__1:
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
				setState(270); simple_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(271); match(NEWLINE);
				setState(272); match(INDENT);
				setState(274); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(273); stmt();
					}
					}
					setState(276); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__8) | (1L << T__5) | (1L << T__2) | (1L << T__1) | (1L << Var) | (1L << New) | (1L << If) | (1L << While) | (1L << Return) | (1L << Null) | (1L << True) | (1L << False) | (1L << Subtract) | (1L << ID) | (1L << INTEGER))) != 0) );
				setState(278); match(DEDENT);
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
		enterRule(_localctx, 58, RULE_guard);
		int _la;
		try {
			setState(299);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new GuardcompexprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(282); guardAtom();
				setState(283);
				((GuardcompexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GTEquals) | (1L << LTEquals) | (1L << GT) | (1L << LT))) != 0)) ) {
					((GuardcompexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(284); guardAtom();
				}
				break;
			case 2:
				_localctx = new GuardeqexprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(286); guardAtom();
				setState(287);
				((GuardeqexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==NEquals) ) {
					((GuardeqexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(288); guardAtom();
				}
				break;
			case 3:
				_localctx = new GuardandexprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(290); guardAtom();
				setState(291); match(And);
				setState(292); guardAtom();
				}
				break;
			case 4:
				_localctx = new GuardorexprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(294); guardAtom();
				setState(295); match(Or);
				setState(296); guardAtom();
				}
				break;
			case 5:
				_localctx = new GuardatomexprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(298); guardAtom();
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
		enterRule(_localctx, 60, RULE_guardAtom);
		try {
			setState(305);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new IdguardatomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(301); match(ID);
				}
				break;
			case INTEGER:
				_localctx = new IntguardatomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(302); match(INTEGER);
				}
				break;
			case T__1:
				_localctx = new NotguardtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(303); match(T__1);
				setState(304); match(ID);
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
		enterRule(_localctx, 62, RULE_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307); match(ID);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(308); match(T__7);
				setState(309); match(ID);
				}
				}
				setState(314);
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
		enterRule(_localctx, 64, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315); expr(0);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(316); match(T__7);
				setState(317); expr(0);
				}
				}
				setState(322);
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
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			switch (_input.LA(1)) {
			case Subtract:
				{
				_localctx = new UnaryMinusexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(324); match(Subtract);
				setState(325); expr(9);
				}
				break;
			case T__1:
				{
				_localctx = new NotexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(326); match(T__1);
				setState(327); expr(8);
				}
				break;
			case T__8:
			case T__5:
			case T__2:
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
				setState(328); atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(349);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new MultexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(331);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(332);
						((MultexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multiply) | (1L << Divide) | (1L << Modulus))) != 0)) ) {
							((MultexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(333); expr(8);
						}
						break;
					case 2:
						{
						_localctx = new AddexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(334);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(335);
						((AddexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Subtract) ) {
							((AddexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(336); expr(7);
						}
						break;
					case 3:
						{
						_localctx = new CompexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(337);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(338);
						((CompexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GTEquals) | (1L << LTEquals) | (1L << GT) | (1L << LT))) != 0)) ) {
							((CompexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(339); expr(6);
						}
						break;
					case 4:
						{
						_localctx = new EqexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(340);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(341);
						((EqexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==NEquals) ) {
							((EqexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(342); expr(5);
						}
						break;
					case 5:
						{
						_localctx = new AndexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(343);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(344); match(And);
						setState(345); expr(4);
						}
						break;
					case 6:
						{
						_localctx = new OrexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(346);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(347); match(Or);
						setState(348); expr(3);
						}
						break;
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		enterRule(_localctx, 68, RULE_atom);
		try {
			setState(360);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(354); match(INTEGER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(355); match(True);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(356); match(False);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(357); match(Null);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(358); match(ID);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(359); method_call();
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
	public static class RandContext extends Method_callContext {
		public RandContext(Method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterRand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitRand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitRand(this);
			else return visitor.visitChildren(this);
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
	public static class PrintContext extends Method_callContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PrintContext(Method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UserDefinedContext extends Method_callContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public UserDefinedContext(Method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterUserDefined(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitUserDefined(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitUserDefined(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetArgContext extends Method_callContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public GetArgContext(Method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterGetArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitGetArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitGetArg(this);
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
		enterRule(_localctx, 70, RULE_method_call);
		try {
			setState(384);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new NewcallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(362); match(New);
				setState(363); ((NewcallContext)_localctx).n = match(ID);
				setState(364); args();
				}
				break;
			case 2:
				_localctx = new MethodcallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(365); ((MethodcallContext)_localctx).c = match(ID);
				setState(366); match(T__6);
				setState(367); ((MethodcallContext)_localctx).m = match(ID);
				setState(368); args();
				}
				break;
			case 3:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(369); match(T__8);
				setState(370); match(OParen);
				setState(371); atom();
				setState(372); match(CParen);
				}
				break;
			case 4:
				_localctx = new RandContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(374); match(T__5);
				setState(375); match(OParen);
				setState(376); match(CParen);
				}
				break;
			case 5:
				_localctx = new GetArgContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(377); match(T__2);
				setState(378); match(OParen);
				setState(379); atom();
				setState(380); match(CParen);
				}
				break;
			case 6:
				_localctx = new UserDefinedContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(382); match(ID);
				setState(383); args();
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
		enterRule(_localctx, 72, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386); match(OParen);
			setState(388);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__5) | (1L << T__2) | (1L << T__1) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << Subtract) | (1L << ID) | (1L << INTEGER))) != 0)) {
				{
				setState(387); expr_list();
				}
			}

			setState(390); match(CParen);
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
		case 33: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u018b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\7\2N\n\2\f\2\16\2Q\13\2\3\2\6"+
		"\2T\n\2\r\2\16\2U\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3a\n\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\7\4j\n\4\f\4\16\4m\13\4\3\4\3\4\3\5\3\5\3\5\3\5\5"+
		"\5u\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5"+
		"\b\u0086\n\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u008e\n\b\3\b\3\b\5\b\u0092\n"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009c\n\t\3\t\3\t\5\t\u00a0\n\t"+
		"\3\n\3\n\5\n\u00a4\n\n\3\n\3\n\3\13\3\13\3\13\7\13\u00ab\n\13\f\13\16"+
		"\13\u00ae\13\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\7\16\u00b9\n\16"+
		"\f\16\16\16\u00bc\13\16\3\17\3\17\5\17\u00c0\n\17\3\20\3\20\3\20\7\20"+
		"\u00c5\n\20\f\20\16\20\u00c8\13\20\3\20\5\20\u00cb\n\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00d4\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\5\24\u00e1\n\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\7\27\u00ec\n\27\f\27\16\27\u00ef\13\27\3\27\5\27\u00f2\n\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\5\35"+
		"\u010f\n\35\3\36\3\36\3\36\3\36\6\36\u0115\n\36\r\36\16\36\u0116\3\36"+
		"\3\36\5\36\u011b\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u012e\n\37\3 \3 \3 \3 \5 \u0134"+
		"\n \3!\3!\3!\7!\u0139\n!\f!\16!\u013c\13!\3\"\3\"\3\"\7\"\u0141\n\"\f"+
		"\"\16\"\u0144\13\"\3#\3#\3#\3#\3#\3#\5#\u014c\n#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u0160\n#\f#\16#\u0163\13#\3$\3$\3"+
		"$\3$\3$\3$\5$\u016b\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\5%\u0183\n%\3&\3&\5&\u0187\n&\3&\3&\3&\2\3D\'\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJ\2\7"+
		"\4\2\36 99\3\2(+\4\2\4\4\'\'\3\2.\60\3\2,-\u019d\2O\3\2\2\2\4Y\3\2\2\2"+
		"\6d\3\2\2\2\bt\3\2\2\2\nv\3\2\2\2\f|\3\2\2\2\16\u0080\3\2\2\2\20\u0093"+
		"\3\2\2\2\22\u00a1\3\2\2\2\24\u00a7\3\2\2\2\26\u00af\3\2\2\2\30\u00b3\3"+
		"\2\2\2\32\u00b5\3\2\2\2\34\u00bf\3\2\2\2\36\u00c1\3\2\2\2 \u00d3\3\2\2"+
		"\2\"\u00d5\3\2\2\2$\u00d9\3\2\2\2&\u00e0\3\2\2\2(\u00e2\3\2\2\2*\u00e7"+
		"\3\2\2\2,\u00e9\3\2\2\2.\u00f3\3\2\2\2\60\u00f8\3\2\2\2\62\u00fd\3\2\2"+
		"\2\64\u0100\3\2\2\2\66\u0105\3\2\2\28\u010c\3\2\2\2:\u011a\3\2\2\2<\u012d"+
		"\3\2\2\2>\u0133\3\2\2\2@\u0135\3\2\2\2B\u013d\3\2\2\2D\u014b\3\2\2\2F"+
		"\u016a\3\2\2\2H\u0182\3\2\2\2J\u0184\3\2\2\2LN\5\4\3\2ML\3\2\2\2NQ\3\2"+
		"\2\2OM\3\2\2\2OP\3\2\2\2PS\3\2\2\2QO\3\2\2\2RT\5\6\4\2SR\3\2\2\2TU\3\2"+
		"\2\2US\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\2\2\3X\3\3\2\2\2YZ\7\16\2\2Z[\7"+
		"9\2\2[\\\7\65\2\2\\]\5\32\16\2]`\7\66\2\2^_\7\13\2\2_a\5\30\r\2`^\3\2"+
		"\2\2`a\3\2\2\2ab\3\2\2\2bc\7\67\2\2c\5\3\2\2\2de\7\17\2\2ef\79\2\2fg\7"+
		"\67\2\2gk\7;\2\2hj\5\b\5\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3"+
		"\2\2\2mk\3\2\2\2no\7<\2\2o\7\3\2\2\2pu\5\n\6\2qu\5\f\7\2ru\5\16\b\2su"+
		"\5\20\t\2tp\3\2\2\2tq\3\2\2\2tr\3\2\2\2ts\3\2\2\2u\t\3\2\2\2vw\7\22\2"+
		"\2wx\5@!\2xy\7\13\2\2yz\5\30\r\2z{\7\67\2\2{\13\3\2\2\2|}\7\23\2\2}~\5"+
		"\22\n\2~\177\5:\36\2\177\r\3\2\2\2\u0080\u0081\7\20\2\2\u0081\u0082\7"+
		"9\2\2\u0082\u0085\5\22\n\2\u0083\u0084\7\13\2\2\u0084\u0086\5\30\r\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008d\3\2\2\2\u0087\u0088\7\67"+
		"\2\2\u0088\u0089\7;\2\2\u0089\u008a\7\25\2\2\u008a\u008b\5<\37\2\u008b"+
		"\u008c\7\26\2\2\u008c\u008e\3\2\2\2\u008d\u0087\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\5:\36\2\u0090\u0092\7<\2\2\u0091"+
		"\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\17\3\2\2\2\u0093\u0094\7\21\2"+
		"\2\u0094\u009b\79\2\2\u0095\u0096\7\67\2\2\u0096\u0097\7;\2\2\u0097\u0098"+
		"\7\25\2\2\u0098\u0099\5<\37\2\u0099\u009a\7\26\2\2\u009a\u009c\3\2\2\2"+
		"\u009b\u0095\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f"+
		"\5:\36\2\u009e\u00a0\7<\2\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\21\3\2\2\2\u00a1\u00a3\7\65\2\2\u00a2\u00a4\5\24\13\2\u00a3\u00a2\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7\66\2\2\u00a6"+
		"\23\3\2\2\2\u00a7\u00ac\5\26\f\2\u00a8\u00a9\7\7\2\2\u00a9\u00ab\5\26"+
		"\f\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\25\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\79\2\2"+
		"\u00b0\u00b1\7\13\2\2\u00b1\u00b2\5\30\r\2\u00b2\27\3\2\2\2\u00b3\u00b4"+
		"\t\2\2\2\u00b4\31\3\2\2\2\u00b5\u00ba\5\30\r\2\u00b6\u00b7\7\7\2\2\u00b7"+
		"\u00b9\5\30\r\2\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3"+
		"\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\33\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00c0\5\36\20\2\u00be\u00c0\5&\24\2\u00bf\u00bd\3\2\2\2\u00bf\u00be\3"+
		"\2\2\2\u00c0\35\3\2\2\2\u00c1\u00c6\5 \21\2\u00c2\u00c3\7\3\2\2\u00c3"+
		"\u00c5\5 \21\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00cb\7\3\2\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00cd\7\67\2\2\u00cd\37\3\2\2\2\u00ce\u00d4\5\"\22\2\u00cf"+
		"\u00d4\5*\26\2\u00d0\u00d4\5(\25\2\u00d1\u00d4\58\35\2\u00d2\u00d4\5H"+
		"%\2\u00d3\u00ce\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d3\u00d0\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4!\3\2\2\2\u00d5\u00d6\5@!\2\u00d6"+
		"\u00d7\7#\2\2\u00d7\u00d8\5B\"\2\u00d8#\3\2\2\2\u00d9\u00da\79\2\2\u00da"+
		"\u00db\7#\2\2\u00db\u00dc\5D#\2\u00dc%\3\2\2\2\u00dd\u00e1\5,\27\2\u00de"+
		"\u00e1\5\64\33\2\u00df\u00e1\5\66\34\2\u00e0\u00dd\3\2\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\'\3\2\2\2\u00e2\u00e3\7\22\2\2\u00e3"+
		"\u00e4\5@!\2\u00e4\u00e5\7\13\2\2\u00e5\u00e6\5\30\r\2\u00e6)\3\2\2\2"+
		"\u00e7\u00e8\5B\"\2\u00e8+\3\2\2\2\u00e9\u00ed\5.\30\2\u00ea\u00ec\5\60"+
		"\31\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f2\5\62"+
		"\32\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2-\3\2\2\2\u00f3\u00f4"+
		"\7\27\2\2\u00f4\u00f5\5D#\2\u00f5\u00f6\7\32\2\2\u00f6\u00f7\5:\36\2\u00f7"+
		"/\3\2\2\2\u00f8\u00f9\7\31\2\2\u00f9\u00fa\5D#\2\u00fa\u00fb\7\32\2\2"+
		"\u00fb\u00fc\5:\36\2\u00fc\61\3\2\2\2\u00fd\u00fe\7\30\2\2\u00fe\u00ff"+
		"\5:\36\2\u00ff\63\3\2\2\2\u0100\u0101\7\33\2\2\u0101\u0102\5D#\2\u0102"+
		"\u0103\7\26\2\2\u0103\u0104\5:\36\2\u0104\65\3\2\2\2\u0105\u0106\7\5\2"+
		"\2\u0106\u0107\5$\23\2\u0107\u0108\7\n\2\2\u0108\u0109\5D#\2\u0109\u010a"+
		"\7\26\2\2\u010a\u010b\5:\36\2\u010b\67\3\2\2\2\u010c\u010e\7\34\2\2\u010d"+
		"\u010f\5D#\2\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2\2\u010f9\3\2\2\2\u0110"+
		"\u011b\5\36\20\2\u0111\u0112\7\67\2\2\u0112\u0114\7;\2\2\u0113\u0115\5"+
		"\34\17\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\7<\2\2\u0119\u011b\3\2"+
		"\2\2\u011a\u0110\3\2\2\2\u011a\u0111\3\2\2\2\u011b;\3\2\2\2\u011c\u011d"+
		"\5> \2\u011d\u011e\t\3\2\2\u011e\u011f\5> \2\u011f\u012e\3\2\2\2\u0120"+
		"\u0121\5> \2\u0121\u0122\t\4\2\2\u0122\u0123\5> \2\u0123\u012e\3\2\2\2"+
		"\u0124\u0125\5> \2\u0125\u0126\7%\2\2\u0126\u0127\5> \2\u0127\u012e\3"+
		"\2\2\2\u0128\u0129\5> \2\u0129\u012a\7$\2\2\u012a\u012b\5> \2\u012b\u012e"+
		"\3\2\2\2\u012c\u012e\5> \2\u012d\u011c\3\2\2\2\u012d\u0120\3\2\2\2\u012d"+
		"\u0124\3\2\2\2\u012d\u0128\3\2\2\2\u012d\u012c\3\2\2\2\u012e=\3\2\2\2"+
		"\u012f\u0134\79\2\2\u0130\u0134\7:\2\2\u0131\u0132\7\r\2\2\u0132\u0134"+
		"\79\2\2\u0133\u012f\3\2\2\2\u0133\u0130\3\2\2\2\u0133\u0131\3\2\2\2\u0134"+
		"?\3\2\2\2\u0135\u013a\79\2\2\u0136\u0137\7\7\2\2\u0137\u0139\79\2\2\u0138"+
		"\u0136\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2"+
		"\2\2\u013bA\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u0142\5D#\2\u013e\u013f"+
		"\7\7\2\2\u013f\u0141\5D#\2\u0140\u013e\3\2\2\2\u0141\u0144\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143C\3\2\2\2\u0144\u0142\3\2\2\2"+
		"\u0145\u0146\b#\1\2\u0146\u0147\7-\2\2\u0147\u014c\5D#\13\u0148\u0149"+
		"\7\r\2\2\u0149\u014c\5D#\n\u014a\u014c\5F$\2\u014b\u0145\3\2\2\2\u014b"+
		"\u0148\3\2\2\2\u014b\u014a\3\2\2\2\u014c\u0161\3\2\2\2\u014d\u014e\f\t"+
		"\2\2\u014e\u014f\t\5\2\2\u014f\u0160\5D#\n\u0150\u0151\f\b\2\2\u0151\u0152"+
		"\t\6\2\2\u0152\u0160\5D#\t\u0153\u0154\f\7\2\2\u0154\u0155\t\3\2\2\u0155"+
		"\u0160\5D#\b\u0156\u0157\f\6\2\2\u0157\u0158\t\4\2\2\u0158\u0160\5D#\7"+
		"\u0159\u015a\f\5\2\2\u015a\u015b\7%\2\2\u015b\u0160\5D#\6\u015c\u015d"+
		"\f\4\2\2\u015d\u015e\7$\2\2\u015e\u0160\5D#\5\u015f\u014d\3\2\2\2\u015f"+
		"\u0150\3\2\2\2\u015f\u0153\3\2\2\2\u015f\u0156\3\2\2\2\u015f\u0159\3\2"+
		"\2\2\u015f\u015c\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0162E\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u016b\7:\2\2\u0165"+
		"\u016b\7!\2\2\u0166\u016b\7\"\2\2\u0167\u016b\7\35\2\2\u0168\u016b\79"+
		"\2\2\u0169\u016b\5H%\2\u016a\u0164\3\2\2\2\u016a\u0165\3\2\2\2\u016a\u0166"+
		"\3\2\2\2\u016a\u0167\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b"+
		"G\3\2\2\2\u016c\u016d\7\24\2\2\u016d\u016e\79\2\2\u016e\u0183\5J&\2\u016f"+
		"\u0170\79\2\2\u0170\u0171\7\b\2\2\u0171\u0172\79\2\2\u0172\u0183\5J&\2"+
		"\u0173\u0174\7\6\2\2\u0174\u0175\7\65\2\2\u0175\u0176\5F$\2\u0176\u0177"+
		"\7\66\2\2\u0177\u0183\3\2\2\2\u0178\u0179\7\t\2\2\u0179\u017a\7\65\2\2"+
		"\u017a\u0183\7\66\2\2\u017b\u017c\7\f\2\2\u017c\u017d\7\65\2\2\u017d\u017e"+
		"\5F$\2\u017e\u017f\7\66\2\2\u017f\u0183\3\2\2\2\u0180\u0181\79\2\2\u0181"+
		"\u0183\5J&\2\u0182\u016c\3\2\2\2\u0182\u016f\3\2\2\2\u0182\u0173\3\2\2"+
		"\2\u0182\u0178\3\2\2\2\u0182\u017b\3\2\2\2\u0182\u0180\3\2\2\2\u0183I"+
		"\3\2\2\2\u0184\u0186\7\65\2\2\u0185\u0187\5B\"\2\u0186\u0185\3\2\2\2\u0186"+
		"\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\7\66\2\2\u0189K\3\2\2\2"+
		"#OU`kt\u0085\u008d\u0091\u009b\u009f\u00a3\u00ac\u00ba\u00bf\u00c6\u00ca"+
		"\u00d3\u00e0\u00ed\u00f1\u010e\u0116\u011a\u012d\u0133\u013a\u0142\u014b"+
		"\u015f\u0161\u016a\u0182\u0186";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}