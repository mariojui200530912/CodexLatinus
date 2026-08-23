package pila;

import java.util.ArrayList;
import java.util.List;

public class EstadoPila {
    public List<String> elementosPila;
    public String logOperacion;

    public EstadoPila(List<String> elementos, String operacion) {
        this.elementosPila = new ArrayList<>(elementos);
        this.logOperacion = operacion;
    }
}
