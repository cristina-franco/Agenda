/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamap;

import java.util.Comparator;

/**
 *
 * @author Cristina Franco Esclapez
 */
public class ComparadorDniCreciente implements Comparator<Dni> {
    
 public int compare(Dni d1, Dni d2){
     
        int comparacion=(int) (d1.getNumeros()-d2.getNumeros());
            
            if(comparacion==0){
                
                int L1=Integer.parseInt(d1.getLetra());
                int L2=Integer.parseInt(d2.getLetra());
                
                return L1-L2;
                
               //mirar la letra (hay que ordenar por letra (método para saber que la a va antes de la b)
            }
            
        return comparacion; 
    }
}