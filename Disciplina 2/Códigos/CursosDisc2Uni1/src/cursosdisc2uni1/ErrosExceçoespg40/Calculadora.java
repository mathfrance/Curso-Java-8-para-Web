/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosdisc2uni1.ErrosExceçoespg40;

import java.util.Scanner;


public class Calculadora {
    
    public void dividir(int n1, int n2){
        System.out.println(n1/n2);
    }
    
    public static void main(String[] args) throws ArithmeticException{
        
        Scanner entrada = new Scanner(System.in);
        Calculadora cal = new Calculadora();
        
        System.out.println("Digite n1:");
        int n1 = entrada.nextInt();
        
        System.out.println("Digite n2:");
        int n2 = entrada.nextInt();
        try{
            cal.dividir(n1, n2);
        }
        catch (ArithmeticException e){
            System.out.println("Erro divisão por zero!");
        }
        
    }
    
}
