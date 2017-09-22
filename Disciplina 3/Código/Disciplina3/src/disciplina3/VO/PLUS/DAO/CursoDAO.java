/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplina3.VO.PLUS.DAO;

import disciplina3.ClienteApp;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
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
public class CursoDAO {
    
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
    public static void inserir(Curso curso) throws SQLException{
        String sql = "insert into Curso values ("+curso.getCodcurso()+",'"+curso.getNome()+"', "+curso.getValor()+" , '"+curso.getUrl()+"')";
        Statement statement = conexao.createStatement();
        statement.execute(sql);
        conexao.commit();
    }
    /** @throws java.sql.SQLException***************************************************************/
    public static Curso consultar(int codcurso) throws SQLException{
        String sql = "Select * from Curso where CODCURSO="+codcurso+"";
        Statement statement =  conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        Curso curso = null;
        while (rs.next()){
            curso = new Curso(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
        }
        return curso;
    }
    /*** @throws java.sql.SQLException***************************************************************/
    public static List<Curso> consultarTodos() throws SQLException{
         String sql = "Select * from Curso";
        Statement statement =  conexao.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Curso> cursos = new LinkedList<>();
        while (rs.next()){
            Curso curso = new Curso(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4)); 
            cursos.add(curso);
        }
        return cursos;
    }
    /**@throws java.sql.SQLException***************************************************************/
    public static void alterar(Curso curso) throws SQLException{
        String sql = "update Curso set nome ='"+curso.getNome()+"', valor="+curso.getValor()+", url='"+curso.getUrl()+"' where codcurso="+curso.getCodcurso();
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
            int opcao = 0, codcurso;
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
                        List<Curso> cursos = CursoDAO.consultarTodos();
                        cursos.forEach(System.out::println);
                        System.out.println("Número total de cursos: "+cursos.size());                        
                        break;
                    }                        
                    case 2:{ //Consultar Especifico
                        System.out.println("[2] Consultar curso especifico");
                        System.out.println("Favor informar o Código do curso: ");
                        codcurso = entrada.nextInt();
                        Curso curso = CursoDAO.consultar(codcurso);
                        System.out.println(curso);
                        break;
                    }
                    case 3:{ // Cadastrar
                        System.out.println("[3] Cadastrar um novo curso");
                        System.out.println("Favor informar o código do curso: ");
                        codcurso = entrada.nextInt();
                        entrada.nextLine(); //Limpar o Buffer do teclado
                        System.out.println("Favor informar o nome: ");
                        nome = entrada.nextLine();
                        System.out.println("Favor informar o valor: ");
                        valor = entrada.nextDouble();
                        entrada.nextLine(); //Limpar o Buffer do teclado
                        System.out.println("Favor informar a URL: ");
                        url = entrada.nextLine();
                        Curso curso = new Curso (codcurso, nome, valor, url);
                        CursoDAO.inserir(curso);
                        break;
                    }
                    case 4:{ // Alterar
                        System.out.println("[4] Alterar um cliente");
                        System.out.println("Favor informar o código do curso: ");
                        codcurso = entrada.nextInt();
                        entrada.nextLine(); //Limpar o Buffer do teclado
                        System.out.println("Favor informar o nome: ");
                        nome = entrada.nextLine();
                        System.out.println("Favor informar o valor: ");
                        valor = entrada.nextDouble();
                        entrada.nextLine(); //Limpar o Buffer do teclado
                        System.out.println("Favor informar a URL: ");
                        url = entrada.nextLine();
                        Curso curso = new Curso (codcurso, nome, valor, url);
                        CursoDAO.alterar(curso);
                        break;
                    }
                    case 5:{ // Excluir
                        System.out.println("[5] Excluir um cliente");
                        System.out.println("Favor informar o código do curso a ser excluido: ");
                        codcurso = entrada.nextInt();
                        entrada.nextLine();
                        CursoDAO.excluir(codcurso);
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
            ex.printStackTrace();
        }
    }
    
}
