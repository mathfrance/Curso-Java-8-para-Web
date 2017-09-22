/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplina3.VO.PLUS.DAO;

/**
 *
 * @author Matheus
 */
public class Cliente {
    
    Long cpf;
    String nome;
    String email;
    
    public Cliente(Long cpf, String nome, String email){
        super();
        this.cpf= cpf;
        this.nome= nome;
        this.email = email;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", nome=" + nome + ", email=" + email + '}';
    }
    
    
}
