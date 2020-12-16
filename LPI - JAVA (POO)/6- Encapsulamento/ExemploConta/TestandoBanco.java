package Encapsulamento.ExemploConta;

public class TestandoBanco {
    public static void main(String[] args) {
        ContaBanco c1 = new ContaBanco();
        
        c1.setDono("Joao"); //Adicionando nome
        c1.setNumConta(154); //Adicionando um numero de conta

        c1.abrirConta("cc");  //abrindo conta
        c1.depositar(500f);     //Deposito de 500 + 50 do saldo atual
        c1.sacar(600f);         //sacando 600, o que nao deve funcionar
        c1.depositar(100f);     //deposita +100 = 650
        c1.pagarMensalidade();  //Pagando mensalidade -12 = 638
        c1.fecharConta();       //fechando conta, deve zerar a conta
        c1.sacar(600);          //tenta sacar e nao funciona pq nao existe conta

        c1.infoConta();
    }
}
