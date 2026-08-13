package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;

public class NodoInstanciaEstructura extends NodoInstruccion {
    public String tipoEstructura;
    public String[] nombresAtributos;
    public NodoExpresion[] expresionesAtributos;
    public int cantAtributos = 0;

    public NodoInstanciaEstructura(String tipoEstructura, int capacidadAtributos) {
        this.tipoEstructura = tipoEstructura;
        this.nombresAtributos = new String[capacidadAtributos];
        this.expresionesAtributos = new NodoExpresion[capacidadAtributos];
    }

    public void agregarAtributo(String nombre, NodoExpresion expresion) {
        if (cantAtributos < nombresAtributos.length) {
            nombresAtributos[cantAtributos] = nombre;
            expresionesAtributos[cantAtributos] = expresion;
            cantAtributos++;
        }
    }
    @Override public void traducirPigLatin() {}
}