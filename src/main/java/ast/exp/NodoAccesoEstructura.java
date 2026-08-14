package ast.exp;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoAccesoEstructura extends NodoExpresion {
    public String idEstructura;
    public String idAtributo;

    public NodoAccesoEstructura(String idEstructura, String idAtributo) {
        this.idEstructura = idEstructura;
        this.idAtributo = idAtributo;
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        Simbolo structVar = entornoActual.buscar(this.idEstructura);

        if (structVar == null) {
            gestorErrores.agregarError("Semantico", "Error Semántico: Variable de estructura '" + this.idEstructura + "' no declarada. [Línea: " + linea + "]", this.linea, this.columna);
            this.tipoInferido = "error";
            return;
        }

        Simbolo definicionStruct = entornoActual.buscar(structVar.tipo);
        if (definicionStruct == null || !definicionStruct.categoria.equals("Struct")) {
            gestorErrores.agregarError("Semantico","Error Fatal: La estructura original '" + structVar.tipo + "' no se encuentra en memoria. [Línea: " + linea + "]", this.linea, this.columna);
            this.tipoInferido = "error";
            return;
        }

        boolean atributoEncontrado = false;
        for (int i = 0; i < definicionStruct.cantAtributos; i++) {
            if (definicionStruct.nombresAtributos[i].equals(this.idAtributo)) {
                this.tipoInferido = definicionStruct.tiposAtributos[i];
                atributoEncontrado = true;
                break;
            }
        }

        if (!atributoEncontrado) {
            gestorErrores.agregarError("Semantico","Error Semántico: El atributo '" + this.idAtributo + "' no existe en la estructura '" + structVar.tipo + "'. [Línea: " + linea + "]",this.linea, this.columna);
            this.tipoInferido = "error";
        }
    }

    @Override
    public String traducirPigLatin() {
        return TraductorPigLatin.traducirPalabra(this.idEstructura) + "." + TraductorPigLatin.traducirPalabra(this.idAtributo);
    }
}
