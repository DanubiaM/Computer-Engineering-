/*
    *Os conceitos visto aqui seram mais avançados do que o da packges "ExemploPessoa"
   
 */
package ExemploPessoa_2;
public class ExemploPessoa_2 {
    public static void main (String[] args){

    Visitante t1 = new Visitante();
    t1.setNome("Jose");
    t1.setIdade(23);
    t1.setSexo("M");
    System.out.println("Nome:"+t1.getNome()+"Idade "+t1.getIdade()+ "Sexo "+t1.getSexo());
    
    
    Aluno a1 = new Aluno();
    a1.setNome("Tie");
    a1.setIdade(26);
    a1.setSexo("F");
    a1.pagarMesalidade();
    
    Bolsista b1 = new Bolsista();
    b1.setNome("She");
    b1.setIdade(12);
    b1.setSexo("M");
    b1.pagarMesalidade();
    
    
    
    }
}
