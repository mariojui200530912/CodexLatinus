package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;

public class NodoImprimir extends NodoAST {
    public NodoExpresion[] expresiones;
    public int contador = 0;

    public NodoImprimir(int capacidad) {
        this.expresiones = new NodoExpresion[capacidad];
    }
    @Override public void traducirPigLatin() {}
}
