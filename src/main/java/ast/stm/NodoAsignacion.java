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

    public NodoAsignacion(String id, NodoExpresion expresionIndice, NodoExpresion expresionValor, int linea, int columna) {
        super(linea, columna);
        this.id = id;
        this.expresionIndice = expresionIndice;
        this.expresionValor = expresionValor;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        if (expresionValor != null) {
            expresionValor.validarSemantica(entornoActual, gestorErrores);
        }

        if (this.id.contains(".")) {
            String[] partes = this.id.split("\\.");
            String nombreVarBase = partes[0];
            String nombreAtributo = partes[1];

            Simbolo variableBase = entornoActual.buscar(nombreVarBase);
            if (variableBase == null) {
                gestorErrores.agregarError("Semántico", "Variable base '" + nombreVarBase + "' no declarada.", this.linea, this.columna);
                return;
            }

            Simbolo definicionStruct = entornoActual.buscar(variableBase.tipo);
            if (definicionStruct == null || !definicionStruct.categoria.equals("Struct")) {
                gestorErrores.agregarError("Semántico", "La variable '" + nombreVarBase + "' no es de tipo estructura.", this.linea, this.columna);
                return;
            }

            String tipoAtributoEsperado = null;
            for (int i = 0; i < definicionStruct.getCantidadAtributosStruct(); i++) {
                if (definicionStruct.getNombreAtributoStruct(i).equals(nombreAtributo)) {
                    tipoAtributoEsperado = definicionStruct.getTipoAtributoStruct(i);
                    break;
                }
            }

            if (tipoAtributoEsperado == null) {
                gestorErrores.agregarError("Semántico", "El atributo '" + nombreAtributo + "' no existe en la estructura '" + variableBase.tipo + "'.", this.linea, this.columna);
                return;
            }

            if (!expresionValor.tipoInferido.equals("error") && !tipoAtributoEsperado.equals(expresionValor.tipoInferido)) {
                if (tipoAtributoEsperado.equals("decimalis") && expresionValor.tipoInferido.equals("numerus")) {
                } else if (tipoAtributoEsperado.equals("numerus") && expresionValor.tipoInferido.equals("decimalis")) {
                    gestorErrores.agregarError("Semántico", "Pérdida de precisión al asignar al atributo '" + nombreAtributo + "'.", this.linea, this.columna);
                } else {
                    gestorErrores.agregarError("Semántico", "Tipos incompatibles. No se puede asignar '" + expresionValor.tipoInferido + "' a atributo de tipo '" + tipoAtributoEsperado + "'.", this.linea, this.columna);
                }
            }
            return;
        }

        Simbolo var = entornoActual.buscar(this.id);
        if (var == null) {
            gestorErrores.agregarError("Semantico", "Error Semántico: Intentando asignar a variable no declarada '" + this.id + "'. [Línea: " + linea + "]", this.linea, this.columna);
            return;
        }

        if (expresionIndice != null) {
            expresionIndice.validarSemantica(entornoActual, gestorErrores);

            if (!expresionIndice.tipoInferido.equals("numerus")) {
                gestorErrores.agregarError("Semantico", "Error Semántico: El índice de un arreglo debe ser de tipo 'numerus'. [Línea: " + linea + "]", this.linea, this.columna);
            } else {
                Integer valorIndice = expresionIndice.evaluarEstaticamente();

                if (valorIndice != null) {
                    if (var.capacidad > 0 && (valorIndice < 0 || valorIndice >= var.capacidad)) {
                        gestorErrores.agregarError("Semantico", "Error Semántico: Índice " + valorIndice + " fuera de rango para el arreglo '" + this.id + "' de tamaño " + var.capacidad + ". [Línea: " + linea + "]", this.linea, this.columna);
                    }
                }
            }
        }

        expresionValor.validarSemantica(entornoActual, gestorErrores);

        if (!expresionValor.tipoInferido.equals("error") && !var.tipo.equals(expresionValor.tipoInferido)) {

            if (var.tipo.equals("decimalis") && expresionValor.tipoInferido.equals("numerus")) {
            }
            else if (var.tipo.equals("numerus") && expresionValor.tipoInferido.equals("decimalis")) {
                gestorErrores.agregarError("Semantico", "Error Semántico: No se puede asignar '" + expresionValor.tipoInferido + "' a variable de tipo '" + var.tipo + "' por pérdida de precisión. [Línea: " + linea + "]", this.linea, this.columna);
            }
            else {
                gestorErrores.agregarError("Semantico", "Error Semántico: Tipos incompatibles. No se puede asignar '" + expresionValor.tipoInferido + "' a '" + var.tipo + "'. [Línea: " + linea + "]", this.linea, this.columna);
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
