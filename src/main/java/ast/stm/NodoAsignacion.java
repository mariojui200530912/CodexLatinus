package ast.stm;

import ast.NodoAST;

public class NodoAsignacion extends NodoAST {
    public String id;
    public NodoAST expresionIndice; // Null si es variable simple, instanciado si es arreglo
    public NodoAST expresionValor;

    public NodoAsignacion(String id, NodoAST expresionIndice, NodoAST expresionValor) {
        this.id = id;
        this.expresionIndice = expresionIndice;
        this.expresionValor = expresionValor;
    }
    @Override public void traducirPigLatin() {}
}
