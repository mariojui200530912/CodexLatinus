package ast;

import errores.GestorErrores;
import simbolos.TablaSimbolos;

public abstract class NodoAST {
    public int linea;
    public int columna;

    public abstract void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores);
    public abstract String traducirPigLatin();
}
