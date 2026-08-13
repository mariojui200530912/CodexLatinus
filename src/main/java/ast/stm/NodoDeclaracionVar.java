package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;

public class NodoDeclaracionVar extends NodoInstruccion {
    public String id;
    public String tipoDato;
    public NodoAST expresionValor; // Null si no se inicializa

    public NodoDeclaracionVar(String id, String tipoDato, NodoExpresion expresionValor) {
        this.id = id;
        this.tipoDato = tipoDato;
        this.expresionValor = expresionValor;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual) {
        if (expresionValor != null) {
            expresionValor.validarSemantica(entornoActual);

            // Aquí en el futuro verificaremos si expresionValor.tipoInferido es compatible con this.tipoDato
        }

        Simbolo nuevoSimbolo = new Simbolo(this.id, this.tipoDato, "Variable", this.linea, this.columna);

        boolean insertado = entornoActual.insertar(nuevoSimbolo);
        if (!insertado) {
            System.err.println("Error Semántico: La variable '" + this.id + "' ya existe en este contexto. [Linea: " + this.linea + "]");
        }
    }

    @Override public void traducirPigLatin() {}
}