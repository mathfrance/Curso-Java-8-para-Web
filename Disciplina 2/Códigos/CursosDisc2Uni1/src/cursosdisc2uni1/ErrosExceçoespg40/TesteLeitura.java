/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosdisc2uni1.ErrosExceçoespg40;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteLeitura {
     public static void main(String[] args) {
         byte bytes[] = new byte[10];
        System.out.print("Digite algo: ");
         try {
             System.in.read(bytes);
         } catch (IOException ex) {
             
             ex.printStackTrace();
         }
        System.out.println("\nEco: " + new String(bytes));
     }
    
}
