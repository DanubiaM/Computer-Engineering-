/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemploPessoa;

/**
 *
 * @author danub
 */
public class Funcionario extends Pessoa{

    private String setor;
    private boolean trabalhando;
    
    public void mudarTrabalho(String newSetor){
        this.setor = newSetor;
    }
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public boolean isTrabalhando() {
        return trabalhando;
    }

    public void setTrabalhando(boolean trabalhando) {
        this.trabalhando = trabalhando;
    }
   
    
    
}
