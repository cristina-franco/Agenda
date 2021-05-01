/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamap;


/**
 *
 * @author Cristina Franco Esclapez
 */
public class Persona{
    
    private static Dni dni;
    private static String nombre;
    private static long telefono;
    
    public Persona(Dni d, String n, long t){
        dni=d;
        nombre=n;
        telefono=t;
    }
    
    public Persona(Dni d){
        dni=d;
        nombre= null;
        telefono=0;    
    }
    
    public String getDni(){
        return String.valueOf(dni);
    }
    
    public void setDni(Dni d){
        dni=d;
    }
    
    public String getNombre(){
        return nombre.toLowerCase();
    }
    
    public void setNombre(String n){
        nombre=n;
    }
    
    public long getTelefono(){
        return telefono;
    }
    
    public void setTelefono(long t){
        telefono=t;
    }
    
}
