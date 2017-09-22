/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abctreinamentos;
 
import java.util.Scanner;

public class CursoApp {
    
        public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        long valor, codcurso;
        String nome, url;
        CursoDAO dao = new CursoDAO();
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
                    //consultarTodos();
                    break;
                }
                case 2:{ //Consultar Especifico
                    System.out.println("[2] Consultar curso especifico");
                    System.out.println("Favor informar o Código do Curso: ");
                    codcurso = entrada.nextLong();
                    System.out.println(dao.find(codcurso));
                    break;
                }
                case 3:{ // Cadastrar
                    System.out.println("[3] Cadastrar um novo curso");
                    System.out.println("Favor informar o código do curso: ");
                    codcurso = entrada.nextLong();
                    entrada.nextLine(); //Limpar o Buffer do teclado
                    System.out.println("Favor informar o nome: ");
                    nome = entrada.nextLine();
                    System.out.println("Favor informar o valor: ");
                    valor = entrada.nextLong();
                    entrada.nextLine(); //Limpar o Buffer do teclado
                    System.out.println("Favor informar a URL: ");
                    url = entrada.nextLine();
                    Curso curso = new Curso(codcurso, nome, valor, url);
                    dao.persist(curso);
                    break;
                }
                case 4:{ // Alterar
                    System.out.println("[4] Alterar um curso");
                    System.out.println("Favor informar o código do curso: ");
                    codcurso = entrada.nextLong();
                    entrada.nextLine(); //Limpar o Buffer do teclado
                    System.out.println("Favor informar o nome: ");
                    nome = entrada.nextLine();
                    System.out.println("Favor informar o valor: ");
                    valor = entrada.nextLong();
                    entrada.nextLine(); //Limpar o Buffer do teclado
                    System.out.println("Favor informar a URL: ");
                    url = entrada.nextLine();
                    Curso curso = new Curso(codcurso, nome, valor, url);
                    dao.merge(curso);
                    break;
                }
                case 5:{ // Excluir
                    System.out.println("[5] Excluir um curso");
                    System.out.println("Favor informar o código do curso a ser excluido: ");
                    codcurso = entrada.nextLong();
                    entrada.hasNextLine();
                    Curso curso = dao.find(codcurso);
                    dao.delete(curso);
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
        }
    }

