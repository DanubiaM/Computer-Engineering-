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

    public int incluir(CursoVO cursoVO) throws PersistenciaException{
        int retorno = 0;

        try{
            comandoIncluir.setString(1, cursoVO.getCurso());
            comandoIncluir.setString(2, cursoVO.getDescricao());
            retorno = comandoIncluir.executeUpdate();
        }catch (SQLException ex){
            throw new PersistenciaException("Erro ao incluir curso - " +ex.getMessage());

        }

        return retorno;

    }

    public int alterar(CursoVO cursoVO) throws PersistenciaException{
        int retorno  = 0;

        try{
            comandoAlterar.setString(1, cursoVO.getCurso());
            comandoAlterar.setString(2, cursoVO.getDescricao());
            retorno  = comandoAlterar.executeUpdate();
        }catch (SQLException ex){
            throw new PersistenciaException("Erro ao alterar curso - "+ex.getMessage());

        }
        return retorno;
    }

    public int excluir( int codigo) throws PersistenciaException{
        int retorno = 0;
    
        try{
            comandoExcluir.setInt(1, codigo);
            retorno = comandoExcluir.executeUpdate();
        }catch (SQLException ex){
            throw new PersistenciaException("Erro ao excluir curso - "+ex.getMessage());
        }
    
        return retorno;
    }

    public CursoVO buscarPorCodigo (int codigo) throws PersistenciaException{
        CursoVO curso = null;

        try{
            comandoBuscaCodigo.setInt(1, codigo);
            ResultSet rs = comandoBuscaCodigo.executeQuery();
            if(rs.next()){
                curso = this.montaCursoVO(rs);
            }

        }catch (Exception ex){
            throw new PersistenciaException ("Erro na seleção por codigo - "+ex.getMessage());
        }
        return curso;
    }
}
