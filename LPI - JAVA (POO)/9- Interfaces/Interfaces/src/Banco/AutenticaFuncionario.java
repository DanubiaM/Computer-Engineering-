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
public class AutenticaFuncionario extends Funcionario{
   
    public boolean autentica(int senha){
        if(senha == super.getIdade() ){
            return true;
        }else return false;
    }
}
