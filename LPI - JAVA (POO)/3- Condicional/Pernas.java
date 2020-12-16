/* *
   * Objetivo: conhecer a condicional case
   *
*/

import java.util.Scanner;
public class Pernas{
	public static void main( String[] args){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite a quantidade de pernas que o animal possui: ");
		int pernas = teclado.nextInt();
		String tipo;

		switch(pernas){
			case 1:
				tipo = "Saci";
				break;
			case 2:
				tipo = "Bipede";
				break;
			case 3: 
				tipo = "Triple";
				break;
			case 4:
				tipo = "Quadruple";
				break;
			case 6, 8:
				tipo = "Aranha";
				break;
			default:
				tipo = "Et";
	 	}
		System.out.println(" O tipo de animal e: "+tipo);
	}
}