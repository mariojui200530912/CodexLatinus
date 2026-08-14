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

    public NodoFuncion(String id, String tipoRetorno, int capParams, int capInstrucciones) {
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

        for (int i = 0; i < cantInstrucciones; i++) {
            instrucciones[i].validarSemantica(entornoLocal, gestorErrores);
        }
    }

    @Override
    public String traducirPigLatin() {
        String tipo = tipoRetorno != null ? TraductorPigLatin.traducirPalabra("ratio") + " " + TraductorPigLatin.traducirPalabra(tipoRetorno) : TraductorPigLatin.traducirPalabra("actio");
        String codigo = tipo + " " + TraductorPigLatin.traducirPalabra(this.id) + "(";

        for (int i = 0; i < nombresParametros.length; i++) {
            if (nombresParametros[i] != null) {
                codigo += TraductorPigLatin.traducirPalabra(nombresParametros[i]) + " : " + TraductorPigLatin.traducirPalabra(tiposParametros[i]);
                if (i < nombresParametros.length - 1 && nombresParametros[i+1] != null) codigo += ", ";
            }
        }

        codigo += ") {\n";
        for (int i = 0; i < cantInstrucciones; i++) {
            codigo += "    " + instrucciones[i].traducirPigLatin() + "\n";
        }
        return codigo + "}\n";
    }
}
