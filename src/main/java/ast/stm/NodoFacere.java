package ast.stm;

import ast.NodoAST;

public class NodoFacere extends NodoAST {
    public NodoAST[] instrucciones;
    public NodoAST condicion;
    public int contador = 0;

    public NodoFacere(int capacidad, NodoAST condicion) {
        this.instrucciones = new NodoAST[capacidad];
        this.condicion = condicion;
    }

    @Override public void traducirPigLatin() {}
}