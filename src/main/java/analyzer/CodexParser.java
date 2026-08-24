// Generated from C:/Users/Hp/IntelliJProjects/CodexLatinus/src/main/java/Codex.g4 by ANTLR 4.13.2
package analyzer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CodexParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMERUS=1, TEXTUM=2, DECIMALIS=3, LITTERA=4, BOOL=5, VERUM=6, FALSUS=7, 
		ESTO=8, SERIES=9, STRUCTURA=10, FINIS=11, FINIS_MAIOR=12, SI=13, ALITER=14, 
		DUM=15, FACERE=16, PER=17, PERGE=18, INTERRUMPE=19, ACTIO=20, RATIO=21, 
		REDDERE=22, VARIABILES=23, MUNERA=24, MAIOR=25, NON=26, LEER=27, IMPRIMIR=28, 
		MAS_MAS=29, MENOS_MENOS=30, MAS=31, MENOS=32, POR=33, DIV=34, IGUAL_IGUAL=35, 
		DIFERENTE=36, MAYOR_IGUAL=37, MENOR_IGUAL=38, MAYOR=39, MENOR=40, AND=41, 
		OR=42, ASIGNACION=43, DOS_PUNTOS=44, PUNTO_COMA=45, COMA=46, PUNTO=47, 
		PAREN_IZQ=48, PAREN_DER=49, LLAVE_IZQ=50, LLAVE_DER=51, CORCHETE_IZQ=52, 
		CORCHETE_DER=53, ID=54, ENTERO=55, DECIMAL=56, CADENA=57, CARACTER=58, 
		COMMENT=59, BLOCK_COMMENT=60, WS=61;
	public static final int
		RULE_program = 0, RULE_seccionVariables = 1, RULE_seccionFunciones = 2, 
		RULE_seccionPrincipal = 3, RULE_tipoDato = 4, RULE_declaracion = 5, RULE_declaracionVar = 6, 
		RULE_declaracionArreglo = 7, RULE_atributoStruct = 8, RULE_definicionStruct = 9, 
		RULE_funcion = 10, RULE_seccionVariablesLocal = 11, RULE_parametros = 12, 
		RULE_parametro = 13, RULE_instruccion = 14, RULE_interrupcion = 15, RULE_retorno = 16, 
		RULE_asignacion = 17, RULE_estructuraControl = 18, RULE_condicionalSi = 19, 
		RULE_cicloDum = 20, RULE_cicloFacere = 21, RULE_cicloPer = 22, RULE_funcionEspecial = 23, 
		RULE_expresion = 24, RULE_llamadaFuncion = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "seccionVariables", "seccionFunciones", "seccionPrincipal", 
			"tipoDato", "declaracion", "declaracionVar", "declaracionArreglo", "atributoStruct", 
			"definicionStruct", "funcion", "seccionVariablesLocal", "parametros", 
			"parametro", "instruccion", "interrupcion", "retorno", "asignacion", 
			"estructuraControl", "condicionalSi", "cicloDum", "cicloFacere", "cicloPer", 
			"funcionEspecial", "expresion", "llamadaFuncion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'numerus'", "'textum'", "'decimalis'", "'littera'", "'bool'", 
			"'verum'", "'falsus'", "'esto'", "'series'", "'structura'", "'finis'", 
			"'FINIS'", "'si'", "'aliter'", "'dum'", "'facere'", "'per'", "'perge'", 
			"'interrumpe'", "'actio'", "'ratio'", "'reddere'", "'VARIABILES'", "'MUNERA'", 
			"'MAIOR'", "'non'", "'<<'", "'>>'", "'++'", "'--'", "'+'", "'-'", "'*'", 
			"'/'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'&&'", "'||'", 
			"'='", "':'", "';'", "','", "'.'", "'('", "')'", "'{'", "'}'", "'['", 
			"']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMERUS", "TEXTUM", "DECIMALIS", "LITTERA", "BOOL", "VERUM", "FALSUS", 
			"ESTO", "SERIES", "STRUCTURA", "FINIS", "FINIS_MAIOR", "SI", "ALITER", 
			"DUM", "FACERE", "PER", "PERGE", "INTERRUMPE", "ACTIO", "RATIO", "REDDERE", 
			"VARIABILES", "MUNERA", "MAIOR", "NON", "LEER", "IMPRIMIR", "MAS_MAS", 
			"MENOS_MENOS", "MAS", "MENOS", "POR", "DIV", "IGUAL_IGUAL", "DIFERENTE", 
			"MAYOR_IGUAL", "MENOR_IGUAL", "MAYOR", "MENOR", "AND", "OR", "ASIGNACION", 
			"DOS_PUNTOS", "PUNTO_COMA", "COMA", "PUNTO", "PAREN_IZQ", "PAREN_DER", 
			"LLAVE_IZQ", "LLAVE_DER", "CORCHETE_IZQ", "CORCHETE_DER", "ID", "ENTERO", 
			"DECIMAL", "CADENA", "CARACTER", "COMMENT", "BLOCK_COMMENT", "WS"
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
	public String getGrammarFileName() { return "Codex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CodexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public SeccionPrincipalContext seccionPrincipal() {
			return getRuleContext(SeccionPrincipalContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CodexParser.EOF, 0); }
		public SeccionVariablesContext seccionVariables() {
			return getRuleContext(SeccionVariablesContext.class,0);
		}
		public SeccionFuncionesContext seccionFunciones() {
			return getRuleContext(SeccionFuncionesContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABILES) {
				{
				setState(52);
				seccionVariables();
				}
			}

			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUNERA) {
				{
				setState(55);
				seccionFunciones();
				}
			}

			setState(58);
			seccionPrincipal();
			setState(59);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SeccionVariablesContext extends ParserRuleContext {
		public TerminalNode VARIABILES() { return getToken(CodexParser.VARIABILES, 0); }
		public TerminalNode MAYOR() { return getToken(CodexParser.MAYOR, 0); }
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public SeccionVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterSeccionVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitSeccionVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitSeccionVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionVariablesContext seccionVariables() throws RecognitionException {
		SeccionVariablesContext _localctx = new SeccionVariablesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_seccionVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(VARIABILES);
			setState(62);
			match(MAYOR);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) {
				{
				{
				setState(63);
				declaracion();
				}
				}
				setState(68);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SeccionFuncionesContext extends ParserRuleContext {
		public TerminalNode MUNERA() { return getToken(CodexParser.MUNERA, 0); }
		public TerminalNode MAYOR() { return getToken(CodexParser.MAYOR, 0); }
		public List<FuncionContext> funcion() {
			return getRuleContexts(FuncionContext.class);
		}
		public FuncionContext funcion(int i) {
			return getRuleContext(FuncionContext.class,i);
		}
		public SeccionFuncionesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionFunciones; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterSeccionFunciones(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitSeccionFunciones(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitSeccionFunciones(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionFuncionesContext seccionFunciones() throws RecognitionException {
		SeccionFuncionesContext _localctx = new SeccionFuncionesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_seccionFunciones);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(MUNERA);
			setState(70);
			match(MAYOR);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ACTIO || _la==RATIO) {
				{
				{
				setState(71);
				funcion();
				}
				}
				setState(76);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SeccionPrincipalContext extends ParserRuleContext {
		public TerminalNode MAIOR() { return getToken(CodexParser.MAIOR, 0); }
		public TerminalNode MAYOR() { return getToken(CodexParser.MAYOR, 0); }
		public TerminalNode FINIS_MAIOR() { return getToken(CodexParser.FINIS_MAIOR, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public SeccionPrincipalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionPrincipal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterSeccionPrincipal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitSeccionPrincipal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitSeccionPrincipal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionPrincipalContext seccionPrincipal() throws RecognitionException {
		SeccionPrincipalContext _localctx = new SeccionPrincipalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_seccionPrincipal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(MAIOR);
			setState(78);
			match(MAYOR);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398917353728L) != 0)) {
				{
				{
				setState(79);
				instruccion();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(FINIS_MAIOR);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTO_COMA) {
				{
				setState(86);
				match(PUNTO_COMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TipoDatoContext extends ParserRuleContext {
		public TerminalNode NUMERUS() { return getToken(CodexParser.NUMERUS, 0); }
		public TerminalNode TEXTUM() { return getToken(CodexParser.TEXTUM, 0); }
		public TerminalNode DECIMALIS() { return getToken(CodexParser.DECIMALIS, 0); }
		public TerminalNode LITTERA() { return getToken(CodexParser.LITTERA, 0); }
		public TerminalNode BOOL() { return getToken(CodexParser.BOOL, 0); }
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public TipoDatoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoDato; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterTipoDato(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitTipoDato(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitTipoDato(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoDatoContext tipoDato() throws RecognitionException {
		TipoDatoContext _localctx = new TipoDatoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipoDato);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398509482046L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionContext extends ParserRuleContext {
		public DeclaracionVarContext declaracionVar() {
			return getRuleContext(DeclaracionVarContext.class,0);
		}
		public DeclaracionArregloContext declaracionArreglo() {
			return getRuleContext(DeclaracionArregloContext.class,0);
		}
		public DefinicionStructContext definicionStruct() {
			return getRuleContext(DefinicionStructContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracion);
		try {
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				declaracionVar();
				}
				break;
			case SERIES:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				declaracionArreglo();
				}
				break;
			case STRUCTURA:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				definicionStruct();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionVarContext extends ParserRuleContext {
		public TerminalNode ESTO() { return getToken(CodexParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(CodexParser.DOS_PUNTOS, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterDeclaracionVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitDeclaracionVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitDeclaracionVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionVarContext declaracionVar() throws RecognitionException {
		DeclaracionVarContext _localctx = new DeclaracionVarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaracionVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(ESTO);
			setState(97);
			match(ID);
			setState(98);
			match(DOS_PUNTOS);
			setState(99);
			tipoDato();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 559853733039571136L) != 0)) {
				{
				setState(100);
				expresion(0);
				}
			}

			setState(103);
			match(PUNTO_COMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionArregloContext extends ParserRuleContext {
		public TerminalNode SERIES() { return getToken(CodexParser.SERIES, 0); }
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public TerminalNode CORCHETE_IZQ() { return getToken(CodexParser.CORCHETE_IZQ, 0); }
		public TerminalNode ENTERO() { return getToken(CodexParser.ENTERO, 0); }
		public TerminalNode CORCHETE_DER() { return getToken(CodexParser.CORCHETE_DER, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(CodexParser.DOS_PUNTOS, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public TerminalNode LLAVE_IZQ() { return getToken(CodexParser.LLAVE_IZQ, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode LLAVE_DER() { return getToken(CodexParser.LLAVE_DER, 0); }
		public List<TerminalNode> COMA() { return getTokens(CodexParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(CodexParser.COMA, i);
		}
		public DeclaracionArregloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionArreglo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterDeclaracionArreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitDeclaracionArreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitDeclaracionArreglo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionArregloContext declaracionArreglo() throws RecognitionException {
		DeclaracionArregloContext _localctx = new DeclaracionArregloContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaracionArreglo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(SERIES);
			setState(106);
			match(ID);
			setState(107);
			match(CORCHETE_IZQ);
			setState(108);
			match(ENTERO);
			setState(109);
			match(CORCHETE_DER);
			setState(110);
			match(DOS_PUNTOS);
			setState(111);
			tipoDato();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LLAVE_IZQ) {
				{
				setState(112);
				match(LLAVE_IZQ);
				setState(113);
				expresion(0);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(114);
					match(COMA);
					setState(115);
					expresion(0);
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121);
				match(LLAVE_DER);
				}
			}

			setState(125);
			match(PUNTO_COMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtributoStructContext extends ParserRuleContext {
		public TerminalNode ESTO() { return getToken(CodexParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(CodexParser.DOS_PUNTOS, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode SERIES() { return getToken(CodexParser.SERIES, 0); }
		public TerminalNode CORCHETE_IZQ() { return getToken(CodexParser.CORCHETE_IZQ, 0); }
		public TerminalNode ENTERO() { return getToken(CodexParser.ENTERO, 0); }
		public TerminalNode CORCHETE_DER() { return getToken(CodexParser.CORCHETE_DER, 0); }
		public AtributoStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributoStruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterAtributoStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitAtributoStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitAtributoStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtributoStructContext atributoStruct() throws RecognitionException {
		AtributoStructContext _localctx = new AtributoStructContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_atributoStruct);
		int _la;
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(ESTO);
				setState(128);
				match(ID);
				setState(129);
				match(DOS_PUNTOS);
				setState(130);
				tipoDato();
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 559853733039571136L) != 0)) {
					{
					setState(131);
					expresion(0);
					}
				}

				}
				break;
			case SERIES:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(SERIES);
				setState(135);
				match(ID);
				setState(136);
				match(DOS_PUNTOS);
				setState(137);
				tipoDato();
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CORCHETE_IZQ) {
					{
					setState(138);
					match(CORCHETE_IZQ);
					setState(139);
					match(ENTERO);
					setState(140);
					match(CORCHETE_DER);
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class DefinicionStructContext extends ParserRuleContext {
		public TerminalNode STRUCTURA() { return getToken(CodexParser.STRUCTURA, 0); }
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public TerminalNode LLAVE_IZQ() { return getToken(CodexParser.LLAVE_IZQ, 0); }
		public TerminalNode LLAVE_DER() { return getToken(CodexParser.LLAVE_DER, 0); }
		public TerminalNode FINIS() { return getToken(CodexParser.FINIS, 0); }
		public List<TerminalNode> PUNTO_COMA() { return getTokens(CodexParser.PUNTO_COMA); }
		public TerminalNode PUNTO_COMA(int i) {
			return getToken(CodexParser.PUNTO_COMA, i);
		}
		public List<AtributoStructContext> atributoStruct() {
			return getRuleContexts(AtributoStructContext.class);
		}
		public AtributoStructContext atributoStruct(int i) {
			return getRuleContext(AtributoStructContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(CodexParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(CodexParser.COMA, i);
		}
		public DefinicionStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicionStruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterDefinicionStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitDefinicionStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitDefinicionStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinicionStructContext definicionStruct() throws RecognitionException {
		DefinicionStructContext _localctx = new DefinicionStructContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_definicionStruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(STRUCTURA);
			setState(146);
			match(ID);
			setState(147);
			match(LLAVE_IZQ);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESTO || _la==SERIES) {
				{
				{
				setState(148);
				atributoStruct();
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA || _la==COMA) {
					{
					setState(149);
					_la = _input.LA(1);
					if ( !(_la==PUNTO_COMA || _la==COMA) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
			match(LLAVE_DER);
			setState(158);
			match(FINIS);
			setState(159);
			match(PUNTO_COMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public TerminalNode PAREN_IZQ() { return getToken(CodexParser.PAREN_IZQ, 0); }
		public TerminalNode PAREN_DER() { return getToken(CodexParser.PAREN_DER, 0); }
		public TerminalNode LLAVE_IZQ() { return getToken(CodexParser.LLAVE_IZQ, 0); }
		public TerminalNode LLAVE_DER() { return getToken(CodexParser.LLAVE_DER, 0); }
		public TerminalNode FINIS() { return getToken(CodexParser.FINIS, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public TerminalNode ACTIO() { return getToken(CodexParser.ACTIO, 0); }
		public TerminalNode RATIO() { return getToken(CodexParser.RATIO, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public SeccionVariablesLocalContext seccionVariablesLocal() {
			return getRuleContext(SeccionVariablesLocalContext.class,0);
		}
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public FuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncionContext funcion() throws RecognitionException {
		FuncionContext _localctx = new FuncionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ACTIO:
				{
				setState(161);
				match(ACTIO);
				}
				break;
			case RATIO:
				{
				setState(162);
				match(RATIO);
				setState(163);
				tipoDato();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(166);
			match(ID);
			setState(167);
			match(PAREN_IZQ);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ESTO) {
				{
				setState(168);
				parametros();
				}
			}

			setState(171);
			match(PAREN_DER);
			setState(172);
			match(LLAVE_IZQ);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABILES) {
				{
				setState(173);
				seccionVariablesLocal();
				}
			}

			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398917353728L) != 0)) {
				{
				{
				setState(176);
				instruccion();
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182);
			match(LLAVE_DER);
			setState(183);
			match(FINIS);
			setState(184);
			match(PUNTO_COMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SeccionVariablesLocalContext extends ParserRuleContext {
		public TerminalNode VARIABILES() { return getToken(CodexParser.VARIABILES, 0); }
		public TerminalNode CORCHETE_IZQ() { return getToken(CodexParser.CORCHETE_IZQ, 0); }
		public TerminalNode CORCHETE_DER() { return getToken(CodexParser.CORCHETE_DER, 0); }
		public List<DeclaracionVarContext> declaracionVar() {
			return getRuleContexts(DeclaracionVarContext.class);
		}
		public DeclaracionVarContext declaracionVar(int i) {
			return getRuleContext(DeclaracionVarContext.class,i);
		}
		public SeccionVariablesLocalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionVariablesLocal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterSeccionVariablesLocal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitSeccionVariablesLocal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitSeccionVariablesLocal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionVariablesLocalContext seccionVariablesLocal() throws RecognitionException {
		SeccionVariablesLocalContext _localctx = new SeccionVariablesLocalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_seccionVariablesLocal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(VARIABILES);
			setState(187);
			match(CORCHETE_IZQ);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESTO) {
				{
				{
				setState(188);
				declaracionVar();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(194);
			match(CORCHETE_DER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(CodexParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(CodexParser.COMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			parametro();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(197);
				match(COMA);
				setState(198);
				parametro();
				}
				}
				setState(203);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParametroContext extends ParserRuleContext {
		public TerminalNode ESTO() { return getToken(CodexParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public TerminalNode DOS_PUNTOS() { return getToken(CodexParser.DOS_PUNTOS, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitParametro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(ESTO);
			setState(205);
			match(ID);
			setState(206);
			match(DOS_PUNTOS);
			setState(207);
			tipoDato();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstruccionContext extends ParserRuleContext {
		public DeclaracionVarContext declaracionVar() {
			return getRuleContext(DeclaracionVarContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public EstructuraControlContext estructuraControl() {
			return getRuleContext(EstructuraControlContext.class,0);
		}
		public FuncionEspecialContext funcionEspecial() {
			return getRuleContext(FuncionEspecialContext.class,0);
		}
		public LlamadaFuncionContext llamadaFuncion() {
			return getRuleContext(LlamadaFuncionContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public InterrupcionContext interrupcion() {
			return getRuleContext(InterrupcionContext.class,0);
		}
		public RetornoContext retorno() {
			return getRuleContext(RetornoContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterInstruccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitInstruccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitInstruccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_instruccion);
		try {
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				declaracionVar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				asignacion();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				estructuraControl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				funcionEspecial();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(213);
				llamadaFuncion();
				setState(214);
				match(PUNTO_COMA);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(216);
				interrupcion();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(217);
				retorno();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterrupcionContext extends ParserRuleContext {
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public TerminalNode PERGE() { return getToken(CodexParser.PERGE, 0); }
		public TerminalNode INTERRUMPE() { return getToken(CodexParser.INTERRUMPE, 0); }
		public InterrupcionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interrupcion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterInterrupcion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitInterrupcion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitInterrupcion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterrupcionContext interrupcion() throws RecognitionException {
		InterrupcionContext _localctx = new InterrupcionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_interrupcion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_la = _input.LA(1);
			if ( !(_la==PERGE || _la==INTERRUMPE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(221);
			match(PUNTO_COMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RetornoContext extends ParserRuleContext {
		public TerminalNode REDDERE() { return getToken(CodexParser.REDDERE, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public RetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorno; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterRetorno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitRetorno(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitRetorno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetornoContext retorno() throws RecognitionException {
		RetornoContext _localctx = new RetornoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_retorno);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(REDDERE);
			setState(224);
			expresion(0);
			setState(225);
			match(PUNTO_COMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AsignacionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CodexParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CodexParser.ID, i);
		}
		public TerminalNode ASIGNACION() { return getToken(CodexParser.ASIGNACION, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public List<TerminalNode> PUNTO() { return getTokens(CodexParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(CodexParser.PUNTO, i);
		}
		public List<TerminalNode> CORCHETE_IZQ() { return getTokens(CodexParser.CORCHETE_IZQ); }
		public TerminalNode CORCHETE_IZQ(int i) {
			return getToken(CodexParser.CORCHETE_IZQ, i);
		}
		public List<TerminalNode> CORCHETE_DER() { return getTokens(CodexParser.CORCHETE_DER); }
		public TerminalNode CORCHETE_DER(int i) {
			return getToken(CodexParser.CORCHETE_DER, i);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_asignacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(ID);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUNTO || _la==CORCHETE_IZQ) {
				{
				setState(234);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PUNTO:
					{
					setState(228);
					match(PUNTO);
					setState(229);
					match(ID);
					}
					break;
				case CORCHETE_IZQ:
					{
					setState(230);
					match(CORCHETE_IZQ);
					setState(231);
					expresion(0);
					setState(232);
					match(CORCHETE_DER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(239);
			match(ASIGNACION);
			setState(240);
			expresion(0);
			setState(241);
			match(PUNTO_COMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EstructuraControlContext extends ParserRuleContext {
		public CondicionalSiContext condicionalSi() {
			return getRuleContext(CondicionalSiContext.class,0);
		}
		public CicloDumContext cicloDum() {
			return getRuleContext(CicloDumContext.class,0);
		}
		public CicloFacereContext cicloFacere() {
			return getRuleContext(CicloFacereContext.class,0);
		}
		public CicloPerContext cicloPer() {
			return getRuleContext(CicloPerContext.class,0);
		}
		public EstructuraControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estructuraControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterEstructuraControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitEstructuraControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitEstructuraControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EstructuraControlContext estructuraControl() throws RecognitionException {
		EstructuraControlContext _localctx = new EstructuraControlContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_estructuraControl);
		try {
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SI:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				condicionalSi();
				}
				break;
			case DUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				cicloDum();
				}
				break;
			case FACERE:
				enterOuterAlt(_localctx, 3);
				{
				setState(245);
				cicloFacere();
				}
				break;
			case PER:
				enterOuterAlt(_localctx, 4);
				{
				setState(246);
				cicloPer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CondicionalSiContext extends ParserRuleContext {
		public TerminalNode SI() { return getToken(CodexParser.SI, 0); }
		public List<TerminalNode> PAREN_IZQ() { return getTokens(CodexParser.PAREN_IZQ); }
		public TerminalNode PAREN_IZQ(int i) {
			return getToken(CodexParser.PAREN_IZQ, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> PAREN_DER() { return getTokens(CodexParser.PAREN_DER); }
		public TerminalNode PAREN_DER(int i) {
			return getToken(CodexParser.PAREN_DER, i);
		}
		public List<TerminalNode> LLAVE_IZQ() { return getTokens(CodexParser.LLAVE_IZQ); }
		public TerminalNode LLAVE_IZQ(int i) {
			return getToken(CodexParser.LLAVE_IZQ, i);
		}
		public List<TerminalNode> LLAVE_DER() { return getTokens(CodexParser.LLAVE_DER); }
		public TerminalNode LLAVE_DER(int i) {
			return getToken(CodexParser.LLAVE_DER, i);
		}
		public TerminalNode FINIS() { return getToken(CodexParser.FINIS, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public List<TerminalNode> ALITER() { return getTokens(CodexParser.ALITER); }
		public TerminalNode ALITER(int i) {
			return getToken(CodexParser.ALITER, i);
		}
		public CondicionalSiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicionalSi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterCondicionalSi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitCondicionalSi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitCondicionalSi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondicionalSiContext condicionalSi() throws RecognitionException {
		CondicionalSiContext _localctx = new CondicionalSiContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_condicionalSi);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(SI);
			setState(250);
			match(PAREN_IZQ);
			setState(251);
			expresion(0);
			setState(252);
			match(PAREN_DER);
			setState(253);
			match(LLAVE_IZQ);
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398917353728L) != 0)) {
				{
				{
				setState(254);
				instruccion();
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(260);
			match(LLAVE_DER);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(261);
					match(ALITER);
					setState(262);
					match(PAREN_IZQ);
					setState(263);
					expresion(0);
					setState(264);
					match(PAREN_DER);
					setState(265);
					match(LLAVE_IZQ);
					setState(269);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398917353728L) != 0)) {
						{
						{
						setState(266);
						instruccion();
						}
						}
						setState(271);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(272);
					match(LLAVE_DER);
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALITER) {
				{
				setState(279);
				match(ALITER);
				setState(280);
				match(LLAVE_IZQ);
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398917353728L) != 0)) {
					{
					{
					setState(281);
					instruccion();
					}
					}
					setState(286);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(287);
				match(LLAVE_DER);
				}
			}

			setState(290);
			match(FINIS);
			setState(291);
			match(PUNTO_COMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CicloDumContext extends ParserRuleContext {
		public TerminalNode DUM() { return getToken(CodexParser.DUM, 0); }
		public TerminalNode PAREN_IZQ() { return getToken(CodexParser.PAREN_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_DER() { return getToken(CodexParser.PAREN_DER, 0); }
		public TerminalNode LLAVE_IZQ() { return getToken(CodexParser.LLAVE_IZQ, 0); }
		public TerminalNode LLAVE_DER() { return getToken(CodexParser.LLAVE_DER, 0); }
		public TerminalNode FINIS() { return getToken(CodexParser.FINIS, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public CicloDumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cicloDum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterCicloDum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitCicloDum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitCicloDum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CicloDumContext cicloDum() throws RecognitionException {
		CicloDumContext _localctx = new CicloDumContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cicloDum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(DUM);
			setState(294);
			match(PAREN_IZQ);
			setState(295);
			expresion(0);
			setState(296);
			match(PAREN_DER);
			setState(297);
			match(LLAVE_IZQ);
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398917353728L) != 0)) {
				{
				{
				setState(298);
				instruccion();
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(304);
			match(LLAVE_DER);
			setState(305);
			match(FINIS);
			setState(306);
			match(PUNTO_COMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CicloFacereContext extends ParserRuleContext {
		public TerminalNode FACERE() { return getToken(CodexParser.FACERE, 0); }
		public TerminalNode LLAVE_IZQ() { return getToken(CodexParser.LLAVE_IZQ, 0); }
		public TerminalNode LLAVE_DER() { return getToken(CodexParser.LLAVE_DER, 0); }
		public TerminalNode DUM() { return getToken(CodexParser.DUM, 0); }
		public TerminalNode PAREN_IZQ() { return getToken(CodexParser.PAREN_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_DER() { return getToken(CodexParser.PAREN_DER, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public CicloFacereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cicloFacere; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterCicloFacere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitCicloFacere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitCicloFacere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CicloFacereContext cicloFacere() throws RecognitionException {
		CicloFacereContext _localctx = new CicloFacereContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_cicloFacere);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(FACERE);
			setState(309);
			match(LLAVE_IZQ);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398917353728L) != 0)) {
				{
				{
				setState(310);
				instruccion();
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(316);
			match(LLAVE_DER);
			setState(317);
			match(DUM);
			setState(318);
			match(PAREN_IZQ);
			setState(319);
			expresion(0);
			setState(320);
			match(PAREN_DER);
			setState(321);
			match(PUNTO_COMA);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CicloPerContext extends ParserRuleContext {
		public TerminalNode PER() { return getToken(CodexParser.PER, 0); }
		public TerminalNode PAREN_IZQ() { return getToken(CodexParser.PAREN_IZQ, 0); }
		public DeclaracionVarContext declaracionVar() {
			return getRuleContext(DeclaracionVarContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public TerminalNode PAREN_DER() { return getToken(CodexParser.PAREN_DER, 0); }
		public TerminalNode LLAVE_IZQ() { return getToken(CodexParser.LLAVE_IZQ, 0); }
		public TerminalNode LLAVE_DER() { return getToken(CodexParser.LLAVE_DER, 0); }
		public TerminalNode MAS_MAS() { return getToken(CodexParser.MAS_MAS, 0); }
		public TerminalNode MENOS_MENOS() { return getToken(CodexParser.MENOS_MENOS, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public CicloPerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cicloPer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterCicloPer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitCicloPer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitCicloPer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CicloPerContext cicloPer() throws RecognitionException {
		CicloPerContext _localctx = new CicloPerContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_cicloPer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(PER);
			setState(324);
			match(PAREN_IZQ);
			setState(325);
			declaracionVar();
			setState(326);
			expresion(0);
			setState(327);
			match(PUNTO_COMA);
			setState(328);
			match(ID);
			setState(329);
			_la = _input.LA(1);
			if ( !(_la==MAS_MAS || _la==MENOS_MENOS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(330);
			match(PAREN_DER);
			setState(331);
			match(LLAVE_IZQ);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398917353728L) != 0)) {
				{
				{
				setState(332);
				instruccion();
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(338);
			match(LLAVE_DER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncionEspecialContext extends ParserRuleContext {
		public TerminalNode LEER() { return getToken(CodexParser.LEER, 0); }
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(CodexParser.PUNTO_COMA, 0); }
		public List<TerminalNode> IMPRIMIR() { return getTokens(CodexParser.IMPRIMIR); }
		public TerminalNode IMPRIMIR(int i) {
			return getToken(CodexParser.IMPRIMIR, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public FuncionEspecialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcionEspecial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterFuncionEspecial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitFuncionEspecial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitFuncionEspecial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncionEspecialContext funcionEspecial() throws RecognitionException {
		FuncionEspecialContext _localctx = new FuncionEspecialContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_funcionEspecial);
		int _la;
		try {
			int _alt;
			setState(359);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEER:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(340);
					match(ID);
					}
				}

				setState(343);
				match(LEER);
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(344);
					match(PUNTO_COMA);
					}
				}

				}
				break;
			case IMPRIMIR:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				match(IMPRIMIR);
				setState(348);
				expresion(0);
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(349);
						match(IMPRIMIR);
						setState(350);
						expresion(0);
						}
						} 
					}
					setState(355);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTO_COMA) {
					{
					setState(356);
					match(PUNTO_COMA);
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprArregloContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public TerminalNode CORCHETE_IZQ() { return getToken(CodexParser.CORCHETE_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode CORCHETE_DER() { return getToken(CodexParser.CORCHETE_DER, 0); }
		public ExprArregloContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprArreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprArreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprArreglo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprSumaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAS() { return getToken(CodexParser.MAS, 0); }
		public TerminalNode MENOS() { return getToken(CodexParser.MENOS, 0); }
		public ExprSumaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprSuma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprSuma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprSuma(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAtributoStructContext extends ExpresionContext {
		public List<TerminalNode> ID() { return getTokens(CodexParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CodexParser.ID, i);
		}
		public TerminalNode PUNTO() { return getToken(CodexParser.PUNTO, 0); }
		public ExprAtributoStructContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprAtributoStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprAtributoStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprAtributoStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprRelacionalContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAYOR() { return getToken(CodexParser.MAYOR, 0); }
		public TerminalNode MENOR() { return getToken(CodexParser.MENOR, 0); }
		public TerminalNode MAYOR_IGUAL() { return getToken(CodexParser.MAYOR_IGUAL, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(CodexParser.MENOR_IGUAL, 0); }
		public ExprRelacionalContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprRelacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprRelacional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnariaContext extends ExpresionContext {
		public TerminalNode MENOS() { return getToken(CodexParser.MENOS, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExprUnariaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprUnaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprUnaria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprUnaria(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprFalsoContext extends ExpresionContext {
		public TerminalNode FALSUS() { return getToken(CodexParser.FALSUS, 0); }
		public ExprFalsoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprFalso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprFalso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprFalso(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprInstanciaStructContext extends ExpresionContext {
		public TerminalNode LLAVE_IZQ() { return getToken(CodexParser.LLAVE_IZQ, 0); }
		public TerminalNode LLAVE_DER() { return getToken(CodexParser.LLAVE_DER, 0); }
		public List<TerminalNode> ID() { return getTokens(CodexParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CodexParser.ID, i);
		}
		public List<TerminalNode> DOS_PUNTOS() { return getTokens(CodexParser.DOS_PUNTOS); }
		public TerminalNode DOS_PUNTOS(int i) {
			return getToken(CodexParser.DOS_PUNTOS, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(CodexParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(CodexParser.COMA, i);
		}
		public ExprInstanciaStructContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprInstanciaStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprInstanciaStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprInstanciaStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLlamadaContext extends ExpresionContext {
		public LlamadaFuncionContext llamadaFuncion() {
			return getRuleContext(LlamadaFuncionContext.class,0);
		}
		public ExprLlamadaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprLlamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprLlamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprLlamada(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprOrContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode OR() { return getToken(CodexParser.OR, 0); }
		public ExprOrContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNegacionContext extends ExpresionContext {
		public TerminalNode NON() { return getToken(CodexParser.NON, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExprNegacionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprNegacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprNegacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprNegacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprCadenaContext extends ExpresionContext {
		public TerminalNode CADENA() { return getToken(CodexParser.CADENA, 0); }
		public ExprCadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprCadena(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprCadena(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprCadena(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVariableContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public ExprVariableContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprEnteroContext extends ExpresionContext {
		public TerminalNode ENTERO() { return getToken(CodexParser.ENTERO, 0); }
		public ExprEnteroContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprEntero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprEntero(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprEntero(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVerdaderoContext extends ExpresionContext {
		public TerminalNode VERUM() { return getToken(CodexParser.VERUM, 0); }
		public ExprVerdaderoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprVerdadero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprVerdadero(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprVerdadero(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIgualdadContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode IGUAL_IGUAL() { return getToken(CodexParser.IGUAL_IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(CodexParser.DIFERENTE, 0); }
		public ExprIgualdadContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprIgualdad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprIgualdad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprIgualdad(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAndContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode AND() { return getToken(CodexParser.AND, 0); }
		public ExprAndContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAgrupacionContext extends ExpresionContext {
		public TerminalNode PAREN_IZQ() { return getToken(CodexParser.PAREN_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_DER() { return getToken(CodexParser.PAREN_DER, 0); }
		public ExprAgrupacionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprAgrupacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprAgrupacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprAgrupacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMultiplicacionContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode POR() { return getToken(CodexParser.POR, 0); }
		public TerminalNode DIV() { return getToken(CodexParser.DIV, 0); }
		public ExprMultiplicacionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprMultiplicacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprMultiplicacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprMultiplicacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprCaracterContext extends ExpresionContext {
		public TerminalNode CARACTER() { return getToken(CodexParser.CARACTER, 0); }
		public ExprCaracterContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprCaracter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprCaracter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprCaracter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprDecimalContext extends ExpresionContext {
		public TerminalNode DECIMAL() { return getToken(CodexParser.DECIMAL, 0); }
		public ExprDecimalContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterExprDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitExprDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitExprDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				_localctx = new ExprUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(362);
				match(MENOS);
				setState(363);
				expresion(20);
				}
				break;
			case 2:
				{
				_localctx = new ExprNegacionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(364);
				match(NON);
				setState(365);
				expresion(19);
				}
				break;
			case 3:
				{
				_localctx = new ExprAgrupacionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(366);
				match(PAREN_IZQ);
				setState(367);
				expresion(0);
				setState(368);
				match(PAREN_DER);
				}
				break;
			case 4:
				{
				_localctx = new ExprEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(370);
				match(ENTERO);
				}
				break;
			case 5:
				{
				_localctx = new ExprDecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(371);
				match(DECIMAL);
				}
				break;
			case 6:
				{
				_localctx = new ExprCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(372);
				match(CADENA);
				}
				break;
			case 7:
				{
				_localctx = new ExprCaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(373);
				match(CARACTER);
				}
				break;
			case 8:
				{
				_localctx = new ExprVerdaderoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(374);
				match(VERUM);
				}
				break;
			case 9:
				{
				_localctx = new ExprFalsoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(375);
				match(FALSUS);
				}
				break;
			case 10:
				{
				_localctx = new ExprArregloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(376);
				match(ID);
				setState(377);
				match(CORCHETE_IZQ);
				setState(378);
				expresion(0);
				setState(379);
				match(CORCHETE_DER);
				}
				break;
			case 11:
				{
				_localctx = new ExprAtributoStructContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(381);
				match(ID);
				setState(382);
				match(PUNTO);
				setState(383);
				match(ID);
				}
				break;
			case 12:
				{
				_localctx = new ExprLlamadaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(384);
				llamadaFuncion();
				}
				break;
			case 13:
				{
				_localctx = new ExprVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(385);
				match(ID);
				}
				break;
			case 14:
				{
				_localctx = new ExprInstanciaStructContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(386);
					match(ID);
					}
				}

				setState(389);
				match(LLAVE_IZQ);
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(390);
					match(ID);
					setState(391);
					match(DOS_PUNTOS);
					setState(392);
					expresion(0);
					setState(394);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMA) {
						{
						setState(393);
						match(COMA);
						}
					}

					}
					}
					setState(400);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(401);
				match(LLAVE_DER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(424);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(422);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(404);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(405);
						_la = _input.LA(1);
						if ( !(_la==POR || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(406);
						expresion(19);
						}
						break;
					case 2:
						{
						_localctx = new ExprSumaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(407);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(408);
						_la = _input.LA(1);
						if ( !(_la==MAS || _la==MENOS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(409);
						expresion(18);
						}
						break;
					case 3:
						{
						_localctx = new ExprRelacionalContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(410);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(411);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2061584302080L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(412);
						expresion(17);
						}
						break;
					case 4:
						{
						_localctx = new ExprIgualdadContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(413);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(414);
						_la = _input.LA(1);
						if ( !(_la==IGUAL_IGUAL || _la==DIFERENTE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(415);
						expresion(16);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(416);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(417);
						match(AND);
						setState(418);
						expresion(15);
						}
						break;
					case 6:
						{
						_localctx = new ExprOrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(419);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(420);
						match(OR);
						setState(421);
						expresion(14);
						}
						break;
					}
					} 
				}
				setState(426);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LlamadaFuncionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CodexParser.ID, 0); }
		public TerminalNode PAREN_IZQ() { return getToken(CodexParser.PAREN_IZQ, 0); }
		public TerminalNode PAREN_DER() { return getToken(CodexParser.PAREN_DER, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(CodexParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(CodexParser.COMA, i);
		}
		public LlamadaFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamadaFuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).enterLlamadaFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CodexListener ) ((CodexListener)listener).exitLlamadaFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CodexVisitor ) return ((CodexVisitor<? extends T>)visitor).visitLlamadaFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamadaFuncionContext llamadaFuncion() throws RecognitionException {
		LlamadaFuncionContext _localctx = new LlamadaFuncionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_llamadaFuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			match(ID);
			setState(428);
			match(PAREN_IZQ);
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 559853733039571136L) != 0)) {
				{
				setState(429);
				expresion(0);
				setState(434);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMA) {
					{
					{
					setState(430);
					match(COMA);
					setState(431);
					expresion(0);
					}
					}
					setState(436);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(439);
			match(PAREN_DER);
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
		case 24:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001=\u01ba\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0003\u00006\b\u0000\u0001\u0000"+
		"\u0003\u00009\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001A\b\u0001\n\u0001\f\u0001D\t\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002I\b\u0002\n\u0002\f\u0002"+
		"L\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003Q\b\u0003\n\u0003"+
		"\f\u0003T\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003X\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005_\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"f\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007u\b\u0007\n\u0007\f\u0007x\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007|\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0085\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u008e\b\b\u0003\b\u0090"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0097\b\t\u0005\t"+
		"\u0099\b\t\n\t\f\t\u009c\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00a5\b\n\u0001\n\u0001\n\u0001\n\u0003\n\u00aa\b\n"+
		"\u0001\n\u0001\n\u0001\n\u0003\n\u00af\b\n\u0001\n\u0005\n\u00b2\b\n\n"+
		"\n\f\n\u00b5\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u00be\b\u000b\n\u000b\f\u000b\u00c1\t\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u00c8\b\f\n\f\f\f\u00cb"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00db\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00eb"+
		"\b\u0011\n\u0011\f\u0011\u00ee\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u00f8\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u0100\b\u0013\n\u0013\f\u0013\u0103\t\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u010c\b\u0013\n\u0013\f\u0013\u010f\t\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u0113\b\u0013\n\u0013\f\u0013\u0116\t\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u011b\b\u0013\n\u0013\f\u0013"+
		"\u011e\t\u0013\u0001\u0013\u0003\u0013\u0121\b\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u012c\b\u0014\n\u0014\f\u0014\u012f\t\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u0138\b\u0015\n\u0015\f\u0015\u013b\t\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u014e"+
		"\b\u0016\n\u0016\f\u0016\u0151\t\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0003\u0017\u0156\b\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u015a\b"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0160"+
		"\b\u0017\n\u0017\f\u0017\u0163\t\u0017\u0001\u0017\u0003\u0017\u0166\b"+
		"\u0017\u0003\u0017\u0168\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0184"+
		"\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u018b\b\u0018\u0005\u0018\u018d\b\u0018\n\u0018\f\u0018\u0190\t"+
		"\u0018\u0001\u0018\u0003\u0018\u0193\b\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u01a7\b\u0018\n"+
		"\u0018\f\u0018\u01aa\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0005\u0019\u01b1\b\u0019\n\u0019\f\u0019\u01b4\t\u0019"+
		"\u0003\u0019\u01b6\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0000\u0001"+
		"0\u001a\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02\u0000\b\u0002\u0000\u0001\u000566\u0001"+
		"\u0000-.\u0001\u0000\u0012\u0013\u0001\u0000\u001d\u001e\u0001\u0000!"+
		"\"\u0001\u0000\u001f \u0001\u0000%(\u0001\u0000#$\u01e5\u00005\u0001\u0000"+
		"\u0000\u0000\u0002=\u0001\u0000\u0000\u0000\u0004E\u0001\u0000\u0000\u0000"+
		"\u0006M\u0001\u0000\u0000\u0000\bY\u0001\u0000\u0000\u0000\n^\u0001\u0000"+
		"\u0000\u0000\f`\u0001\u0000\u0000\u0000\u000ei\u0001\u0000\u0000\u0000"+
		"\u0010\u008f\u0001\u0000\u0000\u0000\u0012\u0091\u0001\u0000\u0000\u0000"+
		"\u0014\u00a4\u0001\u0000\u0000\u0000\u0016\u00ba\u0001\u0000\u0000\u0000"+
		"\u0018\u00c4\u0001\u0000\u0000\u0000\u001a\u00cc\u0001\u0000\u0000\u0000"+
		"\u001c\u00da\u0001\u0000\u0000\u0000\u001e\u00dc\u0001\u0000\u0000\u0000"+
		" \u00df\u0001\u0000\u0000\u0000\"\u00e3\u0001\u0000\u0000\u0000$\u00f7"+
		"\u0001\u0000\u0000\u0000&\u00f9\u0001\u0000\u0000\u0000(\u0125\u0001\u0000"+
		"\u0000\u0000*\u0134\u0001\u0000\u0000\u0000,\u0143\u0001\u0000\u0000\u0000"+
		".\u0167\u0001\u0000\u0000\u00000\u0192\u0001\u0000\u0000\u00002\u01ab"+
		"\u0001\u0000\u0000\u000046\u0003\u0002\u0001\u000054\u0001\u0000\u0000"+
		"\u000056\u0001\u0000\u0000\u000068\u0001\u0000\u0000\u000079\u0003\u0004"+
		"\u0002\u000087\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:;\u0003\u0006\u0003\u0000;<\u0005\u0000\u0000\u0001"+
		"<\u0001\u0001\u0000\u0000\u0000=>\u0005\u0017\u0000\u0000>B\u0005\'\u0000"+
		"\u0000?A\u0003\n\u0005\u0000@?\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000"+
		"\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000C\u0003\u0001"+
		"\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000EF\u0005\u0018\u0000\u0000"+
		"FJ\u0005\'\u0000\u0000GI\u0003\u0014\n\u0000HG\u0001\u0000\u0000\u0000"+
		"IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000"+
		"\u0000K\u0005\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000MN\u0005"+
		"\u0019\u0000\u0000NR\u0005\'\u0000\u0000OQ\u0003\u001c\u000e\u0000PO\u0001"+
		"\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000UW\u0005\f\u0000\u0000VX\u0005-\u0000\u0000WV\u0001\u0000\u0000"+
		"\u0000WX\u0001\u0000\u0000\u0000X\u0007\u0001\u0000\u0000\u0000YZ\u0007"+
		"\u0000\u0000\u0000Z\t\u0001\u0000\u0000\u0000[_\u0003\f\u0006\u0000\\"+
		"_\u0003\u000e\u0007\u0000]_\u0003\u0012\t\u0000^[\u0001\u0000\u0000\u0000"+
		"^\\\u0001\u0000\u0000\u0000^]\u0001\u0000\u0000\u0000_\u000b\u0001\u0000"+
		"\u0000\u0000`a\u0005\b\u0000\u0000ab\u00056\u0000\u0000bc\u0005,\u0000"+
		"\u0000ce\u0003\b\u0004\u0000df\u00030\u0018\u0000ed\u0001\u0000\u0000"+
		"\u0000ef\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0005-\u0000"+
		"\u0000h\r\u0001\u0000\u0000\u0000ij\u0005\t\u0000\u0000jk\u00056\u0000"+
		"\u0000kl\u00054\u0000\u0000lm\u00057\u0000\u0000mn\u00055\u0000\u0000"+
		"no\u0005,\u0000\u0000o{\u0003\b\u0004\u0000pq\u00052\u0000\u0000qv\u0003"+
		"0\u0018\u0000rs\u0005.\u0000\u0000su\u00030\u0018\u0000tr\u0001\u0000"+
		"\u0000\u0000ux\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001"+
		"\u0000\u0000\u0000wy\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000"+
		"yz\u00053\u0000\u0000z|\u0001\u0000\u0000\u0000{p\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0005-\u0000\u0000"+
		"~\u000f\u0001\u0000\u0000\u0000\u007f\u0080\u0005\b\u0000\u0000\u0080"+
		"\u0081\u00056\u0000\u0000\u0081\u0082\u0005,\u0000\u0000\u0082\u0084\u0003"+
		"\b\u0004\u0000\u0083\u0085\u00030\u0018\u0000\u0084\u0083\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0090\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0005\t\u0000\u0000\u0087\u0088\u00056\u0000"+
		"\u0000\u0088\u0089\u0005,\u0000\u0000\u0089\u008d\u0003\b\u0004\u0000"+
		"\u008a\u008b\u00054\u0000\u0000\u008b\u008c\u00057\u0000\u0000\u008c\u008e"+
		"\u00055\u0000\u0000\u008d\u008a\u0001\u0000\u0000\u0000\u008d\u008e\u0001"+
		"\u0000\u0000\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u007f\u0001"+
		"\u0000\u0000\u0000\u008f\u0086\u0001\u0000\u0000\u0000\u0090\u0011\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0005\n\u0000\u0000\u0092\u0093\u00056"+
		"\u0000\u0000\u0093\u009a\u00052\u0000\u0000\u0094\u0096\u0003\u0010\b"+
		"\u0000\u0095\u0097\u0007\u0001\u0000\u0000\u0096\u0095\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0099\u0001\u0000\u0000"+
		"\u0000\u0098\u0094\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000\u0000"+
		"\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000"+
		"\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u00053\u0000\u0000\u009e\u009f\u0005\u000b\u0000\u0000"+
		"\u009f\u00a0\u0005-\u0000\u0000\u00a0\u0013\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a5\u0005\u0014\u0000\u0000\u00a2\u00a3\u0005\u0015\u0000\u0000\u00a3"+
		"\u00a5\u0003\b\u0004\u0000\u00a4\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u00056\u0000\u0000\u00a7\u00a9\u00050\u0000\u0000\u00a8\u00aa\u0003\u0018"+
		"\f\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u00051\u0000\u0000"+
		"\u00ac\u00ae\u00052\u0000\u0000\u00ad\u00af\u0003\u0016\u000b\u0000\u00ae"+
		"\u00ad\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b0\u00b2\u0003\u001c\u000e\u0000\u00b1"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u00053\u0000\u0000\u00b7\u00b8\u0005\u000b\u0000\u0000\u00b8\u00b9"+
		"\u0005-\u0000\u0000\u00b9\u0015\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005"+
		"\u0017\u0000\u0000\u00bb\u00bf\u00054\u0000\u0000\u00bc\u00be\u0003\f"+
		"\u0006\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u00055\u0000\u0000\u00c3\u0017\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c9\u0003\u001a\r\u0000\u00c5\u00c6\u0005.\u0000\u0000"+
		"\u00c6\u00c8\u0003\u001a\r\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8"+
		"\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0001\u0000\u0000\u0000\u00ca\u0019\u0001\u0000\u0000\u0000\u00cb"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\b\u0000\u0000\u00cd\u00ce"+
		"\u00056\u0000\u0000\u00ce\u00cf\u0005,\u0000\u0000\u00cf\u00d0\u0003\b"+
		"\u0004\u0000\u00d0\u001b\u0001\u0000\u0000\u0000\u00d1\u00db\u0003\f\u0006"+
		"\u0000\u00d2\u00db\u0003\"\u0011\u0000\u00d3\u00db\u0003$\u0012\u0000"+
		"\u00d4\u00db\u0003.\u0017\u0000\u00d5\u00d6\u00032\u0019\u0000\u00d6\u00d7"+
		"\u0005-\u0000\u0000\u00d7\u00db\u0001\u0000\u0000\u0000\u00d8\u00db\u0003"+
		"\u001e\u000f\u0000\u00d9\u00db\u0003 \u0010\u0000\u00da\u00d1\u0001\u0000"+
		"\u0000\u0000\u00da\u00d2\u0001\u0000\u0000\u0000\u00da\u00d3\u0001\u0000"+
		"\u0000\u0000\u00da\u00d4\u0001\u0000\u0000\u0000\u00da\u00d5\u0001\u0000"+
		"\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00d9\u0001\u0000"+
		"\u0000\u0000\u00db\u001d\u0001\u0000\u0000\u0000\u00dc\u00dd\u0007\u0002"+
		"\u0000\u0000\u00dd\u00de\u0005-\u0000\u0000\u00de\u001f\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005\u0016\u0000\u0000\u00e0\u00e1\u00030\u0018\u0000"+
		"\u00e1\u00e2\u0005-\u0000\u0000\u00e2!\u0001\u0000\u0000\u0000\u00e3\u00ec"+
		"\u00056\u0000\u0000\u00e4\u00e5\u0005/\u0000\u0000\u00e5\u00eb\u00056"+
		"\u0000\u0000\u00e6\u00e7\u00054\u0000\u0000\u00e7\u00e8\u00030\u0018\u0000"+
		"\u00e8\u00e9\u00055\u0000\u0000\u00e9\u00eb\u0001\u0000\u0000\u0000\u00ea"+
		"\u00e4\u0001\u0000\u0000\u0000\u00ea\u00e6\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ef\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005+\u0000\u0000\u00f0\u00f1"+
		"\u00030\u0018\u0000\u00f1\u00f2\u0005-\u0000\u0000\u00f2#\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f8\u0003&\u0013\u0000\u00f4\u00f8\u0003(\u0014\u0000"+
		"\u00f5\u00f8\u0003*\u0015\u0000\u00f6\u00f8\u0003,\u0016\u0000\u00f7\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f4\u0001\u0000\u0000\u0000\u00f7\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f6\u0001\u0000\u0000\u0000\u00f8%\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0005\r\u0000\u0000\u00fa\u00fb\u00050"+
		"\u0000\u0000\u00fb\u00fc\u00030\u0018\u0000\u00fc\u00fd\u00051\u0000\u0000"+
		"\u00fd\u0101\u00052\u0000\u0000\u00fe\u0100\u0003\u001c\u000e\u0000\u00ff"+
		"\u00fe\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000\u0000\u0101"+
		"\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102"+
		"\u0104\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0104"+
		"\u0114\u00053\u0000\u0000\u0105\u0106\u0005\u000e\u0000\u0000\u0106\u0107"+
		"\u00050\u0000\u0000\u0107\u0108\u00030\u0018\u0000\u0108\u0109\u00051"+
		"\u0000\u0000\u0109\u010d\u00052\u0000\u0000\u010a\u010c\u0003\u001c\u000e"+
		"\u0000\u010b\u010a\u0001\u0000\u0000\u0000\u010c\u010f\u0001\u0000\u0000"+
		"\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000"+
		"\u0000\u010e\u0110\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000"+
		"\u0000\u0110\u0111\u00053\u0000\u0000\u0111\u0113\u0001\u0000\u0000\u0000"+
		"\u0112\u0105\u0001\u0000\u0000\u0000\u0113\u0116\u0001\u0000\u0000\u0000"+
		"\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000"+
		"\u0115\u0120\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000"+
		"\u0117\u0118\u0005\u000e\u0000\u0000\u0118\u011c\u00052\u0000\u0000\u0119"+
		"\u011b\u0003\u001c\u000e\u0000\u011a\u0119\u0001\u0000\u0000\u0000\u011b"+
		"\u011e\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c"+
		"\u011d\u0001\u0000\u0000\u0000\u011d\u011f\u0001\u0000\u0000\u0000\u011e"+
		"\u011c\u0001\u0000\u0000\u0000\u011f\u0121\u00053\u0000\u0000\u0120\u0117"+
		"\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0005\u000b\u0000\u0000\u0123\u0124"+
		"\u0005-\u0000\u0000\u0124\'\u0001\u0000\u0000\u0000\u0125\u0126\u0005"+
		"\u000f\u0000\u0000\u0126\u0127\u00050\u0000\u0000\u0127\u0128\u00030\u0018"+
		"\u0000\u0128\u0129\u00051\u0000\u0000\u0129\u012d\u00052\u0000\u0000\u012a"+
		"\u012c\u0003\u001c\u000e\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c"+
		"\u012f\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d"+
		"\u012e\u0001\u0000\u0000\u0000\u012e\u0130\u0001\u0000\u0000\u0000\u012f"+
		"\u012d\u0001\u0000\u0000\u0000\u0130\u0131\u00053\u0000\u0000\u0131\u0132"+
		"\u0005\u000b\u0000\u0000\u0132\u0133\u0005-\u0000\u0000\u0133)\u0001\u0000"+
		"\u0000\u0000\u0134\u0135\u0005\u0010\u0000\u0000\u0135\u0139\u00052\u0000"+
		"\u0000\u0136\u0138\u0003\u001c\u000e\u0000\u0137\u0136\u0001\u0000\u0000"+
		"\u0000\u0138\u013b\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000"+
		"\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013c\u0001\u0000\u0000"+
		"\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u013d\u00053\u0000\u0000"+
		"\u013d\u013e\u0005\u000f\u0000\u0000\u013e\u013f\u00050\u0000\u0000\u013f"+
		"\u0140\u00030\u0018\u0000\u0140\u0141\u00051\u0000\u0000\u0141\u0142\u0005"+
		"-\u0000\u0000\u0142+\u0001\u0000\u0000\u0000\u0143\u0144\u0005\u0011\u0000"+
		"\u0000\u0144\u0145\u00050\u0000\u0000\u0145\u0146\u0003\f\u0006\u0000"+
		"\u0146\u0147\u00030\u0018\u0000\u0147\u0148\u0005-\u0000\u0000\u0148\u0149"+
		"\u00056\u0000\u0000\u0149\u014a\u0007\u0003\u0000\u0000\u014a\u014b\u0005"+
		"1\u0000\u0000\u014b\u014f\u00052\u0000\u0000\u014c\u014e\u0003\u001c\u000e"+
		"\u0000\u014d\u014c\u0001\u0000\u0000\u0000\u014e\u0151\u0001\u0000\u0000"+
		"\u0000\u014f\u014d\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000"+
		"\u0000\u0150\u0152\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000"+
		"\u0000\u0152\u0153\u00053\u0000\u0000\u0153-\u0001\u0000\u0000\u0000\u0154"+
		"\u0156\u00056\u0000\u0000\u0155\u0154\u0001\u0000\u0000\u0000\u0155\u0156"+
		"\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000\u0000\u0157\u0159"+
		"\u0005\u001b\u0000\u0000\u0158\u015a\u0005-\u0000\u0000\u0159\u0158\u0001"+
		"\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u0168\u0001"+
		"\u0000\u0000\u0000\u015b\u015c\u0005\u001c\u0000\u0000\u015c\u0161\u0003"+
		"0\u0018\u0000\u015d\u015e\u0005\u001c\u0000\u0000\u015e\u0160\u00030\u0018"+
		"\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u0160\u0163\u0001\u0000\u0000"+
		"\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000"+
		"\u0000\u0162\u0165\u0001\u0000\u0000\u0000\u0163\u0161\u0001\u0000\u0000"+
		"\u0000\u0164\u0166\u0005-\u0000\u0000\u0165\u0164\u0001\u0000\u0000\u0000"+
		"\u0165\u0166\u0001\u0000\u0000\u0000\u0166\u0168\u0001\u0000\u0000\u0000"+
		"\u0167\u0155\u0001\u0000\u0000\u0000\u0167\u015b\u0001\u0000\u0000\u0000"+
		"\u0168/\u0001\u0000\u0000\u0000\u0169\u016a\u0006\u0018\uffff\uffff\u0000"+
		"\u016a\u016b\u0005 \u0000\u0000\u016b\u0193\u00030\u0018\u0014\u016c\u016d"+
		"\u0005\u001a\u0000\u0000\u016d\u0193\u00030\u0018\u0013\u016e\u016f\u0005"+
		"0\u0000\u0000\u016f\u0170\u00030\u0018\u0000\u0170\u0171\u00051\u0000"+
		"\u0000\u0171\u0193\u0001\u0000\u0000\u0000\u0172\u0193\u00057\u0000\u0000"+
		"\u0173\u0193\u00058\u0000\u0000\u0174\u0193\u00059\u0000\u0000\u0175\u0193"+
		"\u0005:\u0000\u0000\u0176\u0193\u0005\u0006\u0000\u0000\u0177\u0193\u0005"+
		"\u0007\u0000\u0000\u0178\u0179\u00056\u0000\u0000\u0179\u017a\u00054\u0000"+
		"\u0000\u017a\u017b\u00030\u0018\u0000\u017b\u017c\u00055\u0000\u0000\u017c"+
		"\u0193\u0001\u0000\u0000\u0000\u017d\u017e\u00056\u0000\u0000\u017e\u017f"+
		"\u0005/\u0000\u0000\u017f\u0193\u00056\u0000\u0000\u0180\u0193\u00032"+
		"\u0019\u0000\u0181\u0193\u00056\u0000\u0000\u0182\u0184\u00056\u0000\u0000"+
		"\u0183\u0182\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000"+
		"\u0184\u0185\u0001\u0000\u0000\u0000\u0185\u018e\u00052\u0000\u0000\u0186"+
		"\u0187\u00056\u0000\u0000\u0187\u0188\u0005,\u0000\u0000\u0188\u018a\u0003"+
		"0\u0018\u0000\u0189\u018b\u0005.\u0000\u0000\u018a\u0189\u0001\u0000\u0000"+
		"\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u018d\u0001\u0000\u0000"+
		"\u0000\u018c\u0186\u0001\u0000\u0000\u0000\u018d\u0190\u0001\u0000\u0000"+
		"\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000"+
		"\u0000\u018f\u0191\u0001\u0000\u0000\u0000\u0190\u018e\u0001\u0000\u0000"+
		"\u0000\u0191\u0193\u00053\u0000\u0000\u0192\u0169\u0001\u0000\u0000\u0000"+
		"\u0192\u016c\u0001\u0000\u0000\u0000\u0192\u016e\u0001\u0000\u0000\u0000"+
		"\u0192\u0172\u0001\u0000\u0000\u0000\u0192\u0173\u0001\u0000\u0000\u0000"+
		"\u0192\u0174\u0001\u0000\u0000\u0000\u0192\u0175\u0001\u0000\u0000\u0000"+
		"\u0192\u0176\u0001\u0000\u0000\u0000\u0192\u0177\u0001\u0000\u0000\u0000"+
		"\u0192\u0178\u0001\u0000\u0000\u0000\u0192\u017d\u0001\u0000\u0000\u0000"+
		"\u0192\u0180\u0001\u0000\u0000\u0000\u0192\u0181\u0001\u0000\u0000\u0000"+
		"\u0192\u0183\u0001\u0000\u0000\u0000\u0193\u01a8\u0001\u0000\u0000\u0000"+
		"\u0194\u0195\n\u0012\u0000\u0000\u0195\u0196\u0007\u0004\u0000\u0000\u0196"+
		"\u01a7\u00030\u0018\u0013\u0197\u0198\n\u0011\u0000\u0000\u0198\u0199"+
		"\u0007\u0005\u0000\u0000\u0199\u01a7\u00030\u0018\u0012\u019a\u019b\n"+
		"\u0010\u0000\u0000\u019b\u019c\u0007\u0006\u0000\u0000\u019c\u01a7\u0003"+
		"0\u0018\u0011\u019d\u019e\n\u000f\u0000\u0000\u019e\u019f\u0007\u0007"+
		"\u0000\u0000\u019f\u01a7\u00030\u0018\u0010\u01a0\u01a1\n\u000e\u0000"+
		"\u0000\u01a1\u01a2\u0005)\u0000\u0000\u01a2\u01a7\u00030\u0018\u000f\u01a3"+
		"\u01a4\n\r\u0000\u0000\u01a4\u01a5\u0005*\u0000\u0000\u01a5\u01a7\u0003"+
		"0\u0018\u000e\u01a6\u0194\u0001\u0000\u0000\u0000\u01a6\u0197\u0001\u0000"+
		"\u0000\u0000\u01a6\u019a\u0001\u0000\u0000\u0000\u01a6\u019d\u0001\u0000"+
		"\u0000\u0000\u01a6\u01a0\u0001\u0000\u0000\u0000\u01a6\u01a3\u0001\u0000"+
		"\u0000\u0000\u01a7\u01aa\u0001\u0000\u0000\u0000\u01a8\u01a6\u0001\u0000"+
		"\u0000\u0000\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a91\u0001\u0000\u0000"+
		"\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000\u01ab\u01ac\u00056\u0000\u0000"+
		"\u01ac\u01b5\u00050\u0000\u0000\u01ad\u01b2\u00030\u0018\u0000\u01ae\u01af"+
		"\u0005.\u0000\u0000\u01af\u01b1\u00030\u0018\u0000\u01b0\u01ae\u0001\u0000"+
		"\u0000\u0000\u01b1\u01b4\u0001\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000"+
		"\u0000\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3\u01b6\u0001\u0000"+
		"\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b5\u01ad\u0001\u0000"+
		"\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000"+
		"\u0000\u0000\u01b7\u01b8\u00051\u0000\u0000\u01b83\u0001\u0000\u0000\u0000"+
		".58BJRW^ev{\u0084\u008d\u008f\u0096\u009a\u00a4\u00a9\u00ae\u00b3\u00bf"+
		"\u00c9\u00da\u00ea\u00ec\u00f7\u0101\u010d\u0114\u011c\u0120\u012d\u0139"+
		"\u014f\u0155\u0159\u0161\u0165\u0167\u0183\u018a\u018e\u0192\u01a6\u01a8"+
		"\u01b2\u01b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}