package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;
import simbolos.ValidadorTipos;
import traductor.TraductorPigLatin;

public class NodoDeclaracionArreglo extends NodoInstruccion {
    public String id;
    public int tamano;
    public String tipoDato;
    public NodoExpresion[] valoresIniciales; // Arreglo simple para los valores {exp, exp...}
    public int cantValores = 0;

    public NodoDeclaracionArreglo(String id, int tamano, String tipoDato, int capValores, int linea, int columna) {
        super(linea, columna);
        this.id = id;
        this.tamano = tamano;
        this.tipoDato = tipoDato;
        if (capValores > 0) {
            this.valoresIniciales = new NodoExpresion[capValores];
        }
    }

    public void agregarValorInicial(NodoExpresion valor) {
        if (valoresIniciales != null && cantValores < valoresIniciales.length) {
            valoresIniciales[cantValores++] = valor;
        }
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        Simbolo nuevoArr = new Simbolo(this.id, this.tipoDato, "Arreglo", this.linea, this.columna);
        nuevoArr.capacidad = this.tamano;
        boolean insertado = entornoActual.insertar(nuevoArr);

        if (!insertado) {
            gestorErrores.agregarError("Semántico", "El arreglo '" + this.id + "' ya fue declarado en este contexto.", this.linea, this.columna);
        }

        if (this.cantValores > this.tamano) {
            gestorErrores.agregarError("Semántico", "Desbordamiento: El arreglo '" + this.id + "' es de tamaño " + this.tamano + " pero se le intentan asignar " + this.cantValores + " valores.", this.linea, this.columna);
        }

        for (int i = 0; i < cantValores; i++) {
            valoresIniciales[i].validarSemantica(entornoActual, gestorErrores);

            String tipoInferido = valoresIniciales[i].tipoInferido;

            if (!tipoInferido.equals("error")) {
                int pesoDeclarado = ValidadorTipos.obtenerPeso(this.tipoDato);
                int pesoInferido = ValidadorTipos.obtenerPeso(tipoInferido);

                if (pesoDeclarado > 0 && pesoInferido > 0) {
                    if (pesoInferido > pesoDeclarado && !this.tipoDato.equals("textum")) {
                        gestorErrores.agregarError("Semántico", "Pérdida de precisión en el índice " + i + ". No se puede asignar un '" + tipoInferido + "' a un arreglo de '" + this.tipoDato + "'.", this.linea, this.columna);
                    }
                }
                else if (!this.tipoDato.equals(tipoInferido)) {
                    gestorErrores.agregarError("Semántico", "Tipo incompatible en el índice " + i + " del arreglo. Se esperaba '" + this.tipoDato + "' pero se obtuvo '" + tipoInferido + "'.", this.linea, this.columna);
                }
            }
        }
    }

    @Override
    public String traducirPigLatin() {
        String kwSeries = TraductorPigLatin.traducirPalabra("series");
        String codigo = kwSeries + " " + TraductorPigLatin.traducirPalabra(this.id) + "[" + this.tamano + "] : " + TraductorPigLatin.traducirPalabra(this.tipoDato);

        if (cantValores > 0) {
            codigo += " {";
            for (int i = 0; i < cantValores; i++) {
                codigo += valoresIniciales[i].traducirPigLatin();
                if (i < cantValores - 1) codigo += ", ";
            }
            codigo += "}";
        }
        return codigo + ";";
    }
}