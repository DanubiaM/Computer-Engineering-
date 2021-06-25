
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
