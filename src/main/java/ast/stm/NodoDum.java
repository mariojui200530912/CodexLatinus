package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoDum extends NodoInstruccion {
    public NodoExpresion condicion;
    public NodoInstruccion[] instrucciones;
    public int contador = 0;

    public NodoDum(NodoExpresion condicion, int capacidad) {
        this.condicion = condicion;
        this.instrucciones = new NodoInstruccion[capacidad];
    }

    public void agregarInstruccion(NodoInstruccion inst) {
        if (contador < instrucciones.length) instrucciones[contador++] = inst;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        condicion.validarSemantica(entornoActual, gestorErrores);
        if (!condicion.tipoInferido.equals("bool")) {
            gestorErrores.agregarError("Semantico","Error de Corrupción de Flujo en DUM.", this.linea, this.columna);
        }

        TablaSimbolos entornoDum = new TablaSimbolos(100, entornoActual, "Ciclo DUM");
        for (int i = 0; i < contador; i++) {
            instrucciones[i].validarSemantica(entornoDum, gestorErrores);
        }
    }

    @Override
    public String traducirPigLatin() {
        String kwDum = TraductorPigLatin.traducirPalabra("dum");
        String codigo = kwDum + " " + condicion.traducirPigLatin() + " {\n";
        for (int i = 0; i < contador; i++) {
            codigo += "    " + instrucciones[i].traducirPigLatin() + "\n";
        }
        return codigo + "}";
    }
}
