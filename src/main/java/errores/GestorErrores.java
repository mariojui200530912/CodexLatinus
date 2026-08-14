package errores;

public class GestorErrores {
    public ErrorAnalisis[] listaErrores;
    public int cantidadErrores;

    public GestorErrores(int capacidadMaxima) {
        this.listaErrores = new ErrorAnalisis[capacidadMaxima];
        this.cantidadErrores = 0;
    }

    public void agregarError(String tipo, String descripcion, int linea, int columna) {
        if (cantidadErrores < listaErrores.length) {
            listaErrores[cantidadErrores] = new ErrorAnalisis(tipo, descripcion, linea, columna);
            cantidadErrores++;
        } else {
            System.err.println("Error Fatal: Desbordamiento en el Gestor de Errores. Capacidad máxima alcanzada.");
        }
    }

    public boolean hayErrores() {
        return cantidadErrores > 0;
    }

    public void limpiarErrores() {
        this.cantidadErrores = 0;
    }

    public String obtenerReporteTexto() {
        if (cantidadErrores == 0) {
            return "Análisis completado sin errores. El código es válido.";
        }

        String reporte = "=== REPORTE DE ERRORES (" + cantidadErrores + ") ===\n";
        for (int i = 0; i < cantidadErrores; i++) {
            reporte += listaErrores[i].toString() + "\n";
        }
        return reporte;
    }
}
