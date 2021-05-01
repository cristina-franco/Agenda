/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamap;

import Sleer2.SLeer2;
import java.util.Map;

/**
 *
 * @author crist
 */
public class AgendaTreeMap {

    private static Dni dni;
    private static String nombre;
    private static long telefono;
    private static Agenda ag;
    
    
    /**
     * Este método nos proporciona la lista de las funciones que podemos
     * encontrar en nuestra agenda y seleccionar una de ellas (1-7)
     * @return número de la opción que queremos
     */
    public static int menu() {

        System.out.println("*------------------------------*");
        System.out.println("|         MENÚ AGENDA          |");
        System.out.println("*------------------------------*");
        System.out.println("|   1.- Agregar persona        |");
        System.out.println("|   2.- Buscar persona         |");
        System.out.println("|   3.- Eliminar persona       |");
        System.out.println("|   4.- Modificar persona      |");
        System.out.println("|   5.- Listar agenda          |");
        System.out.println("|   6.- Vaciar agenda          |");
        System.out.println("|   7.- Cerrar agenda          |");
        System.out.println("*------------------------------*");

        int numero = 0;

        do {
            numero = SLeer2.datoInt("¿Qué opción quieres? (0 para salir): ");

            if (numero < 0 || numero > 7) {
                System.out.println("\nValor no válido... introduce otra opción");
            }
        } while (numero < 0 || numero > 7);
        return numero;
    }
    
    /**
     * Método que limpia la pantalla dejándola en blanco (imprime espacios
     * vacíos)
     */
    public static void cls() {

        for (int i = 0; i < 10; i++) {
            System.out.println(" ");
        }
    }
    
    /**
     * Método para pasar a la siguiente operación pulsando intro
     */
    public static void pausa() {

        SLeer2.limpiar();
        SLeer2.datoString("\nPulsa intro para continuar... ");
    }
    
    /*
    pedir nombre-> un nombre es un string que no está vacio y el primer caracter es una letra
    pedir telefono-> son 9 dígitos
    pedir dni-> son 8 dígitos y 1 letra
    no hacer ni cargar ni guardar
    agregar agenda-> pedir dni, pedir nombre, pedir telefono. Si ese dni no lo tenemos se añade correctamente. Llamar a agregar y saca los valores.
                  -> primero pedimos dni y seguidamente lo de agregar. Lo siguiente es el nombre y el telefono y se añade
    
    buscar persona-> pidedni, si existe te da los datos. si no está te dice que no existe
    eliminar persona-> si no existe te aparece que no existe. si existe te da los datos y te dice si quieres eliminarlo si es que no te dice que no se ha eliminado
    modificar-> pedirdni y ver si exite, si existe te da los datos y te dice que valores nuevos quiere. Puedes movificar el nombre y el telefono. Te saldrá por pantalla que se ha modificado correctamente
             -> borra y vuelves a añadir el nuevo
    vaciar-> te pregunta si realmente quieres eliminar todos los datos de la agenda.(poner el total de contactos))
    listar-> llamas a size y pones un contador para que salga los números de contactos.
          -> for(Map.Entry<Dni, Persona> entrada:ag.total()){
                   Persona p = entrada.getValue();
                   System.out...(getnombre..
            }
    
    */
    
    public static void pedirNombre(){
        
        do{
            
        SLeer2.limpiar();
        nombre= SLeer2.datoString("Introduce el nombre: ");
        
        }while(nombre.isEmpty()&& nombre.charAt(0)<64 && nombre.charAt(0)>91);
    }
    
    public static void pedirTelefono(){
        
        String tlf;
        
        do{
            
        telefono= SLeer2.datoLong("Introduce el teléfono: ");
        
        tlf= Long.toString(telefono);
        
        }while(tlf.length()==9);
    }
    
    public static Dni pedirDni(){
        
        String identificacion= SLeer2.datoString("\tIntroduce el Dni: ");
      
        Dni dni= new Dni("identificacion");
        
        boolean leido = false;
        
        do{
            
            if(identificacion.length()==9){
               
                if(dni.getLetra().charAt(identificacion.length()-1)>64 && dni.getLetra().charAt(identificacion.length()-1)<91){//Para controlar la letra (el valor de las letras en la tabla ASCII)
                    
                    leido=true;
                    
                }else{
                
                    System.err.println("El dni tiene que terminar con una letra");
                }
                
            }else{
                System.err.println("El dni ha de tener 9 carácteres");
            }
            
        }while(leido!=true);
        
        return dni;
    }
    
