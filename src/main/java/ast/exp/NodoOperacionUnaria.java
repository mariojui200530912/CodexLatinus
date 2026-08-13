package ast.exp;

import ast.NodoAST;

public class NodoOperacionUnaria extends NodoExpresion {
    public String operador;
    public NodoExpresion expresion;

    public NodoOperacionUnaria(String operador, NodoExpresion expresion) {
        this.operador = operador;
        this.expresion = expresion;
    }
    @Override public void traducirPigLatin() {}
}
