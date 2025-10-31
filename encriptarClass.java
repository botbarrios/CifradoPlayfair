package victor.cifradoplayfair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class encriptarClass {
    
    public static String procesarLinea(String linea) {
        String res = "";
        linea = linea.toUpperCase();
        
        for(int i = 0; i < linea.length(); i++) {
            switch (linea.charAt(i)) {
                case 'J':
                    res += 'I';
                    break;
                case 'Ñ':
                    res += 'N';
                    break;
                case ' ':
                    break;
                default:
                    if(Character.isAlphabetic(linea.charAt(i))) res += linea.charAt(i);
                    break;
            }
        }
        return res;
    }
    
    public static ArrayList<Character> ClaveLetrasUnicas(String palabra) {
        ArrayList<Character> Clave = new ArrayList<>();
        
        palabra = palabra.toUpperCase();
        String temp = "";
        for(int i = 0; i < palabra.length(); i++) {
            if(Character.isAlphabetic(palabra.charAt(i))) {
                temp += palabra.charAt(i);
            }
        }
        palabra = temp;
        
        for(int i = 0; i < palabra.length(); i++) {
            if(!Clave.contains(palabra.charAt(i)) || i == 0) {
                switch (palabra.charAt(i)) {
                    case 'J':
                        Clave.add('I');
                        break;
                    case 'Ñ':
                        Clave.add('N');
                        break;
                    case ' ':
                        break;
                    default:
                        Clave.add(palabra.charAt(i));
                        break;
                }
            }
        }
        return Clave;
    }
    
    public static ArrayList<String> procesarMensaje(String mensaje) {
        mensaje = procesarLinea(mensaje);
        ArrayList<String> res = new ArrayList<>();
        
        String aux = "";
        for(int i = 0; i < mensaje.length(); i++) {
            if(aux.length() > 0 && aux.length() % 2 != 0 && mensaje.charAt(i - 1) == mensaje.charAt(i)) {
                aux += "X";
            } 
            aux += mensaje.charAt(i);
        }
        
        if(aux.length() % 2 != 0) aux += "X";
        
        String par = "";
        for(int i = 0; i < aux.length(); i++) {
            par += aux.charAt(i);
            if(i % 2 != 0) {
                res.add(par);
                par = "";
            }
        }
        return res;
    }
    
    public static ArrayList<Character> MatrizPreparada(ArrayList<Character> clave, char[] abecedario) {
        ArrayList<Character> Matriz5x5 = new ArrayList<>();
        
        for(int i = 0; i < clave.size(); i++) {
            Matriz5x5.add(clave.get(i));
        }
        
        for(int i = 0; i < abecedario.length; i++) {
            if(!Matriz5x5.contains(abecedario[i]))
                Matriz5x5.add(abecedario[i]);
        }
        return Matriz5x5;
    }
    
    public static String encriptaPar(String par, HashMap<Character, int[]> mapa, char[][] matrix) {
        char a = par.charAt(0);
        char b = par.charAt(1);
        int[] coordsA = mapa.get(a).clone();
        int[] coordsB = mapa.get(b).clone();
        
        System.out.println(par);
        System.out.println(Arrays.toString(coordsA));
        System.out.println(Arrays.toString(coordsB));
        
        if(coordsA[0] == coordsB[0]) { // MISMA FILA
            System.out.println("MISMA FILA");
            coordsA[1]++;
            coordsB[1]++;
            if(coordsA[1] == 5) coordsA[1] = 0;
            if(coordsB[1] == 5) coordsB[1] = 0;
        } else if(coordsA[1] == coordsB[1]) { // MISMA COLUMNA
            System.out.println("MISMA COL");
            coordsA[0]++;
            coordsB[0]++;
            if(coordsA[0] == 5) coordsA[0] = 0;
            if(coordsB[0] == 5) coordsB[0] = 0;    
        } else {
            int temp = coordsA[1];
            coordsA[1] = coordsB[1];
            coordsB[1] = temp;
        }
        
        String res = "";
        res += matrix[coordsA[0]][coordsA[1]];
        res += matrix[coordsB[0]][coordsB[1]];
        return res;
    }
}