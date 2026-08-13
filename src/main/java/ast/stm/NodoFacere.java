package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;

public class NodoFacere extends NodoInstruccion {
    public NodoInstruccion[] instrucciones;
    public NodoExpresion condicion;
    public int contador = 0;

    public NodoFacere(int capacidad, NodoExpresion condicion) {
        this.instrucciones = new NodoInstruccion[capacidad];
        this.condicion = condicion;
    }

    public void agregarInstruccion (NodoInstruccion inst) {
        if (contador < instrucciones.length) {
            instrucciones[contador++] = inst;
        }
    }

    @Override public void traducirPigLatin() {}
}