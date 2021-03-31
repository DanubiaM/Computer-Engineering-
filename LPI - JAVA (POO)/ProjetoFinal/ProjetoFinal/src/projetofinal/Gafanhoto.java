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
public class Gafanhoto extends Pessoa{
    private Pessoa login;
    private int totAssistido;
    
    public void viuMaisUm(){
        this.totAssistido++;
    }
    public Pessoa getLogin() {
        return login;
    }

    public void setLogin(String nome, int idade, String sexo) {
        super.setNome(nome);
        super.setIdade(idade);
        super.setSexo(sexo);
    }

    public int getTotAssistido() {
        return totAssistido;
    }

   
    
    
}
