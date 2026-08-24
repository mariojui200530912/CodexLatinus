// Generated from C:/Users/Hp/IntelliJProjects/CodexLatinus/src/main/java/Codex.g4 by ANTLR 4.13.2
package analyzer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CodexParser}.
 */
public interface CodexListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CodexParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CodexParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CodexParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#seccionVariables}.
	 * @param ctx the parse tree
	 */
	void enterSeccionVariables(CodexParser.SeccionVariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#seccionVariables}.
	 * @param ctx the parse tree
	 */
	void exitSeccionVariables(CodexParser.SeccionVariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#seccionFunciones}.
	 * @param ctx the parse tree
	 */
	void enterSeccionFunciones(CodexParser.SeccionFuncionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#seccionFunciones}.
	 * @param ctx the parse tree
	 */
	void exitSeccionFunciones(CodexParser.SeccionFuncionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#seccionPrincipal}.
	 * @param ctx the parse tree
	 */
	void enterSeccionPrincipal(CodexParser.SeccionPrincipalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#seccionPrincipal}.
	 * @param ctx the parse tree
	 */
	void exitSeccionPrincipal(CodexParser.SeccionPrincipalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void enterTipoDato(CodexParser.TipoDatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void exitTipoDato(CodexParser.TipoDatoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(CodexParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(CodexParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#declaracionVar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionVar(CodexParser.DeclaracionVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#declaracionVar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionVar(CodexParser.DeclaracionVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#declaracionArreglo}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionArreglo(CodexParser.DeclaracionArregloContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#declaracionArreglo}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionArreglo(CodexParser.DeclaracionArregloContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#atributoStruct}.
	 * @param ctx the parse tree
	 */
	void enterAtributoStruct(CodexParser.AtributoStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#atributoStruct}.
	 * @param ctx the parse tree
	 */
	void exitAtributoStruct(CodexParser.AtributoStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#definicionStruct}.
	 * @param ctx the parse tree
	 */
	void enterDefinicionStruct(CodexParser.DefinicionStructContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#definicionStruct}.
	 * @param ctx the parse tree
	 */
	void exitDefinicionStruct(CodexParser.DefinicionStructContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(CodexParser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(CodexParser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#seccionVariablesLocal}.
	 * @param ctx the parse tree
	 */
	void enterSeccionVariablesLocal(CodexParser.SeccionVariablesLocalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#seccionVariablesLocal}.
	 * @param ctx the parse tree
	 */
	void exitSeccionVariablesLocal(CodexParser.SeccionVariablesLocalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(CodexParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(CodexParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(CodexParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(CodexParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(CodexParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(CodexParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#interrupcion}.
	 * @param ctx the parse tree
	 */
	void enterInterrupcion(CodexParser.InterrupcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#interrupcion}.
	 * @param ctx the parse tree
	 */
	void exitInterrupcion(CodexParser.InterrupcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(CodexParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(CodexParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#estructuraControl}.
	 * @param ctx the parse tree
	 */
	void enterEstructuraControl(CodexParser.EstructuraControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#estructuraControl}.
	 * @param ctx the parse tree
	 */
	void exitEstructuraControl(CodexParser.EstructuraControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#condicionalSi}.
	 * @param ctx the parse tree
	 */
	void enterCondicionalSi(CodexParser.CondicionalSiContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#condicionalSi}.
	 * @param ctx the parse tree
	 */
	void exitCondicionalSi(CodexParser.CondicionalSiContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#cicloDum}.
	 * @param ctx the parse tree
	 */
	void enterCicloDum(CodexParser.CicloDumContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#cicloDum}.
	 * @param ctx the parse tree
	 */
	void exitCicloDum(CodexParser.CicloDumContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#cicloFacere}.
	 * @param ctx the parse tree
	 */
	void enterCicloFacere(CodexParser.CicloFacereContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#cicloFacere}.
	 * @param ctx the parse tree
	 */
	void exitCicloFacere(CodexParser.CicloFacereContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#cicloPer}.
	 * @param ctx the parse tree
	 */
	void enterCicloPer(CodexParser.CicloPerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#cicloPer}.
	 * @param ctx the parse tree
	 */
	void exitCicloPer(CodexParser.CicloPerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#funcionEspecial}.
	 * @param ctx the parse tree
	 */
	void enterFuncionEspecial(CodexParser.FuncionEspecialContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#funcionEspecial}.
	 * @param ctx the parse tree
	 */
	void exitFuncionEspecial(CodexParser.FuncionEspecialContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprArreglo}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprArreglo(CodexParser.ExprArregloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprArreglo}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprArreglo(CodexParser.ExprArregloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSuma}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprSuma(CodexParser.ExprSumaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSuma}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprSuma(CodexParser.ExprSumaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAtributoStruct}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprAtributoStruct(CodexParser.ExprAtributoStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAtributoStruct}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprAtributoStruct(CodexParser.ExprAtributoStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprRelacional(CodexParser.ExprRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprRelacional(CodexParser.ExprRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprUnaria}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprUnaria(CodexParser.ExprUnariaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprUnaria}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprUnaria(CodexParser.ExprUnariaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFalso}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprFalso(CodexParser.ExprFalsoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFalso}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprFalso(CodexParser.ExprFalsoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInstanciaStruct}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprInstanciaStruct(CodexParser.ExprInstanciaStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInstanciaStruct}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprInstanciaStruct(CodexParser.ExprInstanciaStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLlamada}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprLlamada(CodexParser.ExprLlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLlamada}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprLlamada(CodexParser.ExprLlamadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(CodexParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(CodexParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNegacion}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprNegacion(CodexParser.ExprNegacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNegacion}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprNegacion(CodexParser.ExprNegacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprCadena}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprCadena(CodexParser.ExprCadenaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprCadena}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprCadena(CodexParser.ExprCadenaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprVariable}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprVariable(CodexParser.ExprVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprVariable}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprVariable(CodexParser.ExprVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprEntero}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprEntero(CodexParser.ExprEnteroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprEntero}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprEntero(CodexParser.ExprEnteroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprVerdadero}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprVerdadero(CodexParser.ExprVerdaderoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprVerdadero}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprVerdadero(CodexParser.ExprVerdaderoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprIgualdad(CodexParser.ExprIgualdadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprIgualdad(CodexParser.ExprIgualdadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(CodexParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(CodexParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAgrupacion}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprAgrupacion(CodexParser.ExprAgrupacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAgrupacion}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprAgrupacion(CodexParser.ExprAgrupacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMultiplicacion}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiplicacion(CodexParser.ExprMultiplicacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMultiplicacion}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiplicacion(CodexParser.ExprMultiplicacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprCaracter}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprCaracter(CodexParser.ExprCaracterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprCaracter}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprCaracter(CodexParser.ExprCaracterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprDecimal}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprDecimal(CodexParser.ExprDecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprDecimal}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprDecimal(CodexParser.ExprDecimalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodexParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void enterLlamadaFuncion(CodexParser.LlamadaFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodexParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void exitLlamadaFuncion(CodexParser.LlamadaFuncionContext ctx);
}