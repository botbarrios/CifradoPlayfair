package victor.cifradoplayfair;
import java.util.Scanner;
import java.util.ArrayList;

public class CifradoPlayfair {
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
public static ArrayList <Character> ClaveLetrasUnicas (String palabra){
    
    ArrayList<Character> Clave = new ArrayList <>();
        
    palabra = palabra.toUpperCase();
    //Eliminar caracteres NO alfabeticos
    String temp = "";
    for(int i = 0; i < palabra.length(); i++) {
        if(Character.isAlphabetic(palabra.charAt(i))) {
            temp += palabra.charAt(i);
        }
    }
    palabra = temp;
    for(int i=0; i<palabra.length(); i++){
            if(!Clave.contains(palabra.charAt(i)) || i==0){
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
    
    String aux= "";
    for(int i = 0; i < mensaje.length(); i++) {
        if(aux.length() > 0 && aux.length() % 2 != 0 && mensaje.charAt(i - 1) == mensaje.charAt(i)) {
            aux += "X";
        } 
        aux += mensaje.charAt(i);
        
    }
    System.out.println(aux);
    if(aux.length() % 2 != 0) aux += "X";
    /*
        "abbacxcx"
                i
         "ab",
         "ba",
         "cx",
         "cx"
    */
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
public static ArrayList <Character> MatrizPreparada (ArrayList <Character> clave, char [] abecedario){
    
    ArrayList<Character> Matriz5x5 = new ArrayList <>();
        
      for(int i=0; i<clave.size(); i++){
         Matriz5x5.add(clave.get(i));
        }
        
      for(int i=0; i<abecedario.length; i++){
            if(!Matriz5x5.contains(abecedario[i]))
                Matriz5x5.add(abecedario[i]);
        }
    return Matriz5x5;
}  
    
    public static void main(String[] args) {
        ArrayList<String> test = procesarMensaje("abdabfbbbbIIIIKKKKJJJ");
        System.out.println(test);
        /*
        Scanner sc = new Scanner (System.in);
        char[] abecedario =  {'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        //se pide la clave y el mensaje
        System.out.println("Ingresa una clave:");
        String clave = sc.nextLine();
        System.out.println("Ingresa el mensaje a encriptar:");
        String Mensaje = sc.nextLine();
        
        //se utiliza la funcion para eliminar letras repetidas de la clave
        ArrayList <Character> ClavePrime;
        ClavePrime = ClaveLetrasUnicas(clave);
        System.out.println(ClavePrime);
        
        //se prepara el mensaje para despues procesarlo dentro de la matriz 5x5
        if(Mensaje.length()%2!=0)Mensaje += "x";
        System.out.println(Mensaje);
        char [][] MensajePrime = new char [Mensaje.length()/2][2];
        
        int cont = 0;
        for(int i=0; i<MensajePrime.length; i++)
            for(int j=0; j<MensajePrime[i].length; j++){
               MensajePrime[i][j] = Mensaje.charAt(cont);
              cont++;
            }
       
        cont = 0;
        
        for(char[]x: MensajePrime)
            for(char y: x)
                System.out.println(y);
        
        ArrayList <Character> Lista;
        Lista = MatrizPreparada(ClavePrime, abecedario);
        
        char[][] matrix = new char[5][5];
        
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[i].length; j++){
                matrix[i][j] = Lista.get(cont);
                cont++;
            }
        
        for(char[]x: matrix){
            System.out.println();
            for(char y: x){
                System.out.print(y + " ");
            }
        }
        */
        
    }
}
