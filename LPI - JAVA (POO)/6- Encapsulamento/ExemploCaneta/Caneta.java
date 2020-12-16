package Encapsulamento.ExemploCaneta;
public class Caneta{
    public String modelo;
    private float ponta;
    private boolean tampada;
    private String cor;
   
     
    //metodo construtor
    public Caneta(String c, String m, float p){
        this.tampar();
        setModelo(m);
        setPonta(p);
        setCor(c);
        
    }

    //metodos principais
    public void tampar(){
        this.tampada = true;
    }
    public void destampar(){
        this.tampada = false;
    }
    public String getModelo(){
        return this.modelo;
    }
    public void setModelo(String m){
        this.modelo = m;
    }
    public float getPonta(){
        return this.ponta;
    }
    public void setPonta(float p){
        this.ponta = p;
    }
    public void setCor(String c){
        this.cor = c;
    }
    public void status(){
        System.out.println("INFORMAÇÕES SOBRE A CANETA");
        System.out.println("Modelo: "+this.getModelo());
        System.out.println("Cor: "+ this.cor);
        System.out.println("Ponta: "+this.getPonta());
        System.out.println("Tampada? "+ this.tampada);
    }
    public String getCor() {
        return cor;
    }
    
}