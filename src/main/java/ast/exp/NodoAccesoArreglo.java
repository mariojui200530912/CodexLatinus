package ast.exp;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoAccesoArreglo extends NodoExpresion {
    public String idArreglo;
    public NodoExpresion expresionIndice;

    public NodoAccesoArreglo(String idArreglo, NodoExpresion expresionIndice) {
        this.idArreglo = idArreglo;
        this.expresionIndice = expresionIndice;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        Simbolo arr = entornoActual.buscar(this.idArreglo);
        expresionIndice.validarSemantica(entornoActual, gestorErrores);

        if (arr == null) {
            gestorErrores.agregarError("Semantico","Error: Arreglo '" + this.idArreglo + "' no declarado.", this.linea, this.columna);
            this.tipoInferido = "error";
        } else {
            this.tipoInferido = arr.tipo;
        }
    }

    @Override
    public String traducirPigLatin() {
        return TraductorPigLatin.traducirPalabra(this.idArreglo) + "[" + expresionIndice.traducirPigLatin() + "]";
    }
}
