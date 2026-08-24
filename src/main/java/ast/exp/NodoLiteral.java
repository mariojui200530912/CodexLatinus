package ast.exp;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoLiteral extends NodoExpresion {
    public Object valor;
    public String tipoDato;
    public NodoLiteral(Object valor, String tipoDato, int linea, int columna) {
        super(linea, columna);
        this.valor = valor;
        this.tipoDato = tipoDato;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        this.tipoInferido = this.tipoDato;
    }

    @Override
    public String traducirPigLatin(){
        if (tipoDato.equals("textum")) {
            return "\"" + valor.toString() + "\"";
        } else if (tipoDato.equals("littera")) {
            return "'" + valor.toString() + "'";
        }
        // Para bool ("verum", "falsus"), numerus y decimalis
        if (tipoDato.equals("bool")) {
            return TraductorPigLatin.traducirPalabra(valor.toString());
        }
        return valor.toString();
    }

}
