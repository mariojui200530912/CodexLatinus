package ast.exp;

import errores.GestorErrores;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;
import simbolos.ValidadorTipos;
import traductor.TraductorPigLatin;

public class NodoLlamadaFuncion extends NodoExpresion {
    public String id;
    public NodoExpresion[] argumentos;
    public int cantArgumentos = 0;

    public NodoLlamadaFuncion(String id, int capacidadArgumentos) {
        this.id = id;
        if (capacidadArgumentos > 0) {
            this.argumentos = new NodoExpresion[capacidadArgumentos];
        }
    }

    public void agregarArgumento(NodoExpresion arg) {
        if (argumentos != null && cantArgumentos < argumentos.length) {
            argumentos[cantArgumentos++] = arg;
        }
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        Simbolo func = entornoActual.buscar(this.id);

        if (func == null || !func.categoria.equals("Funcion")) {
            gestorErrores.agregarError("Semántico","La función '" + this.id + "' no está declarada.", this.linea, this.columna);
            this.tipoInferido = "error";
            return;
        }

        this.tipoInferido = func.tipo != null ? func.tipo : "actio";

        if (this.cantArgumentos != func.cantParametros) {
            gestorErrores.agregarError("Semántico", "La función '" + this.id + "' espera " + func.cantParametros + " argumentos, pero se enviaron " + this.cantArgumentos + ".", this.linea, this.columna);
        }

        int limite = Math.min(this.cantArgumentos, func.cantParametros);
        for (int i = 0; i < limite; i++) {
            argumentos[i].validarSemantica(entornoActual, gestorErrores);
            String tipoEnviado = argumentos[i].tipoInferido;
            String tipoEsperado = func.tiposParametros[i];

            if (!tipoEnviado.equals("error") && !tipoEnviado.equals(tipoEsperado)) {
                int pesoEsperado = ValidadorTipos.obtenerPeso(tipoEsperado);
                int pesoEnviado = ValidadorTipos.obtenerPeso(tipoEnviado);

                if (pesoEsperado > 0 && pesoEnviado > 0) {
                    if (pesoEnviado > pesoEsperado && !tipoEsperado.equals("textum")) {
                        gestorErrores.agregarError("Semántico", "Argumento " + (i+1) + " inválido. No se puede enviar un '" + tipoEnviado + "' a un parámetro '" + tipoEsperado + "' por pérdida de precisión.", this.linea, this.columna);
                    }
                } else if (!tipoEsperado.equals(tipoEnviado)) {
                    gestorErrores.agregarError("Semántico", "Argumento " + (i+1) + " inválido en llamada a '" + this.id + "'. Se esperaba '" + tipoEsperado + "' pero se envió '" + tipoEnviado + "'.", this.linea, this.columna);
                }
            }
        }
    }

    @Override
    public String traducirPigLatin() {
        String codigo = TraductorPigLatin.traducirPalabra(this.id) + "(";
        for (int i = 0; i < cantArgumentos; i++) {
            codigo += argumentos[i].traducirPigLatin();
            if (i < cantArgumentos - 1) codigo += ", ";
        }
        return codigo + ")";
    }
}
