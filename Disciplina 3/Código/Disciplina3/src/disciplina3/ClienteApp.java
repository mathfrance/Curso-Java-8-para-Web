/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplina3;

import static disciplina3.VO.PLUS.DAO.ClienteDAO.desconectar;
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
public class ClienteApp {
    
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
    public static void inserir(long cpf, String nome, String email) throws SQLException{
        String sql = "insert into Cliente values ("+cpf+",'"+nome+"', '"+email+"')";
        Statement statement = conexao.createStatement();
        statement.execute(sql);
        conexao.commit();
    }
    /****************************************************************************************************/
     public static void inserirPS(long cpf, String nome, String email) throws SQLException{ //Usando PreparedStatement
        String sql = "insert into Cliente values (?,?,?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setLong(1, cpf);
        statement.setString(2, nome);        
        statement.setString(3, email);
        statement.executeUpdate();
        conexao.commit();
    }
    /* @throws java.sql.SQLException***********************************************************************************************/
     public static void inserirSP(long cpf, String nome, String email) throws SQLException{ //Usando PreparedStatement
        String sql = "{call sp_inserircliente(?,?,?)}";
        CallableStatement cstmt = conexao.prepareCall(sql);
        cstmt.setLong(1, cpf);
        cstmt.setString(2, nome);        
        cstmt.setString(3, email);
        cstmt.execute();
        conexao.commit();
    }
    /** @throws java.sql.SQLException***************************************************************/
    public static void consultar(long cpf) throws SQLException{
        String sql = "Select * from Cliente where cpf="+cpf+"";
        Statement statement =  conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            System.out.println("");
            System.out.println("CPF: "+rs.getInt(1)+" Nome: "+rs.getString(2)+" Email: "+rs.getString(3));
        }
    }
    /*** @throws java.sql.SQLException***************************************************************/
    public static void consultarTodos() throws SQLException{
         String sql = "Select * from Cliente";
        Statement statement =  conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        int contador = 0; //Pega a qnt de registros
        while (rs.next()){
            System.out.println("CPF: "+rs.getInt(1)+" Nome: "+rs.getString(2)+" Email: "+rs.getString(3));
            System.out.println("*****************************************************************************");
            contador++;
        }
        System.out.println("Número de clientes listados: "+contador);
    }
    /**@throws java.sql.SQLException***************************************************************/
    public static void alterar(long cpf, String nome, String email) throws SQLException{
        String sql = "update Cliente set nome ='"+nome+"', email='"+email+"' where cpf="+cpf;
        Statement statement = conexao.createStatement();
        statement.executeUpdate(sql);
        conexao.commit();
    }
    /*****************************************************************/
    public static void excluir(long cpf) throws SQLException{
        String sql = "delete from Cliente where cpf="+cpf;
        Statement statement = conexao.createStatement();
        statement.executeUpdate(sql);
        conexao.commit();
    }
    /*****************************************************************/
    public static void main(String[] args){
        try {
            conectar();
            Scanner entrada = new Scanner(System.in);
            int opcao = 0;
            long cpf;
            String nome, email;

            while(opcao != 6){
                System.out.println("");
                System.out.println("Sistema Gerenciamento de Clientes");
                System.out.println("==========================================");
                System.out.println("Digite [1] para consultar todos os clientes");
                System.out.println("Digite [2] para consultar um cliente especifico");
                System.out.println("Digite [3] para cadastrar um novo cliente");
                System.out.println("Digite [4] para alterar um cliente");
                System.out.println("Digite [5] para excluir um cliente");
                System.out.println("Digite [6] encerrar o sistema");
                opcao=entrada.nextInt();

                switch (opcao){
                    case 1:{ //Consultar todos
                        System.out.println("[1] Consultar todos:");
                        consultarTodos();  
                        break;
                    }                        
                    case 2:{ //Consultar Especifico
                        System.out.println("[2] Consultar cliente especifico");
                        System.out.println("Favor informar o CPF: ");
                        cpf = entrada.nextLong();
                        consultar(cpf);
                        break;
                    }
                    case 3:{ // Cadastrar
                        System.out.println("[3] Cadastrar um novo cliente");
                        System.out.println("Favor informar o CPF: ");
                        cpf = entrada.nextLong();
                        entrada.nextLine(); //Limpar o Buffer do teclado
                        System.out.println("Favor informar o nome: ");
                        nome = entrada.nextLine();
                        System.out.println("Favor informar o e-mail: ");
                        email = entrada.nextLine();
                        //inserir(cpf, nome, email);
                        //inserirPS(cpf, nome, email); PreparedStatement
                        inserirSP(cpf, nome, email);
                        break;
                    }
                    case 4:{ // Alterar
                        System.out.println("[4] Alterar um cliente");
                        System.out.println("Favor informar o CPF: ");
                        cpf = entrada.nextLong();
                        entrada.nextLine(); //Limpar o Buffer do teclado
                        System.out.println("Favor informar o nome: ");
                        nome = entrada.nextLine();
                        System.out.println("Favor informar o e-mail: ");
                        email = entrada.nextLine();
                        alterar(cpf, nome, email);
                        break;
                    }
                    case 5:{ // Excluir
                        System.out.println("[5] Excluir um cliente");
                        System.out.println("Favor informar o CPF do cliente a ser excluido: ");
                        cpf = entrada.nextLong();
                        entrada.hasNextLine();
                        excluir(cpf);
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
                entrada.close();
                desconectar();
            }
        }catch (SQLException ex) {
            Logger.getLogger(ClienteApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
