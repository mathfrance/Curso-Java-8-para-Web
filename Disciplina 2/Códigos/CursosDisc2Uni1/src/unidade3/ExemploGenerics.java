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
public class ExemploGenerics<T> {
    
    T obj;

    public ExemploGenerics(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
    
    public void showType(){
        System.out.println(obj.getClass().getName());
    }
}
