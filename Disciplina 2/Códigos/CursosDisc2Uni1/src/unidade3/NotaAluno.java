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
public class NotaAluno {
    
    double valor;
    
    <T extends Number> NotaAluno (T obj){
        valor = obj.doubleValue();
    }
    
    <T extends Number>double retornarValor (T obj){
        return obj.doubleValue();
    }
}
