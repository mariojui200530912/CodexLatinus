package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import simbolos.TablaSimbolos;

public abstract class NodoInstruccion extends NodoAST {
    @Override
    public abstract void validarSemantica(TablaSimbolos entornoActual);
}
