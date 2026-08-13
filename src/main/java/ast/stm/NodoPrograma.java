package ast.stm;

import ast.NodoAST;
import simbolos.TablaSimbolos;

public class NodoPrograma extends NodoAST {
    public NodoInstruccion[] variablesGlobales;
    public NodoInstruccion[] funciones;
    public NodoInstruccion[] instruccionesPrincipal;

    public int cantGlobales = 0;
    public int cantFunciones = 0;
    public int cantInstrucciones = 0;

    public NodoPrograma(int capGlobales, int capFunciones, int capPrincipal) {
        this.variablesGlobales = new NodoInstruccion[capGlobales];
        this.funciones = new NodoInstruccion[capFunciones];
        this.instruccionesPrincipal = new NodoInstruccion[capPrincipal];
    }

    public void agregarGlobal(NodoInstruccion nodo){
        if(cantGlobales < variablesGlobales.length){
            variablesGlobales[cantGlobales++] = nodo;
        }
    }

    public void agregarFuncion(NodoInstruccion nodo) {
        if (cantFunciones < funciones.length) {
            funciones[cantFunciones++] = nodo;
        }
    }

    public void agregarInstruccion(NodoInstruccion nodo) {
        if (cantInstrucciones < instruccionesPrincipal.length) {
            instruccionesPrincipal[cantInstrucciones++] = nodo;
        }
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual) {
        TablaSimbolos entornoGlobal = new TablaSimbolos(1000, null, "Global");

        for (int i = 0; i < cantGlobales; i++) {
            if (variablesGlobales[i] != null) {
                variablesGlobales[i].validarSemantica(entornoGlobal);
            }
        }

        for (int i = 0; i < cantFunciones; i++) {
            if (funciones[i] != null) {
                funciones[i].validarSemantica(entornoGlobal);
            }
        }

        for (int i = 0; i < cantInstrucciones; i++) {
            if (instruccionesPrincipal[i] != null) {
                instruccionesPrincipal[i].validarSemantica(entornoGlobal);
            }
        }
    }

    @Override
    public void traducirPigLatin() {
        for (int i = 0; i < cantGlobales; i++) {
            if (variablesGlobales[i] != null) {
                variablesGlobales[i].traducirPigLatin();
            }
        }

        for (int i = 0; i < cantFunciones; i++) {
            if (funciones[i] != null) {
                funciones[i].traducirPigLatin();
            }
        }

        for (int i = 0; i < cantInstrucciones; i++) {
            if (instruccionesPrincipal[i] != null) {
                instruccionesPrincipal[i].traducirPigLatin();
            }
        }
    }
}
