/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abctreinamentos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Matheus
 */
@Embeddable
public class PagamentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CPF")
    private long cpf;
    @Basic(optional = false)
    @Column(name = "CODCURSO")
    private long codcurso;

    public PagamentoPK() {
    }

    public PagamentoPK(long cpf, long codcurso) {
        this.cpf = cpf;
        this.codcurso = codcurso;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCodcurso() {
        return codcurso;
    }

    public void setCodcurso(long codcurso) {
        this.codcurso = codcurso;
    }


    @Override
    public String toString() {
        return "PagamentoPK{" + "cpf=" + cpf + ", codcurso=" + codcurso + '}';
    }

    
    
}
