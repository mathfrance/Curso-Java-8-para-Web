/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosdisc2uni1.ErrosExceçoespg40;

public class TesteExceçao {

    public static void main(String[] args) {
        int i = 50;
        try{
            i= i/0;
            System.out.println("O resultado "+i);
            Object c = null;
            System.out.println("O resultado "+ c.toString());
        }
        catch (ArithmeticException | NullPointerException e){
            System.out.println("Erro na execução");;
        }
    }    
}
