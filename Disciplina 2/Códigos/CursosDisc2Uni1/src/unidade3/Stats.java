/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade3;

/**
 *
 * @author mathfrance
 * @param <T>
 */
public class Stats<T extends Number> {
    T[] num;

    public Stats(T[] num) {
        this.num = num;
    }

    double media(){
        int i;
        double soma = 0;
        for (i=0; i<num.length; i++){
            soma = soma + num[i].doubleValue();
        }
        return (soma/i);
    }
}
