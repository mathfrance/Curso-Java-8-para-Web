/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidade4;

import java.util.LinkedHashSet;

/**
 *
 * @author mathfrance
 */
public class LinkedHashSetApp {
    
    public static void main(String[] args){
        
        LinkedHashSet<String> lista = new LinkedHashSet<>();
        
        lista.add("Vermelho");
        lista.add("Verde");
        lista.add("Verde");
        lista.add("Amarelo");
        
        System.out.println(lista);
    }
    
}
