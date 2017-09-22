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
public class PagamentoApp {
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        long cpf, cdCurso;
        String datainscricao;
        PagamentoDAO dao = new PagamentoDAO();
        while(opcao != 6){
            System.out.println("");
            System.out.println("Sistema Gerenciamento de Pagamentos");
            System.out.println("==========================================");
            System.out.println("Digite [1] para consultar todos os pagamentos");
            System.out.println("Digite [2] para consultar um pagamento especifico");
            System.out.println("Digite [3] para cadastrar um novo pagamento");
            System.out.println("Digite [4] para alterar um pagamento");
            System.out.println("Digite [5] para excluir um pagamento");
            System.out.println("Digite [6] encerrar o sistema");
            opcao=entrada.nextInt();
            
            switch (opcao){
                case 1:{ //Consultar todos
                    System.out.println("[1] Consultar todos:");
                    //consultarTodos();
                    break;
                }
                case 2:{ //Consultar Especifico
                    System.out.println("[2] Consultar pagamento especifico");
                    System.out.println("Favor informar o CPF: ");
                    cpf = entrada.nextLong();
                    entrada.nextLine();
                    System.out.println("Favor informar o código do curso: ");
                    cdCurso = entrada.nextLong();
                    PagamentoId pgtoId = new PagamentoId(cpf, cdCurso);
                    System.out.println(dao.find(pgtoId));
                    break;
                }
                case 3:{ // Cadastrar
                    System.out.println("[3] Cadastrar um novo pagamento");
                    System.out.println("Favor informar o CPF: ");
                    cpf = entrada.nextLong();
                    System.out.println("Favor informar o código do curso: ");
                    cdCurso = entrada.nextLong();
                    PagamentoId pgtoId = new PagamentoId(cpf, cdCurso);
                    entrada.nextLine(); //Limpar o Buffer do teclado
                    System.out.println("Favor informar a data de inscrição: ");
                    datainscricao = entrada.nextLine();
                    Pagamento pagamento = new Pagamento(pgtoId, datainscricao);
                    dao.persist(pagamento);
                    break;
                }
                case 4:{ // Alterar
                    System.out.println("[4] Alterar um pagamento");
                    System.out.println("Favor informar o CPF: ");
                    cpf = entrada.nextLong();
                    entrada.nextLine();
                    System.out.println("Favor informar o código do curso: ");
                    cdCurso = entrada.nextLong();
                    PagamentoId pgtoId = new PagamentoId(cpf, cdCurso);
                    entrada.nextLine(); //Limpar o Buffer do teclado
                    System.out.println("Favor informar a data de inscrição: ");
                    datainscricao = entrada.nextLine();
                    Pagamento pagamento = new Pagamento(pgtoId, datainscricao);
                    dao.merge(pagamento);
                    break;
                }
                case 5:{ // Excluir
                    System.out.println("[5] Excluir um pagamento");
                    System.out.println("Favor informar o CPF: ");
                    cpf = entrada.nextLong();
                    entrada.nextLine();
                    System.out.println("Favor informar o código do curso: ");
                    cdCurso = entrada.nextLong();
                    PagamentoId pgtoId = new PagamentoId(cpf, cdCurso);
                    Pagamento pagamento = dao.find(pgtoId);
                    dao.delete(pagamento);
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
