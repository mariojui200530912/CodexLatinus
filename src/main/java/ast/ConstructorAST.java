package ast;

import analyzer.CodexBaseVisitor;
import analyzer.CodexParser;

public class ConstructorAST extends CodexBaseVisitor<NodoAST> {

    // ==========================================
    // 1. ESTRUCTURA PRINCIPAL DEL PROGRAMA
    // ==========================================
    @Override
    public NodoAST visitProgram(CodexParser.ProgramContext ctx) {
        // Contamos cuántas declaraciones hay en cada sección usando el ctx
        int capGlobales = ctx.seccionVariables() != null ? ctx.seccionVariables().declaracion().size() : 0;
        int capFunciones = ctx.seccionFunciones() != null ? ctx.seccionFunciones().funcion().size() : 0;
        int capPrincipal = ctx.seccionPrincipal().instruccion().size();

        NodoPrograma programa = new NodoPrograma(capGlobales, capFunciones, capPrincipal);

        // Visitar variables globales
        if (ctx.seccionVariables() != null) {
            for (CodexParser.DeclaracionContext decCtx : ctx.seccionVariables().declaracion()) {
                programa.agregarGlobal(visit(decCtx));
            }
        }

        // Visitar funciones
        if (ctx.seccionFunciones() != null) {
            for (CodexParser.FuncionContext funCtx : ctx.seccionFunciones().funcion()) {
                programa.agregarFuncion(visit(funCtx));
            }
        }

        // Visitar sección principal (obligatoria)[cite: 1]
        for (CodexParser.InstruccionContext instCtx : ctx.seccionPrincipal().instruccion()) {
            programa.agregarInstruccion(visit(instCtx));
        }

        return programa;
    }

    // ==========================================
    // 2. DECLARACIONES Y ASIGNACIONES
    // ==========================================
    @Override
    public NodoAST visitDeclaracionVar(CodexParser.DeclaracionVarContext ctx) {
        String id = ctx.ID().getText();
        String tipo = ctx.tipoDato().getText();
        NodoAST valor = null;

        if (ctx.expresion() != null) {
            valor = visit(ctx.expresion()); // Visitamos la expresión para obtener su sub-árbol
        }

        NodoDeclaracionVar nodo = new NodoDeclaracionVar(id, tipo, valor);
        nodo.linea = ctx.getStart().getLine();
        nodo.columna = ctx.getStart().getCharPositionInLine();
        return nodo;
    }

    @Override
    public NodoAST visitAsignacion(CodexParser.AsignacionContext ctx) {
        String id = ctx.ID().getText();
        NodoAST indice = null;

        // Si tiene más de una expresión, la primera es el índice del arreglo
        if (ctx.expresion().size() > 1) {
            indice = visit(ctx.expresion(0));
            NodoAST valor = visit(ctx.expresion(1));
            return new NodoAsignacion(id, indice, valor);
        } else {
            NodoAST valor = visit(ctx.expresion(0));
            return new NodoAsignacion(id, null, valor);
        }
    }

    // ==========================================
    // 3. EXPRESIONES (Las etiquetas # del .g4)
    // ==========================================

    // Operaciones matemáticas y lógicas
    @Override
    public NodoAST visitExprSuma(CodexParser.ExprSumaContext ctx) {
        NodoAST izq = visit(ctx.expresion(0));
        NodoAST der = visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText(); // Extrae '+' o '-'

        return new NodoOperacionBinaria(izq, operador, der);
    }

    @Override
    public NodoAST visitExprMultiplicacion(CodexParser.ExprMultiplicacionContext ctx) {
        NodoAST izq = visit(ctx.expresion(0));
        NodoAST der = visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText(); // Extrae '*' o '/'

        return new NodoOperacionBinaria(izq, operador, der);
    }

    // Literales y variables
    @Override
    public NodoAST visitExprEntero(CodexParser.ExprEnteroContext ctx) {
        // En Java, guardamos el literal directamente con su tipo implícito
        return new NodoLiteral(Integer.parseInt(ctx.getText()), "numerus");
    }

    @Override
    public NodoAST visitExprCadena(CodexParser.ExprCadenaContext ctx) {
        // Quitamos las comillas iniciales y finales para guardar el valor limpio
        String texto = ctx.getText();
        texto = texto.substring(1, texto.length() - 1);
        return new NodoLiteral(texto, "textum");
    }

    @Override
    public NodoAST visitExprVariable(CodexParser.ExprVariableContext ctx) {
        return new NodoIdentificador(ctx.getText());
    }

    // ==========================================
    // 4. ESTRUCTURAS DE CONTROL DE FLUJO
    // ==========================================
    @Override
    public NodoAST visitCicloDum(CodexParser.CicloDumContext ctx) {
        NodoAST condicion = visit(ctx.expresion());
        int capInstrucciones = ctx.instruccion().size();

        NodoDum nodoDum = new NodoDum(condicion, capInstrucciones);

        for (CodexParser.InstruccionContext instCtx : ctx.instruccion()) {
            nodoDum.agregarInstruccion(visit(instCtx));
        }

        return nodoDum;
    }
}
