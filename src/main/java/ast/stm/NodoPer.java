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
    public String operacionIterador; // "++", "--" o "="
    public NodoInstruccion[] instrucciones;
    public int contador = 0;
    public NodoExpresion valorAsignacion;

    public NodoPer(NodoDeclaracionVar inicializacion, NodoExpresion condicion, String idIterador, String incremento, NodoExpresion valorAsignacion, int capInstrucciones, int linea, int columna) {
        super(linea, columna);
        this.inicializacion = inicializacion;
        this.condicion = condicion;
        this.idIterador = idIterador;
        this.operacionIterador = incremento;
        this.instrucciones = new NodoInstruccion[capInstrucciones];
        this.valorAsignacion = valorAsignacion;
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
            gestorErrores.agregarError("Semantico", "Error de Corrupción de Flujo en PER. La condición debe ser booleana.", this.linea, this.columna);
        }

        if (operacionIterador.equals("=") && valorAsignacion != null) {
            valorAsignacion.validarSemantica(entornoPer, gestorErrores);
        }

        for (int i = 0; i < contador; i++) {
            instrucciones[i].validarSemantica(entornoPer, gestorErrores);
        }
    }

    @Override
    public String traducirPigLatin() {
        String kwPer = TraductorPigLatin.traducirPalabra("per");
        String initStr = inicializacion.traducirPigLatin().replace(";", "");
        String iteradorTraducido = TraductorPigLatin.traducirPalabra(idIterador);

        String operacionFinal = "";
        if (operacionIterador.equals("=")) {
            operacionFinal = iteradorTraducido + " = " + valorAsignacion.traducirPigLatin();
        } else {
            operacionFinal = iteradorTraducido + operacionIterador; // ej: i++
        }

        String codigo = kwPer + " (" + initStr + " ; " + condicion.traducirPigLatin() + " ; " + operacionFinal + ") {\n";

        for (int i = 0; i < contador; i++) {
            codigo += "    " + instrucciones[i].traducirPigLatin() + "\n";
        }
        return codigo + "}";
    }
}