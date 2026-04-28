package logic.cesar;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class CesarCipher {
    private static final String ABC_MASTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // CIFRADO NORMAL
    public static String cifrarNormal(String texto) {
        StringBuilder res = new StringBuilder();
        for (char c : texto.toUpperCase().toCharArray()) {
            int pos = ABC_MASTER.indexOf(c);
            if (pos == -1) res.append(c);
            else res.append(ABC_MASTER.charAt((pos + 3) % 26));
        }
        return res.toString();
    }

    // CIFRADO POR POSICIONES
    public static String cifrarPorPosicion(String texto, int n) {
        StringBuilder res = new StringBuilder();
        for (char c : texto.toUpperCase().toCharArray()) {
            int pos = ABC_MASTER.indexOf(c);
            if (pos == -1) res.append(c);
            else res.append(ABC_MASTER.charAt((pos + n) % 26));
        }
        return res.toString();
    }

    // CIFRADO CON CLAVE (ESTRICTO)
    public static String cifrarConClave(String texto, String clave) {
        if (clave == null || clave.isEmpty()) return texto;
        
        String claveLimpia = clave.toUpperCase().replace(" ", "");
        texto = texto.toUpperCase();
        
        // 1. Crear la secuencia sin repeticiones
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : claveLimpia.toCharArray()) {
            if (ABC_MASTER.indexOf(c) != -1) set.add(c);
        }
        for (int i = 0; i < 26; i++) {
            set.add(ABC_MASTER.charAt(i));
        }
        
        ArrayList<Character> lista = new ArrayList<>(set);
        
        // 2. Mapear al alfabeto cifrado (Empezando en D = pos 3)
        char[] mapaCifrado = new char[26];
        for (int i = 0; i < 26; i++) {
            mapaCifrado[(i + 3) % 26] = lista.get(i);
        }

        // 3. Generar resultado
        StringBuilder finalRes = new StringBuilder();
        String mapaStr = new String(mapaCifrado);
        
        for (char c : texto.toCharArray()) {
            int idx = ABC_MASTER.indexOf(c);
            if (idx == -1) finalRes.append(c);
            else finalRes.append(mapaStr.charAt(idx));
        }
        
        return finalRes.toString();
    }
}