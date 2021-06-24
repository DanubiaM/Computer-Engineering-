
package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author danub
 */
public class DisciplinaDAO extends DAO{

    private static PreparedStatement comandoIncluir;
    private static PreparedStatement comandoAlterar;
    private static PreparedStatement comandoExcluir;
    private static PreparedStatement comandoBuscaCodigo;
    
    public DisciplinaDAO(Conexaobd conexao) throws PersistenciaException{
        super(conexao);

        try{
            comandoIncluir = conexao.getConexao().prepareStatement("INSERT INTO Disciplina (nome, semestre, cargahoraria, curso) VALUES (?,?,?,?) ");
            comandoAlterar = conexao.getConexao().prepareStatement("UPDATE Disciplina SET nome=?, semestre=?, cargahoraria=?, curso=? WHERE codigo=?");
            comandoExcluir = conexao.getConexao().prepareStatement("DELETE FROM Disciplina WHERE codigo =?");
            comandoBuscaCodigo = conexao.getConexao().prepareStatement("SELECT * FROM Disciplina WHERE codigo = ?");

        }catch (SQLException ex){
            System.out.println("Erro ao realizar operação CRUD - "+ex.getMessage());
        }

    }
}
