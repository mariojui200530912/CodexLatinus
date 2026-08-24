package ast.exp;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoAccesoArreglo extends NodoExpresion {
    public String idArreglo;
    public NodoExpresion expresionIndice;

    public NodoAccesoArreglo(String idArreglo, NodoExpresion expresionIndice, int linea, int columna) {
        super(linea, columna);
        this.idArreglo = idArreglo;
        this.expresionIndice = expresionIndice;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        Simbolo arr = entornoActual.buscar(this.idArreglo);
        expresionIndice.validarSemantica(entornoActual, gestorErrores);

        if (arr == null) {
            gestorErrores.agregarError("Semantico","Error: La variable '" + this.idArreglo + "' no ha sido declarada.", this.linea, this.columna);
            this.tipoInferido = "error";
        } else if (!arr.categoria.equals("Arreglo")) {
            gestorErrores.agregarError("Semantico","Error: La variable '" + this.idArreglo + "' no es un arreglo y no puede ser indexada.", this.linea, this.columna);
            this.tipoInferido = "error";
        } else {
            this.tipoInferido = arr.tipo; // Hereda el tipo base del arreglo (ej. "textum")
        }

        if (!expresionIndice.tipoInferido.equals("error") && !expresionIndice.tipoInferido.equals("numerus")) {
            gestorErrores.agregarError("Semantico", "Error: El índice para acceder al arreglo '" + this.idArreglo + "' debe ser de tipo 'numerus', pero se obtuvo '" + expresionIndice.tipoInferido + "'.", this.linea, this.columna);
        }
    }

    @Override
    public String traducirPigLatin() {
        return TraductorPigLatin.traducirPalabra(this.idArreglo) + "[" + expresionIndice.traducirPigLatin() + "]";
    }
}
