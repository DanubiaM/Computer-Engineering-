public class EmpresaCanetas{

	public static void main(String[] args){
		Caneta c1 = new Caneta();
	
		c1.modelo = "bic";
		c1.cor = "Vermelho";
		c1.ponta = 0.5f;
		c1.carga = 80;
		c1.tampada = false;
		c1.status();
		c1.rabiscar();
		
		c1.destampar();
		c1.status();
		c1.tampar();
		c1.status();

	}





}