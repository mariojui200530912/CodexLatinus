package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoInstanciaEstructura extends NodoExpresion {
    public String tipoEstructura;
    public String[] nombresAtributos;
    public NodoExpresion[] expresionesAtributos;
    public int cantAtributos = 0;

    public NodoInstanciaEstructura(String tipoEstructura, int capacidadAtributos) {
        this.tipoEstructura = tipoEstructura;
        this.nombresAtributos = new String[capacidadAtributos];
        this.expresionesAtributos = new NodoExpresion[capacidadAtributos];
    }

    public void agregarAtributo(String nombre, NodoExpresion expresion) {
        if (cantAtributos < nombresAtributos.length) {
            nombresAtributos[cantAtributos] = nombre;
            expresionesAtributos[cantAtributos] = expresion;
            cantAtributos++;
        }
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        this.tipoInferido = (this.tipoEstructura != null) ? this.tipoEstructura : "EstructuraAnonima";

        for (int i = 0; i < cantAtributos; i++) {
            if (expresionesAtributos[i] != null) {
                expresionesAtributos[i].validarSemantica(entornoActual, gestorErrores);
            }
        }

        Simbolo definicionStruct = entornoActual.buscar(this.tipoEstructura);
        if (definicionStruct == null || !definicionStruct.categoria.equals("Struct")) {
            gestorErrores.agregarError("Semántico", "La estructura '" + this.tipoEstructura + "' no ha sido declarada.", this.linea, this.columna);
            return;
        }

        int totalAtributosDefinidos = definicionStruct.getCantidadAtributosStruct();

        if (this.cantAtributos != totalAtributosDefinidos) {
            gestorErrores.agregarError("Semántico", "La instancia de la estructura '" + this.tipoEstructura + "' tiene " + this.cantAtributos + " atributos, pero se esperaban " + totalAtributosDefinidos + ".", this.linea, this.columna);
        }

        for (int i = 0; i < totalAtributosDefinidos; i++) {
            String nombreOriginal = definicionStruct.getNombreAtributoStruct(i);
            String tipoOriginal = definicionStruct.getTipoAtributoStruct(i);

            int indiceEnInstancia = -1;
            for (int j = 0; j < this.cantAtributos; j++) {
                if (this.nombresAtributos[j].equals(nombreOriginal)) {
                    indiceEnInstancia = j;
                    break;
                }
            }

            if (indiceEnInstancia == -1) {
                gestorErrores.agregarError("Semántico", "Falta el atributo obligatorio '" + nombreOriginal + "' en la instancia de la estructura '" + this.tipoEstructura + "'.", this.linea, this.columna);
            } else {
                String tipoProporcionado = this.expresionesAtributos[indiceEnInstancia].tipoInferido;
                if (!tipoOriginal.equals(tipoProporcionado) && !tipoProporcionado.equals("error")) {
                    gestorErrores.agregarError("Semántico", "El atributo '" + nombreOriginal + "' de la estructura '" + this.tipoEstructura + "' es de tipo '" + tipoOriginal + "', pero se le asignó un valor de tipo '" + tipoProporcionado + "'.", this.linea, this.columna);
                }
            }
        }
    }

    @Override
    public String traducirPigLatin() {
        String codigo = "";
        if (tipoEstructura != null) {
            codigo += TraductorPigLatin.traducirPalabra(tipoEstructura) + " ";
        }
        codigo += "{ ";
        for (int i = 0; i < cantAtributos; i++) {
            codigo += TraductorPigLatin.traducirPalabra(nombresAtributos[i]) + " : " + expresionesAtributos[i].traducirPigLatin();
            if (i < cantAtributos - 1) codigo += ", ";
        }
        return codigo + " }";
    }
}