/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosdisc2uni1.ErrosExceçoespg40;

/**
 *
 * @author mathfrance
 */
public class TesteComThrows {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        int i=0;
        String frases [] = {"um", "dois" , "tres"};
        while (i<4){            
            System.out.println(frases[i]);
            i++;
        }
    }
    
}
