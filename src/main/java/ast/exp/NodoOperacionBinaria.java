package ast.exp;

import ast.NodoAST;

public class NodoOperacionBinaria extends NodoAST {
    public NodoAST hijoIzquierdo;
    public String operador;
    public NodoAST hijoDerecho;

    public NodoOperacionBinaria(NodoAST izq, String op, NodoAST der) {
        this.hijoIzquierdo = izq;
        this.operador = op;
        this.hijoDerecho = der;
    }
    @Override public void traducirPigLatin() {}
}