// Generated from C:/Users/Hp/IntelliJProjects/CodexLatinus/src/main/java/Codex.g4 by ANTLR 4.13.2
package analyzer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CodexParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CodexVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CodexParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CodexParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#seccionVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionVariables(CodexParser.SeccionVariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#seccionFunciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionFunciones(CodexParser.SeccionFuncionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#seccionPrincipal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionPrincipal(CodexParser.SeccionPrincipalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#tipoDato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDato(CodexParser.TipoDatoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(CodexParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#declaracionVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionVar(CodexParser.DeclaracionVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#declaracionArreglo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionArreglo(CodexParser.DeclaracionArregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#atributoStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtributoStruct(CodexParser.AtributoStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#definicionStruct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicionStruct(CodexParser.DefinicionStructContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(CodexParser.FuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#seccionVariablesLocal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionVariablesLocal(CodexParser.SeccionVariablesLocalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(CodexParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(CodexParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(CodexParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#interrupcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterrupcion(CodexParser.InterrupcionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(CodexParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#estructuraControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructuraControl(CodexParser.EstructuraControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#condicionalSi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicionalSi(CodexParser.CondicionalSiContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#cicloDum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicloDum(CodexParser.CicloDumContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#cicloFacere}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicloFacere(CodexParser.CicloFacereContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#cicloPer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicloPer(CodexParser.CicloPerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#funcionEspecial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncionEspecial(CodexParser.FuncionEspecialContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprArreglo}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprArreglo(CodexParser.ExprArregloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSuma}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSuma(CodexParser.ExprSumaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAtributoStruct}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAtributoStruct(CodexParser.ExprAtributoStructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprRelacional}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelacional(CodexParser.ExprRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprUnaria}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnaria(CodexParser.ExprUnariaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFalso}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFalso(CodexParser.ExprFalsoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprInstanciaStruct}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInstanciaStruct(CodexParser.ExprInstanciaStructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLlamada}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLlamada(CodexParser.ExprLlamadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(CodexParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNegacion}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNegacion(CodexParser.ExprNegacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprCadena}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCadena(CodexParser.ExprCadenaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprVariable}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVariable(CodexParser.ExprVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprEntero}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEntero(CodexParser.ExprEnteroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprVerdadero}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVerdadero(CodexParser.ExprVerdaderoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprIgualdad}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgualdad(CodexParser.ExprIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(CodexParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAgrupacion}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAgrupacion(CodexParser.ExprAgrupacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMultiplicacion}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultiplicacion(CodexParser.ExprMultiplicacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprCaracter}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCaracter(CodexParser.ExprCaracterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprDecimal}
	 * labeled alternative in {@link CodexParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDecimal(CodexParser.ExprDecimalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodexParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamadaFuncion(CodexParser.LlamadaFuncionContext ctx);
}