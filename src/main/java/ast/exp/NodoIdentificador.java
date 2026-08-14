package ast.exp;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoIdentificador extends NodoExpresion {
    public String id;

    public NodoIdentificador(String id) {
        this.id = id;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        Simbolo sim = entornoActual.buscar(this.id);

        if (sim == null) {
            gestorErrores.agregarError("Semantico", "Error Semántico: La variable '" + this.id + "' no ha sido declarada. [Linea: " + this.linea + "]", this.linea, this.columna);
            this.tipoInferido = "error";
        } else {
            this.tipoInferido = sim.tipo;
        }
    }

    @Override
    public String traducirPigLatin() {
        return TraductorPigLatin.traducirPalabra(this.id);
    }
}