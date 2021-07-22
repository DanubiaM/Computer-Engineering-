/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "grupoproduto")
public class GrupoProdutoVO implements Serializable {

  
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    private String nome;
    private float margemLucro;
    private float promocao;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
    }

    
    public float getPromocao() {
        return promocao;
    }

    public void setPromocao(float promocao) {
        this.promocao = promocao;
    }
    
    @Override
    public String toString(){
        return this.nome+" - "+this.codigo;
        
    }
    
    @Override
    public boolean equals (Object obj){
        if(obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final GrupoProdutoVO other = (GrupoProdutoVO) obj;
        if (this.codigo!= other.codigo){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.codigo;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Float.floatToIntBits(this.margemLucro);
        hash = 47 * hash + Float.floatToIntBits(this.promocao);
        return hash;
    }
}
