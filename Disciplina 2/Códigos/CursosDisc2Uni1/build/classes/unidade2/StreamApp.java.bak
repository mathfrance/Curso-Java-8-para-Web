/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade2;

import java.io.FileInputStream;
import java.util.Scanner;

public class StreamApp {
    
    public static void ByteStream () throws Exception{
        FileInputStream entrada = new FileInputStream("/home/mathfrance/Documentos/Netbeans/CursosDisc2Uni1/src/unidade2/dados.txt");
        int cont = 0;
        int caracter;
        
        while((caracter = entrada.read()) != -1){
            cont++;
        }
        System.out.println("Número de caracteres é:"+cont);
        entrada.close();
    }
    
    public static void CharStream (char letra) throws Exception{
        FileInputStream entrada = new FileInputStream("/home/mathfrance/Documentos/Netbeans/CursosDisc2Uni1/src/unidade2/dados.txt");
        int cont = 0;
        int caracter;
        
        while((caracter = entrada.read()) != -1){
            if (caracter == letra){
                cont++;
            }
        }
        System.out.println("Número de vezes que a letra aparece é:"+cont);
        entrada.close();
    }
    
    public static void main(String[] args){
         try {
             ByteStream();
         }
         catch(Exception e){
                e.printStackTrace();
            }
            
        System.out.println("Qual a letra que deseja ser buscada?");
        try{
            char letra = (char)System.in.read(); 
            CharStream(letra);
        }
        catch(Exception e){
            e.printStackTrace();
        }
     }              
}
        
