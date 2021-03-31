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

    public Gafanhoto(String nome, int idade, String sexo, String login) {
        super(nome, idade, sexo);
        this.totAssistido = 0;
    }
    
    
    public void viuMaisUm(){
        this.totAssistido++;
    }
    public Pessoa getLogin() {
        return login;
    }

    public void setLogin() {
       this.login = login;
    }

    public int getTotAssistido() {
        return totAssistido;
    }
    
    @Override
    public String toString(){
        return "Gafanhoto+"+super.toString()+"\n Login"+login;
    }
    
    
}
