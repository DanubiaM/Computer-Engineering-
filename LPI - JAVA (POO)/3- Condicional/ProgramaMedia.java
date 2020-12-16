import java.util.Scanner;
public class ProgramaMedia{
	public static void main( String[] args){

		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite a primeira nota: ");
		float n1 = teclado.nextFloat();
		System.out.println("Digite a segunda nota: ");
		float n2 = teclado.nextFloat();
		float media = (n1+n2)/2;
	
		System.out.println("Media: "+media);

		if(media>9){
			System.out.println("CONGRATULATIONS!");
		}
	}

}