package ast.stm;

import ast.NodoAST;

public class NodoImprimir extends NodoAST {
    public NodoAST[] expresiones;
    public int contador = 0;

    public NodoImprimir(int capacidad) {
        this.expresiones = new NodoAST[capacidad];
    }
    @Override public void traducirPigLatin() {}
}
