package ast.exp;

import errores.GestorErrores;
import simbolos.TablaSimbolos;
import simbolos.ValidadorTipos;

public class NodoOperacionBinaria extends NodoExpresion {
    public NodoExpresion hijoIzquierdo;
    public String operador;
    public NodoExpresion hijoDerecho;

    public NodoOperacionBinaria(NodoExpresion izq, String op, NodoExpresion der) {
        this.hijoIzquierdo = izq;
        this.operador = op;
        this.hijoDerecho = der;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        hijoIzquierdo.validarSemantica(entornoActual, gestorErrores);
        hijoDerecho.validarSemantica(entornoActual, gestorErrores);

        if (operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/")) {
            this.tipoInferido = ValidadorTipos.inferirTipoAritmetico(hijoIzquierdo.tipoInferido, operador, hijoDerecho.tipoInferido, gestorErrores, this.linea, this.columna);
        } else if (operador.equals("&&") || operador.equals("||")) {
            if (!hijoIzquierdo.tipoInferido.equals("bool") || !hijoDerecho.tipoInferido.equals("bool")) {
                gestorErrores.agregarError("Semántico", "Operadores lógicos requieren booleanos a ambos lados.", this.linea, this.columna);
                this.tipoInferido = "error";
            } else {
                this.tipoInferido = "bool";
            }
        } else {
            this.tipoInferido = ValidadorTipos.inferirTipoRelacional(hijoIzquierdo.tipoInferido, hijoDerecho.tipoInferido, operador, gestorErrores, this.linea, this.columna);
        }
    }

    @Override
    public String traducirPigLatin() {
        return hijoIzquierdo.traducirPigLatin() + " " + operador + " " + hijoDerecho.traducirPigLatin();
    }
}