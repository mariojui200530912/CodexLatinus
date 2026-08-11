package ast.exp;

import ast.NodoAST;

public class NodoAccesoArreglo extends NodoAST {
    public String idArreglo;
    public NodoAST expresionIndice;

    public NodoAccesoArreglo(String idArreglo, NodoAST expresionIndice) {
        this.idArreglo = idArreglo;
        this.expresionIndice = expresionIndice;
    }
    @Override public void traducirPigLatin() {}
}
