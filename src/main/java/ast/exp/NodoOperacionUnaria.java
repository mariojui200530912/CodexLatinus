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

        if (operador.equals("non") && !expresion.tipoInferido.equals("bool")) {
            gestorErrores.agregarError("Semantica", "Error: Operador 'non' solo aplicable a booleanos.", this.linea, this.columna);
        }
        this.tipoInferido = expresion.tipoInferido;
    }

    @Override
    public String traducirPigLatin() {
        String op = operador.equals("non") ? TraductorPigLatin.traducirPalabra("non") : operador;
        return op + " " + expresion.traducirPigLatin();
    }
}
