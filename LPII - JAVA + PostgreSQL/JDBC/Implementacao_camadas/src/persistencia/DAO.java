/*
SuperClasse para as classes de persistencia
 */

package persistencia;


public class DAO {
    protected Conexaobd conexao;
    //construtor
    public DAO(Conexaobd conexao) throws PersistenciaException{
        this.conexao = conexao;

    }

    public  Conexaobd getConexao(){
        return conexao;
    }

    public void setConexao(Conexaobd conexao){
        this.conexao = conexao;
    }
    public void desconectarBD() throws PersistenciaException{
        conexao.desconectar();
    }
}
