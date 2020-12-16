public class Banco{
	public static void main(String[] agrs){
		Conta minhaConta;
		minhaConta = new Conta();

		minhaConta.saldo = 1500;
		minhaConta.titular = "Danubia";
	
		System.out.println("Saldo atual: "+minhaConta.saldo);
		if(minhaConta.sacar(10000)){
			System.out.println("Saque realizado com sucesso!");
		}else{
			System.out.println("Saque nao realizado, verifique seu saldo!");
		}
				
		System.out.println(minhaConta.depositar(2000));


		//criando duas novas contas

		Conta meuSonho = new Conta();

		Conta minhaRealidade = new Conta();

		meuSonho = minhaConta;

		if(meuSonho == minhaConta){

			System.out.println("Enderecamento de contas iguais");
		}

		minhaRealidade.saldo = 1500;
		minhaRealidade.titular = "Danubia";

		if(minhaRealidade == minhaConta){
			System.out.println("Enderecamento de contas iguais");
		}else{
			System.out.println("Enderecamento de contas diferentes");

		}

		if(meuSonho.transferePara(minhaRealidade, 4500)){

			System.out.println("Transferencia realizada com sucesso!");
		}else{
			System.out.println("Transferencia mal sucedida!");
		}		

	}
}