package ast.stm;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoLeer extends NodoInstruccion {
    public String idDestino; // Puede ser null si solo es '<<' sin variable

    public NodoLeer(String idDestino) {
        this.idDestino = idDestino;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        if (idDestino != null) {
            if (entornoActual.buscar(idDestino) == null) {
                gestorErrores.agregarError("Semantico", "Error: Variable '" + idDestino + "' no declarada para lectura.", this.linea, this.columna);
            }
        }
    }

    @Override
    public String traducirPigLatin() {
        String codigo = "%OINK_OINK"; // Ley Porcina de Lectura
        if (idDestino != null) {
            codigo += " " + TraductorPigLatin.traducirPalabra(idDestino);
        }
        return codigo + ";";
    }
}
