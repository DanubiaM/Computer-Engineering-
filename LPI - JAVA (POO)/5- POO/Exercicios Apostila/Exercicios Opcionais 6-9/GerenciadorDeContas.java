/*
 *
 *@author Danubia Macedo
 *@since 08-12-2020
 */

public class GerenciadorDeContas{

	public static void main(String[] args){
		Conta c1 = new Conta();
		Data data= new Data();

		c1.dataAbertura = data;

		c1.titular = "Danubia";
		c1.numero = 5781;
		c1.agencia = "44578-9";
		c1.saldo = 450f;
		/*
		c1.dataAbertura.dia = 04;
		c1.dataAbertura.mes = 12;
		c1.dataAbertura.ano = 2012;
		*/
		System.out.println(c1.recuperaDadosParaImpressao());
	}




}