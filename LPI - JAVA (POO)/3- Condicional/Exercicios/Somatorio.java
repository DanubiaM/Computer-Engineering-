/*	*
	*Objetivo: Apresentar o somatório dos valores pares entre o intervalo 50 à 150.
	*by: Danubia Macedo
	*date:30-11-2020
*/
import java.util.Scanner;
public class Somatorio{
	public static void main( String[] args){
		int i= 50;
		int soma = 0;

		while(i<=150){
			if( (i % 2) == 0){ //Se divisivel por 2, logo par.
				soma++;
				//System.out.printf("Par: %d Somando: %d\n", i,soma);
			}
		
			i++;
		};
		System.out.println("A somatoria dos valores pares e: "+soma);

	}
}