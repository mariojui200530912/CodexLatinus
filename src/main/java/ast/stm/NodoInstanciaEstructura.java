package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

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

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        for (int i = 0; i < cantAtributos; i++) {
            expresionesAtributos[i].validarSemantica(entornoActual, gestorErrores);
        }
    }

    @Override
    public String traducirPigLatin() {
        String codigo = "";
        if (tipoEstructura != null) {
            codigo += TraductorPigLatin.traducirPalabra(tipoEstructura) + " ";
        }
        codigo += "{ ";
        for (int i = 0; i < cantAtributos; i++) {
            codigo += TraductorPigLatin.traducirPalabra(nombresAtributos[i]) + " : " + expresionesAtributos[i].traducirPigLatin();
            if (i < cantAtributos - 1) codigo += ", ";
        }
        return codigo + " }";
    }
}