package errores;

public class ErrorAnalisis {
    public String tipo; // "Lexico", "Sintactico", "Semantico"
    public String descripcion;
    public int linea;
    public int columna;

    public ErrorAnalisis(String tipo, String descripcion, int linea, int columna) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "Error " + tipo + " en [" + linea + ":" + columna + "]: " + descripcion;
    }
}
