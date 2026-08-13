package ast;

import analyzer.CodexBaseVisitor;
import analyzer.CodexParser;
import ast.stm.*;
import ast.exp.*;

public class ConstructorAST extends CodexBaseVisitor<NodoAST> {

    // ESTRUCTURA PRINCIPAL DEL PROGRAMA
    @Override
    public NodoAST visitProgram(CodexParser.ProgramContext ctx) {
        int capGlobales = ctx.seccionVariables() != null ? ctx.seccionVariables().declaracion().size() : 0;
        int capFunciones = ctx.seccionFunciones() != null ? ctx.seccionFunciones().funcion().size() : 0;
        int capPrincipal = ctx.seccionPrincipal().instruccion().size();

        NodoPrograma programa = new NodoPrograma(capGlobales, capFunciones, capPrincipal);

        // Visitar variables globales
        if (ctx.seccionVariables() != null) {
            for (CodexParser.DeclaracionContext decCtx : ctx.seccionVariables().declaracion()) {
                programa.agregarGlobal((NodoInstruccion) visit(decCtx));
            }
        }

        // Visitar funciones
        if (ctx.seccionFunciones() != null) {
            for (CodexParser.FuncionContext funCtx : ctx.seccionFunciones().funcion()) {
                programa.agregarFuncion((NodoInstruccion) visit(funCtx));
            }
        }

        // Visitar seccion principal
        for (CodexParser.InstruccionContext instCtx : ctx.seccionPrincipal().instruccion()) {
            programa.agregarInstruccion((NodoInstruccion) visit(instCtx));
        }

        return programa;
    }

    // DECLARACIONES Y ASIGNACIONES
    @Override
    public NodoAST visitDeclaracionVar(CodexParser.DeclaracionVarContext ctx) {
        String id = ctx.ID().getText();
        String tipo = ctx.tipoDato().getText();
        NodoAST valor = null;

        if (ctx.expresion() != null) {
            valor = visit(ctx.expresion()); // Visitamos la expresión para obtener su sub-árbol
        }

        NodoDeclaracionVar nodo = new NodoDeclaracionVar(id, tipo, (NodoExpresion) valor);
        nodo.linea = ctx.getStart().getLine();
        nodo.columna = ctx.getStart().getCharPositionInLine();
        return nodo;
    }

    @Override
    public NodoAST visitAsignacion(CodexParser.AsignacionContext ctx) {
        String id = ctx.ID().getText();
        NodoAST indice = null;

        if (ctx.expresion().size() > 1) {
            indice = visit(ctx.expresion(0));
            NodoAST valor = visit(ctx.expresion(1));
            return new NodoAsignacion(id, (NodoExpresion) indice, (NodoExpresion) valor);
        } else {
            NodoAST valor = visit(ctx.expresion(0));
            return new NodoAsignacion(id, (NodoExpresion) null, (NodoExpresion) valor);
        }
    }

    // ARREGLOS Y ASIGNACIONES
    @Override
    public NodoAST visitDeclaracionArreglo(CodexParser.DeclaracionArregloContext ctx) {
        String id = ctx.ID().getText();
        int tamano = Integer.parseInt(ctx.ENTERO().getText());
        String tipo = ctx.tipoDato().getText();

        int capValores = ctx.expresion().size();
        NodoDeclaracionArreglo nodoArreglo = new NodoDeclaracionArreglo(id, tamano, tipo, capValores);

        for (CodexParser.ExpresionContext exprCtx : ctx.expresion()) {
            nodoArreglo.agregarValorInicial((NodoExpresion) visit(exprCtx));
        }

        return nodoArreglo;
    }

    @Override
    public NodoAST visitDefinicionStruct(CodexParser.DefinicionStructContext ctx) {
        String id = ctx.ID(0).getText(); // El primer ID es el nombre de la estructura
        int capAtributos = ctx.tipoDato().size();

        NodoDefinicionStruct nodoStruct = new NodoDefinicionStruct(id, capAtributos);

        // Iteramos desde 1 porque el índice 0 es el nombre de la estructura en sí
        for (int i = 0; i < capAtributos; i++) {
            String nombreAtributo = ctx.ID(i + 1).getText();
            String tipoAtributo = ctx.tipoDato(i).getText();
            nodoStruct.agregarAtributo(nombreAtributo, tipoAtributo);
        }

        return nodoStruct;
    }

