package ast.stm;

import ast.NodoAST;

public class NodoLeer extends NodoInstruccion {
    public String idDestino; // Puede ser null si solo es '<<' sin variable

    public NodoLeer(String idDestino) {
        this.idDestino = idDestino;
    }

    @Override public void traducirPigLatin() {}
}
