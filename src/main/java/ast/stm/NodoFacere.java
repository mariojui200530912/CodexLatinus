package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoFacere extends NodoInstruccion {
    public NodoInstruccion[] instrucciones;
    public NodoExpresion condicion;
    public int contador = 0;

    public NodoFacere(int capacidad, NodoExpresion condicion) {
        this.instrucciones = new NodoInstruccion[capacidad];
        this.condicion = condicion;
    }

    public void agregarInstruccion (NodoInstruccion inst) {
        if (contador < instrucciones.length) {
            instrucciones[contador++] = inst;
        }
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        TablaSimbolos entornoFacere = new TablaSimbolos(100, entornoActual, "Ciclo FACERE");
        for (int i = 0; i < contador; i++) {
            instrucciones[i].validarSemantica(entornoFacere, gestorErrores);
        }

        condicion.validarSemantica(entornoActual, gestorErrores);
        if (!condicion.tipoInferido.equals("bool")) {
            gestorErrores.agregarError("Semantico", "Error de Corrupción de Flujo en FACERE.", this.linea, this.columna);
        }
    }

    @Override
    public String traducirPigLatin() {
        String kwFacere = TraductorPigLatin.traducirPalabra("facere");
        String kwDum = TraductorPigLatin.traducirPalabra("dum");

        String codigo = kwFacere + " {\n";
        for (int i = 0; i < contador; i++) {
            codigo += "    " + instrucciones[i].traducirPigLatin() + "\n";
        }

        codigo += "} " + kwDum + " (" + condicion.traducirPigLatin() + ");";
        return codigo;
    }
}