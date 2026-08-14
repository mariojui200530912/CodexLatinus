package traductor;

public class TraductorPigLatin {
    public static String traducirPalabra(String original) {
        if (original == null || original.length() == 0) return original;
        if (!Character.isLetter(original.charAt(0))) return original;

        char[] caracteres = original.toCharArray();
        int indicePrimeraVocal = -1;

        for (int i = 0; i < caracteres.length; i++) {
            char c = Character.toLowerCase(caracteres[i]);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                indicePrimeraVocal = i;
                break;
            }
        }

        if (indicePrimeraVocal == 0) {
            return original + "way";
        }else if (indicePrimeraVocal > 0) {
            String consonantes = original.substring(0, indicePrimeraVocal);
            String resto = original.substring(indicePrimeraVocal);
            return resto + consonantes + "ay";
        }

        return original + "ay";
    }
}
