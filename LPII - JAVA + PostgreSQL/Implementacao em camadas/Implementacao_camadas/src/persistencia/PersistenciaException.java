/*
 Classe para capturar e tratar excessoes ocorridas na camada de persistencia.
 */

package persistencia;

public class PersistenciaException extends Exception{
    public PersistenciaException(){
        super("Erro ocorrido  na manipulação do banco de dados");
    }
    public PersistenciaException(String msg){
        super(msg);
    }
}
