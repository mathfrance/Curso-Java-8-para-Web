/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidade4.com.abctreinamentos;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mathfrance
 */
public class Cliente {
    
    Set <Curso> cursos;
    
    public static void main (String[] args) {
        
        Curso java8 = new Curso("Java8");
        Curso HTML5 = new Curso("HTML5");
        
        Set <Curso> cursosA = new HashSet<>();
        Set <Curso> cursosB = new HashSet<>();
        
        cursosA.add(HTML5);
        cursosA.add(java8);
        
        cursosB.add(HTML5);
        
        //Interseção *Definitivo
        cursosA.retainAll(cursosB);
        System.out.println(cursosA);
        
        //Diferença *Definitivo
        cursosA.removeAll(cursosB);
        System.out.println(cursosA);        
        
        //União *Definitivo
        cursosA.addAll(cursosB);
        System.out.println(cursosA);
        
        
    }
    
}
