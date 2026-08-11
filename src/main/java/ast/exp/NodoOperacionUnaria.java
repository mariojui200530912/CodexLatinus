package ast.exp;

import ast.NodoAST;

public class NodoOperacionUnaria extends NodoAST {
    public String operador;
    public NodoAST expresion;

    public NodoOperacionUnaria(String operador, NodoAST expresion) {
        this.operador = operador;
        this.expresion = expresion;
    }
    @Override public void traducirPigLatin() {}
}
