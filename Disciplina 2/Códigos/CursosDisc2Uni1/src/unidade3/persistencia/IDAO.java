/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade3.persistencia;

/**
 *
 * @author mathfrance
 * @param <T>
 */
public interface IDAO<T> {
    
      public void create(T entidade);
      public void read(T entidade);
      public void update(T entidade);
      public void delete(T entidade);
}

