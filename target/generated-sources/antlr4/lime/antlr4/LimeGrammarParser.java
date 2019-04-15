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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, Class=16, Method=17, 
		Action=18, Var=19, Init=20, New=21, When=22, Do=23, If=24, Else=25, Elif=26, 
		Then=27, While=28, Return=29, Null=30, Booltype=31, Inttype=32, Voidtype=33, 
		True=34, False=35, Assign=36, Or=37, And=38, Equals=39, NEquals=40, GTEquals=41, 
		LTEquals=42, GT=43, LT=44, Add=45, Subtract=46, Multiply=47, Divide=48, 
		Modulus=49, OBrace=50, CBrace=51, OBracket=52, CBracket=53, OParen=54, 
		CParen=55, NEWLINE=56, SKIP_=57, ID=58, INTEGER=59, INDENT=60, DEDENT=61;
	public static final String[] tokenNames = {
		"<INVALID>", "'='", "'for'", "'getRand'", "','", "'getArg'", "'array'", 
		"'of'", "';'", "'print'", "'.'", "'to'", "':'", "'setRand'", "'not'", 
		"'import'", "'class'", "'method'", "'action'", "'var'", "'init'", "'new'", 
		"'when'", "'do'", "'if'", "'else'", "'elif'", "'then'", "'while'", "'return'", 
		"'nil'", "'bool'", "'int'", "'void'", "'true'", "'false'", "':='", "'or'", 
		"'and'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'*'", 
		"'/'", "'%'", "'{'", "'}'", "'['", "']'", "'('", "')'", "NEWLINE", "SKIP_", 
		"ID", "INTEGER", "INDENT", "DEDENT"
	};
	public static final int
		RULE_compilationUnit = 0, RULE_importStmts = 1, RULE_importstmt = 2, RULE_classDecls = 3, 
		RULE_classDecl = 4, RULE_classMember = 5, RULE_fieldDecl = 6, RULE_initDecl = 7, 
		RULE_methodDecl = 8, RULE_actionDecl = 9, RULE_parameters = 10, RULE_typeparslist = 11, 
		RULE_parsdef = 12, RULE_type = 13, RULE_arrayDecl = 14, RULE_type_list = 15, 
		RULE_stmt = 16, RULE_simple_stmt = 17, RULE_small_stmt = 18, RULE_multi_assign = 19, 
		RULE_single_assign = 20, RULE_compound_stmt = 21, RULE_localDecl = 22, 
		RULE_expr_stmt = 23, RULE_if_stmt = 24, RULE_if_stat = 25, RULE_elif_stat = 26, 
		RULE_else_stat = 27, RULE_while_stmt = 28, RULE_for_stmt = 29, RULE_return_stmt = 30, 
		RULE_block = 31, RULE_guard = 32, RULE_id_list = 33, RULE_id_ele = 34, 
		RULE_expr_list = 35, RULE_expr = 36, RULE_atom = 37, RULE_method_call = 38, 
		RULE_arrayCreate = 39, RULE_arrayElement = 40, RULE_selector = 41, RULE_args = 42;
	public static final String[] ruleNames = {
		"compilationUnit", "importStmts", "importstmt", "classDecls", "classDecl", 
		"classMember", "fieldDecl", "initDecl", "methodDecl", "actionDecl", "parameters", 
		"typeparslist", "parsdef", "type", "arrayDecl", "type_list", "stmt", "simple_stmt", 
		"small_stmt", "multi_assign", "single_assign", "compound_stmt", "localDecl", 
		"expr_stmt", "if_stmt", "if_stat", "elif_stat", "else_stat", "while_stmt", 
		"for_stmt", "return_stmt", "block", "guard", "id_list", "id_ele", "expr_list", 
		"expr", "atom", "method_call", "arrayCreate", "arrayElement", "selector", 
		"args"
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
		public ImportStmtsContext importStmts() {
			return getRuleContext(ImportStmtsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LimeGrammarParser.EOF, 0); }
		public ClassDeclsContext classDecls() {
			return getRuleContext(ClassDeclsContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); importStmts();
			setState(87); classDecls();
			setState(88); match(EOF);
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

	public static class ImportStmtsContext extends ParserRuleContext {
		public List<ImportstmtContext> importstmt() {
			return getRuleContexts(ImportstmtContext.class);
		}
		public ImportstmtContext importstmt(int i) {
			return getRuleContext(ImportstmtContext.class,i);
		}
		public ImportStmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterImportStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitImportStmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitImportStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStmtsContext importStmts() throws RecognitionException {
		ImportStmtsContext _localctx = new ImportStmtsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importStmts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(90); importstmt();
				}
				}
				setState(95);
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

	public static class ImportstmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public TerminalNode NEWLINE() { return getToken(LimeGrammarParser.NEWLINE, 0); }
		public Type_listContext type_list() {
			return getRuleContext(Type_listContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ImportstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterImportstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitImportstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitImportstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportstmtContext importstmt() throws RecognitionException {
		ImportstmtContext _localctx = new ImportstmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(T__0);
			setState(97); match(ID);
			setState(98); match(OParen);
			setState(99); type_list();
			setState(100); match(CParen);
			setState(103);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(101); match(T__3);
				setState(102); type();
				}
			}

			setState(105); match(NEWLINE);
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

	public static class ClassDeclsContext extends ParserRuleContext {
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public ClassDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterClassDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitClassDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitClassDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclsContext classDecls() throws RecognitionException {
		ClassDeclsContext _localctx = new ClassDeclsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Class) {
				{
				{
				setState(107); classDecl();
				}
				}
				setState(112);
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
		enterRule(_localctx, 8, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(Class);
			setState(114); match(ID);
			setState(115); match(NEWLINE);
			setState(116); match(INDENT);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Method) | (1L << Action) | (1L << Var) | (1L << Init))) != 0)) {
				{
				{
				setState(117); classMember();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123); match(DEDENT);
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
		enterRule(_localctx, 10, RULE_classMember);
		try {
			setState(129);
			switch (_input.LA(1)) {
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(125); fieldDecl();
				}
				break;
			case Init:
				enterOuterAlt(_localctx, 2);
				{
				setState(126); initDecl();
				}
				break;
			case Method:
				enterOuterAlt(_localctx, 3);
				{
				setState(127); methodDecl();
				}
				break;
			case Action:
				enterOuterAlt(_localctx, 4);
				{
				setState(128); actionDecl();
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
		enterRule(_localctx, 12, RULE_fieldDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); match(Var);
			setState(132); id_list();
			setState(133); match(T__3);
			setState(134); type();
			setState(135); match(NEWLINE);
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
		enterRule(_localctx, 14, RULE_initDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); match(Init);
			setState(138); parameters();
			setState(139); block();
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
		enterRule(_localctx, 16, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); match(Method);
			setState(142); match(ID);
			setState(143); parameters();
			setState(146);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(144); match(T__3);
				setState(145); type();
				}
			}

			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(148); match(NEWLINE);
				setState(149); match(INDENT);
				setState(150); match(When);
				setState(151); guard(0);
				setState(152); match(Do);
				}
				break;
			}
			setState(156); block();
			setState(158);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(157); match(DEDENT);
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
		enterRule(_localctx, 18, RULE_actionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(Action);
			setState(161); match(ID);
			setState(168);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(162); match(NEWLINE);
				setState(163); match(INDENT);
				setState(164); match(When);
				setState(165); guard(0);
				setState(166); match(Do);
				}
				break;
			}
			setState(170); block();
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(171); match(DEDENT);
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
		enterRule(_localctx, 20, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(OParen);
			setState(176);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(175); typeparslist();
				}
			}

			setState(178); match(CParen);
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
		enterRule(_localctx, 22, RULE_typeparslist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180); parsdef();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(181); match(T__11);
				setState(182); parsdef();
				}
				}
				setState(187);
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
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_parsdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188); id_list();
			setState(189); match(T__3);
			setState(190); type();
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
		public Type typ;
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public ArrayDeclContext arrayDecl() {
			return getRuleContext(ArrayDeclContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_type);
		try {
			setState(197);
			switch (_input.LA(1)) {
			case Inttype:
				enterOuterAlt(_localctx, 1);
				{
				setState(192); match(Inttype);
				}
				break;
			case Booltype:
				enterOuterAlt(_localctx, 2);
				{
				setState(193); match(Booltype);
				}
				break;
			case Voidtype:
				enterOuterAlt(_localctx, 3);
				{
				setState(194); match(Voidtype);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(195); match(ID);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(196); arrayDecl();
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

	public static class ArrayDeclContext extends ParserRuleContext {
		public ArrayType typ;
		public Token ty;
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitArrayDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arrayDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(T__9);
			setState(200); match(T__8);
			setState(201);
			((ArrayDeclContext)_localctx).ty = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Booltype) | (1L << Inttype) | (1L << ID))) != 0)) ) {
				((ArrayDeclContext)_localctx).ty = (Token)_errHandler.recoverInline(this);
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
		enterRule(_localctx, 30, RULE_type_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); type();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(204); match(T__11);
				setState(205); type();
				}
				}
				setState(210);
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
		enterRule(_localctx, 32, RULE_stmt);
		try {
			setState(213);
			switch (_input.LA(1)) {
			case T__12:
			case T__10:
			case T__6:
			case T__2:
			case T__1:
			case Var:
			case New:
			case Return:
			case Null:
			case True:
			case False:
			case Subtract:
			case OParen:
			case ID:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(211); simple_stmt();
				}
				break;
			case T__13:
			case If:
			case While:
				enterOuterAlt(_localctx, 2);
				{
				setState(212); compound_stmt();
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
		enterRule(_localctx, 34, RULE_simple_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215); small_stmt();
			setState(220);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(216); match(T__7);
					setState(217); small_stmt();
					}
					} 
				}
				setState(222);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(224);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(223); match(T__7);
				}
			}

			setState(226); match(NEWLINE);
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
		enterRule(_localctx, 36, RULE_small_stmt);
		try {
			setState(233);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228); multi_assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(229); expr_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(230); localDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(231); return_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(232); method_call();
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
		enterRule(_localctx, 38, RULE_multi_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235); id_list();
			setState(236); match(Assign);
			setState(237); expr_list();
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
		enterRule(_localctx, 40, RULE_single_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); match(ID);
			setState(240); match(Assign);
			setState(241); expr(0);
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
		enterRule(_localctx, 42, RULE_compound_stmt);
		try {
			setState(246);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(243); if_stmt();
				}
				break;
			case While:
				enterOuterAlt(_localctx, 2);
				{
				setState(244); while_stmt();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(245); for_stmt();
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
		enterRule(_localctx, 44, RULE_localDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248); match(Var);
			setState(249); id_list();
			setState(250); match(T__3);
			setState(251); type();
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
		enterRule(_localctx, 46, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); ((Expr_stmtContext)_localctx).src = expr_list();
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
		enterRule(_localctx, 48, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255); if_stat();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Elif) {
				{
				{
				setState(256); elif_stat();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(263);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(262); else_stat();
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
		enterRule(_localctx, 50, RULE_if_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); match(If);
			setState(266); expr(0);
			setState(267); match(Then);
			setState(268); block();
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
		enterRule(_localctx, 52, RULE_elif_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); match(Elif);
			setState(271); expr(0);
			setState(272); match(Then);
			setState(273); block();
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
		enterRule(_localctx, 54, RULE_else_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275); match(Else);
			setState(276); block();
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
		enterRule(_localctx, 56, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278); match(While);
			setState(279); expr(0);
			setState(280); match(Do);
			setState(281); block();
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
		enterRule(_localctx, 58, RULE_for_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283); match(T__13);
			setState(284); single_assign();
			setState(285); match(T__4);
			setState(286); expr(0);
			setState(287); match(Do);
			setState(288); block();
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
		enterRule(_localctx, 60, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290); match(Return);
			setState(292);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__10) | (1L << T__6) | (1L << T__2) | (1L << T__1) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << Subtract) | (1L << OParen) | (1L << ID) | (1L << INTEGER))) != 0)) {
				{
				setState(291); expr(0);
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
		enterRule(_localctx, 62, RULE_block);
		int _la;
		try {
			setState(304);
			switch (_input.LA(1)) {
			case T__12:
			case T__10:
			case T__6:
			case T__2:
			case T__1:
			case Var:
			case New:
			case Return:
			case Null:
			case True:
			case False:
			case Subtract:
			case OParen:
			case ID:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(294); simple_stmt();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(295); match(NEWLINE);
				setState(296); match(INDENT);
				setState(298); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(297); stmt();
					}
					}
					setState(300); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__12) | (1L << T__10) | (1L << T__6) | (1L << T__2) | (1L << T__1) | (1L << Var) | (1L << New) | (1L << If) | (1L << While) | (1L << Return) | (1L << Null) | (1L << True) | (1L << False) | (1L << Subtract) | (1L << OParen) | (1L << ID) | (1L << INTEGER))) != 0) );
				setState(302); match(DEDENT);
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
		public List<GuardContext> guard() {
			return getRuleContexts(GuardContext.class);
		}
		public GuardContext guard(int i) {
			return getRuleContext(GuardContext.class,i);
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
	public static class GuardatomidContext extends GuardContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public GuardatomidContext(GuardContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterGuardatomid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitGuardatomid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitGuardatomid(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GuardatomintContext extends GuardContext {
		public TerminalNode INTEGER() { return getToken(LimeGrammarParser.INTEGER, 0); }
		public GuardatomintContext(GuardContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterGuardatomint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitGuardatomint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitGuardatomint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GuardcompexprContext extends GuardContext {
		public Token op;
		public List<GuardContext> guard() {
			return getRuleContexts(GuardContext.class);
		}
		public GuardContext guard(int i) {
			return getRuleContext(GuardContext.class,i);
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
		public List<GuardContext> guard() {
			return getRuleContexts(GuardContext.class);
		}
		public GuardContext guard(int i) {
			return getRuleContext(GuardContext.class,i);
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
	public static class GuardatomnotContext extends GuardContext {
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public GuardatomnotContext(GuardContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterGuardatomnot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitGuardatomnot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitGuardatomnot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GuardparenContext extends GuardContext {
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public GuardparenContext(GuardContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterGuardparen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitGuardparen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitGuardparen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		return guard(0);
	}

	private GuardContext guard(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GuardContext _localctx = new GuardContext(_ctx, _parentState);
		GuardContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_guard, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			switch (_input.LA(1)) {
			case T__1:
				{
				_localctx = new GuardatomnotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(307); match(T__1);
				setState(308); guard(6);
				}
				break;
			case OParen:
				{
				_localctx = new GuardparenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(309); match(OParen);
				setState(310); guard(0);
				setState(311); match(CParen);
				}
				break;
			case ID:
				{
				_localctx = new GuardatomidContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(313); match(ID);
				}
				break;
			case INTEGER:
				{
				_localctx = new GuardatomintContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(314); match(INTEGER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(328);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(326);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new GuardcompexprContext(new GuardContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_guard);
						setState(317);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(318);
						((GuardcompexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << NEquals) | (1L << GTEquals) | (1L << LTEquals) | (1L << GT) | (1L << LT))) != 0)) ) {
							((GuardcompexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(319); guard(6);
						}
						break;
					case 2:
						{
						_localctx = new GuardandexprContext(new GuardContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_guard);
						setState(320);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(321); match(And);
						setState(322); guard(5);
						}
						break;
					case 3:
						{
						_localctx = new GuardorexprContext(new GuardContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_guard);
						setState(323);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(324); match(Or);
						setState(325); guard(4);
						}
						break;
					}
					} 
				}
				setState(330);
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

	public static class Id_listContext extends ParserRuleContext {
		public List<Id_eleContext> id_ele() {
			return getRuleContexts(Id_eleContext.class);
		}
		public Id_eleContext id_ele(int i) {
			return getRuleContext(Id_eleContext.class,i);
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
		enterRule(_localctx, 66, RULE_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331); id_ele();
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(332); match(T__11);
				setState(333); id_ele();
				}
				}
				setState(338);
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

	public static class Id_eleContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public Id_eleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_ele; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterId_ele(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitId_ele(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitId_ele(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Id_eleContext id_ele() throws RecognitionException {
		Id_eleContext _localctx = new Id_eleContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_id_ele);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339); match(ID);
			setState(341);
			_la = _input.LA(1);
			if (_la==OBracket) {
				{
				setState(340); selector();
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
		enterRule(_localctx, 70, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343); expr(0);
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(344); match(T__11);
				setState(345); expr(0);
				}
				}
				setState(350);
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
	public static class ParenexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterParenexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitParenexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitParenexpr(this);
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
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			switch (_input.LA(1)) {
			case Subtract:
				{
				_localctx = new UnaryMinusexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(352); match(Subtract);
				setState(353); expr(9);
				}
				break;
			case T__1:
				{
				_localctx = new NotexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(354); match(T__1);
				setState(355); expr(8);
				}
				break;
			case OParen:
				{
				_localctx = new ParenexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(356); match(OParen);
				setState(357); expr(0);
				setState(358); match(CParen);
				}
				break;
			case T__12:
			case T__10:
			case T__6:
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
				setState(360); atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(383);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(381);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new MultexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(363);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(364);
						((MultexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multiply) | (1L << Divide) | (1L << Modulus))) != 0)) ) {
							((MultexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(365); expr(8);
						}
						break;
					case 2:
						{
						_localctx = new AddexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(366);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(367);
						((AddexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Subtract) ) {
							((AddexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(368); expr(7);
						}
						break;
					case 3:
						{
						_localctx = new CompexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(369);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(370);
						((CompexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GTEquals) | (1L << LTEquals) | (1L << GT) | (1L << LT))) != 0)) ) {
							((CompexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(371); expr(6);
						}
						break;
					case 4:
						{
						_localctx = new EqexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(372);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(373);
						((EqexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==NEquals) ) {
							((EqexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(374); expr(5);
						}
						break;
					case 5:
						{
						_localctx = new AndexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(375);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(376); match(And);
						setState(377); expr(4);
						}
						break;
					case 6:
						{
						_localctx = new OrexprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(378);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(379); match(Or);
						setState(380); expr(3);
						}
						break;
					}
					} 
				}
				setState(385);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		public ArrayCreateContext arrayCreate() {
			return getRuleContext(ArrayCreateContext.class,0);
		}
		public TerminalNode False() { return getToken(LimeGrammarParser.False, 0); }
		public TerminalNode True() { return getToken(LimeGrammarParser.True, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public ArrayElementContext arrayElement() {
			return getRuleContext(ArrayElementContext.class,0);
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
		enterRule(_localctx, 74, RULE_atom);
		try {
			setState(394);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(386); match(INTEGER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(387); match(True);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(388); match(False);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(389); match(Null);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(390); match(ID);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(391); method_call();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(392); arrayCreate();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(393); arrayElement();
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
	public static class PrintContext extends Method_callContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
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
	public static class ArrayElementmethodcallContext extends Method_callContext {
		public Token m;
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public ArrayElementContext arrayElement() {
			return getRuleContext(ArrayElementContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ArrayElementmethodcallContext(Method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterArrayElementmethodcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitArrayElementmethodcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitArrayElementmethodcall(this);
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
	public static class SetRandContext extends Method_callContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public SetRandContext(Method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterSetRand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitSetRand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitSetRand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetArgContext extends Method_callContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
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
	public static class GetRandContext extends Method_callContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public GetRandContext(Method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterGetRand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitGetRand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitGetRand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_method_call);
		try {
			setState(418);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new NewcallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(396); match(New);
				setState(397); ((NewcallContext)_localctx).n = match(ID);
				setState(398); args();
				}
				break;
			case 2:
				_localctx = new MethodcallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(399); ((MethodcallContext)_localctx).c = match(ID);
				setState(400); match(T__5);
				setState(401); ((MethodcallContext)_localctx).m = match(ID);
				setState(402); args();
				}
				break;
			case 3:
				_localctx = new ArrayElementmethodcallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(403); arrayElement();
				setState(404); match(T__5);
				setState(405); ((ArrayElementmethodcallContext)_localctx).m = match(ID);
				setState(406); args();
				}
				break;
			case 4:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(408); match(T__6);
				setState(409); args();
				}
				break;
			case 5:
				_localctx = new GetRandContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(410); match(T__12);
				setState(411); args();
				}
				break;
			case 6:
				_localctx = new SetRandContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(412); match(T__2);
				setState(413); args();
				}
				break;
			case 7:
				_localctx = new GetArgContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(414); match(T__10);
				setState(415); args();
				}
				break;
			case 8:
				_localctx = new UserDefinedContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(416); match(ID);
				setState(417); args();
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

	public static class ArrayCreateContext extends ParserRuleContext {
		public Token ty;
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public ArrayCreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterArrayCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitArrayCreate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitArrayCreate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayCreateContext arrayCreate() throws RecognitionException {
		ArrayCreateContext _localctx = new ArrayCreateContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_arrayCreate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420); match(New);
			setState(421);
			((ArrayCreateContext)_localctx).ty = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Booltype) | (1L << Inttype) | (1L << ID))) != 0)) ) {
				((ArrayCreateContext)_localctx).ty = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(422); selector();
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

	public static class ArrayElementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LimeGrammarParser.ID, 0); }
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public ArrayElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterArrayElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitArrayElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitArrayElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayElementContext arrayElement() throws RecognitionException {
		ArrayElementContext _localctx = new ArrayElementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_arrayElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424); match(ID);
			setState(425); selector();
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

	public static class SelectorContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LimeGrammarListener ) ((LimeGrammarListener)listener).exitSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LimeGrammarVisitor ) return ((LimeGrammarVisitor<? extends T>)visitor).visitSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_selector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427); match(OBracket);
			setState(428); expr(0);
			setState(429); match(CBracket);
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
		enterRule(_localctx, 84, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431); match(OParen);
			setState(433);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__10) | (1L << T__6) | (1L << T__2) | (1L << T__1) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << Subtract) | (1L << OParen) | (1L << ID) | (1L << INTEGER))) != 0)) {
				{
				setState(432); expr_list();
				}
			}

			setState(435); match(CParen);
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
		case 32: return guard_sempred((GuardContext)_localctx, predIndex);
		case 36: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean guard_sempred(GuardContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 5);
		case 1: return precpred(_ctx, 4);
		case 2: return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 7);
		case 4: return precpred(_ctx, 6);
		case 5: return precpred(_ctx, 5);
		case 6: return precpred(_ctx, 4);
		case 7: return precpred(_ctx, 3);
		case 8: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3?\u01b8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\3\7\3^\n\3\f\3\16\3a\13\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4j\n\4\3\4\3\4\3\5\7\5o\n\5\f\5\16\5r\13\5\3\6\3\6\3\6\3\6\3"+
		"\6\7\6y\n\6\f\6\16\6|\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u0084\n\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u0095\n\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u009d\n\n\3\n\3\n\5\n\u00a1\n\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ab\n\13\3\13\3\13\5\13\u00af\n\13"+
		"\3\f\3\f\5\f\u00b3\n\f\3\f\3\f\3\r\3\r\3\r\7\r\u00ba\n\r\f\r\16\r\u00bd"+
		"\13\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00c8\n\17\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u00d1\n\21\f\21\16\21\u00d4\13\21"+
		"\3\22\3\22\5\22\u00d8\n\22\3\23\3\23\3\23\7\23\u00dd\n\23\f\23\16\23\u00e0"+
		"\13\23\3\23\5\23\u00e3\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\5\24\u00ec"+
		"\n\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27\u00f9"+
		"\n\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\7\32\u0104\n\32\f\32"+
		"\16\32\u0107\13\32\3\32\5\32\u010a\n\32\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \5 \u0127\n \3!\3!\3!\3!\6!\u012d\n!\r"+
		"!\16!\u012e\3!\3!\5!\u0133\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\""+
		"\u013e\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0149\n\"\f\"\16\""+
		"\u014c\13\"\3#\3#\3#\7#\u0151\n#\f#\16#\u0154\13#\3$\3$\5$\u0158\n$\3"+
		"%\3%\3%\7%\u015d\n%\f%\16%\u0160\13%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&"+
		"\u016c\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\7&\u0180"+
		"\n&\f&\16&\u0183\13&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u018d\n\'\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u01a5"+
		"\n(\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3,\3,\5,\u01b4\n,\3,\3,\3,\2\4BJ"+
		"-\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF"+
		"HJLNPRTV\2\b\4\2!\"<<\4\2\3\3*.\3\2\61\63\3\2/\60\3\2+.\4\2\3\3**\u01ce"+
		"\2X\3\2\2\2\4_\3\2\2\2\6b\3\2\2\2\bp\3\2\2\2\ns\3\2\2\2\f\u0083\3\2\2"+
		"\2\16\u0085\3\2\2\2\20\u008b\3\2\2\2\22\u008f\3\2\2\2\24\u00a2\3\2\2\2"+
		"\26\u00b0\3\2\2\2\30\u00b6\3\2\2\2\32\u00be\3\2\2\2\34\u00c7\3\2\2\2\36"+
		"\u00c9\3\2\2\2 \u00cd\3\2\2\2\"\u00d7\3\2\2\2$\u00d9\3\2\2\2&\u00eb\3"+
		"\2\2\2(\u00ed\3\2\2\2*\u00f1\3\2\2\2,\u00f8\3\2\2\2.\u00fa\3\2\2\2\60"+
		"\u00ff\3\2\2\2\62\u0101\3\2\2\2\64\u010b\3\2\2\2\66\u0110\3\2\2\28\u0115"+
		"\3\2\2\2:\u0118\3\2\2\2<\u011d\3\2\2\2>\u0124\3\2\2\2@\u0132\3\2\2\2B"+
		"\u013d\3\2\2\2D\u014d\3\2\2\2F\u0155\3\2\2\2H\u0159\3\2\2\2J\u016b\3\2"+
		"\2\2L\u018c\3\2\2\2N\u01a4\3\2\2\2P\u01a6\3\2\2\2R\u01aa\3\2\2\2T\u01ad"+
		"\3\2\2\2V\u01b1\3\2\2\2XY\5\4\3\2YZ\5\b\5\2Z[\7\2\2\3[\3\3\2\2\2\\^\5"+
		"\6\4\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\5\3\2\2\2a_\3\2\2\2b"+
		"c\7\21\2\2cd\7<\2\2de\78\2\2ef\5 \21\2fi\79\2\2gh\7\16\2\2hj\5\34\17\2"+
		"ig\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7:\2\2l\7\3\2\2\2mo\5\n\6\2nm\3\2\2\2"+
		"or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\t\3\2\2\2rp\3\2\2\2st\7\22\2\2tu\7<\2"+
		"\2uv\7:\2\2vz\7>\2\2wy\5\f\7\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2"+
		"{}\3\2\2\2|z\3\2\2\2}~\7?\2\2~\13\3\2\2\2\177\u0084\5\16\b\2\u0080\u0084"+
		"\5\20\t\2\u0081\u0084\5\22\n\2\u0082\u0084\5\24\13\2\u0083\177\3\2\2\2"+
		"\u0083\u0080\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0082\3\2\2\2\u0084\r\3"+
		"\2\2\2\u0085\u0086\7\25\2\2\u0086\u0087\5D#\2\u0087\u0088\7\16\2\2\u0088"+
		"\u0089\5\34\17\2\u0089\u008a\7:\2\2\u008a\17\3\2\2\2\u008b\u008c\7\26"+
		"\2\2\u008c\u008d\5\26\f\2\u008d\u008e\5@!\2\u008e\21\3\2\2\2\u008f\u0090"+
		"\7\23\2\2\u0090\u0091\7<\2\2\u0091\u0094\5\26\f\2\u0092\u0093\7\16\2\2"+
		"\u0093\u0095\5\34\17\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u009c"+
		"\3\2\2\2\u0096\u0097\7:\2\2\u0097\u0098\7>\2\2\u0098\u0099\7\30\2\2\u0099"+
		"\u009a\5B\"\2\u009a\u009b\7\31\2\2\u009b\u009d\3\2\2\2\u009c\u0096\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\5@!\2\u009f\u00a1"+
		"\7?\2\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\23\3\2\2\2\u00a2"+
		"\u00a3\7\24\2\2\u00a3\u00aa\7<\2\2\u00a4\u00a5\7:\2\2\u00a5\u00a6\7>\2"+
		"\2\u00a6\u00a7\7\30\2\2\u00a7\u00a8\5B\"\2\u00a8\u00a9\7\31\2\2\u00a9"+
		"\u00ab\3\2\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ae\5@!\2\u00ad\u00af\7?\2\2\u00ae\u00ad\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\25\3\2\2\2\u00b0\u00b2\78\2\2\u00b1\u00b3\5\30\r\2\u00b2"+
		"\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\79"+
		"\2\2\u00b5\27\3\2\2\2\u00b6\u00bb\5\32\16\2\u00b7\u00b8\7\6\2\2\u00b8"+
		"\u00ba\5\32\16\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3"+
		"\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\31\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00bf\5D#\2\u00bf\u00c0\7\16\2\2\u00c0\u00c1\5\34\17\2\u00c1\33\3\2\2"+
		"\2\u00c2\u00c8\7\"\2\2\u00c3\u00c8\7!\2\2\u00c4\u00c8\7#\2\2\u00c5\u00c8"+
		"\7<\2\2\u00c6\u00c8\5\36\20\2\u00c7\u00c2\3\2\2\2\u00c7\u00c3\3\2\2\2"+
		"\u00c7\u00c4\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\35"+
		"\3\2\2\2\u00c9\u00ca\7\b\2\2\u00ca\u00cb\7\t\2\2\u00cb\u00cc\t\2\2\2\u00cc"+
		"\37\3\2\2\2\u00cd\u00d2\5\34\17\2\u00ce\u00cf\7\6\2\2\u00cf\u00d1\5\34"+
		"\17\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3!\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\5$\23\2"+
		"\u00d6\u00d8\5,\27\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8#\3"+
		"\2\2\2\u00d9\u00de\5&\24\2\u00da\u00db\7\n\2\2\u00db\u00dd\5&\24\2\u00dc"+
		"\u00da\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3\7\n\2\2\u00e2"+
		"\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\7:"+
		"\2\2\u00e5%\3\2\2\2\u00e6\u00ec\5(\25\2\u00e7\u00ec\5\60\31\2\u00e8\u00ec"+
		"\5.\30\2\u00e9\u00ec\5> \2\u00ea\u00ec\5N(\2\u00eb\u00e6\3\2\2\2\u00eb"+
		"\u00e7\3\2\2\2\u00eb\u00e8\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ea\3\2"+
		"\2\2\u00ec\'\3\2\2\2\u00ed\u00ee\5D#\2\u00ee\u00ef\7&\2\2\u00ef\u00f0"+
		"\5H%\2\u00f0)\3\2\2\2\u00f1\u00f2\7<\2\2\u00f2\u00f3\7&\2\2\u00f3\u00f4"+
		"\5J&\2\u00f4+\3\2\2\2\u00f5\u00f9\5\62\32\2\u00f6\u00f9\5:\36\2\u00f7"+
		"\u00f9\5<\37\2\u00f8\u00f5\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2"+
		"\2\2\u00f9-\3\2\2\2\u00fa\u00fb\7\25\2\2\u00fb\u00fc\5D#\2\u00fc\u00fd"+
		"\7\16\2\2\u00fd\u00fe\5\34\17\2\u00fe/\3\2\2\2\u00ff\u0100\5H%\2\u0100"+
		"\61\3\2\2\2\u0101\u0105\5\64\33\2\u0102\u0104\5\66\34\2\u0103\u0102\3"+
		"\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010a\58\35\2\u0109\u0108\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010a\63\3\2\2\2\u010b\u010c\7\32\2\2\u010c\u010d"+
		"\5J&\2\u010d\u010e\7\35\2\2\u010e\u010f\5@!\2\u010f\65\3\2\2\2\u0110\u0111"+
		"\7\34\2\2\u0111\u0112\5J&\2\u0112\u0113\7\35\2\2\u0113\u0114\5@!\2\u0114"+
		"\67\3\2\2\2\u0115\u0116\7\33\2\2\u0116\u0117\5@!\2\u01179\3\2\2\2\u0118"+
		"\u0119\7\36\2\2\u0119\u011a\5J&\2\u011a\u011b\7\31\2\2\u011b\u011c\5@"+
		"!\2\u011c;\3\2\2\2\u011d\u011e\7\4\2\2\u011e\u011f\5*\26\2\u011f\u0120"+
		"\7\r\2\2\u0120\u0121\5J&\2\u0121\u0122\7\31\2\2\u0122\u0123\5@!\2\u0123"+
		"=\3\2\2\2\u0124\u0126\7\37\2\2\u0125\u0127\5J&\2\u0126\u0125\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127?\3\2\2\2\u0128\u0133\5$\23\2\u0129\u012a\7:\2\2\u012a"+
		"\u012c\7>\2\2\u012b\u012d\5\"\22\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0131\7?\2\2\u0131\u0133\3\2\2\2\u0132\u0128\3\2\2\2\u0132\u0129\3\2"+
		"\2\2\u0133A\3\2\2\2\u0134\u0135\b\"\1\2\u0135\u0136\7\20\2\2\u0136\u013e"+
		"\5B\"\b\u0137\u0138\78\2\2\u0138\u0139\5B\"\2\u0139\u013a\79\2\2\u013a"+
		"\u013e\3\2\2\2\u013b\u013e\7<\2\2\u013c\u013e\7=\2\2\u013d\u0134\3\2\2"+
		"\2\u013d\u0137\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013c\3\2\2\2\u013e\u014a"+
		"\3\2\2\2\u013f\u0140\f\7\2\2\u0140\u0141\t\3\2\2\u0141\u0149\5B\"\b\u0142"+
		"\u0143\f\6\2\2\u0143\u0144\7(\2\2\u0144\u0149\5B\"\7\u0145\u0146\f\5\2"+
		"\2\u0146\u0147\7\'\2\2\u0147\u0149\5B\"\6\u0148\u013f\3\2\2\2\u0148\u0142"+
		"\3\2\2\2\u0148\u0145\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014bC\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u0152\5F$\2\u014e"+
		"\u014f\7\6\2\2\u014f\u0151\5F$\2\u0150\u014e\3\2\2\2\u0151\u0154\3\2\2"+
		"\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153E\3\2\2\2\u0154\u0152"+
		"\3\2\2\2\u0155\u0157\7<\2\2\u0156\u0158\5T+\2\u0157\u0156\3\2\2\2\u0157"+
		"\u0158\3\2\2\2\u0158G\3\2\2\2\u0159\u015e\5J&\2\u015a\u015b\7\6\2\2\u015b"+
		"\u015d\5J&\2\u015c\u015a\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2"+
		"\2\u015e\u015f\3\2\2\2\u015fI\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162"+
		"\b&\1\2\u0162\u0163\7\60\2\2\u0163\u016c\5J&\13\u0164\u0165\7\20\2\2\u0165"+
		"\u016c\5J&\n\u0166\u0167\78\2\2\u0167\u0168\5J&\2\u0168\u0169\79\2\2\u0169"+
		"\u016c\3\2\2\2\u016a\u016c\5L\'\2\u016b\u0161\3\2\2\2\u016b\u0164\3\2"+
		"\2\2\u016b\u0166\3\2\2\2\u016b\u016a\3\2\2\2\u016c\u0181\3\2\2\2\u016d"+
		"\u016e\f\t\2\2\u016e\u016f\t\4\2\2\u016f\u0180\5J&\n\u0170\u0171\f\b\2"+
		"\2\u0171\u0172\t\5\2\2\u0172\u0180\5J&\t\u0173\u0174\f\7\2\2\u0174\u0175"+
		"\t\6\2\2\u0175\u0180\5J&\b\u0176\u0177\f\6\2\2\u0177\u0178\t\7\2\2\u0178"+
		"\u0180\5J&\7\u0179\u017a\f\5\2\2\u017a\u017b\7(\2\2\u017b\u0180\5J&\6"+
		"\u017c\u017d\f\4\2\2\u017d\u017e\7\'\2\2\u017e\u0180\5J&\5\u017f\u016d"+
		"\3\2\2\2\u017f\u0170\3\2\2\2\u017f\u0173\3\2\2\2\u017f\u0176\3\2\2\2\u017f"+
		"\u0179\3\2\2\2\u017f\u017c\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2"+
		"\2\2\u0181\u0182\3\2\2\2\u0182K\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u018d"+
		"\7=\2\2\u0185\u018d\7$\2\2\u0186\u018d\7%\2\2\u0187\u018d\7 \2\2\u0188"+
		"\u018d\7<\2\2\u0189\u018d\5N(\2\u018a\u018d\5P)\2\u018b\u018d\5R*\2\u018c"+
		"\u0184\3\2\2\2\u018c\u0185\3\2\2\2\u018c\u0186\3\2\2\2\u018c\u0187\3\2"+
		"\2\2\u018c\u0188\3\2\2\2\u018c\u0189\3\2\2\2\u018c\u018a\3\2\2\2\u018c"+
		"\u018b\3\2\2\2\u018dM\3\2\2\2\u018e\u018f\7\27\2\2\u018f\u0190\7<\2\2"+
		"\u0190\u01a5\5V,\2\u0191\u0192\7<\2\2\u0192\u0193\7\f\2\2\u0193\u0194"+
		"\7<\2\2\u0194\u01a5\5V,\2\u0195\u0196\5R*\2\u0196\u0197\7\f\2\2\u0197"+
		"\u0198\7<\2\2\u0198\u0199\5V,\2\u0199\u01a5\3\2\2\2\u019a\u019b\7\13\2"+
		"\2\u019b\u01a5\5V,\2\u019c\u019d\7\5\2\2\u019d\u01a5\5V,\2\u019e\u019f"+
		"\7\17\2\2\u019f\u01a5\5V,\2\u01a0\u01a1\7\7\2\2\u01a1\u01a5\5V,\2\u01a2"+
		"\u01a3\7<\2\2\u01a3\u01a5\5V,\2\u01a4\u018e\3\2\2\2\u01a4\u0191\3\2\2"+
		"\2\u01a4\u0195\3\2\2\2\u01a4\u019a\3\2\2\2\u01a4\u019c\3\2\2\2\u01a4\u019e"+
		"\3\2\2\2\u01a4\u01a0\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5O\3\2\2\2\u01a6"+
		"\u01a7\7\27\2\2\u01a7\u01a8\t\2\2\2\u01a8\u01a9\5T+\2\u01a9Q\3\2\2\2\u01aa"+
		"\u01ab\7<\2\2\u01ab\u01ac\5T+\2\u01acS\3\2\2\2\u01ad\u01ae\7\66\2\2\u01ae"+
		"\u01af\5J&\2\u01af\u01b0\7\67\2\2\u01b0U\3\2\2\2\u01b1\u01b3\78\2\2\u01b2"+
		"\u01b4\5H%\2\u01b3\u01b2\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\3\2\2"+
		"\2\u01b5\u01b6\79\2\2\u01b6W\3\2\2\2&_ipz\u0083\u0094\u009c\u00a0\u00aa"+
		"\u00ae\u00b2\u00bb\u00c7\u00d2\u00d7\u00de\u00e2\u00eb\u00f8\u0105\u0109"+
		"\u0126\u012e\u0132\u013d\u0148\u014a\u0152\u0157\u015e\u016b\u017f\u0181"+
		"\u018c\u01a4\u01b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}