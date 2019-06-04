/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import interfaces.Entidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author rumen
 */
@Entity
public class Cliente implements Serializable, Entidade {



    public Cliente (){
        this.dataInicio = new Date(System.currentTimeMillis());
    }
    public Cliente (Endereco endereco,String nome,String telefone,String senha){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.senha = senha;
        this.dataInicio = new Date(System.currentTimeMillis());
    }
    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGO")
    private Integer codigo;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "TELEFONE", unique = true)
    private String telefone;
    
    @Column(name = "SENHA")
    private String senha;
    
    @Column(name = "DATA_ATIVACAO")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    
    @Override
    public Object getChave() {
        return this.getCodigo();
    }
    

    // GETTERS AND SETTERS
    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    
     /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