    @Override
    public NodoAST visitExprArreglo(CodexParser.ExprArregloContext ctx) {
        String idArreglo = ctx.ID().getText();
        NodoExpresion indice = (NodoExpresion) visit(ctx.expresion());
        return new NodoAccesoArreglo(idArreglo, indice);
    }

    @Override
    public NodoAST visitExprAtributoStruct(CodexParser.ExprAtributoStructContext ctx) {
        String idEstructura = ctx.ID(0).getText();
        String idAtributo = ctx.ID(1).getText();
        return new NodoAccesoEstructura(idEstructura, idAtributo);
    }

    // EXPRESIONES
    // Operaciones matematicas y logicas
    @Override
    public NodoAST visitExprSuma(CodexParser.ExprSumaContext ctx) {
        NodoExpresion izq = (NodoExpresion) visit(ctx.expresion(0));
        NodoExpresion der = (NodoExpresion) visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText();
        return new NodoOperacionBinaria(izq, operador, der);
    }

    @Override
    public NodoAST visitExprMultiplicacion(CodexParser.ExprMultiplicacionContext ctx) {
        NodoExpresion izq = (NodoExpresion) visit(ctx.expresion(0));
        NodoExpresion der = (NodoExpresion) visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText(); // Extrae '*' o '/'

        return new NodoOperacionBinaria(izq, operador, der);
    }

    @Override
    public NodoAST visitExprRelacional(CodexParser.ExprRelacionalContext ctx) {
        NodoExpresion izq = (NodoExpresion) visit(ctx.expresion(0));
        NodoExpresion der = (NodoExpresion) visit(ctx.expresion(1));
        return new NodoOperacionBinaria(izq, ctx.getChild(1).getText(), der);
    }

    @Override
    public NodoAST visitExprIgualdad(CodexParser.ExprIgualdadContext ctx) {
        NodoExpresion izq = (NodoExpresion) visit(ctx.expresion(0));
        NodoExpresion der = (NodoExpresion) visit(ctx.expresion(1));
        return new NodoOperacionBinaria(izq, ctx.getChild(1).getText(), der);
    }

    @Override
    public NodoAST visitExprAnd(CodexParser.ExprAndContext ctx) {
        return new NodoOperacionBinaria((NodoExpresion) visit(ctx.expresion(0)), "&&", (NodoExpresion) visit(ctx.expresion(1)));
    }

    @Override
    public NodoAST visitExprOr(CodexParser.ExprOrContext ctx) {
        return new NodoOperacionBinaria((NodoExpresion) visit(ctx.expresion(0)), "||", (NodoExpresion) visit(ctx.expresion(1)));
    }

    @Override
    public NodoAST visitExprInstanciaStruct(CodexParser.ExprInstanciaStructContext ctx) {
        String tipoEstructura = null;
        int startIndexID = 0;

        if (ctx.ID().size() > 0 && !ctx.getChild(0).getText().equals("{")) {
            tipoEstructura = ctx.ID(0).getText();
            startIndexID = 1; // Los siguientes IDs serán los atributos
        }

        int capAtributos = ctx.expresion().size();
        NodoInstanciaEstructura nodoInstancia = new NodoInstanciaEstructura(tipoEstructura, capAtributos);

        for (int i = 0; i < capAtributos; i++) {
            String nombreAtributo = ctx.ID(i + startIndexID).getText();
            NodoExpresion valorAtributo = (NodoExpresion) visit(ctx.expresion(i));

            nodoInstancia.agregarAtributo(nombreAtributo, valorAtributo);
        }

        nodoInstancia.linea = ctx.getStart().getLine();
        nodoInstancia.columna = ctx.getStart().getCharPositionInLine();

        return nodoInstancia;
    }

