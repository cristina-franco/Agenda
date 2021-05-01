/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamap;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
//clave=dni valor=persona
/**
 *
 * @author Cristina Franco Esclapez
 */

public class Agenda implements java.io.Serializable{
    
    private SortedMap<Dni,Persona> agmap;
    
    public Agenda(){
        
        agmap= new TreeMap <Dni, Persona>(new ComparadorDniCreciente());
        
    }
    
    public boolean agregar(Dni d, String n, long t){
      
        if(agmap.containsKey(d)==true){
            return false;   
        }else{
            
            Persona p = new Persona(d,n,t);
            agmap.put(d,p);
            return true;
        }
        // te devulve true si se puede agregar 
        // para saber si están esos parámetros se llama a containsKey(te devuelve false o true) 
        //if existe tiene que devolver falso, sino se crea un objeto persona con estos datos y se introducen con el método put. Como se han metido se devulve true
        
    }
    
    public boolean eliminar(Dni d){
        
        if(agmap.containsKey(d)==true){
            
            agmap.remove(d);
            return true;
            
        }else{
            
            return false;
        }
        //if te da true llama a remove y devuelve true
        // si no lo tienes da falso y ya
        
    }
    
    public Persona recuperar(Dni d){
        
        if(agmap.containsKey(d)==true){
            
            return agmap.get(d);
        
        }else{
            
            return null;
        }
        
        //primero ver si está o no
        //si está se llama a get que te da el objeto persona
        //si no está devuelves null
      
    }
    
    public boolean vaciar(){
        
        if(estaVacia()==true){
            
            return false;
            
        }else{
            
            agmap.clear();
            return true;
        }
         
        //si está vacia devuelves false
        //si no está vacia llamas a clear y devuelves true
    }
    
    public boolean estaVacia(){
        
        return agmap.isEmpty();
       // utilizas el método que te dice si está vacio o no 
       
    }
    
    public Set<Map.Entry<Dni,Persona>> total(){
       
        //tiene que devolver el mapa 
        return agmap.entrySet();
    }

}
