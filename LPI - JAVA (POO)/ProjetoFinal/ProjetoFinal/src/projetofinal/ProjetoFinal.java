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
        
        Pessoa p = new Pessoa();
        p.setNome("Danubia");
        p.setIdade(21);
        p.setSexo("F");
        p.ganharExp(14);
        
        System.out.println(p.getNome()+" "+ p.getIdade() +" anos "+ p.getSexo()+" "+ p.getExperiencia());
        Video guanabara = new Video();
        
        guanabara.play();
        guanabara.pause();
        guanabara.like();
    }
    
}
