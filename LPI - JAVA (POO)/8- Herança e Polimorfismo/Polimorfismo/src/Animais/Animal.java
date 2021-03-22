/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animais;

/**
 *
 * @author danub
 */
public abstract class Animal {
    private float peso;
    private int idade;
    private int membros;
    
    //metodos abstratos para sobrecarga.
    public abstract void locomover();
    public abstract void alimentar();
    public abstract void emitirSom();
//    
//    //metodos acessores nao necessários.
//    public float getPeso(){
//        return this.peso;
//    }
//    public void setPeso(float _peso){
//        this.peso = _peso;
//    }
//    public int getIdade(){
//        return this.idade;
//    }
//    public void setIdade(int _idade){
//        this.idade = _idade;
//    }
//    public int getMembros(){
//        return this.membros;
//    }
//    public void setMembros(int _membros){
//        this.membros = _membros;
//    }
    
    
}
