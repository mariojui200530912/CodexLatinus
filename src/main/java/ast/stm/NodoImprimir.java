package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.TablaSimbolos;

public class NodoImprimir extends NodoAST {
    public NodoExpresion[] expresiones;
    public int contador = 0;

    public NodoImprimir(int capacidad) {
        this.expresiones = new NodoExpresion[capacidad];
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        for (int i = 0; i < contador; i++) {
            expresiones[i].validarSemantica(entornoActual, gestorErrores);
        }
    }

    @Override
    public String traducirPigLatin() {
        String instruccion = "";

        // Reconstruimos la cadena de impresiones: %OINK expr %OINK expr;
        for (int i = 0; i < contador; i++) {
            instruccion += "%OINK " + expresiones[i].traducirPigLatin() + " ";
        }

        return instruccion.trim() + ";";
    }
}
