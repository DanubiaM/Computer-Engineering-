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
public class Ave extends Animal{
    private String corPena;
    
    @Override
    public void locomover(){
        System.out.println("Voando");
    }
    @Override
    public void alimentar(){
        System.out.println("Comendo frutas");
    }
    @Override
    public void emitirSom(){
        System.out.println("Emitindo som de ave!");
    }
    
    //metodos acessores
    public String getCorPena(){
        return this.corPena;
    }
    public void setCorPena(String _corPena){
        this.corPena = _corPena;
    }
}
