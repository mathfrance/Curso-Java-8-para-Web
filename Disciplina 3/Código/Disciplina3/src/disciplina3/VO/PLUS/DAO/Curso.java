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
public class Curso {
    
    int codcurso;
    String nome;
    double valor;
    String url;

    public Curso(int codcurso, String nome, double valor, String url) {
        this.codcurso = codcurso;
        this.nome = nome;
        this.valor = valor;
        this.url = url;
    }

    public int getCodcurso() {
        return codcurso;
    }

    public void setCodcurso(int codcurso) {
        this.codcurso = codcurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Curso{" + "codcurso=" + codcurso + ", nome=" + nome + ", valor=" + valor + ", url=" + url + '}';
    }
    
    
    
}
