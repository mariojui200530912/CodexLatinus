package ast.exp;

import ast.NodoAST;

public class NodoLiteral extends NodoExpresion {
    public Object valor;
    public String tipoDato;
    public NodoLiteral(Object valor, String tipoDato) {
        this.valor = valor;
        this.tipoDato = tipoDato;
    }
    @Override
    public void traducirPigLatin(){}
}
