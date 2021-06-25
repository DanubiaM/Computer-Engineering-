
package negocio;

/**
 *
 * @author danub
 */
public class DisciplinaNegocio {
    private DisciplinaDAO disciplinaDAO;

    public DisciplinaNegocio() throws NegocioException{
        try{
            this.DisciplinaDAO = new DisciplinaDAO(Conexaobd.getInstancia());
        }catch(PersistenciaException ex){
            throw new NegocioException("Erro ao iniciar a Persistencia - " + ex.getMessage());
        }
    }
    
    public void inserir(DisciplinaVO disciplina) throws NegocioException(){
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
}
