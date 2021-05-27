/*

 */

package negocio;


public class AlunoNegocio {

    private AlunoDAO alunoDAO;

    public AlunoNegocio() throws NegocioException{
        try{
            this.alunoDAO = new AlunoDAO(Conexaobd.getInstancia());
        }catch(PersistenciaException ex){
            throw new NegocioException("Erro ao iniciar a Persistencia - "+ ex.getMessage());
        }

    }

}
