
/**	
	Tipops de variaveis
	@author Danubia Macedo
	@version 1.0
	@since 23-11-2020

 */
import java.util.Scanner;
public  class TiposPrimitivos{
	public static void main( String[] args){
		//declaração de variavel convencional
		int idade = 20;
		

		//declaração de variavel utilizando typecast
		float altura = (float) 1.65;

		//declaração utilizando Wrapper Class
		Character letra = new Character('D');
	

		//Entrada de dados
		System.out.print("Digite seu nome: ");
		Scanner name = new Scanner(System.in);
		String nome= name.nextLine();

		System.out.println("Idade: " +idade);
		System.out.printf("Nome: %s \t Altura: %.2f \n", nome, altura);
		System.out.println(letra);

		//Testando conversão de valores String<->int
		String newAltura = Float.toString(altura);
		System.out.println("Altura com string: " + newAltura);

		Float newAlturaFloat = Float.parseFloat(newAltura);
		System.out.println("Altura com float: " + newAlturaFloat);

		
	}
}