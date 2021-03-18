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
public class Aluno extends Pessoa {
    private int matricula;
    private String curso;
    
    public void pagarMesalidade(){
        System.out.println("Mensalidade Paga de"+this.getNome());
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
  
    

    
}
