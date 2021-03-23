/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animais;

public class TestandoAnimais {
    public static void main(String[] args){
        Mamifero  m = new Mamifero();
        m.setPeso(10);
        m.setIdade(4);
        m.setMembros(4);
        m.setCorPelo("Branco");
        m.alimentar();
        m.emitirSom();
        m.locomover();
        
        Reptil p = new Reptil();
        p.setPeso(3.5f);
        p.setIdade(2);
        p.setMembros(4);
        p.setCorEscama("Verde");
        p.alimentar();
        p.emitirSom();
        p.locomover();
        
        Peixe px = new Peixe();        
        px.setPeso(0.5f);
        px.setIdade(1);
        px.setMembros(0);
        px.alimentar();
        px.emitirSom();
        px.locomover();
        px.soltarBolha();

        Ave a = new Ave();
        a.setPeso(1.5f);
        a.setIdade(2);
        a.setMembros(4);
        a.alimentar();
        a.emitirSom();
        a.locomover();
        a.fazerNinho();
        
        Canguru canguru = new Canguru();
        
        canguru.setIdade(4);
        canguru.locomover();
        
        Tartaruga tartaruga = new Tartaruga();        
        tartaruga.locomover();
        
        Cachorro cachorro = new Cachorro();
        cachorro.enterrarOsso();
        cachorro.abanarRabo();
        cachorro.alimentar();
        cachorro.reagir("Ola");
        cachorro.reagir(17);
        
       
        
        
    }
}
