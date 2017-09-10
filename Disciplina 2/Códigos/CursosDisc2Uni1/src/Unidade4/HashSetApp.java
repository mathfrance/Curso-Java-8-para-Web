/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidade4;

import java.util.HashSet;

/**
 *
 * @author mathfrance
 */
public class HashSetApp {
    
    public static void main(String[] args){
        
        HashSet<String> lista = new HashSet<>();
        
        lista.add("Vermelho");
        lista.add("Verde");
        lista.add("Verde");
        lista.add("Amarelo");
        
        System.out.println(lista);
    }
    
}
