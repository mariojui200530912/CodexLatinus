package ast.stm;

import ast.NodoAST;

public class NodoDeclaracionVar extends NodoAST {
    public String id;
    public String tipoDato;
    public NodoAST expresionValor; // Null si no se inicializa

    public NodoDeclaracionVar(String id, String tipoDato, NodoAST expresionValor) {
        this.id = id;
        this.tipoDato = tipoDato;
        this.expresionValor = expresionValor;
    }
    @Override public void traducirPigLatin() {}
}