    // UNARIAS Y AGRUPACION
    @Override
    public NodoAST visitExprNegacion(CodexParser.ExprNegacionContext ctx) {
        return new NodoOperacionUnaria("non", (NodoExpresion) visit(ctx.expresion()));
    }

    @Override
    public NodoAST visitExprUnaria(CodexParser.ExprUnariaContext ctx) {
        return new NodoOperacionUnaria("-", (NodoExpresion) visit(ctx.expresion()));
    }

    @Override
    public NodoAST visitExprAgrupacion(CodexParser.ExprAgrupacionContext ctx) {
        return visit(ctx.expresion());
    }

    // Literales y variables
    @Override
    public NodoAST visitExprEntero(CodexParser.ExprEnteroContext ctx) {
        return new NodoLiteral(Integer.parseInt(ctx.getText()), "numerus");
    }

    @Override
    public NodoAST visitExprCadena(CodexParser.ExprCadenaContext ctx) {
        String texto = ctx.getText();
        texto = texto.substring(1, texto.length() - 1);
        return new NodoLiteral(texto, "textum");
    }

    @Override
    public NodoAST visitExprVariable(CodexParser.ExprVariableContext ctx) {
        return new NodoIdentificador(ctx.getText());
    }

    @Override
    public NodoAST visitExprDecimal(CodexParser.ExprDecimalContext ctx) {
        return new NodoLiteral(Double.parseDouble(ctx.getText()), "decimalis");
    }

    @Override
    public NodoAST visitExprCaracter(CodexParser.ExprCaracterContext ctx) {
        return new NodoLiteral(ctx.getText().charAt(1), "littera");
    }

    @Override
    public NodoAST visitExprVerdadero(CodexParser.ExprVerdaderoContext ctx) {
        return new NodoLiteral(true, "bool");
    }

    @Override
    public NodoAST visitExprFalso(CodexParser.ExprFalsoContext ctx) {
        return new NodoLiteral(false, "bool");
    }

    // ESTRUCTURAS DE CONTROL DE FLUJO
    @Override
    public NodoAST visitCicloDum(CodexParser.CicloDumContext ctx) {
        NodoAST condicion = visit(ctx.expresion());
        int capInstrucciones = ctx.instruccion().size();

        NodoDum nodoDum = new NodoDum((NodoExpresion) condicion, capInstrucciones);

        for (CodexParser.InstruccionContext instCtx : ctx.instruccion()) {
            nodoDum.agregarInstruccion((NodoInstruccion) visit(instCtx));
        }

        return nodoDum;
    }

    @Override
    public NodoAST visitCondicionalSi(CodexParser.CondicionalSiContext ctx) {
        NodoExpresion condicion = (NodoExpresion) visit(ctx.expresion(0));

        int capVerdadero = ctx.instruccion().size();
        int capFalso = 0;

        NodoSi nodoSi = new NodoSi(condicion, capVerdadero, capFalso);
        for (CodexParser.InstruccionContext instCtx : ctx.instruccion()) {
            nodoSi.agregarInstruccionVerdadera((NodoInstruccion) visit(instCtx));
        }

        return nodoSi;
    }

    @Override
    public NodoAST visitCicloFacere(CodexParser.CicloFacereContext ctx) {
        NodoExpresion condicion = (NodoExpresion) visit(ctx.expresion());
        int capInstrucciones = ctx.instruccion().size();

        NodoFacere nodoFacere = new NodoFacere(capInstrucciones, condicion);

        for (CodexParser.InstruccionContext instCtx : ctx.instruccion()) {
            nodoFacere.agregarInstruccion((NodoInstruccion) visit(instCtx));
        }

        return nodoFacere;
    }

    @Override
    public NodoAST visitCicloPer(CodexParser.CicloPerContext ctx) {
        NodoDeclaracionVar inicializacion = (NodoDeclaracionVar) visit(ctx.declaracionVar());
        NodoExpresion condicion = (NodoExpresion) visit(ctx.expresion());
        String idIterador = ctx.ID().getText();
        String operacion = ctx.MAS_MAS() != null ? "++" : "--";

        int capInstrucciones = ctx.instruccion().size();
        NodoPer nodoPer = new NodoPer(inicializacion, condicion, idIterador, operacion, capInstrucciones);

        for (CodexParser.InstruccionContext instCtx : ctx.instruccion()) {
            nodoPer.agregarInstruccion((NodoInstruccion) visit(instCtx));
        }

        return nodoPer;
    }

