/*	*
	*Objetivo: Apresentar os numeros divisiveis por 2 e3 entre 1 à 100
	*by: Danubia Macedo
	*date:30-11-2020
*/

import java.util.Scanner;
public class Divisiveis{
	public static void main( String[] args){
		int i = 1;
		
		while(i<=100){
			
			if((i % 2 ) == 0){
				System.out.printf("O valor %d e divisivel por 2. \n", i);
			};
			
			if( ( i % 3) == 0){
				System.out.printf("O valor %d e divisivel por 3. \n", i);
			};
			
			
			i++;
		} 
		
		
	}
}