package ast.stm;

import ast.NodoAST;

public class NodoRetorno extends NodoAST {
    public NodoAST expresionRetorno;

    public NodoRetorno(NodoAST expresionRetorno) {
        this.expresionRetorno = expresionRetorno;
    }
    @Override public void traducirPigLatin() {}
}