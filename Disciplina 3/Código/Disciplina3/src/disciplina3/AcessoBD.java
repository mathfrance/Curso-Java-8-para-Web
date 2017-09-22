/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplina3;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class AcessoBD {

    static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    static String usuario = "curso_java";
    static String senha = "schema";
    static Connection conexao;
    
    public static void conectar() throws SQLException{
        conexao = DriverManager.getConnection(url, usuario, senha);
        conexao.setAutoCommit(false);
    }
    
    public static void consultarCliente() throws SQLException{
        String consulta = "SELECT * FROM Cliente";
        Statement statement = conexao.createStatement();
        ResultSet rs = statement.executeQuery(consulta);
        
        while (rs.next()){
            JOptionPane.showMessageDialog(null,"CPF: "+rs.getInt(1)+" Nome: "+rs.getString(2)+" Email: "+rs.getString(3));
        }
    }
    
    public static void mostrarMetaInfoBD() throws SQLException{
        DatabaseMetaData meta = conexao.getMetaData();
        String fabricanteBD = meta.getDatabaseProductName();
        String versaoBD =meta.getDatabaseProductVersion();
        JOptionPane.showMessageDialog(null, fabricanteBD+"<==>"+versaoBD);
    }
    
    public static void main(String[] args){
        try {
            conectar();
            mostrarMetaInfoBD();
            consultarCliente();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
