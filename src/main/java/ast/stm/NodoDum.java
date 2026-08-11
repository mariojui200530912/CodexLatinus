package ast.stm;

import ast.NodoAST;

public class NodoDum extends NodoAST {
    public NodoAST condicion;
    public NodoAST[] instrucciones;
    public int contador = 0;

    public NodoDum(NodoAST condicion, int capacidad) {
        this.condicion = condicion;
        this.instrucciones = new NodoAST[capacidad];
    }

    public void agregarInstruccion(NodoAST inst) {
        if (contador < instrucciones.length) instrucciones[contador++] = inst;
    }
    @Override public void traducirPigLatin() {}
}
