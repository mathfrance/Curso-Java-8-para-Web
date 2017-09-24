/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abctreinamentos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")
    , @NamedQuery(name = "Curso.findByCodcurso", query = "SELECT c FROM Curso c WHERE c.codcurso = :codcurso")
    , @NamedQuery(name = "Curso.findByNome", query = "SELECT c FROM Curso c WHERE c.nome = :nome")
    , @NamedQuery(name = "Curso.findByValor", query = "SELECT c FROM Curso c WHERE c.valor = :valor")
    , @NamedQuery(name = "Curso.findByUrl", query = "SELECT c FROM Curso c WHERE c.url = :url")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CODCURSO")
    private Long codcurso;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private long valor;
    @Basic(optional = false)
    @Column(name = "URL")
    private String url;

    public Curso() {
    }

    public Curso(Long codcurso) {
        this.codcurso = codcurso;
    }

    public Curso(Long codcurso, String nome, long valor, String url) {
        this.codcurso = codcurso;
        this.nome = nome;
        this.valor = valor;
        this.url = url;
    }

    public Long getCodcurso() {
        return codcurso;
    }

    public void setCodcurso(Long codcurso) {
        this.codcurso = codcurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcurso != null ? codcurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codcurso == null && other.codcurso != null) || (this.codcurso != null && !this.codcurso.equals(other.codcurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curso{" + "codcurso=" + codcurso + ", nome=" + nome + ", valor=" + valor + ", url=" + url + '}';
    }

   
    
}
