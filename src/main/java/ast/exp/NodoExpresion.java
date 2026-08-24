package ast.exp;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.TablaSimbolos;

public abstract class NodoExpresion extends NodoAST {
    public String tipoInferido= "";

    public NodoExpresion(int linea, int columna) {
        super(linea, columna);
    }

    @Override
    public abstract void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores);

    public Integer evaluarEstaticamente(){
        return null;
    }
}
