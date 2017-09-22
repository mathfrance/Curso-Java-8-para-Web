/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplina3.VO.PLUS.DAO;

import disciplina3.ClienteApp;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class ClienteDAO {
    static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    static String usuario = "curso_java";
    static String senha = "schema";
    static Connection conexao;
    /**
     * @throws java.sql.SQLException****************************************************************/
     public static void conectar() throws SQLException{
        conexao = DriverManager.getConnection(url, usuario, senha);
         DatabaseMetaData meta = conexao.getMetaData();
        conexao.setAutoCommit(false);
         System.out.println(">>>CONECTADO AO BANCO DE DADOS "+meta.getDatabaseProductVersion());
    }
    /**
     * @throws java.sql.SQLException***************************************************************/
    public static void desconectar() throws SQLException{
        conexao.close();
    }
    /**
     * @throws java.sql.SQLException***************************************************************/
    public static void inserir(Cliente cliente) throws SQLException{
        String sql = "insert into Cliente values ("+cliente.getCpf()+",'"+cliente.getNome()+"', '"+cliente.getEmail()+"')";
        Statement statement = conexao.createStatement();
        statement.execute(sql);
        conexao.commit();
    }
    /** @throws java.sql.SQLException***************************************************************/
    public static Cliente consultar(long cpf) throws SQLException{
        String sql = "Select * from Cliente where cpf="+cpf+"";
        Statement statement =  conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        Cliente cliente = null;
        while (rs.next()){
            cliente = new Cliente(rs.getLong(1), rs.getString(2), rs.getString(3));
        }
        return cliente;
    }
    /*** @throws java.sql.SQLException***************************************************************/
    public static List<Cliente> consultarTodos() throws SQLException{
         String sql = "Select * from Cliente";
        Statement statement =  conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Cliente> clientes = new LinkedList<>();
        while (rs.next()){
            Cliente cliente = new Cliente(rs.getLong(1), rs.getString(2), rs.getString(3)); 
            clientes.add(cliente);
        }
        return clientes;
    }
    /**@throws java.sql.SQLException***************************************************************/
    public static void alterar(Cliente cliente) throws SQLException{
        String sql = "update Cliente set nome ='"+cliente.getNome()+"', email='"+cliente.getEmail()+"' where cpf="+cliente.getCpf();
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
                        List<Cliente> clientes = ClienteDAO.consultarTodos();
                        clientes.forEach(System.out::println);
                        System.out.println("Número total de cliente: "+clientes.size());
                        
                        break;
                    }                        
                    case 2:{ //Consultar Especifico
                        System.out.println("[2] Consultar cliente especifico");
                        System.out.println("Favor informar o CPF: ");
                        cpf = entrada.nextLong();
                        Cliente cliente = ClienteDAO.consultar(cpf);
                        System.out.println(cliente);
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
                        Cliente cliente = new Cliente (cpf, nome, email);
                        ClienteDAO.inserir(cliente);
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
                        Cliente cliente = new Cliente (cpf, nome, email);
                        ClienteDAO.alterar(cliente);
                        break;
                    }
                    case 5:{ // Excluir
                        System.out.println("[5] Excluir um cliente");
                        System.out.println("Favor informar o CPF do cliente a ser excluido: ");
                        cpf = entrada.nextLong();
                        entrada.hasNextLine();
                        ClienteDAO.excluir(cpf);
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
