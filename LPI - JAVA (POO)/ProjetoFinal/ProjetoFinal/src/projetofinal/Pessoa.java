/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal;

/**
 *
 * @author danub
 */
public abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected String sexo;
    protected int experiencia;
 
    public Pessoa(String nome, int idade, String sexo){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.experiencia = 0;
    }
    protected void ganharExp(int exp){
        this.experiencia+=exp;
    }
    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected int getIdade() {
        return idade;
    }

    protected void setIdade(int idade) {
        this.idade = idade;
    }

    protected String getSexo() {
        return sexo;
    }

    protected void setSexo(String sexo) {
        this.sexo = sexo;
    }

    protected int getExperiencia() {
        return experiencia;
    }    
     @Override
     public String toString(){
         return "Pessoa{"+",titulo= "+nome+",idade= "+idade+",sexo "+sexo+",experiencia "+experiencia+"}";
     }
}
