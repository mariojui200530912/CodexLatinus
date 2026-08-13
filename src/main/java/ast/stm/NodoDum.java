package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;

public class NodoDum extends NodoInstruccion {
    public NodoExpresion condicion;
    public NodoInstruccion[] instrucciones;
    public int contador = 0;

    public NodoDum(NodoExpresion condicion, int capacidad) {
        this.condicion = condicion;
        this.instrucciones = new NodoInstruccion[capacidad];
    }

    public void agregarInstruccion(NodoInstruccion inst) {
        if (contador < instrucciones.length) instrucciones[contador++] = inst;
    }
    @Override public void traducirPigLatin() {}
}
