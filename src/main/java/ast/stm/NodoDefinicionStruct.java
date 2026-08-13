package ast.stm;

import ast.NodoAST;

public class NodoDefinicionStruct extends NodoInstruccion {
    public String id;
    public String[] nombresAtributos;
    public String[] tiposAtributos;
    public int cantAtributos = 0;

    public NodoDefinicionStruct(String id, int capacidadAtributos) {
        this.id = id;
        this.nombresAtributos = new String[capacidadAtributos];
        this.tiposAtributos = new String[capacidadAtributos];
    }

    public void agregarAtributo(String nombre, String tipo) {
        if (cantAtributos < nombresAtributos.length) {
            nombresAtributos[cantAtributos] = nombre;
            tiposAtributos[cantAtributos] = tipo;
            cantAtributos++;
        }
    }
    @Override public void traducirPigLatin() {}
}