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
public class Reptil extends Animal{
    private String corEscama;
    
    @Override
    public void locomover(){
        System.out.println("Rastejando");
    }
    
    @Override 
    public void alimentar(){
        System.out.println("Comendo vegetais :3");
    }
    
    @Override 
    public void emitirSom(){
        System.out.println("Som de um reptil");
    }
    
    public String getCorEscama(){
        return this.corEscama;
    }
    
    public void setCorEscama(String _corEscama){
        this.corEscama = _corEscama;
    }
}
