package ast.stm;

import ast.NodoAST;

public class NodoSi extends NodoAST {
    public NodoAST condicion;
    public NodoAST[] instruccionesVerdadero;
    public NodoAST[] instruccionesFalso;
    public int cantVerdadero = 0;
    public int cantFalso = 0;

    public NodoSi(NodoAST condicion, int capVerdadero, int capFalso) {
        this.condicion = condicion;
        this.instruccionesVerdadero = new NodoAST[capVerdadero];
        if (capFalso > 0) this.instruccionesFalso = new NodoAST[capFalso];
    }

    public void agregarInstruccionVerdadera(NodoAST inst) {
        if (cantVerdadero < instruccionesVerdadero.length) instruccionesVerdadero[cantVerdadero++] = inst;
    }

    public void agregarInstruccionFalsa(NodoAST inst) {
        if (instruccionesFalso != null && cantFalso < instruccionesFalso.length) instruccionesFalso[cantFalso++] = inst;
    }
    @Override public void traducirPigLatin() {}
}
