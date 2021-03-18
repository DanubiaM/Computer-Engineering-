/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemploPessoa_2;

/**
 *
 * @author danub
 */
public class Bolsista extends Aluno{
    private int bolsa;
    
    public void renovasBolsa(){
        System.out.println("Bolsa renovada");
    }
    
    public void pagarMensalidade(){
        System.out.println("Aluno Bolsista! Mensalidade paga!");
    };
    
}
