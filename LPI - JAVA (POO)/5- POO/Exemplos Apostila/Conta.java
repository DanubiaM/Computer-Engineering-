public class Conta{

	//declaração de atributos
	double saldo;
	String titular;
	int numero;

	//declaração de metodo
	boolean sacar(double valor){
		if(this.saldo<valor){
			return false;
		}
		else{
			double novoSaldo = this.saldo - valor;
			this.saldo = novoSaldo;
			return true;
		}


	}

	String depositar(double valor){
		
		this.saldo+=valor;	
		return "Deposito realizado com sucesso!";
	}
	boolean transferePara(Conta destino, double valor){
		boolean retirou = this.sacar(valor);
		if(retirou == false){
			return false;
		}else{
			destino.depositar(valor);
			return true;

		}
	
	}

}