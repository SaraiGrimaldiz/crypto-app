package logic.cesar;

import java.util.LinkedHashSet;

public class CesarCipher {
    private static final String ABC_CLARO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String cifrarNormal(String texto) {
        return ejecutarDesplazamiento(texto, 3);
    }

    public static String cifrarPorPosicion(String texto, int n) {
        return ejecutarDesplazamiento(texto, n);
    }

    private static String ejecutarDesplazamiento(String texto, int n) {
        StringBuilder res = new StringBuilder();
        for (char c : texto.toUpperCase().toCharArray()) {
            int pos = ABC_CLARO.indexOf(c);
            if (pos == -1) res.append(c);
            else res.append(ABC_CLARO.charAt((pos + n) % 26));
        }
        return res.toString();
    }

    public static String cifrarConClave(String texto, String clave) {
        clave = clave.toUpperCase().replace(" ", "");
        
        // 1. CONSTRUIR TU ALFABETO ESPECIAL EXACTO
        // Secuencia: 'D' + CLAVE + RESTO DEL ABC
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        
        // Primero la D 
        set.add('D'); 
        
        // Luego la clave 
        for (char c : clave.toCharArray()) {
            if (ABC_CLARO.indexOf(c) != -1) set.add(c);
        }
        
        // Luego el resto del abecedario para completar las 26 letras
        for (int i = 0; i < 26; i++) {
            set.add(ABC_CLARO.charAt(i));
        }
        
        // Convertimos el conjunto a un String (Mapa)
        StringBuilder sb = new StringBuilder();
        for (char c : set) sb.append(c);
        String abcCifrado = sb.toString();

        // 2. PROCESO DE SUSTITUCIÓN
        StringBuilder resultado = new StringBuilder();
        for (char c : texto.toUpperCase().toCharArray()) {
            int pos = ABC_CLARO.indexOf(c);
            if (pos == -1) {
                resultado.append(c);
            } else {
                // Buscamos la letra en la misma posición de tu alfabeto especial
                resultado.append(abcCifrado.charAt(pos));
            }
        }
        return resultado.toString();
    }
}