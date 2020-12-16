import java.util.Scanner;
public class Idade{
	public static void main( String[] args){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite seu ano de nascimento: ");
		int nascimento = teclado.nextInt();

		int ano_atual = 2020;
		int idade = ano_atual - nascimento;
		System.out.printf("Sua idade e de %d anos \n", idade);

		if(idade>=18){
			System.out.println("Maior");
		}else{
			System.out.println("Menor");
		}
		


	}
}