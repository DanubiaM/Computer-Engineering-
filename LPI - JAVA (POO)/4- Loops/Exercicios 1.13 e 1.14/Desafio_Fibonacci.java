public class Desafio_Fibonacci{
	public static void main( String[] args){
		int fib = 1, f2 = 0;
		
		while(fib<100){
			fib= fib + f2;

			f2 = fib - f2;
			System.out.println(""+fib);
		}



	}
}