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

/**
 *
 * @author Matheus
 */
public class ClienteApp {

    public static void main(String[] args){
        try (Scanner entrada = new Scanner(System.in)) {
            int opcao = 0;
            long cpf;
            String nome, email;
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAAppPU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
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
                        TypedQuery<Cliente> query = em.createQuery("" + "Select c from Cliente c", Cliente.class);
                        List<Cliente> clientes = query.getResultList();
                        clientes.forEach(System.out::println);
                        break;
                    }
                    case 2:{ //Consultar Especifico
                        System.out.println("[2] Consultar cliente especifico");
                        System.out.println("Favor informar o CPF: ");
                        cpf = entrada.nextLong();
                        Cliente cliente = em.find(Cliente.class, cpf);
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
                        Cliente cliente = new Cliente(cpf, nome, email);
                        tx.begin();
                        em.persist(cliente);
                        tx.commit();
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
                        Cliente cliente = new Cliente(cpf, nome, email);
                        tx.begin();
                        em.merge(cliente);
                        tx.commit();
                        break;
                    }
                    case 5:{ // Excluir
                        System.out.println("[5] Excluir um cliente");
                        System.out.println("Favor informar o CPF do cliente a ser excluido: ");
                        cpf = entrada.nextLong();
                        entrada.hasNextLine();
                        Cliente cliente = em.find(Cliente.class, cpf);
                        tx.begin();
                        em.remove(cliente);
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
        }
        }
    }