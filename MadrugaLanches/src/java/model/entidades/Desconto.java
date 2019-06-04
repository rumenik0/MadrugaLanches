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
public class Desconto implements Serializable, Entidade {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGO")
    private Integer codigo;
    
    @Column(name = "MOTIVO")
    private String motivo;
    
    @Column(name = "VALOR")
    private Double valor;
    
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
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