    @Override
    public NodoAST visitInterrupcion(CodexParser.InterrupcionContext ctx) {
        String tipo = ctx.PERGE() != null ? "perge" : "interrumpe";

        NodoInterrupcion nodo = new NodoInterrupcion(tipo);
        nodo.linea = ctx.getStart().getLine();
        nodo.columna = ctx.getStart().getCharPositionInLine();

        return nodo;
    }

    // FUNCIONES
    @Override
    public NodoAST visitFuncion(CodexParser.FuncionContext ctx) {
        String id = ctx.ID().getText();
        String tipoRetorno = ctx.RATIO() != null ? ctx.tipoDato().getText() : null;

        int capParams = ctx.parametros() != null ? ctx.parametros().parametro().size() : 0;
        int capInstrucciones = ctx.instruccion().size();

        NodoFuncion nodoFuncion = new NodoFuncion(id, tipoRetorno, capParams, capInstrucciones);

        // Procesar parametros
        if (ctx.parametros() != null) {
            for (int i = 0; i < capParams; i++) {
                CodexParser.ParametroContext paramCtx = ctx.parametros().parametro(i);
                nodoFuncion.nombresParametros[i] = paramCtx.ID().getText();
                nodoFuncion.tiposParametros[i] = paramCtx.tipoDato().getText();
            }
        }

        // Procesar variables locales si existen
        if (ctx.seccionVariablesLocal() != null) {
            for (CodexParser.DeclaracionVarContext varCtx : ctx.seccionVariablesLocal().declaracionVar()) {
                nodoFuncion.agregarInstruccion((NodoInstruccion) visit(varCtx));
            }
        }

        // Procesar cuerpo de la función
        for (CodexParser.InstruccionContext instCtx : ctx.instruccion()) {
            nodoFuncion.agregarInstruccion((NodoInstruccion) visit(instCtx));
        }

        // Procesar el retorno si existe
        if (ctx.REDDERE() != null) {
            NodoExpresion exprRetorno = (NodoExpresion) visit(ctx.expresion());
            nodoFuncion.agregarInstruccion(new NodoRetorno(exprRetorno));
        }

        return nodoFuncion;
    }

    @Override
    public NodoAST visitLlamadaFuncion(CodexParser.LlamadaFuncionContext ctx) {
        String id = ctx.ID().getText();
        int capArgumentos = ctx.expresion().size();

        NodoLlamadaFuncion llamada = new NodoLlamadaFuncion(id, capArgumentos);

        for (CodexParser.ExpresionContext exprCtx : ctx.expresion()) {
            llamada.agregarArgumento((NodoExpresion) visit(exprCtx));
        }

        return llamada;
    }

    @Override
    public NodoAST visitExprLlamada(CodexParser.ExprLlamadaContext ctx) {
        return visit(ctx.llamadaFuncion());
    }

    // FUNCIONES ESPECIALES
    @Override
    public NodoAST visitFuncionEspecial(CodexParser.FuncionEspecialContext ctx) {
        if (ctx.LEER() != null) {
            String idDestino = ctx.ID() != null ? ctx.ID().getText() : null;
            return new NodoLeer(idDestino);
        } else if (ctx.IMPRIMIR() != null && !ctx.IMPRIMIR().isEmpty()) {
            int capExpresiones = ctx.expresion().size();
            NodoImprimir nodoImprimir = new NodoImprimir(capExpresiones);

            for (CodexParser.ExpresionContext exprCtx : ctx.expresion()) {
                nodoImprimir.expresiones[nodoImprimir.contador++] = (NodoExpresion) visit(exprCtx);
            }
            return nodoImprimir;
        }
        return null;
    }
}
