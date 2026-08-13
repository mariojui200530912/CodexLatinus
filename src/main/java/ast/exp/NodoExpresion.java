package ast.exp;

import ast.NodoAST;
import simbolos.TablaSimbolos;

public abstract class NodoExpresion extends NodoAST {
    public String tipoInferido= "";

    @Override
    public abstract void validarSemantica(TablaSimbolos entornoActual);
}
