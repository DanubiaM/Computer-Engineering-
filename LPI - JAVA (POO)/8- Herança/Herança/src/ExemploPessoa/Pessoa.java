
package ExemploPessoa;
public class Pessoa {
    //atributos
    String nome;
    int idade;
    String sexo;
    
    public void fazerAniversario(){
        setIdade(this.idade+1);
    }
    
    //metodos acessores
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
}
