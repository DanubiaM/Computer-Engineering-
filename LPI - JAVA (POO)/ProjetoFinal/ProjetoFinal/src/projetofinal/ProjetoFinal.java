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
        
        Gafanhoto gafanhoto = new Gafanhoto();
        
        gafanhoto.setLogin("Danubia", 21,"F");
//        System.out.println(gafanhoto.getLogin());
        System.out.println(gafanhoto.getNome()+" "+ gafanhoto.getIdade() +" anos "+ gafanhoto.getSexo()+" "+ gafanhoto.getExperiencia());
        Video guanabara = new Video();
        
        guanabara.play();
        guanabara.pause();
        guanabara.like();
    }
    
}
