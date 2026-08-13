package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;

public class NodoPer extends NodoInstruccion {
    public NodoDeclaracionVar inicializacion;
    public NodoExpresion condicion;
    public String idIterador;
    public String operacionIterador; // "++" o "--"
    public NodoInstruccion[] instrucciones;
    public int contador = 0;

    public NodoPer(NodoDeclaracionVar init, NodoExpresion cond, String id, String opIt, int capacidad) {
        this.inicializacion = init;
        this.condicion = cond;
        this.idIterador = id;
        this.operacionIterador = opIt;
        this.instrucciones = new NodoInstruccion[capacidad];
    }

    public void agregarInstruccion (NodoInstruccion inst) {
        if (contador < instrucciones.length) {
            instrucciones[contador++] = inst;
        }
    }
    @Override public void traducirPigLatin() {}
}