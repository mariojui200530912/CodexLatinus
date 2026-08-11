package ast.stm;

import ast.NodoAST;

public class NodoFuncion extends NodoAST {
    public String id;
    public String tipoRetorno; // Null si es 'actio' (sin retorno)
    public String[] nombresParametros;
    public String[] tiposParametros;
    public NodoAST[] instrucciones;
    public int cantInstrucciones = 0;

    public NodoFuncion(String id, String tipoRetorno, int capParams, int capInstrucciones) {
        this.id = id;
        this.tipoRetorno = tipoRetorno;
        this.nombresParametros = new String[capParams];
        this.tiposParametros = new String[capParams];
        this.instrucciones = new NodoAST[capInstrucciones];
    }
    @Override public void traducirPigLatin() {}
}
