/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abctreinamentos;
 
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CursoApp {
    
        public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        long valor, codcurso;
        String nome, url;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAAppPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
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
                    TypedQuery<Curso> query = em.createQuery("" + "Select c from Curso c", Curso.class);
                    List<Curso> cursos = query.getResultList();
                    cursos.forEach(System.out::println);
                    break;
                }
                case 2:{ //Consultar Especifico
                    System.out.println("[2] Consultar curso especifico");
                    System.out.println("Favor informar o Código do Curso: ");
                    codcurso = entrada.nextLong();
                    Curso curso = em.find(Curso.class, codcurso);
                    System.out.println(curso);
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
                    tx.begin();
                    em.persist(curso);
                    tx.commit();
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
                    tx.begin();
                    em.merge(curso);
                    tx.commit();
                    break;
                }
                case 5:{ // Excluir
                    System.out.println("[5] Excluir um curso");
                    System.out.println("Favor informar o código do curso a ser excluido: ");
                    codcurso = entrada.nextLong();
                    entrada.nextLine();
                    Curso curso = em.find(Curso.class, codcurso);
                    tx.begin();
                    em.remove(curso);
                    tx.commit();
                    break;
                }
                case 6:{ // Sair
                    System.out.println("Encerrando o sistema...");
                    em.close();
                    emf.close();
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

