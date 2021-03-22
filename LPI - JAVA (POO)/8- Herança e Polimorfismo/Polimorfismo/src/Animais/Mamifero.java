/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animais;

public class Mamifero extends Animal{
    private String corPelo;
    
    
    @Override 
    public void locomover(){
        System.out.println("Andando =D");
    }
    @Override
    public void alimentar(){
        System.out.println("Gut Gut ... Mamando!");
    }
    @Override
    public void emitirSom(){
        System.out.println("Emitindo som de mamifero");
    }
    public String getCorPelo(){
        return this.corPelo;
    }
    
    public void setCorPelo(String _corPelo){
        this.corPelo = _corPelo;
    }
}
