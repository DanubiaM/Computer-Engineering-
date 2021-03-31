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
        System.out.println(g.toString());
        System.out.println("\\");
        
        Video guanabara = new Video("Curso POO");        
        System.out.println(guanabara.toString());
        System.out.println("\\");

        Visualizacao v = new Visualizacao(g, guanabara);
        System.out.println(v.toString());
        guanabara.like();
        System.out.println("\\");
        System.out.println(v.toString());
        
        Visualizacao x = new Visualizacao(g, guanabara);

        System.out.println("\\");
        x.avaliar();
        x.avaliar(25);
        System.out.println(v.toString());
        

        
    }
    
}
