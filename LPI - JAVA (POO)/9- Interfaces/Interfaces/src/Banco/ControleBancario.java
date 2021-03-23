/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

/**
 *
 * @author danub
 */
public class ControleBancario {
    public static void main(String[] args){
        Diretor d = new Diretor();
        
        d.setIdade(52);
        d.setNome("Antonio");
        d.setCpf("1221551521");
        
        SistemaInterno acessar = new SistemaInterno();
        
        acessar.setSenha(51);
        acessar.login(d);
        acessar.setSenha(52);
        acessar.login(d);


        
    }
}
