/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidade4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author mathfrance
 */
public class PropertiesApp {
    
    public static void main(String[] args) throws IOException{
        Properties sites = new Properties();
        sites.loadFromXML(new FileInputStream("/home/mathfrance/Documentos/Netbeans/CursosDisc2Uni1/src/Unidade4/sites.xml"));
        System.out.println(sites.getProperty("3"));
        
    }
    
}
