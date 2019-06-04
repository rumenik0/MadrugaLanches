/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import interfaces.Entidade;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author rumen
 */
@Entity
public class Filial implements Serializable, Entidade{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGO")
    private Integer codigo;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    
    @Column(name = "NOME")
    private String nome;
    
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
    
}
