
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
    
}
