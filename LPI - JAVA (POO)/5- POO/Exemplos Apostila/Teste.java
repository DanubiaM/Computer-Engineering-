public class Teste{
	public static void main(String[] args){

	Conta_1 minhaConta = new Conta_1();
	Cliente c = new Cliente();
	minhaConta.titular = c;

	minhaConta.titular.nome = "Dan";

	System.out.println(minhaConta.titular.nome);
	System.out.println(minhaConta.titular.sobrenome);
	System.out.println(minhaConta.titular.cpf);	

	}



}