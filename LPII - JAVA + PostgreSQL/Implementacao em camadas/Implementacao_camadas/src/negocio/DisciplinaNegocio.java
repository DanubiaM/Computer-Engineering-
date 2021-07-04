
package negocio;
import java.util.List;
import persistencia.DisciplinaDAO;
import persistencia.Conexaobd;
import persistencia.PersistenciaException;
import vo.DisciplinaVO;
/**
 *
 * @author danub
 */
public class DisciplinaNegocio {
    private DisciplinaDAO disciplinaDAO;

    public DisciplinaNegocio() throws NegocioException{
        try{
            this.disciplinaDAO = new DisciplinaDAO(Conexaobd.getInstancia());
        }catch(PersistenciaException ex){
            throw new NegocioException("Erro ao iniciar a Persistencia - " + ex.getMessage());
        }
    }
    
    public void inserir(DisciplinaVO disciplina) throws NegocioException{
        String mensagemErros = this.validarDados(disciplina);

        if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }
        try{
            if(disciplinaDAO.incluir(disciplina) == 0){
                throw new NegocioException("Inclusao não realizada!!");
            }
       
        }catch (PersistenciaException ex){
            throw new NegocioException("CursoNegocio: Erro ao incluir o curso -"+ ex.getMessage());
        }
    }
    public void alterar (DisciplinaVO disciplina)throws NegocioException{
    String mensagemErros = this.validarDados(disciplina);
        
        if(!mensagemErros.isEmpty()){
      
            throw new NegocioException(mensagemErros);
        }
        try{
            
            if(disciplinaDAO.alterar(disciplina)== 0){
                  
                throw new NegocioException("Alteracao nao realizada!!");
            }
        }catch(PersistenciaException ex){
            throw new NegocioException("Erro ao alterar o disciplina - "+ex.getMessage());
        }

    }
    public void excluir(int codigo) throws NegocioException{
        try{
            if(disciplinaDAO.excluir(codigo) == 0 ){
                throw new NegocioException("Exclusao nao realizada !!");
            }
        }catch (PersistenciaException ex){
            throw new NegocioException("Erro ao excluir o disciplina - "+ex.getMessage());
        }
    }

    public List<DisciplinaVO> pesquisaParteNome (String parteNome) throws NegocioException{
        try{
            return disciplinaDAO.buscaPorDisciplina(parteNome);
        }catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar a disciplina - " + ex.getMessage());
        }

    }
    public DisciplinaVO pesquisaCodigo(int codigo) throws NegocioException{
        try{
            return disciplinaDAO.buscarPorCodigo(codigo);

        }catch (PersistenciaException ex){
            throw new NegocioException("Erro ao pesquisar a disciplina - "+ex.getMessage());
        }

    }
    public List<DisciplinaVO> listaTodasDisciplinas() throws NegocioException{
        try{
            return disciplinaDAO.listaDisciplina();
        }catch (Exception ex) {
            throw new NegocioException("Erro ao obter lista de disciplinas - " + ex.getMessage());
        }
    }

    //metodo auxiliar
    public String validarDados(DisciplinaVO disciplina){
        String mensagemErros = "";
        if(disciplina.getNome() == null || disciplina.getNome().length() == 0){
            mensagemErros += "Nome da disciplina nao pode ser vazio";
        }
        if (disciplina.getSemestre() <=0 ){
            mensagemErros += "Semestre da disciplina nao pode ser vazia ou menor que zero";
        }
        if (disciplina.getCargaHoraria() <= 0){
            mensagemErros += "Carga horaria da disciplina nao pode ser vazio ou menor que zero";
        }
        if(disciplina.getCurso() == null || disciplina.getCurso().length() == 0){
            mensagemErros += "Nome do curso nao pode ser vazio";
        }
        return mensagemErros;

    }
}
