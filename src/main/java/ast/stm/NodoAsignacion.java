package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;
import simbolos.ValidadorTipos;
import traductor.TraductorPigLatin;

public class NodoAsignacion extends NodoInstruccion {
    public String id;
    public NodoExpresion expresionIndice; // Null si es variable simple, instanciado si es arreglo
    public NodoExpresion expresionValor;

    public NodoAsignacion(String id, NodoExpresion expresionIndice, NodoExpresion expresionValor) {
        this.id = id;
        this.expresionIndice = expresionIndice;
        this.expresionValor = expresionValor;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        Simbolo var = entornoActual.buscar(this.id);
        if (var == null) {
            System.err.println("Error: Intentando asignar a variable no declarada '" + this.id + "'.");
            return;
        }

        if (expresionIndice != null) {
            expresionIndice.validarSemantica(entornoActual, gestorErrores);
            if (!expresionIndice.tipoInferido.equals("numerus")) {
                gestorErrores.agregarError("Semantico", "Error Semántico: El índice de un arreglo debe ser de tipo 'numerus'. [Línea: " + linea + "]", this.linea, this.columna);
            }
        }

        expresionValor.validarSemantica(entornoActual, gestorErrores);
        if (!expresionValor.tipoInferido.equals("error") && !var.tipo.equals(expresionValor.tipoInferido)) {
            int pesoVariable = ValidadorTipos.obtenerPeso(var.tipo);
            int pesoAsignacion = ValidadorTipos.obtenerPeso(expresionValor.tipoInferido);

            if (pesoVariable > 0 && pesoAsignacion > 0) {
                if (pesoAsignacion > pesoVariable && !var.tipo.equals("textum")) {
                    gestorErrores.agregarError("Semantico", "Error Semántico: No se puede asignar '" + expresionValor.tipoInferido + "' a variable de tipo '" + var.tipo + "'. [Línea: " + linea + "]", this.linea, this.columna);
                }
            } else {
                System.err.println("Error Semántico: Asignación de tipos de estructuras incompatibles. [Línea: " + linea + "]");
            }
        }
    }

    @Override
    public String traducirPigLatin() {
        String idTraducido = TraductorPigLatin.traducirPalabra(this.id);
        String codigo = idTraducido;

        if (expresionIndice != null) {
            codigo += "[" + expresionIndice.traducirPigLatin() + "]";
        }
        codigo += " = " + expresionValor.traducirPigLatin() + ";";
        return codigo;
    }
}
