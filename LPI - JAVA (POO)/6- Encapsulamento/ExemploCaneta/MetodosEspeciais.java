package Encapsulamento.ExemploCaneta;
public class MetodosEspeciais{
    public static void main(String[] agrs){
        Caneta c1 = new Caneta("Azul","Bic",0.5f);

       // c1.setModelo("bic");
       // c1.setPonta(0.5f); 
        c1.status();

        Caneta c2 = new Caneta("Preto", "Mak", 1.5f);
        c2.status();
    }
    
}