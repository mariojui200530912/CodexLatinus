package ast.exp;

import ast.NodoAST;

public class NodoAccesoEstructura extends NodoExpresion {
    public String idEstructura;
    public String idAtributo;

    public NodoAccesoEstructura(String idEstructura, String idAtributo) {
        this.idEstructura = idEstructura;
        this.idAtributo = idAtributo;
    }
    @Override public void traducirPigLatin() {}
}
