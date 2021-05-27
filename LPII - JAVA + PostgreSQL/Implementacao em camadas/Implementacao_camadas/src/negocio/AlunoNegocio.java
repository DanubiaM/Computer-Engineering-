/*

 */

package negocio;

import java.util.List;
import persistencia.AlunoDAO;
import persistencia.Conexaobd
import persistencia.PersistenciaException;
import vo.AlunoVO;

public class AlunoNegocio {

    private AlunoDAO alunoDAO;

    public AlunoNegocio() throws NegocioException{
        try{
            this.alunoDAO = new AlunoDAO(Conexaobd.getInstancia());
        }catch(PersistenciaException ex){
            throw new NegocioException("Erro ao iniciar a Persistencia - "+ ex.getMessage());
        }

    }

    public void inserir(AlunoVO alunoVO) throws NegocioException{
        String mensagemErros = this.validarDados(alunoVO);
        
        if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }
        try{
            if(alunoDAO.incluir(alunoVO) == 0){
               throw new NegocioException("Inclusao nao realizada!"); 
            }
        }catch(SQLException ex){
            throw new NegocioException("Erro ao incluir o aluno "+ ex.getMessage());
        }
    }

}
