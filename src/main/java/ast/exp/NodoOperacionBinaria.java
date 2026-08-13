package ast.exp;

import ast.NodoAST;

public class NodoOperacionBinaria extends NodoExpresion {
    public NodoExpresion hijoIzquierdo;
    public String operador;
    public NodoExpresion hijoDerecho;

    public NodoOperacionBinaria(NodoExpresion izq, String op, NodoExpresion der) {
        this.hijoIzquierdo = izq;
        this.operador = op;
        this.hijoDerecho = der;
    }
    @Override public void traducirPigLatin() {}
}