package ast.stm;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoInterrupcion extends NodoInstruccion {
    public String tipo; // "perge" o "interrumpe"

    public NodoInterrupcion(String tipo, int linea, int columna) {
        super(linea, columna);
        this.tipo = tipo;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        TablaSimbolos temp = entornoActual;
        boolean enCiclo = false;
        while (temp != null) {
            if (temp.nombreEntorno.contains("Ciclo")) {
                enCiclo = true;
                break;
            }
            temp = temp.padre;
        }
        if (!enCiclo) {
            gestorErrores.agregarError("Semantico", "Error: '" + tipo + "' solo permitido dentro de ciclos.", this.linea, this.columna);
        }
    }

    @Override
    public String traducirPigLatin() {
        return TraductorPigLatin.traducirPalabra(this.tipo) + ";";
    }
}
