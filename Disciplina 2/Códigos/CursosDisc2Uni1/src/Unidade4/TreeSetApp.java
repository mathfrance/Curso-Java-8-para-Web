/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidade4;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author mathfrance
 */
public class TreeSetApp {
    
    public static void main(String[] args){
        
        Set<String> lista = new TreeSet<>();
        
        lista.add("Vermelho");
        lista.add("Verde");
        lista.add("Verde");
        lista.add("Amarelo");
        
        System.out.println(lista);
    }
    
}
