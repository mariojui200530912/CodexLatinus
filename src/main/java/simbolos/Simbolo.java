package simbolos;

public class Simbolo {
    public String id;
    public String tipo; // "numerus", "bool", "textum", etc
    public String categoria; // "Variable", "Arreglo", "Funcion", "Struct"
    public int linea;
    public int columna;

    public String[] nombresAtributos;
    public String[] tiposAtributos;
    public int cantAtributos;

    public String[] tiposParametros;
    public int cantParametros;

    public int capacidad = 0;

    public Simbolo(String id, String tipo, String categoria, int linea, int columna) {
        this.id = id;
        this.tipo = tipo;
        this.categoria = categoria;
        this.linea = linea;
        this.columna = columna;
    }

    public void inicializarAtributosStruct(int capacidad) {
        this.nombresAtributos = new String[capacidad];
        this.tiposAtributos = new String[capacidad];
        this.cantAtributos = 0;
    }

    public void agregarAtributoStruct(String nombre, String tipoAtributo) {
        if (nombresAtributos != null && cantAtributos < nombresAtributos.length) {
            nombresAtributos[cantAtributos] = nombre;
            tiposAtributos[cantAtributos] = tipoAtributo;
            cantAtributos++;
        }
    }

    public void inicializarParametrosFuncion(int capacidad) {
        this.tiposParametros = new String[capacidad];
        this.cantParametros = 0;
    }

    public void agregarTipoParametro(String tipo) {
        if (tiposParametros != null && cantParametros < tiposParametros.length) {
            tiposParametros[cantParametros++] = tipo;
        }
    }

    public int getCantidadAtributosStruct() {
        return this.cantAtributos;
    }

    public String getNombreAtributoStruct(int indice) {
        if (nombresAtributos != null && indice >= 0 && indice < cantAtributos) {
            return nombresAtributos[indice];
        }
        return null;
    }

    public String getTipoAtributoStruct(int indice) {
        if (tiposAtributos != null && indice >= 0 && indice < cantAtributos) {
            return tiposAtributos[indice];
        }
        return null;
    }
}
