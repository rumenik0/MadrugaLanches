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
 * @author Rumenik
 */
@Entity
public class Produto implements Serializable, Entidade{

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "Descricao")
    private String desc;
    @Column(name = "Nome", length=30 )
    private String nome;

    @Override
    public Object getChave() {
        return getId();
    }
}
