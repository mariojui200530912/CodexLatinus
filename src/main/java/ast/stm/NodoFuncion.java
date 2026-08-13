package ast.stm;

import ast.NodoAST;

public class NodoFuncion extends NodoInstruccion {
    public String id;
    public String tipoRetorno; // Null si es 'actio' (sin retorno)
    public String[] nombresParametros;
    public String[] tiposParametros;
    public NodoInstruccion[] instrucciones;
    public int cantInstrucciones = 0;

    public NodoFuncion(String id, String tipoRetorno, int capParams, int capInstrucciones) {
        this.id = id;
        this.tipoRetorno = tipoRetorno;
        this.nombresParametros = new String[capParams];
        this.tiposParametros = new String[capParams];
        this.instrucciones = new NodoInstruccion[capInstrucciones];
    }

    public void agregarInstruccion(NodoInstruccion nodo) {
        if (cantInstrucciones < instrucciones.length) {
            instrucciones[cantInstrucciones++] = nodo;
        }
    }
    @Override public void traducirPigLatin() {}
}
