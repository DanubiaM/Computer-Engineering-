
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
    Lutador(String nm, String nc, int id, float al, float ps, int vt, int dr, int em ){
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
        setCategoria(peso);
    
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

    public void setCategoria(float  peso) {
        if(peso<52.2 || peso > 120.2){
            this.categoria = "Invalido";
        }else if ( peso <= 70.3){
            this.categoria = "Leve";
        }else if(peso<=83.9){
            this.categoria = "Médio";
        } else if( peso <=120.2){
            this.categoria = "Pesado";
        }
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
        System.out.println("Nome: " + getNome());
        System.out.println("Nacionalidade: "+ getNacionalidade());
        System.out.println("Idade: "+ getIdade());
        System.out.println("Peso: "+ getPeso());
        System.out.println("Altura: "+ getAltura());
        System.out.println("Categoria: "+ getCategoria());
        System.out.println("Vitorias: "+ getVitorias());
        System.out.println("Derrotas: "+ getDerrotas());
        System.out.println("Empates: "+ getEmpates());    
        
    }
    
    public void ganharLuta(){
        setVitorias(getVitorias() + 1);
    }
    public void perderLuta(){
        setDerrotas(getDerrotas() +1);
    }
    
    public void empatarLuta(){
        setEmpates(getEmpates() +1);
    }
    
    public void status(){
        System.out.println(getNome());
        System.out.println("Possui o peso: "+ getPeso());       
        System.out.println("Tem "+ getVitorias() + " vitorias");
        System.out.println(getDerrotas()+" derrotas ");
        System.out.println("e "+ getEmpates() + "empates");     
    }
}
