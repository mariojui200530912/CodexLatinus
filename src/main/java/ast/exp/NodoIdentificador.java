package ast.exp;

import ast.NodoAST;

public class NodoIdentificador extends NodoAST {
    public String id;

    public NodoIdentificador(String id) {
        this.id = id;
    }
    @Override public void traducirPigLatin() {}
}