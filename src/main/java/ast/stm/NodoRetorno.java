package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;

public class NodoRetorno extends NodoInstruccion {
    public NodoExpresion expresionRetorno;

    public NodoRetorno(NodoExpresion expresionRetorno) {
        this.expresionRetorno = expresionRetorno;
    }
    @Override public void traducirPigLatin() {}
}