package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vo.CursoVO;
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
            comandoIncluir.setString(1, cursoVO.getNome());
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
            comandoAlterar.setString(1, cursoVO.getNome());
            comandoAlterar.setString(2, cursoVO.getDescricao());
            comandoAlterar.setInt(3, cursoVO.getCodigo());         
            
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

    public List <CursoVO> buscaPorCurso (String nome) throws PersistenciaException{
        List <CursoVO> listaCurso = new ArrayList<CursoVO>();

        CursoVO curso = null;
        String comandoSQL = "SELECT * FROM Curso WHERE UPPER(nome) LIKE '"+nome.trim().toUpperCase()+"%' ORDER BY NOME LIMIT 10";
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(comandoSQL);
            ResultSet rs = comando.executeQuery();
            while (rs.next()){
                curso = this.montaCursoVO(rs);
                listaCurso.add(curso);
            }
            comando.close();
        }catch(Exception ex){
            throw new PersistenciaException("Erro na selecao por nome -"+ex.getMessage());
        }
        return listaCurso;
    }

    private CursoVO montaCursoVO(ResultSet rs) throws PersistenciaException{
        CursoVO curso = new CursoVO();
         
        if (rs != null){
            try{
               curso.setCodigo(rs.getInt("codigo"));
               curso.setNome(rs.getString("nome").trim());
               curso.setDescricao(rs.getString("descricao").trim());

            }catch (Exception ex){
                throw new PersistenciaException("Erro ao acessar dados do resultado");
            }
        }
        return curso;
    }
    public List <CursoVO> listaCursos() throws PersistenciaException{
        List <CursoVO> cursosCadastrados = new ArrayList<CursoVO>();
        CursoVO curso = null;
        String sqlcommand = "SELECT codigo, nome  FROM Curso ";
        try{
            
            PreparedStatement comando = conexao.getConexao().prepareStatement(sqlcommand);
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                curso = montaCurso(rs);
                cursosCadastrados.add(curso);             
            }
            comando.close();
        }catch(SQLException ex){
            System.out.println("Erro ao recuperar lista de cursos cadastrados - "+ex.toString());
        }       
        
        return cursosCadastrados;
    }
    private CursoVO montaCurso(ResultSet rs) throws PersistenciaException{
            CursoVO curso = new CursoVO();

            if (rs != null){
                try{
                   curso.setCodigo(rs.getInt("codigo"));
                   curso.setNome(rs.getString("nome").trim());
                   

                }catch (Exception ex){
                    throw new PersistenciaException("Erro ao acessar dados do resultado");
                }
            }
            return curso;
    }

     public void listaCursoAluno(String curso) throws PersistenciaException{
        
        
        PreparedStatement comando = null;
        try{
            
            comando = conexao.getConexao().prepareStatement("SELECT  Aluno.nome as nomeAluno, Aluno.matricula , Curso.codigo, Curso.nome as nomeCurso FROM Aluno INNER JOIN Curso ON codigo = curso WHERE upper(Curso.nome) = ?");
            comando.setString(1, curso.toUpperCase());         
            ResultSet rs = comando.executeQuery();            
            System.out.println(">>>LISTA DE ALUNOS DO CURSO DE "+curso.toUpperCase()+"<<<");
            while(rs.next()){
                System.out.println("Codigo do Curso...........:"+rs.getInt("codigo"));
                System.out.println("Nome do curso.............:"+rs.getString("nomecurso"));
                System.out.println("Matricula.................:"+rs.getInt("matricula"));
                System.out.println("Nome......................:"+rs.getString("nomealuno"));
                System.out.println(".......................................");
            }
            comando.close();
        }catch(SQLException ex){
            throw new PersistenciaException("Erro ao acessar alunos do curso");
        }
    } 

 public void listaCursoDisciplina(String curso) throws PersistenciaException{
        
        
        PreparedStatement comando = null;
        try{
            
            comando = conexao.getConexao().prepareStatement("SELECT  Disciplina.nome as nomeDisciplina, Disciplina.codigo as codigoDisciplina, Curso.codigo as codigoCurso, Curso.nome as nomeCurso  \n" +
                                                            "FROM Disciplina INNER JOIN Curso  ON curso = Curso.codigo  WHERE upper(Curso.nome) = ?"); 
            comando.setString(1, curso.toUpperCase());         
            ResultSet rs = comando.executeQuery();            
            System.out.println(">>>LISTA DE DISCIPLINAS DO CURSO DE "+curso.toUpperCase()+"<<<");
            while(rs.next()){
                System.out.println("Codigo do Curso...........:"+rs.getInt("codigocurso"));
                System.out.println("Nome do curso.............:"+rs.getString("nomecurso"));
                System.out.println("Codigo Disciplina.................:"+rs.getInt("codigodisciplina"));
                System.out.println("Disciplina......................:"+rs.getString("nomedisciplina"));
                System.out.println(".......................................");
            }
            comando.close();
        }catch(SQLException ex){
            throw new PersistenciaException("Erro ao acessar disciplinas do curso");
        }
    }     
}
