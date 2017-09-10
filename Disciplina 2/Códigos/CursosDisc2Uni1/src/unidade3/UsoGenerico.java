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
public class UsoGenerico {
    
    public static void main(String[] args){
        
        ExemploGenerics<Integer> intObj = new ExemploGenerics<>(16);
        intObj.showType();
        ExemploGenerics<String> StrObj = new ExemploGenerics<>("Matheus");
        StrObj.showType();
        intObj.showType();
    }
}
