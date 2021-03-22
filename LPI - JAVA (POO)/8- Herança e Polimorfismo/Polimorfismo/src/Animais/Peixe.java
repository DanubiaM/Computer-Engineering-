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
public class Peixe extends Animal{
    private String corEscama;
    
    @Override
    public void locomover(){
        System.out.println("Nadando");
    }
    @Override 
    public void alimentar(){
        System.out.println("Comendo substancias");
    }
    @Override
    public void emitirSom(){
        System.out.println("Peixe não faz som");
    }
    public void soltarBolha(){
        System.out.println("Soltando uma bolha!");
    }

    //metodos acessores
    public String getCorEscama(){
        return this.corEscama;
    }
    public void setCorEscama(String _corEscama){
        this.corEscama = _corEscama;
    }
}
