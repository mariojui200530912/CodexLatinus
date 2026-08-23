package ast.exp;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoOperacionUnaria extends NodoExpresion {
    public String operador;
    public NodoExpresion expresion;

    public NodoOperacionUnaria(String operador, NodoExpresion expresion) {
        this.operador = operador;
        this.expresion = expresion;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        expresion.validarSemantica(entornoActual, gestorErrores);

        if (operador.equals("non")) {
            if (!expresion.tipoInferido.equals("bool") && !expresion.tipoInferido.equals("error")) {
                gestorErrores.agregarError("Semantico", "Error: Operador 'non' solo es aplicable a valores booleanos.", this.linea, this.columna);
                this.tipoInferido = "error";
            } else {
                this.tipoInferido = "bool";
            }
        } else if (operador.equals("-")) {
            if (!expresion.tipoInferido.equals("numerus") && !expresion.tipoInferido.equals("decimalis") && !expresion.tipoInferido.equals("error")) {
                gestorErrores.agregarError("Semantico", "Error: Operador negativo '-' solo es aplicable a números, se obtuvo '" + expresion.tipoInferido + "'.", this.linea, this.columna);
                this.tipoInferido = "error";
            } else {
                this.tipoInferido = expresion.tipoInferido; // Conserva el tipo numérico original
            }
        } else {
            this.tipoInferido = expresion.tipoInferido;
        }
    }

    @Override
    public String traducirPigLatin() {
        String op = operador.equals("non") ? TraductorPigLatin.traducirPalabra("non") : operador;
        return op + " " + expresion.traducirPigLatin();
    }
}
