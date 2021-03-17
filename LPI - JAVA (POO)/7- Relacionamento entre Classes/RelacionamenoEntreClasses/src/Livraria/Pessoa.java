/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livraria;

/**
 *
 * @author danub
 */
public class Pessoa {

    private String nome;
    private int idade;
    private String sexo;
    
    Pessoa(String nm, int id, String sx){
        setNome(nm);
        setIdade(id);
        setSexo(sx);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public void fazerAniversario(){
        this.idade++;
    }
    
    
}
