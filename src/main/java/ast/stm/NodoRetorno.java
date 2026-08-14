package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoRetorno extends NodoInstruccion {
    public NodoExpresion expresionRetorno;

    public NodoRetorno(NodoExpresion expresionRetorno) {
        this.expresionRetorno = expresionRetorno;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        if (expresionRetorno != null) {
            expresionRetorno.validarSemantica(entornoActual, gestorErrores);
        }
    }

    @Override
    public String traducirPigLatin() {
        String kwReddere = TraductorPigLatin.traducirPalabra("reddere");
        String codigo = kwReddere;
        if (expresionRetorno != null) {
            codigo += " " + expresionRetorno.traducirPigLatin();
        }
        return codigo + ";";
    }
}