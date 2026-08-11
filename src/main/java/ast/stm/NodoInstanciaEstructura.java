package ast.stm;

import ast.NodoAST;

public class NodoInstanciaEstructura extends NodoAST {
    public String tipoEstructura;
    public String[] nombresAtributos;
    public NodoAST[] expresionesAtributos;
    public int cantAtributos = 0;

    public NodoInstanciaEstructura(String tipoEstructura, int capacidadAtributos) {
        this.tipoEstructura = tipoEstructura;
        this.nombresAtributos = new String[capacidadAtributos];
        this.expresionesAtributos = new NodoAST[capacidadAtributos];
    }

    public void agregarAtributo(String nombre, NodoAST expresion) {
        if (cantAtributos < nombresAtributos.length) {
            nombresAtributos[cantAtributos] = nombre;
            expresionesAtributos[cantAtributos] = expresion;
            cantAtributos++;
        }
    }
    @Override public void traducirPigLatin() {}
}