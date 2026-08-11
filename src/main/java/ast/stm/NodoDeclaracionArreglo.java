package ast.stm;

import ast.NodoAST;

public class NodoDeclaracionArreglo extends NodoAST {
    public String id;
    public int tamano;
    public String tipoDato;
    public NodoAST[] valoresIniciales; // Arreglo simple para los valores {exp, exp...}
    public int cantValores = 0;

    public NodoDeclaracionArreglo(String id, int tamano, String tipoDato, int capValores) {
        this.id = id;
        this.tamano = tamano;
        this.tipoDato = tipoDato;
        if (capValores > 0) {
            this.valoresIniciales = new NodoAST[capValores];
        }
    }

    public void agregarValorInicial(NodoAST valor) {
        if (valoresIniciales != null && cantValores < valoresIniciales.length) {
            valoresIniciales[cantValores++] = valor;
        }
    }
    @Override public void traducirPigLatin() {}
}