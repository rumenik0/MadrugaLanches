/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import interfaces.Entidade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author rumen
 */
@Entity
public class Pedido implements Serializable, Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;
    
    @OneToOne
    private Entregador entregador;
    
    @OneToOne
    private Cliente cliente;
    
    @OneToMany
    private List<Item> itens;
    
    @OneToOne
    private Endereco endereco;
    
    @OneToOne
    private Filial filial;
    
    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;
    
    @Column(name = "DATA_PEDIDO")
    private Date dataPedido;
    
    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "COMENTARIO")
    private String comentario;
    
    @Column(name = "ESTRELAS")
    private int avaliacao;
    
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
     * @return the entregador
     */
    public Entregador getEntregador() {
        return entregador;
    }

    /**
     * @param entregador the entregador to set
     */
    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the itens
     */
    public List<Item> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<Item> itens) {
        this.itens = itens;
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
     * @return the filial
     */
    public Filial getFilial() {
        return filial;
    }

    /**
     * @param filial the filial to set
     */
    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the dataPedido
     */
    public Date getDataPedido() {
        return dataPedido;
    }

    /**
     * @param dataPedido the dataPedido to set
     */
    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
     * @return the avaliacao
     */
    public int getAvaliacao() {
        return avaliacao;
    }

    /**
     * @param avaliacao the avaliacao to set
     */
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    
}
