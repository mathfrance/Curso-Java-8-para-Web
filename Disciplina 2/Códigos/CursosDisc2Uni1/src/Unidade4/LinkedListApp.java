/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidade4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author mathfrance
 */
public class LinkedListApp {
    
    public static void main(String[] args){
        
        LinkedList<String> lista = new LinkedList<>(); //FIFO && LIFO
        
        lista.add("Vermelho");
        lista.add("Verde");
        lista.add("Verde");
        lista.add("Amarelo");     
        
        System.out.println(lista);
        lista.removeFirst();
        System.out.println(lista);
        lista.removeLast();
        System.out.println(lista);
        lista.addLast("Preto");
        System.out.println(lista.peekFirst()); // Pega o primeiro
        System.out.println(lista);
    }
    
}
