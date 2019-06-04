/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import interfaces.Entidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author rumen
 */
@Entity
public class Item implements Serializable, Entidade{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGO")
    private Integer codigo;
    
    @OneToOne
    private Produto produto;
    
    @OneToMany
    private List<Desconto> descontos;
    
    @Column(name = "COMENTARIO")
    private String comentario;
    
    @Column(name = "VALOR_ATUAL")
    private Double valorAtual;
    
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
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the valorAtual
     */
    public Double getValorAtual() {
        return valorAtual;
    }

    /**
     * @param valorAtual the valorAtual to set
     */
    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }
    
}
