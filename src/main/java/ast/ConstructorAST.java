package ast;

import analyzer.CodexBaseVisitor;
import analyzer.CodexParser;
import ast.stm.*;
import ast.exp.*;

public class ConstructorAST extends CodexBaseVisitor<NodoAST> {
    private int ciclosAbiertos = 0;

    // ESTRUCTURA PRINCIPAL DEL PROGRAMA
    @Override
    public NodoAST visitProgram(CodexParser.ProgramContext ctx) {
        int capGlobales = ctx.seccionVariables() != null ? ctx.seccionVariables().declaracion().size() : 0;
        int capFunciones = ctx.seccionFunciones() != null ? ctx.seccionFunciones().funcion().size() : 0;
        int capPrincipal = ctx.seccionPrincipal().instruccion().size();
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        NodoPrograma programa = new NodoPrograma(capGlobales, capFunciones, capPrincipal, linea, columna);

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
    public NodoAST visitDeclaracion(CodexParser.DeclaracionContext ctx) {
        if (ctx.declaracionVar() != null) {
            return visit(ctx.declaracionVar());
        } else if (ctx.declaracionArreglo() != null) {
            return visit(ctx.declaracionArreglo());
        } else if (ctx.definicionStruct() != null) {
            return visit(ctx.definicionStruct());
        } else if (ctx.asignacion() != null) {
            return visit(ctx.asignacion());
        }
        return null;
    }

    @Override
    public NodoAST visitDeclaracionVar(CodexParser.DeclaracionVarContext ctx) {
        String id = ctx.ID().getText();
        String tipo = ctx.tipoDato().getText();
        NodoAST valor = null;

        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        if (ctx.expresion() != null) {
            valor = visit(ctx.expresion()); // Visitamos la expresion para obtener su sub-arbol
            if (valor instanceof NodoInstanciaEstructura) {
                NodoInstanciaEstructura instancia = (NodoInstanciaEstructura) valor;
                if (instancia.tipoEstructura == null || instancia.tipoEstructura.isEmpty()) {
                    instancia.tipoEstructura = tipo;
                }
            }
        }

        return new NodoDeclaracionVar(id, tipo, (NodoExpresion) valor, linea, columna);
    }

    @Override
    public NodoAST visitAsignacion(CodexParser.AsignacionContext ctx) {
        String id = ctx.ID(0).getText();

        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        NodoExpresion valor = (NodoExpresion) visit(ctx.expresion(ctx.expresion().size() - 1));

        NodoExpresion indice = null;
        if (ctx.expresion().size() > 1) {
            indice = (NodoExpresion) visit(ctx.expresion(0));
        }

        if (ctx.ID().size() > 1) {
            String idAtributo = ctx.ID(1).getText();
            id = id + "." + idAtributo;
        }

        return new NodoAsignacion(id, indice, valor, linea, columna);
    }

    @Override
    public NodoAST visitIncremento(CodexParser.IncrementoContext ctx) {
        String id = ctx.ID().getText();

        String operador = ctx.MAS_MAS() != null ? "+" : "-";

        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        NodoIdentificador variableIzquierda = new NodoIdentificador(id, linea, columna);

        NodoLiteral literalUno = new NodoLiteral(1, "numerus", linea, columna);

        NodoOperacionBinaria operacion = new NodoOperacionBinaria(variableIzquierda, operador, literalUno, linea, columna);

        return new NodoAsignacion(id, null, operacion, linea, columna);
    }

    // ARREGLOS Y ASIGNACIONES
    @Override
    public NodoAST visitDeclaracionArreglo(CodexParser.DeclaracionArregloContext ctx) {
        String id = ctx.ID().getText();
        int tamano = Integer.parseInt(ctx.ENTERO().getText());
        String tipo = ctx.tipoDato().getText();

        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        int capValores = ctx.expresion().size();
        NodoDeclaracionArreglo nodoArreglo = new NodoDeclaracionArreglo(id, tamano, tipo, capValores, linea, columna);

        for (CodexParser.ExpresionContext exprCtx : ctx.expresion()) {
            nodoArreglo.agregarValorInicial((NodoExpresion) visit(exprCtx));
        }

        return nodoArreglo;
    }

    @Override
    public NodoAST visitDefinicionStruct(CodexParser.DefinicionStructContext ctx) {
        String id = ctx.ID().getText();
        int capAtributos = ctx.atributoStruct().size();
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        NodoDefinicionStruct nodoStruct = new NodoDefinicionStruct(id, capAtributos, linea, columna);

        for (CodexParser.AtributoStructContext attrCtx : ctx.atributoStruct()) {
            String nombreAtributo = attrCtx.ID().getText();
            String tipoAtributo = attrCtx.tipoDato().getText();
            nodoStruct.agregarAtributo(nombreAtributo, tipoAtributo);
        }

        return nodoStruct;
    }

    @Override
    public NodoAST visitExprArreglo(CodexParser.ExprArregloContext ctx) {
        String idArreglo = ctx.ID().getText();
        NodoExpresion indice = (NodoExpresion) visit(ctx.expresion());
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoAccesoArreglo(idArreglo, indice, linea, columna);
    }

    @Override
    public NodoAST visitExprAtributoStruct(CodexParser.ExprAtributoStructContext ctx) {
        String idEstructura = ctx.ID(0).getText();
        String idAtributo = ctx.ID(1).getText();
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoAccesoEstructura(idEstructura, idAtributo,  linea, columna);
    }

    // EXPRESIONES
    // Operaciones matematicas y logicas
    @Override
    public NodoAST visitExprSuma(CodexParser.ExprSumaContext ctx) {
        NodoExpresion izq = (NodoExpresion) visit(ctx.expresion(0));
        NodoExpresion der = (NodoExpresion) visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText();
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoOperacionBinaria(izq, operador, der, linea, columna);
    }

    @Override
    public NodoAST visitExprMultiplicacion(CodexParser.ExprMultiplicacionContext ctx) {
        NodoExpresion izq = (NodoExpresion) visit(ctx.expresion(0));
        NodoExpresion der = (NodoExpresion) visit(ctx.expresion(1));
        String operador = ctx.getChild(1).getText(); // Extrae '*' o '/'
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoOperacionBinaria(izq, operador, der, linea, columna);
    }

    @Override
    public NodoAST visitExprRelacional(CodexParser.ExprRelacionalContext ctx) {
        NodoExpresion izq = (NodoExpresion) visit(ctx.expresion(0));
        NodoExpresion der = (NodoExpresion) visit(ctx.expresion(1));
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoOperacionBinaria(izq, ctx.getChild(1).getText(), der,  linea, columna);
    }

    @Override
    public NodoAST visitExprIgualdad(CodexParser.ExprIgualdadContext ctx) {
        NodoExpresion izq = (NodoExpresion) visit(ctx.expresion(0));
        NodoExpresion der = (NodoExpresion) visit(ctx.expresion(1));
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoOperacionBinaria(izq, ctx.getChild(1).getText(), der, linea, columna);
    }

    @Override
    public NodoAST visitExprAnd(CodexParser.ExprAndContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoOperacionBinaria((NodoExpresion) visit(ctx.expresion(0)), "&&", (NodoExpresion) visit(ctx.expresion(1)), linea, columna);
    }

    @Override
    public NodoAST visitExprOr(CodexParser.ExprOrContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoOperacionBinaria((NodoExpresion) visit(ctx.expresion(0)), "||", (NodoExpresion) visit(ctx.expresion(1)), linea, columna);
    }

    @Override
    public NodoAST visitExprInstanciaStruct(CodexParser.ExprInstanciaStructContext ctx) {
        String tipoEstructura = null;
        int startIndexID = 0;
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        if (ctx.ID().size() > 0 && !ctx.getChild(0).getText().equals("{")) {
            tipoEstructura = ctx.ID(0).getText();
            startIndexID = 1;
        }

        int capAtributos = ctx.expresion().size();
        NodoInstanciaEstructura nodoInstancia = new NodoInstanciaEstructura(tipoEstructura, capAtributos, linea, columna);

        for (int i = 0; i < capAtributos; i++) {
            String nombreAtributo = ctx.ID(i + startIndexID).getText();
            NodoExpresion valorAtributo = (NodoExpresion) visit(ctx.expresion(i));

            nodoInstancia.agregarAtributo(nombreAtributo, valorAtributo);
        }

        return nodoInstancia;
    }

    // UNARIAS Y AGRUPACION
    @Override
    public NodoAST visitExprNegacion(CodexParser.ExprNegacionContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoOperacionUnaria("non", (NodoExpresion) visit(ctx.expresion()), linea, columna);
    }

    @Override
    public NodoAST visitExprUnaria(CodexParser.ExprUnariaContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoOperacionUnaria("-", (NodoExpresion) visit(ctx.expresion()), linea, columna);
    }

    @Override
    public NodoAST visitExprAgrupacion(CodexParser.ExprAgrupacionContext ctx) {
        return visit(ctx.expresion());
    }

    // Literales y variables
    @Override
    public NodoAST visitExprEntero(CodexParser.ExprEnteroContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoLiteral(Integer.parseInt(ctx.getText()), "numerus", linea, columna);
    }

    @Override
    public NodoAST visitExprCadena(CodexParser.ExprCadenaContext ctx) {
        String texto = ctx.getText();
        texto = texto.substring(1, texto.length() - 1);
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoLiteral(texto, "textum", linea, columna);
    }

    @Override
    public NodoAST visitExprVariable(CodexParser.ExprVariableContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoIdentificador(ctx.getText(),  linea, columna);
    }

    @Override
    public NodoAST visitExprDecimal(CodexParser.ExprDecimalContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoLiteral(Double.parseDouble(ctx.getText()), "decimalis",  linea, columna);
    }

    @Override
    public NodoAST visitExprCaracter(CodexParser.ExprCaracterContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoLiteral(ctx.getText().charAt(1), "littera",   linea, columna);
    }

    @Override
    public NodoAST visitExprVerdadero(CodexParser.ExprVerdaderoContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoLiteral(true, "bool", linea, columna);
    }

    @Override
    public NodoAST visitExprFalso(CodexParser.ExprFalsoContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoLiteral(false, "bool",  linea, columna);
    }

    // ESTRUCTURAS DE CONTROL DE FLUJO
    @Override
    public NodoAST visitCicloDum(CodexParser.CicloDumContext ctx) {
        ciclosAbiertos++;
        NodoAST condicion = visit(ctx.expresion());
        int capInstrucciones = ctx.instruccion().size();
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        NodoDum nodoDum = new NodoDum((NodoExpresion) condicion, capInstrucciones, linea, columna);

        for (CodexParser.InstruccionContext instCtx : ctx.instruccion()) {
            nodoDum.agregarInstruccion((NodoInstruccion) visit(instCtx));
        }
        ciclosAbiertos--;
        return nodoDum;
    }

    @Override
    public NodoAST visitCondicionalSi(CodexParser.CondicionalSiContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        int totalInst = ctx.instruccion().size();

        NodoSi nodoRaiz = null;
        NodoSi nodoActual = null;

        int condicionIndex = 0;
        boolean llenandoVerdaderas = true;

        for (int i = 0; i < ctx.getChildCount(); i++) {
            org.antlr.v4.runtime.tree.ParseTree child = ctx.getChild(i);
            String texto = child.getText();

            if (texto.equals("si")) {
                NodoExpresion condicion = (NodoExpresion) visit(ctx.expresion(condicionIndex++));
                nodoRaiz = new NodoSi(condicion, totalInst, totalInst, linea, columna);
                nodoActual = nodoRaiz;
                llenandoVerdaderas = true;
            }
            else if (texto.equals("aliter")) {
                if (i + 1 < ctx.getChildCount() && ctx.getChild(i + 1).getText().equals("(")) {
                    NodoExpresion condicion = (NodoExpresion) visit(ctx.expresion(condicionIndex++));
                    NodoSi nuevoSi = new NodoSi(condicion, totalInst, totalInst, linea, columna);

                    nodoActual.agregarInstruccionFalsa(nuevoSi);
                    nodoActual = nuevoSi;
                    llenandoVerdaderas = true;
                } else if (i + 1 < ctx.getChildCount() && ctx.getChild(i + 1).getText().equals("{")) {
                    llenandoVerdaderas = false;
                }
            }
            else if (child instanceof CodexParser.InstruccionContext) {

                NodoInstruccion instruccion = (NodoInstruccion) visit(child);
                if (llenandoVerdaderas) {
                    nodoActual.agregarInstruccionVerdadera(instruccion);
                } else {
                    nodoActual.agregarInstruccionFalsa(instruccion);
                }
            }
        }

        return nodoRaiz;
    }

    @Override
    public NodoAST visitCicloFacere(CodexParser.CicloFacereContext ctx) {
        ciclosAbiertos++;
        NodoExpresion condicion = (NodoExpresion) visit(ctx.expresion());
        int capInstrucciones = ctx.instruccion().size();
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        NodoFacere nodoFacere = new NodoFacere(capInstrucciones, condicion, linea, columna);

        for (CodexParser.InstruccionContext instCtx : ctx.instruccion()) {
            nodoFacere.agregarInstruccion((NodoInstruccion) visit(instCtx));
        }
        ciclosAbiertos--;
        return nodoFacere;
    }

    @Override
    public NodoAST visitCicloPer(CodexParser.CicloPerContext ctx) {
        ciclosAbiertos++;
        NodoDeclaracionVar inicializacion = (NodoDeclaracionVar) visit(ctx.declaracionVar());

        NodoExpresion condicion = (NodoExpresion) visit(ctx.expresion(0));

        String idIterador = ctx.ID().getText();

        String operacion = "";
        NodoExpresion valorAsignacion = null;

        if (ctx.MAS_MAS() != null) {
            operacion = "++";
        } else if (ctx.MENOS_MENOS() != null) {
            operacion = "--";
        } else if (ctx.ASIGNACION() != null) {
            operacion = "=";
            valorAsignacion = (NodoExpresion) visit(ctx.expresion(1));
        }

        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        int capInstrucciones = ctx.instruccion().size();

        NodoPer nodoPer = new NodoPer(inicializacion, condicion, idIterador, operacion, valorAsignacion, capInstrucciones, linea, columna);

        for (CodexParser.InstruccionContext instCtx : ctx.instruccion()) {
            nodoPer.agregarInstruccion((NodoInstruccion) visit(instCtx));
        }

        ciclosAbiertos--;
        return nodoPer;
    }

    @Override
    public NodoAST visitInterrupcion(CodexParser.InterrupcionContext ctx) {
        String tipo = ctx.PERGE() != null ? "perge" : "interrumpe";
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        NodoInterrupcion nodo = new NodoInterrupcion(tipo, linea, columna);
        if (ciclosAbiertos == 0) {
            System.err.println("Error Semantico en [" + linea + ":" + columna + "]: La instruccion '" + tipo + "' solo se puede usar dentro de un ciclo.");
        }

        return nodo;
    }

    // FUNCIONES
    @Override
    public NodoAST visitFuncion(CodexParser.FuncionContext ctx) {
        String id = ctx.ID().getText();
        String tipoRetorno = ctx.RATIO() != null ? ctx.tipoDato().getText() : null;

        int capParams = ctx.parametros() != null ? ctx.parametros().parametro().size() : 0;
        int capInstrucciones = ctx.instruccion().size();
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        if (ctx.seccionVariablesLocal() != null) {
            capInstrucciones += ctx.seccionVariablesLocal().declaracionVar().size();
        }

        NodoFuncion nodoFuncion = new NodoFuncion(id, tipoRetorno, capParams, capInstrucciones, linea, columna);

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

        // Procesar cuerpo de la funcion
        for (CodexParser.InstruccionContext instCtx : ctx.instruccion()) {
            nodoFuncion.agregarInstruccion((NodoInstruccion) visit(instCtx));
        }

        return nodoFuncion;
    }

    @Override
    public NodoAST visitLlamadaFuncion(CodexParser.LlamadaFuncionContext ctx) {
        String id = ctx.ID().getText();
        int capArgumentos = ctx.expresion().size();
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        NodoLlamadaFuncion llamada = new NodoLlamadaFuncion(id, capArgumentos, linea, columna);

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
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        if (ctx.LEER() != null) {
            String idDestino = ctx.ID() != null ? ctx.ID().getText() : null;
            return new NodoLeer(idDestino, linea, columna);
        } else if (ctx.IMPRIMIR() != null && !ctx.IMPRIMIR().isEmpty()) {
            int capExpresiones = ctx.expresion().size();
            NodoImprimir nodoImprimir = new NodoImprimir(capExpresiones, linea, columna);

            for (CodexParser.ExpresionContext exprCtx : ctx.expresion()) {
                nodoImprimir.expresiones[nodoImprimir.contador++] = (NodoExpresion) visit(exprCtx);
            }
            return nodoImprimir;
        }
        return null;
    }

    @Override
    public NodoAST visitRetorno(CodexParser.RetornoContext ctx) {
        NodoExpresion expr = (NodoExpresion) visit(ctx.expresion());
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        return new NodoRetorno(expr, linea, columna);
    }
}
