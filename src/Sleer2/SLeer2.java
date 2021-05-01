/*
 * SLeer2.java
 *
 * 
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Sleer2;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class SLeer2 {

    //public static Scanner teclado = new Scanner(System.in);
    public static Scanner teclado = new Scanner(System.in).useDelimiter("\\n");
    //lo que quiere decir useDelimiter: le decimos al tecladoque /n será un cambio de línea

    public static void limpiar() {
        if (teclado.hasNextLine()) {
            teclado.nextLine();
        }
    }//limpiar el buffer del teclado, quitar el intro por ejemplo tras añadir un numérico si luego queremos añadir un string

    // ********************** MÉTODOS SIN PARÁMETRO MENSAJE ********************
    public static String datoString() {
        boolean leido = false;
        String dato = null;
        do {
            dato = null;
            dato = teclado.nextLine();
            if (dato.isEmpty()) {//método de si está vacio
                System.err.println("Error, por favor introduce dato de nuevo...");
            } else {
                leido = true;
            }
        } while (leido == false);
        return dato;
    }

    public static char datoChar() {//El ordenador ve numeros pero nosotros caracteres
        boolean leido = false;
        String dato = null;
        char c = 0;
        do {
            dato = null;
            c = 0;
            dato = datoString();
            if (!dato.isEmpty() && dato.length() < 2) {//si no está vacio y su longitud es menor que 2, es decir de 1 letra.
                c = dato.charAt(0);//coge la primera letra xq en elas palabras se empiezan a contar las letras por 0
                leido = true;
            } else {
                System.err.println("Error, por favor introduce un carácter...");
            }
        } while (leido == false);
        return c;
    }

    public static boolean datoBoolean() {

        boolean leido = false;
        boolean sn = false;
        do {
            sn = false;
            if (teclado.hasNextBoolean()) {
                sn = teclado.nextBoolean();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un valor boolean...");//err: canal de informar de errores (sale el mensaje en rojo
                limpiar();
            }
        } while (leido == false);
        return sn;
    }
    
    public static byte datoByte() {

        boolean leido = false;
        byte num = 0;
        do {
            num = 0;
            if (teclado.hasNextByte()) {
                num = teclado.nextByte();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número byte...");
                limpiar();
            }
        } while (leido == false);
        return num;
    }

    public static short datoShort() {
        boolean leido = false;
        short num = 0;
        do {
            num = 0;
            if (teclado.hasNextShort()) {
                num = teclado.nextShort();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número short...");
                limpiar();
            }
        } while (leido == false);
        return num;
    }

    public static int datoInt() {
        boolean leido = false;
        int num = 0;
        do {
            num = 0;
            if (teclado.hasNextInt()) {
                num = teclado.nextInt();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número int...");
                limpiar();
            }
        } while (leido == false);
        return num;
    }

    ;
  
  
  public static long datoLong() {
        boolean leido = false;
        long num = 0;
        do {
            num = 0;
            if (teclado.hasNextLong()) {
                num = teclado.nextLong();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número long...");
                limpiar();
            }
        } while (leido == false);
        return num;
    }

    public static float datoFloat() {
        boolean leido = false;
        float num = 0;
        do {
            num = 0;
            if (teclado.hasNextFloat()) {
                num = teclado.nextFloat();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número float...");
                limpiar();
            }
        } while (leido == false);
        return num;
    }

    public static double datoDouble() {
        boolean leido = false;
        double num = 0;
        do {
            num = 0;
            if (teclado.hasNextDouble()) {
                num = teclado.nextDouble();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número double...");
                limpiar();
            }

        } while (leido == false);
        return num;
    }

    // ********************** MÉTODOS CON PARÁMETRO MENSAJE ********************
     public static String datoString(String mensaje) {
        boolean leido = false;
        String dato = null;
        do {
            dato = null;
            System.out.print("\n" + mensaje);
            dato = teclado.nextLine().toUpperCase();
            if (dato.isEmpty()) {
                System.err.println("Error, por favor introduce dato de nuevo...");
            } else {
                leido = true;
            }
            
            leido=true;
            
        } while (leido == false);
        return dato;
    }
    
     public static String datoStringContinue(String mensaje) {
        boolean leido = false;
        String dato = null;
        do {
            dato = null;
            System.out.print("\n" + mensaje);
            dato = teclado.nextLine();
            /*if (dato.isEmpty()) {
                System.err.println("Error, por favor introduce dato de nuevo...");
            } else {
                leido = true;
            }*/
            
            leido=true;
            
        } while (leido == false);
        return dato;
    }

    public static char datoChar(String mensaje) {
        boolean leido = false;
        String dato = null;
        char c = 0;
        do {
            dato = null;
            c = 0;
            System.out.print("\n" + mensaje);
            dato = datoString();
            if (!dato.isEmpty() && dato.length() < 2) {
                c = dato.charAt(0);
                leido = true;
            } else {
                System.err.println("Error, por favor introduce un carácter...");
            }
        } while (leido == false);
        return c;
    }

    public static short datoShort(String mensaje) {
        boolean leido = false;
        short num = 0;
        do {
            num = 0;
            System.out.print("\n" + mensaje);
            if (teclado.hasNextShort()) {
                num = teclado.nextShort();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número short...");
                limpiar();
            }
        } while (leido == false);
        return num;
    }

     public static boolean datoBoolean(String mensaje) {

        boolean leido = false;
        boolean sn = false;
        do {
            sn = false;
            System.out.print("\n" + mensaje);
            if (teclado.hasNextBoolean()) {
                sn = teclado.nextBoolean();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número byte...");
                limpiar();
            }
        } while (leido == false);
        return sn;
    }
    public static byte datoByte(String mensaje) {
        boolean leido = false;
        byte num = 0;
        do {
            num = 0;
            System.out.print("\n" + mensaje);
            if (teclado.hasNextByte()) {
                num = teclado.nextByte();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número byte...");
                limpiar();
            }
        } while (leido == false);
        return num;
    }

    public static int datoInt(String mensaje) {
        boolean leido = false;
        int num = 0;
        do {
            num = 0;
            System.out.print("\n" + mensaje);
            if (teclado.hasNextInt()) {
                num = teclado.nextInt();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número int...");
                limpiar();
            }
        } while (leido == false);
        return num;
    }

    ;
  
  
  public static long datoLong(String mensaje) {
        boolean leido = false;
        long num = 0;
        do {
            num = 0;
            System.out.print("\n" + mensaje);
            if (teclado.hasNextLong()) {
                num = teclado.nextLong();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número long...");
                limpiar();
            }
        } while (leido == false);
        return num;
    }

    public static float datoFloat(String mensaje) {
        boolean leido = false;
        float num = 0;
        do {
            num = 0;
            System.out.print("\n" + mensaje);
            if (teclado.hasNextFloat()) {
                num = teclado.nextFloat();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número float...");
                limpiar();
            }
        } while (leido == false);
        return num;
    }

    public static double datoDouble(String mensaje) {
        boolean leido = false;
        double num = 0;
        do {
            num = 0;
            System.out.print("\n" + mensaje);
            if (teclado.hasNextDouble()) {
                num = teclado.nextDouble();
                leido = true;
            } else {
                System.err.println("Error, no has introducido un número double...");
                limpiar();
            }

        } while (leido == false);
        return num;
    }

}
