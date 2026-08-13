package ast.exp;

import ast.NodoAST;

public class NodoAccesoArreglo extends NodoExpresion {
    public String idArreglo;
    public NodoExpresion expresionIndice;

    public NodoAccesoArreglo(String idArreglo, NodoExpresion expresionIndice) {
        this.idArreglo = idArreglo;
        this.expresionIndice = expresionIndice;
    }
    @Override public void traducirPigLatin() {}
}
