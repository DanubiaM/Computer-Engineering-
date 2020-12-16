public class Conta{
	String titular;
	int numero;
	String agencia;
	double saldo;
	Data dataAbertura;

	void saca(double valor){
		this.saldo-=valor;
		System.out.println("Saque no valor de "+valor+" realizado com sucesso!");

		
	}
	void deposita(double valor){
		this.saldo+=valor;
		System.out.println("Deposito no valor  de "+valor+" realizado com sucesso!");
	}
	
	double calculaRendimento(){

		return this.saldo*0.1;
	}
	String recuperaDadosParaImpressao(){
		String dados = "Titular: "+this.titular;
		dados+="\nNumero: "+this.numero;
		dados+="\nAgencia: "+this.agencia+ "\nSaldo: "+this.saldo;
		dados+="\nRendimento mensal: "+this.calculaRendimento();
		
		/*
		dados+="\nDia: "+this.dataAbertura.dia;
		dados+="\nMes: "+this.dataAbertura.mes;
		dados+="\nAno: "+this.dataAbertura.ano;
		*/
		dados+="\nData de abertura: "+this.dataAbertura.formatada();
		return dados;

	}




}