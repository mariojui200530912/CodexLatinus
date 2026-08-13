package ast.exp;

import ast.NodoAST;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;

public class NodoIdentificador extends NodoExpresion {
    public String id;

    public NodoIdentificador(String id) {
        this.id = id;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual) {
        Simbolo sim = entornoActual.buscar(this.id);

        if (sim == null) {
            System.err.println("Error Semántico: La variable '" + this.id + "' no ha sido declarada. [Linea: " + this.linea + "]");
            this.tipoInferido = "error";
        } else {
            this.tipoInferido = sim.tipo;
        }
    }

    @Override public void traducirPigLatin() {}
}