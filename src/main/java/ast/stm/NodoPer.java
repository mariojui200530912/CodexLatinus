package ast.stm;

import ast.NodoAST;

public class NodoPer extends NodoAST {
    public NodoDeclaracionVar inicializacion;
    public NodoAST condicion;
    public String idIterador;
    public String operacionIterador; // "++" o "--"
    public NodoAST[] instrucciones;
    public int contador = 0;

    public NodoPer(NodoDeclaracionVar init, NodoAST cond, String id, String opIt, int capacidad) {
        this.inicializacion = init;
        this.condicion = cond;
        this.idIterador = id;
        this.operacionIterador = opIt;
        this.instrucciones = new NodoAST[capacidad];
    }
    @Override public void traducirPigLatin() {}
}