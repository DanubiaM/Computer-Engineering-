package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Implementacao de Inclusao, alteração, exclusao, busca por Codigo e busca por nome. 
 * Busca por Nome deve retornar uma lista.
 * @author github:danubiaM
 */
public class CursoDAO extends DAO{
    private static PreparedStatement comandoIncluir;
    private static PreparedStatement comandoAlterar;
    private static PreparedStatement comandoExcluir;
    private static PreparedStatement comandoBuscaCodigo;  

    public CursoDAO (Conexaobd conexao) throws PersistenciaException{
        super(conexao);
        try{
            comandoIncluir = conexao.getConexao().prepareStatement("INSERT INTO Curso (nome, descricao) VALUES (?, ?)");
            comandoAlterar = conexao.getConexao().prepareStatement("UPDATE Curso SET nome=?, descricao=? WHERE codigo =?");
            comandoExcluir = conexao.getConexao().prepareStatement("DELETE FROM Curso WHERE codigo=?");
            comandoBuscaCodigo = conexao.getConexao().prepareStatement("SELECT * FROM Curso WHERE codigo=?");

        }catch (SQLException ex){
            throw new PersistenciaException("Erro ao incluir novo aluno - "+ ex.getMessage());
        }

    }

}
