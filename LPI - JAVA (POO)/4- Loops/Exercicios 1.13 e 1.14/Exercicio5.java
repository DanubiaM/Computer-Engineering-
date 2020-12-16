public class Exercicio5{
	public static void main(String[] args){
	
		double fatorial=1;

		for(int i=1; i<=40;i++){
			fatorial = fatorial*i;
			System.out.println("O fatorial de "+i+" e: "+fatorial); //Apartir do 17, o valor dos fatoriais começam a não funcionar
		}								// O tipo int permite a impressão de 4bytes, dessa maneira deve-se mudar o valor para long
										// Apartir do 20, o tipo long não funciona, usa-se double
	}	

}