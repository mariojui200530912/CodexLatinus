package ast.stm;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

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
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        TablaSimbolos entornoGlobal = new TablaSimbolos(1000, null, "Global");

        for (int i = 0; i < cantGlobales; i++) {
            if (variablesGlobales[i] != null) {
                variablesGlobales[i].validarSemantica(entornoGlobal, gestorErrores);
            }
        }

        for (int i = 0; i < cantFunciones; i++) {
            if (funciones[i] != null) {
                funciones[i].validarSemantica(entornoGlobal, gestorErrores);
            }
        }

        for (int i = 0; i < cantInstrucciones; i++) {
            if (instruccionesPrincipal[i] != null) {
                instruccionesPrincipal[i].validarSemantica(entornoGlobal, gestorErrores);
            }
        }
    }

    @Override
    public String traducirPigLatin() {
        String codigoPig = "";

        if(cantGlobales > 0) {
            codigoPig += TraductorPigLatin.traducirPalabra("VARIABILES") + "-\n";
            for (int i = 0; i < cantGlobales; i++) {
                codigoPig += variablesGlobales[i].traducirPigLatin() + "\n";
            }
        }

        if (cantFunciones > 0) {
            codigoPig += TraductorPigLatin.traducirPalabra("MUNERA") + ">\n";
            for (int i = 0; i < cantFunciones; i++) {
                codigoPig += funciones[i].traducirPigLatin() + "\n";
            }
        }

        codigoPig += TraductorPigLatin.traducirPalabra("MAIOR") + ">\n";
        for (int i = 0; i < cantInstrucciones; i++) {
            codigoPig += instruccionesPrincipal[i].traducirPigLatin() + "\n";
        }

        codigoPig += TraductorPigLatin.traducirPalabra("FINIS") + ";\n";

        return codigoPig;
    }
}
