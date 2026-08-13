package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;

public class NodoSi extends NodoInstruccion {
    public NodoExpresion condicion;
    public NodoInstruccion[] instruccionesVerdadero;
    public NodoInstruccion[] instruccionesFalso;
    public int cantVerdadero = 0;
    public int cantFalso = 0;

    public NodoSi(NodoExpresion condicion, int capVerdadero, int capFalso) {
        this.condicion = condicion;
        this.instruccionesVerdadero = new NodoInstruccion[capVerdadero];
        if (capFalso > 0) this.instruccionesFalso = new NodoInstruccion[capFalso];
    }

    public void agregarInstruccionVerdadera(NodoInstruccion inst) {
        if (cantVerdadero < instruccionesVerdadero.length) instruccionesVerdadero[cantVerdadero++] = inst;
    }

    public void agregarInstruccionFalsa(NodoInstruccion inst) {
        if (instruccionesFalso != null && cantFalso < instruccionesFalso.length) instruccionesFalso[cantFalso++] = inst;
    }
    @Override public void traducirPigLatin() {}
}
