
package relacionamenoentreclasses;

/**
 *
 * @author danub
 */
public class Lutador {

    private String nome;
    private String nacionalidade;
    private int idade;
    private float peso;
    private float altura;
    private String categoria;
    private int vitorias;
    private int derrotas;
    private int empates;
    
    
    /*Construtor*/
    public void Lutador(String nm, String nc, int id, int ps, int al, int vt, int dr, int em ){
        setNome(nm);
        setNacionalidade(nc);
        setIdade(id);
        setPeso(ps);
        setAltura(al);
        setVitorias(vt);
        setDerrotas(dr);
        setEmpates(em);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String lutador) {
        this.nome = lutador;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        if(peso<52.2 || peso > 120.2){
            setCategoria("Invalido");
        }else if ( peso <= 70.3){
            setCategoria("Leve");
        }else if(peso<=83.9){
            setCategoria("Médio");
        } else if( peso <=120.2){
            setCategoria("Pesado");
        }
    
   }
        
    

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
   
    public void apresentar(){
        System.out.println("----------------COM VOCÊS-----------:");
        System.out.println("Nome: " + this.nome);
        System.out.println("Nacionalidade: "+ this.nacionalidade);
        System.out.println("Idade: "+ this.altura);
        System.out.println("Peso: "+this.peso);
        System.out.println("Altura: "+this.altura);
        System.out.println("Categoria: "+this.categoria);
        System.out.println("Vitorias: "+this.vitorias);
        System.out.println("Derrotas: "+this.derrotas);
        System.out.println("Empates: "+this.empates);    
        
    }
    
    
}