    public static void agregarAgenda(){
     
        pedirDni();
        Persona p = new Persona(dni);
        
        ag.recuperar(dni);
        
        if(p!=null){
            System.out.println("Ya existe este contacto");    
            
            System.out.println("*---CONTACTO---*");  
            System.out.println("\tNombre: " + p.getNombre());
            System.out.println("\tDni: " + p.getDni()); 
            System.out.println("\tTeléfono: " + p.getTelefono());  
            System.out.println("----------------");  
            
        }else{
            pedirNombre();
            pedirTelefono();
            if(ag.agregar(dni, nombre, telefono)==true){
                System.out.println("¡Añadido con exito!");  
            }  
        }
    }
    
    public static void buscarAgenda(){
        
        pedirDni();
        
        Persona p = new Persona(dni);
        
        if(ag.recuperar(dni)==null){
            
            System.out.println("No existe este contacto");
            
        }else{
            
            System.out.println("*---CONTACTO---*");  
            System.out.println("\tNombre: " + p.getNombre());
            System.out.println("\tDni: " + p.getDni()); 
            System.out.println("\tTeléfono: " + p.getTelefono());  
            System.out.println("----------------");  
            
        } 
    }
    
    public static void eliminarAgenda(){
        
        pedirDni();
        
        Persona p = new Persona(dni);
      
        if(ag.recuperar(dni)==null){
           System.out.println("No existe este contacto"); 
        }else{
            
            String respuesta = null;
            respuesta= SLeer2.datoString("¿Estás seguro de que quieres eliminarlo? (si/no) ");

            if (respuesta.equals("si") || respuesta.equals("no")) {
                if (respuesta.equals("si")) {
                    ag.eliminar(dni); 
                    System.out.println("¡Ha sido eliminado correctamente!"); 
            
                } else {
                    System.out.println("No se ha eliminado");
                }
            } else {
                System.out.println("No te he entendido...");
                eliminarAgenda();
            }

        }
     
    }
    
    public static void modificarAgenda(){
        
         pedirDni();
        
        if(ag.recuperar(dni)==null){
            System.out.println("No existe este contacto");
        }else{
            ag.recuperar(dni);
            
            System.out.println("La persona existe, introduce los nuevos valores: ");
            
            Dni dniMof=dni;
            
            ag.eliminar(dni);
            
            Persona p = new Persona(dniMof);

            pedirNombre();
            pedirTelefono();
            
            ag.agregar(dniMof,nombre,telefono);
            
            System.out.println("Se ha modificado correctamente");
        }
        
    }
    
    public static void vaciarAgenda(){
        
        if(ag.estaVacia()==true){
            System.out.println("La agenda está vacía");
        }else{
            
            String respuesta = null;
            respuesta= SLeer2.datoString("¿Seguro que quieres eliminar todos los datos de la agenda? (si/no)");
            
             if (respuesta.equals("si") || respuesta.equals("no")) {
                if (respuesta.equals("si")) {
                    ag.vaciar();
                    System.out.println("¡Agenda vacia!"); 
                } else {
                    System.out.println("No se ha eliminado");
                }
            } else {
                System.out.println("No te he entendido...");
                vaciarAgenda();
            }
        }
    
    }
    
    public static void listarAgenda(){
        
        int contador=0;
        
        System.out.println("Hay un total de " + contador + " contactos: ");
        
        for(Map.Entry<Dni, Persona> entrada:ag.total()){
            
            System.out.println("\nPersona con DNI: " + entrada.getKey());
            System.out.println("\t Datos: " + entrada.getValue());
            contador++;
        }
    }
    
     public static void cerrarAgenda(){
        
         System.out.println("------Agenda cerrada------");
  
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        int numero = 0;
      
        do {

            numero = menu();

            switch (numero) { //Dentro de la opción que hemos elegido nos hará una operación
                case 1:
                    System.out.println("\n####### OPCIÓN AGREGAR PERSONA #######");
                    agregarAgenda();
                    break;
                case 2:
                    System.out.println("\n####### OPCIÓN BUSCAR PERSONA #######");
                    buscarAgenda();break;
                case 3:
                    System.out.println("\n####### OPCIÓN ELIMINAR PERSONA #######");
                    eliminarAgenda();break;
                case 4:
                    System.out.println("\n####### OPCIÓN MODIFICAR PERSONA #######");
                    modificarAgenda();break;
                case 5:
                    System.out.println("\n####### OPCIÓN LISTAR AGENDA #######");
                    listarAgenda();break;
                case 6:
                    System.out.println("\n####### OPCIÓN VACIAR AGENDA #######");
                    vaciarAgenda();break;
                case 7:
                    System.out.println("\n####### OPCIÓN CERRAR AGENDA #######");
                    cerrarAgenda();break;
            }

            pausa();
            cls();
            
            }while(numero!=0);
    }
    
}
