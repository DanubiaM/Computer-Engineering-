package Encapsulamento.Exercicios;

public class TestandoConta {
    public static void main(String[] args) {
        Conta user = new Conta();

       //user.sacar(); qualquer metodo ou atributo privado não ira funcionar no main, apenas na classe Conta
       user.setTitular("Danubia");
       System.out.println(user.getTitular());
       user.deposita(500);
       user.saca(200);
       System.out.println(user.getSaldo());
        //atividade similar e mais completa ja feita na past Exemplo conta, desenvolvido no video do guanabara

    }
}
