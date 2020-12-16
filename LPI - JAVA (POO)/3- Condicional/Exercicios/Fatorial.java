/*	*
	*Objetivo: Apresentar o fatorial dos numeros no intervalo de 5 até 10.
	*by: Danubia Macedo
	*date:30-11-2020
	*
*/

public class Fatorial{
	public static void main( String[] args){
		int i,j,fat;


		for( i=5; i<=10; i++){
			fat=j=i;
			
			while(j!=1){
				j--;
				fat= j*fat;
			}
			System.out.printf("O fatorial de %d e: %d \n",i,fat);
		}

	}
}