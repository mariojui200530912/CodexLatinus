package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.TablaSimbolos;

public abstract class NodoInstruccion extends NodoAST {

    public NodoInstruccion(int linea, int columna) {
        super(linea, columna);
    }

    @Override
    public abstract void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores);
}
