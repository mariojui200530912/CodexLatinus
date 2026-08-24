package ast.stm;

import ast.NodoAST;
import errores.GestorErrores;
import simbolos.Simbolo;
import simbolos.TablaSimbolos;
import traductor.TraductorPigLatin;

public class NodoDefinicionStruct extends NodoInstruccion {
    public String id;
    public String[] nombresAtributos;
    public String[] tiposAtributos;
    public int cantAtributos = 0;

    public NodoDefinicionStruct(String id, int capacidadAtributos, int linea, int columna) {
        super(linea, columna);
        this.id = id;
        this.nombresAtributos = new String[capacidadAtributos];
        this.tiposAtributos = new String[capacidadAtributos];
    }

    public void agregarAtributo(String nombre, String tipo) {
        if (cantAtributos < nombresAtributos.length) {
            nombresAtributos[cantAtributos] = nombre;
            tiposAtributos[cantAtributos] = tipo;
            cantAtributos++;
        }
    }

    @Override
    public void validarSemantica(TablaSimbolos entornoActual, GestorErrores gestorErrores) {
        Simbolo nuevoStruct = new Simbolo(this.id, "structura", "Struct", this.linea, this.columna);
        boolean insertado = entornoActual.insertar(nuevoStruct);

        if (!insertado) {
            gestorErrores.agregarError("Semántico", "La estructura '" + this.id + "' ya fue declarada en este contexto.", this.linea, this.columna);
        }

        nuevoStruct.inicializarAtributosStruct(this.cantAtributos);

        for (int i = 0; i < this.cantAtributos; i++) {
            String nombreAttrActual = this.nombresAtributos[i];
            boolean atributoDuplicado = false;

            for (int j = 0; j < i; j++) {
                if (this.nombresAtributos[j].equals(nombreAttrActual)) {
                    atributoDuplicado = true;
                    break;
                }
            }

            if (atributoDuplicado) {
                gestorErrores.agregarError("Semántico", "El atributo '" + nombreAttrActual + "' está duplicado dentro de la estructura '" + this.id + "'.", this.linea, this.columna);
            } else {
                nuevoStruct.agregarAtributoStruct(nombreAttrActual, this.tiposAtributos[i]);
            }
        }
    }

    @Override
    public String traducirPigLatin() {
        String kwStructura = TraductorPigLatin.traducirPalabra("structura");
        String kwEsto = TraductorPigLatin.traducirPalabra("esto");
        String kwFinis = TraductorPigLatin.traducirPalabra("finis");

        String codigo = kwStructura + " " + TraductorPigLatin.traducirPalabra(this.id) + " {\n";
        for (int i = 0; i < cantAtributos; i++) {
            codigo += "    " + kwEsto + " " + TraductorPigLatin.traducirPalabra(nombresAtributos[i]) + " : " + TraductorPigLatin.traducirPalabra(tiposAtributos[i]);
            if (i < cantAtributos - 1) codigo += ",";
            codigo += "\n";
        }
        return codigo + "} " + kwFinis + ";";
    }
}