public class ContinueBreak{

	public static void main( String[] args){
	
		for(int i=0; i<100;i++){
			if(i>50 && i<60){ //Nesta situação, os valroes entre 50 e 60 irão ser pulado
				continue; //O comando continue quando executado, o laço volta para o teste da contição do laço de repetição.
			}
			System.out.println(i);
		}
	}
}	