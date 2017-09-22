/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplina3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class CursoApp {
    static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    static String usuario = "curso_java";
    static String senha = "schema";
    static Connection conexao;
    /**
     * @throws java.sql.SQLException****************************************************************/
     public static void conectar() throws SQLException{
        conexao = DriverManager.getConnection(url, usuario, senha);
        conexao.setAutoCommit(false);
    }
    /**
     * @throws java.sql.SQLException***************************************************************/
    public static void desconectar() throws SQLException{
        conexao.close();
    }
    /**
     * @throws java.sql.SQLException***************************************************************/
    public static void inserir(int codcurso, String nome, double valor, String url) throws SQLException{
        String sql = "insert into Curso values ("+codcurso+",'"+nome+"', "+valor+",'"+url+"')";
        Statement statement = conexao.createStatement();
        statement.execute(sql);
        conexao.commit();
    }
    /****************************************************************************************************/
     public static void inserirPS(int codcurso, String nome, double valor, String url) throws SQLException{ //Usando PreparedStatement
        String sql = "insert into Curso values (?,?,?,?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, codcurso);
        statement.setString(2, nome);        
        statement.setDouble(3, valor);       
        statement.setString(4, url);
        statement.executeUpdate();
        conexao.commit();
    }
    /* @throws java.sql.SQLException***********************************************************************************************/
     public static void inserirSP(int codcurso, String nome, double valor, String url) throws SQLException{ //Usando PreparedStatement
        String sql = "{call sp_inserircurso(?,?,?,?)}";
        CallableStatement cstmt = conexao.prepareCall(sql);
        cstmt.setInt(1, codcurso);
        cstmt.setString(2, nome);        
        cstmt.setDouble(3, valor);
        cstmt.setString(4, url);
        cstmt.execute();
        conexao.commit();
    }
    /** @throws java.sql.SQLException***************************************************************/
    public static void consultar(int codcurso) throws SQLException{
        String sql = "Select * from Curso where CODCURSO="+codcurso+"";
        Statement statement =  conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            System.out.println("");
            System.out.println("Código do Curso: "+rs.getInt(1)+" Nome: "+rs.getString(2)+" Valor: "+rs.getDouble(3)+" Url: "+rs.getString(4));
        }
    }
    /*** @throws java.sql.SQLException***************************************************************/
    public static void consultarTodos() throws SQLException{
         String sql = "Select * from Curso";
        Statement statement =  conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        int contador = 0; //Pega a qnt de registros
        while (rs.next()){
            System.out.println("Código do Curso: "+rs.getInt(1)+" Nome: "+rs.getString(2)+" Valor: "+rs.getDouble(3)+" Url: "+rs.getString(4));
            System.out.println("****************************************************************************************************************");
            contador++;
        }
        System.out.println("Número de cursos listados: "+contador);
    }
    /**@throws java.sql.SQLException***************************************************************/
    public static void alterar(int codcurso, String nome, double valor, String url) throws SQLException{
        String sql = "update Curso set nome ='"+nome+"', valor="+valor+", url='"+url+"' where codcurso="+codcurso;
        Statement statement = conexao.createStatement();
        statement.executeUpdate(sql);
        conexao.commit();
    }
    /*****************************************************************/
    public static void excluir(int codcurso) throws SQLException{
        String sql = "delete from Curso where codcurso="+codcurso;
        Statement statement = conexao.createStatement();
        statement.executeUpdate(sql);
        conexao.commit();
    }
    /*****************************************************************/
    public static void main(String[] args){
        try {
            conectar();
            Scanner entrada = new Scanner(System.in);
            int codcurso , opcao = 0;
            double valor;
            String nome, url;

            while(opcao != 6){
                System.out.println("");
                System.out.println("Sistema Gerenciamento de Cursos");
                System.out.println("==========================================");
                System.out.println("Digite [1] para consultar todos os cursos");
                System.out.println("Digite [2] para consultar um curso especifico");
                System.out.println("Digite [3] para cadastrar um novo curso");
                System.out.println("Digite [4] para alterar um curso");
                System.out.println("Digite [5] para excluir um curso");
                System.out.println("Digite [6] encerrar o sistema");
                opcao=entrada.nextInt();

                switch (opcao){
                    case 1:{ //Consultar todos
                        System.out.println("[1] Consultar todos:");
                        consultarTodos();  
                        break;
                    }                        
                    case 2:{ //Consultar Especifico
                        System.out.println("[2] Consultar curso especifico");
                        System.out.println("Favor informar o Código do Curso: ");
                        codcurso = entrada.nextInt();
                        entrada.nextLine(); // Limpar o Buffer
                        consultar(codcurso);
                        break;
                    }
                    case 3:{ // Cadastrar
                        System.out.println("[3] Cadastrar um novo curso");
                        System.out.println("Favor informar o Código do Curso: ");
                        codcurso = entrada.nextInt();
                        entrada.nextLine(); //Limpar o Buffer do teclado
                        System.out.println("Favor informar o nome: ");
                        nome = entrada.nextLine();
                        System.out.println("Favor informar o valor: ");
                        valor = entrada.nextDouble();
                        entrada.nextLine(); // Limpar o Buffer do teclado
                        System.out.println("Favor informar a URL: ");
                        url = entrada.nextLine();
                        //inserir(codcurso, nome, valor, url);
                        //inserirPS(codcurso, nome, valor, url);// PreparedStatement
                        inserirSP(codcurso, nome, valor, url); // Stored Procedures
                        break;
                    }
                    case 4:{ // Alterar
                        System.out.println("Favor informar o Código do Curso: ");
                        codcurso = entrada.nextInt();
                        entrada.nextLine(); //Limpar o Buffer do teclado
                        System.out.println("Favor informar o nome: ");
                        nome = entrada.nextLine();
                        System.out.println("Favor informar o valor: ");
                        valor = entrada.nextDouble();
                        entrada.nextLine(); // Limpar o Buffer do teclado
                        System.out.println("Favor informar a URL: ");
                        url = entrada.nextLine();
                        alterar(codcurso, nome, valor, url);
                        break;
                    }
                    case 5:{ // Excluir
                        System.out.println("[5] Excluir um cliente");
                        System.out.println("Favor informar o código do curso a ser excluido: ");
                        codcurso = entrada.nextInt();
                        entrada.nextLine();
                        excluir(codcurso);
                        break;
                    }
                    case 6:{ // Sair
                        System.out.println("Encerrando o sistema...");
                        break;
                    }
                    default:{
                        System.out.println("Opção escolhida não identificada, tente novamente");
                        break;
                    }
                }               
            }
            entrada.close();
            desconectar();
        }catch (SQLException ex) {
            Logger.getLogger(ClienteApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
