package traductor;

public class TraductorPigLatin {
    public static String traducirPalabra(String original) {
        if (original == null || original.length() == 0) return original;
        if (!Character.isLetter(original.charAt(0))) return original;

        boolean esTodoMayuscula = original.equals(original.toUpperCase());

        char[] caracteres = original.toCharArray();
        int indicePrimeraVocal = -1;

        for (int i = 0; i < caracteres.length; i++) {
            char c = Character.toLowerCase(caracteres[i]);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                indicePrimeraVocal = i;
                break;
            }
        }

        String traduccion = "";

        if (indicePrimeraVocal == 0) {
            traduccion = original + (esTodoMayuscula ? "WAY" : "way");
        } else if (indicePrimeraVocal > 0) {
            String consonantes = original.substring(0, indicePrimeraVocal);
            String resto = original.substring(indicePrimeraVocal);
            traduccion = resto + consonantes + (esTodoMayuscula ? "AY" : "ay");
        } else {
            traduccion = original + (esTodoMayuscula ? "AY" : "ay");
        }

        return traduccion;
    }
}
