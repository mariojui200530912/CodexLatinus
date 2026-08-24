package ast.stm;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoFuncion extends NodoInstruccion {
    public String id;
    public String tipoRetorno; // Null si es 'actio' (sin retorno)
    public String[] nombresParametros;
    public String[] tiposParametros;
    public NodoInstruccion[] instrucciones;
    public int cantInstrucciones = 0;

    public NodoFuncion(String id, String tipoRetorno, int capParams, int capInstrucciones, int linea, int columna) {
        super(linea, columna);
        this.id = id;
        this.tipoRetorno = tipoRetorno;
        this.nombresParametros = new String[capParams];
        this.tiposParametros = new String[capParams];
        this.instrucciones = new NodoInstruccion[capInstrucciones];
    }

    public void agregarInstruccion(NodoInstruccion nodo) {
        if (cantInstrucciones < instrucciones.length) {
            instrucciones[cantInstrucciones++] = nodo;
        }
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        Simbolo simFunc = new Simbolo(this.id, this.tipoRetorno, "Funcion", this.linea, this.columna);
        simFunc.inicializarParametrosFuncion(nombresParametros.length);

        boolean insertado = entornoActual.insertar(simFunc);
        if (!insertado) {
            gestorErrores.agregarError("Semántico", "La función '" + this.id + "' ya fue declarada.", this.linea, this.columna);
        }

        TablaSimbolos entornoLocal = new TablaSimbolos(200, entornoActual, "Funcion " + this.id);
        entornoLocal.tipoRetornoEsperado = this.tipoRetorno;

        for (int i = 0; i < nombresParametros.length; i++) {
            if (nombresParametros[i] != null) {
                simFunc.agregarTipoParametro(tiposParametros[i]);

                Simbolo paramSim = new Simbolo(nombresParametros[i], tiposParametros[i], "Parametro", this.linea, this.columna);
                boolean paramInsertado = entornoLocal.insertar(paramSim);

                if (!paramInsertado) {
                    gestorErrores.agregarError("Semántico", "El parámetro '" + nombresParametros[i] + "' está duplicado en la función '" + this.id + "'.", this.linea, this.columna);
                }
            }
        }

        boolean tieneRetorno = false;
        String tipoRetornado = null;

        for (int i = 0; i < cantInstrucciones; i++) {
            if (instrucciones[i] != null) {
                instrucciones[i].validarSemantica(entornoLocal, gestorErrores);

                if (instrucciones[i] instanceof NodoRetorno) {
                    tieneRetorno = true;
                    NodoRetorno nodoRet = (NodoRetorno) instrucciones[i];
                    if (nodoRet.expresionRetorno != null) {
                        tipoRetornado = nodoRet.expresionRetorno.tipoInferido;
                    }
                }
            }
        }

        if (this.tipoRetorno != null) {
            if (!tieneRetorno) {
                gestorErrores.agregarError("Semántico", "La función 'ratio' (" + this.id + ") debe tener al menos una instrucción 'reddere' en su cuerpo.", this.linea, this.columna);
            } else if (tipoRetornado != null && !this.tipoRetorno.equals(tipoRetornado) && !tipoRetornado.equals("error")) {
                gestorErrores.agregarError("Semántico", "Tipo de retorno incorrecto en función '" + this.id + "'. Se esperaba '" + this.tipoRetorno + "' pero se intenta retornar '" + tipoRetornado + "'.", this.linea, this.columna);
            }
        } else {
            if (tieneRetorno) {
                gestorErrores.agregarError("Semántico", "La función 'actio' (" + this.id + ") no debe retornar ningún valor.", this.linea, this.columna);
            }
        }
    }

    @Override
    public String traducirPigLatin() {
        String tipo = tipoRetorno != null ? TraductorPigLatin.traducirPalabra("ratio") + " " + TraductorPigLatin.traducirPalabra(tipoRetorno) : TraductorPigLatin.traducirPalabra("actio");
        String codigo = tipo + " " + TraductorPigLatin.traducirPalabra(this.id) + "(";

        String kwEsto = TraductorPigLatin.traducirPalabra("esto");
        for (int i = 0; i < nombresParametros.length; i++) {
            if (nombresParametros[i] != null) {
                codigo += kwEsto + " " + TraductorPigLatin.traducirPalabra(nombresParametros[i]) + " : " + TraductorPigLatin.traducirPalabra(tiposParametros[i]);
                if (i < nombresParametros.length - 1 && nombresParametros[i+1] != null) codigo += ", ";
            }
        }

        codigo += ") {\n";

        for (int i = 0; i < cantInstrucciones; i++) {
            codigo += "    " + instrucciones[i].traducirPigLatin() + "\n";
        }

        String kwFinis = TraductorPigLatin.traducirPalabra("finis");
        return codigo + "} " + kwFinis + ";\n";
    }
}
