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
public class Endereco implements Serializable,Entidade{
    public Endereco (){}
    public Endereco (Integer cep, String logradouro, Integer numero, String referencia){
        this.setCep(cep);
        this.setLogradouro(logradouro);
        this.setNumero(numero);
        this.setReferencia(referencia);
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "CODIGO")
    private Integer codigo;
    
    //@Column(name = "CEP")
    private Integer cep;
    
    //@Column(name = "LOGRADOURO")
    private String logradouro;
    
    //@Column(name = "NUMERO")
    private Integer numero;
    
    //@Column(name = "REFERENCIA")
    private String referencia;
    
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
     * @return the cep
     */
    public Integer getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(Integer cep) {
        this.cep = cep;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }    
}
