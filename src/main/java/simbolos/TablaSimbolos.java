package simbolos;

public class TablaSimbolos {
    public Simbolo[] simbolos;
    public int cantidadSimbolos;
    public TablaSimbolos padre;
    public String nombreEntorno; // Ej. "Global", "Funcion calcularPoder", "Bloque SI"
    public String tipoRetornoEsperado = null;

    public TablaSimbolos(int capacidadMaxima, TablaSimbolos padre, String nombreEntorno) {
        this.simbolos = new Simbolo[capacidadMaxima];
        this.cantidadSimbolos = 0;
        this.padre = padre;
        this.nombreEntorno = nombreEntorno;
    }

    public boolean insertar(Simbolo nuevoSimbolo) {
        if (buscarLocal(nuevoSimbolo.id) != null) {
            return false; // Error Semantico: La variable ya está declarada aquí
        }

        if (cantidadSimbolos < simbolos.length) {
            simbolos[cantidadSimbolos] = nuevoSimbolo;
            cantidadSimbolos++;
            return true;
        }

        System.err.println("Error fatal: Desbordamiento de memoria en el entorno " + nombreEntorno);
        return false;
    }

    public Simbolo buscarLocal(String id) {
        for (int i = 0; i < cantidadSimbolos; i++) {
            if (simbolos[i].id.equals(id)) {
                return simbolos[i];
            }
        }
        return null; // No se encontró
    }

    public Simbolo buscar(String id) {
        Simbolo sim = buscarLocal(id);
        if (sim != null) {
            return sim;
        }
        if (padre != null) {
            return padre.buscar(id);
        }
        return null; // Variable no declarada en ningun alcance
    }
}
