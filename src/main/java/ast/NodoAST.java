package ast;

import errores.GestorErrores;
import simbolos.TablaSimbolos;

public abstract class NodoAST {
    public int linea;
    public int columna;

    public NodoAST(int linea, int columna) {
        this.linea = linea;
        this.columna = columna;
    }

    public abstract void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores);
    public abstract String traducirPigLatin();
}
