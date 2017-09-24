/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abctreinamentos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "PAGAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p")
    , @NamedQuery(name = "Pagamento.findByCpf", query = "SELECT p FROM Pagamento p WHERE p.pagamentoPK.cpf = :cpf")
    , @NamedQuery(name = "Pagamento.findByCodcurso", query = "SELECT p FROM Pagamento p WHERE p.pagamentoPK.codcurso = :codcurso")
    , @NamedQuery(name = "Pagamento.findByDatainscricao", query = "SELECT p FROM Pagamento p WHERE p.datainscricao = :datainscricao")})
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagamentoPK pagamentoPK;
    @Basic(optional = false)
    @Column(name = "DATAINSCRICAO")
    private String datainscricao;

    public Pagamento() {
    }

    public Pagamento(PagamentoPK pagamentoPK) {
        this.pagamentoPK = pagamentoPK;
    }

    public Pagamento(PagamentoPK pagamentoPK, String datainscricao) {
        this.pagamentoPK = pagamentoPK;
        this.datainscricao = datainscricao;
    }

    public Pagamento(long cpf, long codcurso) {
        this.pagamentoPK = new PagamentoPK(cpf, codcurso);
    }

    public PagamentoPK getPagamentoPK() {
        return pagamentoPK;
    }

    public void setPagamentoPK(PagamentoPK pagamentoPK) {
        this.pagamentoPK = pagamentoPK;
    }

    public String getDatainscricao() {
        return datainscricao;
    }

    public void setDatainscricao(String datainscricao) {
        this.datainscricao = datainscricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagamentoPK != null ? pagamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.pagamentoPK == null && other.pagamentoPK != null) || (this.pagamentoPK != null && !this.pagamentoPK.equals(other.pagamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "pagamentoPK=" + pagamentoPK + ", datainscricao=" + datainscricao + '}';
    }

    
    
}
