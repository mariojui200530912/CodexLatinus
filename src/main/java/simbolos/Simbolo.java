package simbolos;

public class Simbolo {
    public String id;
    public String tipo; // "numerus", "bool", "textum", etc
    public String categoria; // "Variable", "Arreglo", "Funcion", "Struct"
    public int linea;
    public int columna;

    public Simbolo(String id, String tipo, String categoria, int linea, int columna) {
        this.id = id;
        this.tipo = tipo;
        this.categoria = categoria;
        this.linea = linea;
        this.columna = columna;
    }
}
