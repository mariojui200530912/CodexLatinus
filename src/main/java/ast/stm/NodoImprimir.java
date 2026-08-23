package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.TablaSimbolos;

public class NodoImprimir extends NodoInstruccion {
    public NodoExpresion[] expresiones;
    public int contador = 0;

    public NodoImprimir(int capacidad) {
        this.expresiones = new NodoExpresion[capacidad];
    }

    public void agregarExpresion(NodoExpresion exp) {
        if (contador < expresiones.length) {
            expresiones[contador++] = exp;
        }
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

        for (int i = 0; i < contador; i++) {
            instruccion += "%OINK " + expresiones[i].traducirPigLatin() + " ";
        }

        return instruccion.trim() + ";";
    }
}
