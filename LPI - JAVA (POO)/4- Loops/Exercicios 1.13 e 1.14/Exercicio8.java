public class Exercicio8{
	public static void main( String[] args){		

		for(int i=1;i<=4;i++){				
			for(int j=1;j<=4;j++){
				if(j>i){ 		//Analisou-se a tabela como uma matriz, sendo os valores da matriz traingular superior
					continue;	//os que não desejo imprimir. Logo se j>i, não deve acontecer nada. 				
				}
				
				System.out.printf(" %d", (i*j));
			}
			System.out.println("");
			
		}
	}
}