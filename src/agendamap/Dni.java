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
public class Dni {

    private static long numeros;
    private static String letra;
    
        public Dni(long n, String l) {
            
            numeros=n;
            letra=l;
            
        }
        
        public Dni(String sdni){//te dan un dni como String y separas los números en long y la letra
            
            letra= sdni.substring(sdni.length()-1);
            numeros= Long.parseLong(sdni.substring(sdni.length()-1));
          
        }
   
        public long getNumeros(){
            return numeros;
        }
        
        public String getLetra(){
            return letra;
        }
        
        public String toString() {
        return numeros + letra;
    }

    }
    

