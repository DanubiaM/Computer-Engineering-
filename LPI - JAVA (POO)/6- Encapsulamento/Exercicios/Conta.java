package Encapsulamento.Exercicios;

public class Conta {
    private String titular;
    private  int numero;
    private double saldo;
    private int identificador;

    public void saca(double valor){
        saldo -= valor;
       }
    public void deposita(double valor){
           saldo += valor;
    }
    public double calcRendimento(){
        return saldo*0.5f;
    }
    //metodos especiais

    public void Conta(){
        System.out.println("Conta criada com sucesso");
        getIdentificador();

    }
    public void Conta(String nome){
        setTitular(nome);
        getIdentificador();
        System.out.println("Conta criada com sucesso");
    }

    public void setTitular(String nome){
        this.titular = nome;
    }

    public String getTitular(){
        return this.titular;
    }

    public void setNumero(int num){
        this.numero = num;
    }

    public int getNumero(){
        return this.numero;
    }
    public void setSaldo(double valor){
        this.saldo = valor;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public void getIdentificador(){
        this.identificador ++;
    }
}
