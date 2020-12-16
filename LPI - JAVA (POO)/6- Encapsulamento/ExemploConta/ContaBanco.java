package Encapsulamento.ExemploConta;

public class ContaBanco {
    public int numConta;
   // protected String tipo[] = new String[10]; //declaração de vetor em java
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    //Construtor
    public ContaBanco(){
        setSaldo(0);
        setStatus(false);
        System.out.println("Conta criada com sucesso!");
    }

    //metodos principais
    public void abrirConta(String typeConta){
        setStatus(true);
        setTipo(typeConta);
        if(typeConta == "cc") {
            setSaldo(50f);
        }else{
            setSaldo(150f);
        }
    }

    public void fecharConta(){
        if((saldo<0)  || (this.status == false)){
            //System.out.println("Necessario quitar saldo devedor: "+this.saldo);
            System.out.println("Erro! Por favor verifique o saldo devedor ou a existencia da conta.");
        }else{
            sacar(this.saldo);
            this.status = false;
        }
    }

    public void sacar(float valor){
        
        if((status == true) && (this.saldo >= valor)) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso, saldo atual: "+this.saldo);
        }else{
            System.out.println("Saque não realizado, verifique seu saldo ou o status da conta: "+this.saldo + this.status);
        }
        
      
    }
    public void depositar(float valor){
        if(status == true) {
            setSaldo(getSaldo()+valor);
        }else{
            System.out.println("Conta inexistente!");
        }
    }

    public void pagarMensalidade(){
        if(getTipo() == "cc"){
            setSaldo(getSaldo()-12);
        }else{
            setSaldo(getSaldo()-20);
        }

    }
    public void infoConta(){
        System.out.println("-----------------------");
        System.out.println("INFORMAÇÕES BANCARIA");
        System.out.println("Dono: "+getDono());
        System.out.println("Numero: "+getNumConta());
        System.out.println("Tipo: "+getTipo());
        System.out.println("Saldo: "+getSaldo());
        System.out.println("Status: "+getStatus());
        

    }

    //metodos especiais
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }

    public int getNumConta(){
        return this.numConta;
    }
    public void setNumConta(int num){
        this.numConta = num;
    }

    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public float getSaldo(){
        return saldo;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }

    public boolean getStatus(){
        return this.status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    




}
