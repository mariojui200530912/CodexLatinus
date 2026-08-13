package ast;

import simbolos.TablaSimbolos;

public abstract class NodoAST {
    public int linea;
    public int columna;

    public abstract void validarSemantica(TablaSimbolos entornoActual);
    public abstract void traducirPigLatin();
}
