/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author maurobarros
 */
public class Candidatura {
    private String nome_Empresa;
    private String morada;
    private int telefone;
    private double AreaExposicao;
    private String produto;
    private int convites;

    public Candidatura(String nome_Empresa, String morada, int telefone, double AreaExposicao, String produto, int convites) {
        this.nome_Empresa = nome_Empresa;
        this.morada = morada;
        this.telefone = telefone;
        this.AreaExposicao = AreaExposicao;
        this.produto = produto;
        this.convites = convites;
    }

    public Candidatura() {
    }

    public String getNome_Empresa() {
        return nome_Empresa;
    }

    public String getMorada() {
        return morada;
    }

    public int getTelefone() {
        return telefone;
    }

    public double getAreaExposicao() {
        return AreaExposicao;
    }

    public String getProduto() {
        return produto;
    }

    public int getConvites() {
        return convites;
    }

    public void setNome_Empresa(String nome_Empresa) {
        this.nome_Empresa = nome_Empresa;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setAreaExposicao(double AreaExposicao) {
        this.AreaExposicao = AreaExposicao;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setConvites(int convites) {
        this.convites = convites;
    }

    @Override
    public String toString() {
        return "Candidatura{" + "nome_Empresa=" + nome_Empresa + ", morada=" + morada + ", telefone=" + telefone + ", AreaExposicao=" + AreaExposicao + ", produto=" + produto + ", convites=" + convites + '}';
    }
   
    
}
