package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoSi extends NodoInstruccion {
    public NodoExpresion condicion;
    public NodoInstruccion[] instruccionesVerdadero;
    public NodoInstruccion[] instruccionesFalso;
    public int cantVerdadero = 0;
    public int cantFalso = 0;

    public NodoSi(NodoExpresion condicion, int capVerdadero, int capFalso) {
        this.condicion = condicion;
        this.instruccionesVerdadero = new NodoInstruccion[capVerdadero];
        if (capFalso > 0) this.instruccionesFalso = new NodoInstruccion[capFalso];
    }

    public void agregarInstruccionVerdadera(NodoInstruccion inst) {
        if (cantVerdadero < instruccionesVerdadero.length) instruccionesVerdadero[cantVerdadero++] = inst;
    }

    public void agregarInstruccionFalsa(NodoInstruccion inst) {
        if (instruccionesFalso != null && cantFalso < instruccionesFalso.length) instruccionesFalso[cantFalso++] = inst;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        condicion.validarSemantica(entornoActual, gestorErrores);
        if (!condicion.tipoInferido.equals("bool")) {
            gestorErrores.agregarError("Semantico", "Error de Corrupción de Flujo: Condición no es booleana.", this.linea, this.columna);
        }

        TablaSimbolos entornoSi = new TablaSimbolos(100, entornoActual, "Bloque SI");
        for (int i = 0; i < cantVerdadero; i++) {
            instruccionesVerdadero[i].validarSemantica(entornoSi, gestorErrores);
        }

        if (instruccionesFalso != null) {
            TablaSimbolos entornoAliter = new TablaSimbolos(100, entornoActual, "Bloque ALITER");
            for (int i = 0; i < cantFalso; i++) {
                instruccionesFalso[i].validarSemantica(entornoAliter,  gestorErrores);
            }
        }
    }

    @Override
    public String traducirPigLatin() {
        String kwSi = TraductorPigLatin.traducirPalabra("si");
        String codigo = kwSi + " " + condicion.traducirPigLatin() + " {\n";

        for (int i = 0; i < cantVerdadero; i++) {
            codigo += "    " + instruccionesVerdadero[i].traducirPigLatin() + "\n";
        }
        codigo += "}";

        if (instruccionesFalso != null && cantFalso > 0) {
            String kwAliter = TraductorPigLatin.traducirPalabra("aliter");
            codigo += " " + kwAliter + " {\n";
            for (int i = 0; i < cantFalso; i++) {
                codigo += "    " + instruccionesFalso[i].traducirPigLatin() + "\n";
            }
            codigo += "}";
        }
        return codigo;
    }
}
