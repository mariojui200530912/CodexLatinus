package ast.stm;

import ast.NodoAST;

public class NodoInterrupcion extends NodoAST {
    public String tipo; // "perge" o "interrumpe"

    public NodoInterrupcion(String tipo) {
        this.tipo = tipo;
    }
    @Override public void traducirPigLatin() {}
}
