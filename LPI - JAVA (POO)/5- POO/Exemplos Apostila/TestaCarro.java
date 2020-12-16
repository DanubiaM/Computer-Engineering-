public class TestaCarro{
	public static void main(String[] args){

		Carro meuCarro = new Carro();
		meuCarro.cor ="Cinza";
		meuCarro.modelo="HB20S";
		meuCarro.velocidadeAtual = 0;
		meuCarro.velocidadeMaxima = 120;

		meuCarro.liga();

		meuCarro.acelera(20);
		System.out.println(meuCarro.velocidadeAtual);	

	}




}