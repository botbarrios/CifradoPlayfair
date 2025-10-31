package victor.cifradoplayfair;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CifradoPlayfair {
    
    public static void mainEncrypt() {
        Scanner sc = new Scanner(System.in);
        char[] abecedario = {'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        System.out.println("Ingresa una clave:");
        String clave = sc.nextLine();
        System.out.println("Ingresa el mensaje a encriptar:");
        String Mensaje = sc.nextLine();
        
        ArrayList<Character> ClavePrime = encriptarClass.ClaveLetrasUnicas(clave);
        ArrayList<String> MensajePrime = encriptarClass.procesarMensaje(Mensaje);
        ArrayList<Character> Lista = encriptarClass.MatrizPreparada(ClavePrime, abecedario);
        
        char[][] matrix = new char[5][5];
        int cont = 0;
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Lista.get(cont);
                cont++;
            }
        
        
        for(char[] x : matrix) {
            System.out.println();
            for(char y : x) {
                System.out.print(y + " ");
            }
        }
        
        HashMap<Character, int[]> map = new HashMap<>();
        System.out.println("");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                map.put(matrix[i][j], new int[]{i, j});
                int[] a = map.get(matrix[i][j]);
                //System.out.print(matrix[i][j] + " :");
                //System.out.print(Arrays.toString(a)); 
                //System.out.println("");
            }
        }
        
        ArrayList<String> result = new ArrayList<String>();
        for(String par : MensajePrime) {
            result.add(encriptarClass.encriptaPar(par, map, matrix));
        }
        System.out.println("Su mensaje encriptado es: " + result);
    }
    public static void mainDecrypt() {
        Scanner sc = new Scanner(System.in);
        char[] abecedario = {'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        System.out.println("Ingresa una clave:");
        String clave = sc.nextLine();
        System.out.println("Ingresa el mensaje a encriptar:");
        String Mensaje = sc.nextLine();
        
        ArrayList<Character> ClavePrime = decriptarClass.ClaveLetrasUnicas(clave);
        ArrayList<String> MensajePrime = decriptarClass.procesarMensaje(Mensaje);
        ArrayList<Character> Lista = decriptarClass.MatrizPreparada(ClavePrime, abecedario);
        
        char[][] matrix = new char[5][5];
        int cont = 0;
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Lista.get(cont);
                cont++;
            }
        
        
        for(char[] x : matrix) {
            System.out.println();
            for(char y : x) {
                System.out.print(y + " ");
            }
        }
        
        HashMap<Character, int[]> map = new HashMap<>();
        System.out.println("");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                map.put(matrix[i][j], new int[]{i, j});
                int[] a = map.get(matrix[i][j]);
                //System.out.print(matrix[i][j] + " :");
                //System.out.print(Arrays.toString(a)); 
                //System.out.println("");
            }
        }
        
        ArrayList<String> result = new ArrayList<String>();
        for(String par : MensajePrime) {
            result.add(decriptarClass.decriptaPar(par, map, matrix));
        }
        System.out.println("Su mensaje decriptado es: " + result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("CIFRADO PLAYFAIR");
        System.out.println("BY Raul, Ronald");
        System.out.println("and Victor");
        System.out.println("----------------");
        System.out.println("");
        
        boolean corriendo = true;
        while(corriendo) {
            System.out.println("Escoja una opción:");
            System.out.println("1- Encriptar");
            System.out.println("2- Decriptar");
            System.out.println("3- Exit");
            int opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    mainEncrypt();
                    break;
                case 2:
                    mainDecrypt();
                    break;
                default:
                    return;
            }
        }
    }
}