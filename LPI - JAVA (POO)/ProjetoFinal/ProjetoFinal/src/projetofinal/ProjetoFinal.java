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
public class ProjetoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        
        Gafanhoto g = new Gafanhoto("Danubia", 21,"F", "dan");
        g.viuMaisUm();
        System.out.println(g.toString());

        Video guanabara = new Video("Curso POO");
        
        System.out.println(guanabara.toString());
        guanabara.play();
        guanabara.pause();
        guanabara.like();
        System.out.println(guanabara.toString());
    }
    
}
