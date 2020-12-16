/*Exercicios da apostila FJ-11 seção 4.12 (1 ao 5)
 *Exercicios do 6 ao 9 se encontra na pasta de exericios opcionais
 *@author Danubia Macedo
 *@since 08-12-2020
 */

public class GerenciadorDeContas{

	public static void main(String[] args){
		Conta c1 = new Conta();
		c1.titular = "Hugo";
		c1.numero = 123;
		c1.agencia = "48785-11";
		c1.saldo = 50.5f;
		c1.dataAbertura = "01/06/2015";

		c1.deposita(100);
		System.out.println("Saldo atual: "+c1.saldo);
		System.out.println("Rendimento mensal: "+ c1.calculaRendimento());

		System.out.println("\n"+c1.recuperaDadosParaImpressao());
	
		Conta c2 = new Conta();

		c2 = c1;
		if(c2 == c1){
			System.out.println("\nReferencia de objetos iguais");
		}else{
			System.out.println("\nReferencia de objetos diferentes");
		}
	}




}