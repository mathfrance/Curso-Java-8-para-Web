/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade3;

/**
 *
 * @author mathfrance
 */
public class UsoGenerico2 {
    
    public static void main(String[] args){
        ExemploGenerics2 <String , Integer> obj = new ExemploGenerics2<>("Matheus" , 22);
        obj.showType();
    }
    
}
