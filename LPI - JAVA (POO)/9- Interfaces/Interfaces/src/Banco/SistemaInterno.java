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
public class SistemaInterno {
    private int senha;
    
    public void setSenha(int senha){
        this.senha = senha;
    }
    
    public void login(Autenticavel af){
        
        boolean ok = af.autentica(this.senha);
        if(ok == true){
            System.out.println("Autenticado");
        }else{
        System.out.println("Não altenticado");
        }        
    }
}
