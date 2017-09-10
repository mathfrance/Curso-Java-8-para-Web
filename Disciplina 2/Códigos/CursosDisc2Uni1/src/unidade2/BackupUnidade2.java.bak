/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidade2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author mathfrance
 */
public class BackupUnidade2 {
    
    public static void main(String[] args) throws IOException{
        Path home = Paths.get("/home/mathfrance/Documentos/Netbeans/CursosDisc2Uni1/src/unidade2");
        String filtro = "*.java";
        DirectoryStream<Path> stream = Files.newDirectoryStream(home, filtro);
        for (Path p: stream ){
            Path txt = home.resolve(p);
            Path backup = home.resolve(p+".bak");
            Files.copy(txt, backup, StandardCopyOption.REPLACE_EXISTING);       
        }
    }
}
