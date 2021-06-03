


package negocio;


public class NegocioException extends Exception {
    public NegocioException(){
        super("Erro ocorrido  na camada de negocio");
    }

    public negocio Exceptio(String msg){
        super(msg);
    }

}
