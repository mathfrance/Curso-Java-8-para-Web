/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade2;

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author mathfrance
 */
public class ScannereFormater {
    
    public static void main(String[] args) throws Exception{
        double soma;
        try (Scanner entrada = new Scanner(new FileReader("/home/mathfrance/Documentos/Netbeans/CursosDisc2Uni1/src/unidade2/números.txt"))) {
            soma = 0;
            String valor;
            while (entrada.hasNext()){
                valor = entrada.next(); //Pega a proxima String completa.
                soma= soma+Double.parseDouble(valor);
            }
        }
        System.out.println("A soma do valores é:"+soma);
    }
}
    

