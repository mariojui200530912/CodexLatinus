package ast.exp;

public class NodoLlamadaFuncion extends NodoExpresion {
    public String id;
    public NodoExpresion[] argumentos;
    public int cantArgumentos = 0;

    public NodoLlamadaFuncion(String id, int capacidadArgumentos) {
        this.id = id;
        if (capacidadArgumentos > 0) {
            this.argumentos = new NodoExpresion[capacidadArgumentos];
        }
    }

    public void agregarArgumento(NodoExpresion arg) {
        if (argumentos != null && cantArgumentos < argumentos.length) {
            argumentos[cantArgumentos++] = arg;
        }
    }
    @Override public void traducirPigLatin() {}
}
