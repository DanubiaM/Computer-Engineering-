
package persistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
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
    public int incluir(DisciplinaVO disciplina) throws PersistenciaException{
        int retorno =0;
        Map <String, Integer> listaGrupos = obterGrupoCurso();
        //System.out.println(listaGrupos);
        //System.out.println("Disciplina: "+disciplina.getCurso());
        //System.out.println("Cod?:"+listaGrupos.get("Medicina"));
        try{
            comandoIncluir.setString(1, disciplina.getNome());
            comandoIncluir.setInt(2, disciplina.getSemestre());
            comandoIncluir.setInt(3, disciplina.getCargaHoraria());
            comandoIncluir.setInt(4, listaGrupos.get(disciplina.getCurso()));
            retorno = comandoIncluir.executeUpdate();
        }catch(Exception ex){
            throw new PersistenciaException(" Erro ao incluir aluno − " + ex.getMessage());
        }       
        return retorno;
    }

    public int alterar(DisciplinaVO disciplina) throws PersistenciaException{
       int retorno = 0;
       Map <String, Integer> listaGrupos = obterGrupoCurso();
       try{
            comandoAlterar.setString(1, disciplina.getNome());
            comandoAlterar.setInt(2, disciplina.getSemestre());
            comandoAlterar.setInt(3, disciplina.getCargaHoraria());            
            comandoAlterar.setInt(4, listaGrupos.get(disciplina.getCurso()));            
            comandoAlterar.setInt(5, disciplina.getCodigo());
            retorno = comandoAlterar.executeUpdate();
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
            throw new PersistenciaException("Erro ao excluir disciplina - "+ex.getMessage());
        }
    
        return retorno;
    }

    public DisciplinaVO buscarPorCodigo (int codigo) throws PersistenciaException{
        DisciplinaVO disciplina = null;

        try{           
            comandoBuscaCodigo.setInt(1, codigo);
            ResultSet rs = comandoBuscaCodigo.executeQuery();
            if(rs.next()){                
                disciplina = this.montaDisciplina(rs);                
            }

        }catch (Exception ex){
            throw new PersistenciaException ("Erro na seleção por codigo - "+ex.getMessage());
        }
        return disciplina;
    }

    public List <DisciplinaVO> buscaPorDisciplina (String nome) throws PersistenciaException{
        List <DisciplinaVO> listaDisciplina = new ArrayList<DisciplinaVO>();

        DisciplinaVO disciplina = null;
        String comandoSQL = "SELECT * FROM Disciplina WHERE UPPER(nome) LIKE '"+nome.trim().toUpperCase()+"%' ORDER BY NOME LIMIT 10";
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(comandoSQL);
            ResultSet rs = comando.executeQuery();
            while (rs.next()){
                disciplina = this.montaDisciplina(rs);
                listaDisciplina.add(disciplina);
            }
            comando.close();
        }catch(Exception ex){
            throw new PersistenciaException("Erro na selecao por nome -"+ex.getMessage());
        }
        return listaDisciplina;
    }

    public DisciplinaVO montaDisciplina (ResultSet rs) throws PersistenciaException{
        DisciplinaVO discTemp= new DisciplinaVO();
        
        if(rs != null){
            try{
                discTemp.setCodigo(rs.getInt("codigo"));
                discTemp.setNome(rs.getString("nome").trim());
                discTemp.setSemestre(rs.getInt("semestre"));
                discTemp.setCargaHoraria(rs.getInt("cargahoraria"));                  
                discTemp.setCurso(obterNomeGrupoCurso(rs.getInt("curso")));
                             
            }catch(Exception ex){
                 throw new PersistenciaException("Erro ao acessar dados do resultado");

            }
            
        }
        return discTemp;
    }
   public List <DisciplinaVO> listaDisciplina() throws PersistenciaException{
        List <DisciplinaVO> disciplinasCadastradas = new ArrayList<DisciplinaVO>();
        DisciplinaVO disciplina = null;
        String sqlcommand = "SELECT codigo, nome, semestre, cargahoraria  FROM Disciplina";
        try{
            
            PreparedStatement comando = conexao.getConexao().prepareStatement(sqlcommand);
            ResultSet rs = comando.executeQuery();
            
            while(rs.next()){
                disciplina = montaDisciplina(rs);
                disciplinasCadastradas.add(disciplina);             
            }
            comando.close();
        }catch(SQLException ex){
            System.out.println("Erro ao recuperar lista de disciplinas cadastradas - "+ex.toString());
        }       
        
        return disciplinasCadastradas;
    }

    public String obterNomeGrupoCurso(int cod) throws PersistenciaException{
        String nomeGrupo = null;
        PreparedStatement comandoGrupoCurso = null;        
       
        try{
            
            comandoGrupoCurso = conexao.getConexao().prepareStatement("SELECT * FROM Curso WHERE codigo = ?");
            comandoGrupoCurso.setInt(1, cod);
            ResultSet resultado = comandoGrupoCurso.executeQuery();
           
            if(resultado.next()){                
                nomeGrupo = resultado.getString("nome");
            }             
        }catch(SQLException ex){
            throw new PersistenciaException("Erro ao recuperar um grupo" + ex.toString());
        }        
        return nomeGrupo;
    }

    public Map<String, Integer> obterGrupoCurso(){
        Map <String, Integer> listaGrupos = new HashMap();
        PreparedStatement comandoGrupoCurso = null;
        try{
            comandoGrupoCurso = conexao.getConexao().prepareStatement("SELECT * FROM Curso ORDER BY nome");
            ResultSet resultado = comandoGrupoCurso.executeQuery();
            while(resultado.next()){
                listaGrupos.put(resultado.getString("nome").trim(), resultado.getInt("codigo"));
            }
            resultado.close();
        }catch(SQLException ex){
            System.out.println("Erro ao recuperar o grupo de cursos - "+ex.toString());
        }
        return listaGrupos;
    }
}
