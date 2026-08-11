package ast.stm;

import ast.NodoAST;

public class NodoLlamadaFuncion extends NodoAST {
    public String id;
    public NodoAST[] argumentos;
    public int cantArgumentos = 0;

    public NodoLlamadaFuncion(String id, int capacidadArgumentos) {
        this.id = id;
        if (capacidadArgumentos > 0) {
            this.argumentos = new NodoAST[capacidadArgumentos];
        }
    }

    public void agregarArgumento(NodoAST arg) {
        if (argumentos != null && cantArgumentos < argumentos.length) {
            argumentos[cantArgumentos++] = arg;
        }
    }
    @Override public void traducirPigLatin() {}
}
