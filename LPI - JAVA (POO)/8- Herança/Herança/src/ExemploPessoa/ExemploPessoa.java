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
public class ExemploPessoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       Pessoa p = new Pessoa();
        p.setNome("Joao");
        p.setSexo("masculino");
        p.setIdade(25);
        p.fazerAniversario();
        System.out.println( p.getIdade());
        
        
        Aluno aluno = new Aluno();        
        aluno.setNome("Maria");
        aluno.setSexo("Feminino");
        aluno.setIdade(21);
        aluno.setCurso("Eng. CP");
        aluno.setMatricula(15423);
        aluno.cancelarMatricula();
        System.out.println(aluno.getCurso());
        
        Funcionario f = new Funcionario();
        
        f.setNome("Jose");
        f.setTrabalhando(true);
        f.setSetor("Suporte TI");
        System.out.println(f.getSetor());
        f.mudarTrabalho("Desenvolvedor");
        System.out.println(f.getSetor());

        Professor prof = new Professor();
        prof.setNome("Adae");
        prof.setEspecialidade("Redes Neurais");
        prof.setSalario(7000);
        prof.receberAumento(475.25f);
        System.out.println(prof.getNome()+" "+prof.getSalario());
       

        
        
        
        
    }
    
}
