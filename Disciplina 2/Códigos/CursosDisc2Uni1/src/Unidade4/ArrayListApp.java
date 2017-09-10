/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidade4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mathfrance
 */
public class ArrayListApp {
    
    public static void main(String[] args){
        
        List<String> lista = new ArrayList<>();
        
        lista.add("Vermelho");
        lista.add("Verde");
        lista.add("Verde");
        lista.add("Amarelo");
        
        Collections.sort(lista); // Ordenação
        
        System.out.println(lista);
    }
}
