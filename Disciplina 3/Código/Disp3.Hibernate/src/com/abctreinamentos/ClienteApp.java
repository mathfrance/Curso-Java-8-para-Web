/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abctreinamentos;

import java.util.Scanner;

/**
 *
 * @author Matheus
 */
public class ClienteApp {

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        long cpf;
        String nome, email;
        ClienteDAO dao = new ClienteDAO();
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
                    //consultarTodos();
                    break;
                }
                case 2:{ //Consultar Especifico
                    System.out.println("[2] Consultar cliente especifico");
                    System.out.println("Favor informar o CPF: ");
                    cpf = entrada.nextLong();
                    System.out.println(dao.find(cpf));
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
                    dao.persist(cliente);
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
                    dao.merge(cliente);
                    break;
                }
                case 5:{ // Excluir
                    System.out.println("[5] Excluir um cliente");
                    System.out.println("Favor informar o CPF do cliente a ser excluido: ");
                    cpf = entrada.nextLong();
                    entrada.hasNextLine();
                    Cliente cliente = dao.find(cpf);
                    dao.delete(cliente);
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