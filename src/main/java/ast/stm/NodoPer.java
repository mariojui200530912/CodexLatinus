package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoPer extends NodoInstruccion {
    public NodoDeclaracionVar inicializacion;
    public NodoExpresion condicion;
    public String idIterador;
    public String operacionIterador; // "++" o "--"
    public NodoInstruccion[] instrucciones;
    public int contador = 0;

    public NodoPer(NodoDeclaracionVar init, NodoExpresion cond, String id, String opIt, int capacidad) {
        this.inicializacion = init;
        this.condicion = cond;
        this.idIterador = id;
        this.operacionIterador = opIt;
        this.instrucciones = new NodoInstruccion[capacidad];
    }

    public void agregarInstruccion (NodoInstruccion inst) {
        if (contador < instrucciones.length) {
            instrucciones[contador++] = inst;
        }
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        TablaSimbolos entornoPer = new TablaSimbolos(100, entornoActual, "Ciclo PER");
        inicializacion.validarSemantica(entornoPer, gestorErrores);
        condicion.validarSemantica(entornoPer, gestorErrores);

        if (!condicion.tipoInferido.equals("bool")) {
            gestorErrores.agregarError("Semantico", "Error de Corrupción de Flujo en PER.", this.linea, this.columna);
        }

        for (int i = 0; i < contador; i++) {
            instrucciones[i].validarSemantica(entornoPer, gestorErrores);
        }
    }

    @Override
    public String traducirPigLatin() {
        String kwPer = TraductorPigLatin.traducirPalabra("per");
        String initStr = inicializacion.traducirPigLatin().replace(";", "");

        String codigo = kwPer + " (" + initStr + " ; " + condicion.traducirPigLatin() + " ; " +
                TraductorPigLatin.traducirPalabra(idIterador) + operacionIterador + ") {\n";

        for (int i = 0; i < contador; i++) {
            codigo += "    " + instrucciones[i].traducirPigLatin() + "\n";
        }
        return codigo + "}";
    }
}