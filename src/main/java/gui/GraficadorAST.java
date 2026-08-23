package gui;

import ast.NodoAST;
import ast.exp.*;
import ast.stm.*;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.view.mxGraph;

import javax.swing.*;

public class GraficadorAST {
    private mxGraph graph;
    private Object parent;

    public void graficar(NodoPrograma raiz, mxGraph graph) {
        this.graph = graph;
        this.parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            graph.removeCells(graph.getChildVertices(graph.getDefaultParent()));

            if (raiz != null) {
                recorrerNodo(raiz, null);
            }

            mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
            layout.setOrientation(SwingConstants.NORTH);
            layout.setIntraCellSpacing(50);
            layout.setInterRankCellSpacing(60);
            layout.execute(parent);

        } finally {
            graph.getModel().endUpdate();
        }
    }

    private Object recorrerNodo(NodoAST nodoActual, Object verticePadre) {
        if (nodoActual == null) return null;

        String etiqueta = obtenerEtiqueta(nodoActual);

        int ancho = Math.max(100, etiqueta.length() * 8);
        int alto = 40;

        String estiloNodo = "fillColor=#E3F2FD;strokeColor=#1976D2;fontColor=#000000;rounded=1;fontFamily=Monospaced;";
        String estiloArista = "strokeColor=#546E7A;edgeStyle=orthogonalEdgeStyle;";

        Object verticeActual = graph.insertVertex(parent, null, etiqueta, 0, 0, ancho, alto, estiloNodo);

        if (verticePadre != null) {
            graph.insertEdge(parent, null, "", verticePadre, verticeActual, estiloArista);
        }

        // Enrutar hijos
        if (nodoActual instanceof NodoPrograma) {
            NodoPrograma np = (NodoPrograma) nodoActual;
            for (int i = 0; i < np.cantGlobales; i++) {
                recorrerNodo(np.variablesGlobales[i], verticeActual);
            }
            for (int i = 0; i < np.cantFunciones; i++) {
                recorrerNodo(np.funciones[i], verticeActual);
            }
            for (int i = 0; i < np.cantInstrucciones; i++) {
                recorrerNodo(np.instruccionesPrincipal[i], verticeActual);
            }
        }
        else if (nodoActual instanceof NodoOperacionBinaria) {
            NodoOperacionBinaria nob = (NodoOperacionBinaria) nodoActual;
            recorrerNodo(nob.hijoIzquierdo, verticeActual);
            recorrerNodo(nob.hijoDerecho, verticeActual);
        }
        else if (nodoActual instanceof NodoOperacionUnaria) {
            NodoOperacionUnaria nou = (NodoOperacionUnaria) nodoActual;
            recorrerNodo(nou.expresion, verticeActual);
        }
        else if (nodoActual instanceof NodoAsignacion) {
            NodoAsignacion na = (NodoAsignacion) nodoActual;
            if (na.expresionIndice != null) {
                recorrerNodo(na.expresionIndice, verticeActual);
            }
            recorrerNodo(na.expresionValor, verticeActual);
        }
        else if (nodoActual instanceof NodoDeclaracionVar) {
            NodoDeclaracionVar ndv = (NodoDeclaracionVar) nodoActual;
            if (ndv.expresionValor != null) {
                recorrerNodo(ndv.expresionValor, verticeActual);
            }
        }
        else if (nodoActual instanceof NodoDeclaracionArreglo) {
            NodoDeclaracionArreglo nda = (NodoDeclaracionArreglo) nodoActual;
            if (nda.valoresIniciales != null) {
                for (int i = 0; i < nda.cantValores; i++) {
                    recorrerNodo(nda.valoresIniciales[i], verticeActual);
                }
            }
        }
        else if (nodoActual instanceof NodoDum) {
            NodoDum nDum = (NodoDum) nodoActual;
            recorrerNodo(nDum.condicion, verticeActual);

            for (int i = 0; i < nDum.contador; i++) {
                recorrerNodo(nDum.instrucciones[i], verticeActual);
            }
        }
        else if (nodoActual instanceof NodoFacere) {
            NodoFacere nFacere = (NodoFacere) nodoActual;

            for (int i = 0; i < nFacere.contador; i++) {
                recorrerNodo(nFacere.instrucciones[i], verticeActual);
            }
            recorrerNodo(nFacere.condicion, verticeActual);
        }
        else if (nodoActual instanceof NodoFuncion) {
            NodoFuncion nFunc = (NodoFuncion) nodoActual;
            for (int i = 0; i < nFunc.cantInstrucciones; i++) {
                recorrerNodo(nFunc.instrucciones[i], verticeActual);
            }
        }
        else if (nodoActual instanceof NodoImprimir) {
            NodoImprimir nImp = (NodoImprimir) nodoActual;
            for (int i = 0; i < nImp.contador; i++) {
                recorrerNodo(nImp.expresiones[i], verticeActual);
            }
        }
        else if (nodoActual instanceof NodoInstanciaEstructura) {
            NodoInstanciaEstructura nie = (NodoInstanciaEstructura) nodoActual;
            for (int i = 0; i < nie.cantAtributos; i++) {
                recorrerNodo(nie.expresionesAtributos[i], verticeActual);
            }
        }
        else if (nodoActual instanceof NodoPer) {
            NodoPer nPer = (NodoPer) nodoActual;
            recorrerNodo(nPer.inicializacion, verticeActual);
            recorrerNodo(nPer.condicion, verticeActual);
            for (int i = 0; i < nPer.contador; i++) {
                recorrerNodo(nPer.instrucciones[i], verticeActual);
            }
        }
        else if (nodoActual instanceof NodoRetorno) {
            NodoRetorno nRet = (NodoRetorno) nodoActual;

            if (nRet.expresionRetorno != null) {
                recorrerNodo(nRet.expresionRetorno, verticeActual);
            }
        }
        else if (nodoActual instanceof NodoSi) {
            NodoSi nSi = (NodoSi) nodoActual;
            recorrerNodo(nSi.condicion, verticeActual);

            for (int i = 0; i < nSi.cantVerdadero; i++) {
                recorrerNodo(nSi.instruccionesVerdadero[i], verticeActual);
            }

            if (nSi.instruccionesFalso != null) {
                for (int i = 0; i < nSi.cantFalso; i++) {
                    recorrerNodo(nSi.instruccionesFalso[i], verticeActual);
                }
            }
        }
        else if (nodoActual instanceof NodoLlamadaFuncion) {
            NodoLlamadaFuncion nLlamada = (NodoLlamadaFuncion) nodoActual;
            for (int i = 0; i < nLlamada.cantArgumentos; i++) {
                recorrerNodo(nLlamada.argumentos[i], verticeActual);
            }
        }
        else if (nodoActual instanceof NodoAccesoArreglo) {
            NodoAccesoArreglo naa = (NodoAccesoArreglo) nodoActual;
            recorrerNodo(naa.expresionIndice, verticeActual);
        }

        return verticeActual;
    }


    private String obtenerEtiqueta(NodoAST nodo) {
        if (nodo instanceof NodoPrograma) return "Programa";

            // --- EXPRESIONES ---
        else if (nodo instanceof NodoOperacionBinaria) {
            return "Op\n[ " + ((NodoOperacionBinaria) nodo).operador + " ]";
        }
        else if (nodo instanceof NodoOperacionUnaria) {
            return "Unaria\n[ " + ((NodoOperacionUnaria) nodo).operador + " ]";
        }
        else if (nodo instanceof NodoLiteral) {
            NodoLiteral nl = (NodoLiteral) nodo;
            return "Literal\n" + nl.valor;
        }
        else if (nodo instanceof NodoIdentificador) { return "ID\n" + ((NodoIdentificador) nodo).id; }
        else if (nodo instanceof NodoAccesoArreglo) {
            return "Acceso Arreglo\n" + ((NodoAccesoArreglo) nodo).idArreglo;
        }
        else if (nodo instanceof NodoAccesoEstructura) {
            NodoAccesoEstructura nae = (NodoAccesoEstructura) nodo;
            return "Acceso Struct\n" + nae.idEstructura + "." + nae.idAtributo;
        }
        else if (nodo instanceof NodoLlamadaFuncion) return "Llamada\n" + ((NodoLlamadaFuncion) nodo).id + "()";

            // --- INSTRUCCIONES ---
        else if (nodo instanceof NodoAsignacion) return "Asignacion\n" + ((NodoAsignacion) nodo).id;
        else if (nodo instanceof NodoDeclaracionVar) return "Decl. Var\n" + ((NodoDeclaracionVar) nodo).id;
        else if (nodo instanceof NodoDeclaracionArreglo) return "Decl. Arreglo\n" + ((NodoDeclaracionArreglo) nodo).id;
        else if (nodo instanceof NodoDefinicionStruct) {
            return "Definición Struct\n" + ((NodoDefinicionStruct) nodo).id;
        }
        else if (nodo instanceof NodoInstanciaEstructura) return "Instancia\nStruct";

            // --- CONTROL DE FLUJO ---
        else if (nodo instanceof NodoSi) return "Condicional\n(si)";
        else if (nodo instanceof NodoDum) return "Ciclo\n(dum)";
        else if (nodo instanceof NodoFacere) return "Ciclo\n(facere dum)";
        else if (nodo instanceof NodoPer) {
            NodoPer nPer = (NodoPer) nodo;
            return "Ciclo\n(per) " + nPer.idIterador + nPer.operacionIterador;
        }
        else if (nodo instanceof NodoInterrupcion) {
            NodoInterrupcion ni = (NodoInterrupcion) nodo;
            return "Interrupción\n(" + ni.tipo + ")";
        }

            // --- FUNCIONES Y SISTEMA ---
        else if (nodo instanceof NodoFuncion) return "Funcion\n" + ((NodoFuncion) nodo).id;
        else if (nodo instanceof NodoRetorno) return "Retorno\n(reddere)";
        else if (nodo instanceof NodoImprimir) return "Imprimir\n(>>)";
        else if (nodo instanceof NodoLeer) {
            NodoLeer nl = (NodoLeer) nodo;
            if (nl.idDestino != null) {
                return "Leer\n(<<) a " + nl.idDestino;
            }
            return "Leer\n(<<)";
        }

        return nodo.getClass().getSimpleName();
    }
}