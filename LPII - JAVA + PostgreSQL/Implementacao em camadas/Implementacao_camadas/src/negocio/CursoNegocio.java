/*
 * Inclusao, alteração, exclusao, busca por cógido, busca por nome e validação dos dados.
 * 
 */

package negocio;
import java.util.List;
import persistencia.CursoDAO;
import persistencia.Conexaobd;
import persistencia.PersistenciaException;
import vo.CursoVO;

/**
 *
 * @author danub
 */
public class CursoNegocio {
    private CursoDAO cursoDAO;
    
    public CursoNegocio() throws NegocioException{
        try{
            this.cursoDAO = new CursoDAO(Conexaobd.getInstancia());
        }catch (PersistenciaException ex ){
           throw new NegocioException("Erro ao iniciar a Persistencia - " + ex.getMessage());
        }
    }

    public void inserir(CursoVO cursoVO) throws NegocioException{
        String mensagemErros = this.validarDados(cursoVO);
        if (!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);

        }
        try{
            if(cursoDAO.incluir(cursoVO) == 0){
                throw new NegocioException("Inclusao não realizada!!");
                
            }
        }catch (PersistenciaException ex){
            throw new NegocioException("CursoNegocio: Erro ao incluir o curso -"+ ex.getMessage());
        }
    }
    public void alterar(CursoVO cursoVO) throws NegocioException{
        
        String mensagemErros = this.validarDados(cursoVO);
        
        if(!mensagemErros.isEmpty()){
      
            throw new NegocioException(mensagemErros);
        }
        try{
            
            if(cursoDAO.alterar(cursoVO)== 0){
                  
                throw new NegocioException("Alteracao nao realizada!!");
            }
        }catch(PersistenciaException ex){
            throw new NegocioException("Erro ao alterar o curso - "+ex.getMessage());
        }
    }
    
    public void excluir(int codigo) throws NegocioException{
        try{
            if(cursoDAO.excluir(codigo) == 0 ){
                throw new NegocioException("Exclusao nao realizada !!");
            }
        }catch (PersistenciaException ex){
            throw new NegocioException("Erro ao excluir o curso - "+ex.getMessage());
        }
    }

    public List<CursoVO> pesquisaParteNome (String parteNome) throws NegocioException{
        try{
            return cursoDAO.buscaPorCurso(parteNome);
        }catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar o curso - " + ex.getMessage());
        }

    }
    public CursoVO pesquisaCodigo(int codigo) throws NegocioException{
        try{
            return cursoDAO.buscarPorCodigo(codigo);

        }catch (PersistenciaException ex){
            throw new NegocioException("Erro ao pesquisar o curso - "+ex.getMessage());
        }

    }

    private String validarDados(CursoVO cursoVO){
        String mensagemErros= "";
        if(cursoVO.getNome() == null || cursoVO.getNome().length() == 0){
            mensagemErros += "Nome do curso nao pode ser vazio";
        }
        if (cursoVO.getDescricao() == null || cursoVO.getDescricao().length() == 0){
            mensagemErros += "Descricao do curso nao pode ser vazio";
        }
        return mensagemErros;
    }
}
