
package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import vo.DisciplinaVO;
/**
 *
 * @author danub
 */
public class DisciplinaDAO extends DAO{

    private static PreparedStatement comandoIncluir;
    private static PreparedStatement comandoAlterar;
    private static PreparedStatement comandoExcluir;
    private static PreparedStatement comandoBuscaCodigo;
    private static PreparedStatement comandoGrupoCurso;
    
    public DisciplinaDAO(Conexaobd conexao) throws PersistenciaException{
        super(conexao);

        try{
            comandoIncluir = conexao.getConexao().prepareStatement("INSERT INTO Disciplina (nome, semestre, cargahoraria, curso) VALUES (?,?,?,?) ");
            comandoAlterar = conexao.getConexao().prepareStatement("UPDATE Disciplina SET nome=?, semestre=?, cargahoraria=?, curso=? WHERE codigo=?");
            comandoExcluir = conexao.getConexao().prepareStatement("DELETE FROM Disciplina WHERE codigo =?");
            comandoBuscaCodigo = conexao.getConexao().prepareStatement("SELECT * FROM Disciplina WHERE codigo = ?");
            comandoGrupoCurso = conexao.getConexao().prepareStatement("SELECT * FROM Curso ORDER BY nome");
        }catch (SQLException ex){
            System.out.println("Erro ao realizar operação CRUD - "+ex.getMessage());
        }

    }
    public int incluir(DisciplinaVO disciplina) throws PersistenciaException{
        int retorno =0;
        Map <String, Integer> listaGrupos = obterGrupoCurso();
        try{
            comandoIncluir.setString(1, disciplina.getNome());
            comandoIncluir.setInt(2, disciplina.getSemestre());
            comandoIncluir.setInt(3, disciplina.getCargaHoraria());
            comandoIncluir.setInt(4, listaGrupos.get(disciplina.getCurso()));
            retorno = comandoIncluir.executeUpdate();
        }catch(SQLException ex){
            throw new PersistenciaException(" Erro ao incluir aluno − " + ex.getMessage());
        }

    
    

    }


    public Map<String, Integer> obterGrupoCurso(){
        Map <String, Integer> listaGrupos = new HashMap();
       
        try{
            
            ResultSet resultado = comandoGrupoCurso.executeQuery();
            while(resultado.next()){
                listaGrupos.put(resultado.getString("nome"), resultado.getInt("codigo"));
            }
            resultado.close();
        }catch(SQLException ex){
            System.out.println("Erro ao recuperar o grupo de cursos - "+ex.toString());
        }
        return listaGrupos;
    }
}
