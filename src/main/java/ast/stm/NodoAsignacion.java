package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;

public class NodoAsignacion extends NodoInstruccion {
    public String id;
    public NodoExpresion expresionIndice; // Null si es variable simple, instanciado si es arreglo
    public NodoExpresion expresionValor;

    public NodoAsignacion(String id, NodoExpresion expresionIndice, NodoExpresion expresionValor) {
        this.id = id;
        this.expresionIndice = expresionIndice;
        this.expresionValor = expresionValor;
    }
    @Override public void traducirPigLatin() {}
}
