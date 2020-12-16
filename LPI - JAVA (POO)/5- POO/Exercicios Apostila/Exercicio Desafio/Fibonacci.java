public class Fibonacci{


	int calculaFibonacci(int j){

		/*if(j<=1){		
			return j;
		}else{
			return calculaFibonacci(j-1) + calculaFibonacci(j-2);
		}
		*/
		return ((j<=1) ? j : (calculaFibonacci(j-1) + calculaFibonacci(j-2)));
	}	

}