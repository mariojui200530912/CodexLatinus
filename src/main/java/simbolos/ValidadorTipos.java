package simbolos;

import errores.GestorErrores;

public class ValidadorTipos {
    public static int obtenerPeso(String tipo) {
        switch (tipo) {
            case "textum": return 5;
            case "decimalis": return 4;
            case "numerus": return 3;
            case "littera": return 2;
            case "bool": return 1;
            default: return 0; // Para structs o tipos no primitivos
        }
    }

    public static String inferirTipoAritmetico(String tipoIzq, String op, String tipoDer, GestorErrores gestor, int linea, int col) {
        if (tipoIzq.equals("error") || tipoDer.equals("error")) return "error";

        int pesoIzq = obtenerPeso(tipoIzq);
        int pesoDer = obtenerPeso(tipoDer);

        if (pesoIzq == 5 || pesoDer == 5) {
            if (op.equals("+")) {
                return "textum";
            } else {
                // REGISTRO DE ERROR A TRAVÉS DEL GESTOR
                gestor.agregarError("Semántico", "El tipo 'textum' solo es compatible con el operador '+' (concatenación).", linea, col);
                return "error";
            }
        }

        int mayorPeso = Math.max(pesoIzq, pesoDer);
        switch (mayorPeso) {
            case 4: return "decimalis";
            case 3: return "numerus";
            case 2: return "littera";
            case 1: return "bool";
            default: return "error";
        }
    }

    public static String inferirTipoRelacional(String tipoIzq, String tipoDer, String operador, GestorErrores gestor, int linea, int col) {
        if (tipoIzq.equals("error") || tipoDer.equals("error")) return "error";

        int pesoIzq = obtenerPeso(tipoIzq);
        int pesoDer = obtenerPeso(tipoDer);

        if (pesoIzq == 0 || pesoDer == 0) {
            if (!tipoIzq.equals(tipoDer)) {
                gestor.agregarError("Semántico", "No se pueden comparar tipos incompatibles: '" + tipoIzq + "' y '" + tipoDer + "'.", linea, col);
                return "error";
            }
            if (!operador.equals("==") && !operador.equals("!=")) {
                gestor.agregarError("Semántico", "Las estructuras '" + tipoIzq + "' solo soportan operadores de igualdad (==, !=).", linea, col);
                return "error";
            }
            return "bool";
        }

        if ((pesoIzq == 5 && pesoDer != 5) || (pesoIzq != 5 && pesoDer == 5)) {
            gestor.agregarError("Semántico", "Operación inválida: No se puede comparar un 'textum' con otros tipos de datos.", linea, col);
            return "error";
        }

        if ((pesoIzq == 1 || pesoDer == 1) && (!operador.equals("==") && !operador.equals("!="))) {
            gestor.agregarError("Semántico", "Los tipos 'bool' solo pueden compararse usando igualdad (==, !=).", linea, col);
            return "error";
        }

        return "bool";
    }
}
