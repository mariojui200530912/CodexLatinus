package ast.stm;

import ast.NodoAST;
import ast.exp.NodoExpresion;

public class NodoDeclaracionArreglo extends NodoInstruccion {
    public String id;
    public int tamano;
    public String tipoDato;
    public NodoExpresion[] valoresIniciales; // Arreglo simple para los valores {exp, exp...}
    public int cantValores = 0;

    public NodoDeclaracionArreglo(String id, int tamano, String tipoDato, int capValores) {
        this.id = id;
        this.tamano = tamano;
        this.tipoDato = tipoDato;
        if (capValores > 0) {
            this.valoresIniciales = new NodoExpresion[capValores];
        }
    }

    public void agregarValorInicial(NodoExpresion valor) {
        if (valoresIniciales != null && cantValores < valoresIniciales.length) {
            valoresIniciales[cantValores++] = valor;
        }
    }
    @Override public void traducirPigLatin() {}
}