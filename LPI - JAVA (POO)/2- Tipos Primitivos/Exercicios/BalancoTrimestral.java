
public class BalancoTrimestral{
	public static void main( String[] args){

		int gastosJaneiro = 15000;
		int gastosFevereiro = 23000;
		int gastosMarco = 17000;
		int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;

		System.out.println(gastosTrimestre);

		/*	
			*Testando se funciona assim
			*Float mediaMensal = new Float (gastosTrimestre /3);
			*float mediaMensal = (float) gastosTrimestre/3;
		*/

		Float mediaMensal = new Float (gastosTrimestre /3);
		System.out.println("Valor da média mensal =" + mediaMensal);

	}
}