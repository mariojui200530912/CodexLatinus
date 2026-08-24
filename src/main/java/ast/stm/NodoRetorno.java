package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import simbolos.ValidadorTipos;
import traductor.TraductorPigLatin;

public class NodoRetorno extends NodoInstruccion {
    public NodoExpresion expresionRetorno;

    public NodoRetorno(NodoExpresion expresionRetorno, int linea, int columna) {
        super(linea, columna);
        this.expresionRetorno = expresionRetorno;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        String tipoEsperado = null;
        boolean dentroDeFuncion = false;
        TablaSimbolos temp = entornoActual;

        while (temp != null) {
            if (temp.nombreEntorno != null && temp.nombreEntorno.startsWith("Funcion")) {
                tipoEsperado = temp.tipoRetornoEsperado;
                dentroDeFuncion = true;
                break;
            }
            temp = temp.padre;
        }

        if (!dentroDeFuncion) {
            gestorErrores.agregarError("Semantico", "La instrucción 'reddere' solo puede usarse dentro de una función (MUNERA).", this.linea, this.columna);
            return;
        }

        if (this.expresionRetorno != null) {
            this.expresionRetorno.validarSemantica(entornoActual, gestorErrores);

            if (tipoEsperado == null) {
                gestorErrores.agregarError("Semantico", "Una función de tipo 'actio' no debe retornar ningún valor.", this.linea, this.columna);
            } else {
                String tipoObtenido = expresionRetorno.tipoInferido;

                if (!tipoObtenido.equals("error") && !tipoObtenido.equals(tipoEsperado)) {

                    if (tipoEsperado.equals("decimalis") && tipoObtenido.equals("numerus")) {
                    }
                    else if (tipoEsperado.equals("numerus") && tipoObtenido.equals("decimalis")) {
                        gestorErrores.agregarError("Semantico", "Pérdida de precisión en el retorno. Se esperaba '" + tipoEsperado + "' pero se obtuvo '" + tipoObtenido + "'.", this.linea, this.columna);
                    }
                    else {
                        gestorErrores.agregarError("Semantico", "Tipo de retorno incorrecto. Se esperaba '" + tipoEsperado + "' pero se retornó '" + tipoObtenido + "'.", this.linea, this.columna);
                    }
                }
            }
        }
    }

    @Override
    public String traducirPigLatin() {
        String kwReddere = TraductorPigLatin.traducirPalabra("reddere");
        String codigo = kwReddere;
        if (expresionRetorno != null) {
            codigo += " " + expresionRetorno.traducirPigLatin();
        }
        return codigo + ";";
    }
}