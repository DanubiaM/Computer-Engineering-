public class Exercicio6{
	public static void main(String[] args){
		int fib = 1, aux = 1;
		int f2 = 0;
		
		while(fib<100){
			fib = fib + f2;
			f2 = aux;
			aux = fib;
			System.out.println(""+fib);		
		}
		
	}
}