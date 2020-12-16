import java.util.Scanner;
public class Voto{
	public static void main( String[] args){

		System.out.println("Digite a sua data de nascimento: ");
		Scanner scanf = new Scanner(System.in);
		int nascimento = scanf.nextInt();

		int idade = 2020 - nascimento;
		
		System.out.println("Sua idade e: "+idade);
		if(idade<16){
			System.out.println("Votacao nao obrigatoria!");
		}else if( idade<18 || idade>=70){
			System.out.println("Votacao opcional!");
		}else{
			System.out.println("Votacao obrigatoria!");
		}
	}
}

