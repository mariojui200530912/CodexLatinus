package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;
import simbolos.ValidadorTipos;
import traductor.TraductorPigLatin;

public class NodoDeclaracionVar extends NodoInstruccion {
    public String id;
    public String tipoDato;
    public NodoExpresion expresionValor; // Null si no se inicializa

    public NodoDeclaracionVar(String id, String tipoDato, NodoExpresion expresionValor, int linea, int columna) {
        super(linea, columna);
        this.id = id;
        this.tipoDato = tipoDato;
        this.expresionValor = expresionValor;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        if (expresionValor != null) {
            expresionValor.validarSemantica(entornoActual, gestorErrores);

            if (!expresionValor.tipoInferido.equals("error")) {
                int pesoDeclarado = ValidadorTipos.obtenerPeso(this.tipoDato);
                int pesoInferido = ValidadorTipos.obtenerPeso(expresionValor.tipoInferido);

                if (pesoDeclarado > 0 && pesoInferido > 0) {
                    if (pesoInferido > pesoDeclarado && !this.tipoDato.equals("textum")) {
                        gestorErrores.agregarError("Semantico", "Error Semántico: No se puede asignar un '" + expresionValor.tipoInferido + "' a una variable '" + this.tipoDato + "' por pérdida de precisión. [Línea: " + linea + "]", this.linea, this.columna);
                    }
                } else if (!this.tipoDato.equals(expresionValor.tipoInferido)) {
                    gestorErrores.agregarError("Semantico", "Error Semántico: Tipo incompatible. Se esperaba '" + this.tipoDato + "' pero se obtuvo '" + expresionValor.tipoInferido + "'. [Línea: " + linea + "]", this.linea, this.columna);
                }
            }
        }

        Simbolo nuevoSimbolo = new Simbolo(this.id, this.tipoDato, "Variable", this.linea, this.columna);

        boolean insertado = entornoActual.insertar(nuevoSimbolo);
        if (!insertado) {
            gestorErrores.agregarError("Semantico", "Error Semántico: La variable '" + this.id + "' ya existe en este contexto. [Linea: " + this.linea + "]", this.linea, this.columna);
        }
    }

    @Override
    public String traducirPigLatin() {
        String tradEsto = TraductorPigLatin.traducirPalabra("esto");
        String tradId = TraductorPigLatin.traducirPalabra(this.id);
        String tradTipo = TraductorPigLatin.traducirPalabra(this.tipoDato);

        String instruccion = tradEsto + " " + tradId + " : " + tradTipo;

        if (expresionValor != null) {
            instruccion += " " + expresionValor.traducirPigLatin();
        }

        return instruccion.trim() + ";";
    }
}