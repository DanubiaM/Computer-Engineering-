/*

 */

package negocio;

import java.util.List;
import persistencia.AlunoDAO;
import persistencia.Conexaobd;
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

    public void inserir (AlunoVO alunoVO) throws NegocioException{
        String mensagemErros = this.validarDados(alunoVO);
        
        if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }
        try{
            if(alunoDAO.incluir(alunoVO) == 0){
               throw new NegocioException("Inclusao nao realizada!"); 
            }
        }catch(PersistenciaException ex){
            throw new NegocioException("Erro ao incluir o aluno "+ ex.getMessage());
        }
    }

    public void alterar(AlunoVO alunoVO) throws NegocioException{
        String mensagemErros = this.validarDados(alunoVO);
        if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }try{
            if(alunoDAO.alterar(alunoVO) == 0)
                throw new NegocioException("Altecao não realizada!!");
        }catch (PersistenciaException ex){
            throw new NegocioException  ("Erro ao alterar o aluno - "+ex.getMessage());
        }
    }
    
    public void excluir (int codigo) throws NegocioException{
        try{
            if (alunoDAO.excluir(codigo) == 0){
                throw new NegocioException("Exclusao não realizada!!");
            }
        }catch (PersistenciaException ex ){
            throw new NegocioException ("Erro ao excluir o aluno - "+ex.getMessage());
        }
    }

    public List<AlunoVO> pesquisaParteNome (String parteNome) throws NegocioException{
        try{
            return alunoDAO.buscarPorNome(parteNome);

        }catch (PersistenciaException ex){
            throw new NegocioException("Erro ao pesquisar aluno pelo nome - "+ ex.getMessage());
        }

    }

    public AlunoVO pesquisaMatricula (int matricula) throws NegocioException{
        try{
            return alunoDAO.buscaPorMatricula(matricula);

        }catch (PersistenciaException ex){
            throw new NegocioException("Erro ao pesquisar aluno pela matricula - "+ex.getMessage());
        }

    }

    private String validarDados (AlunoVO alunoVO){
        String mensagemErros = "";

        if (alunoVO.getNome() == null || alunoVO.getNome().lenght() == 0){
            mensagemErros +="Nome do aluno não pode ser vazio";
        }
        if (alunoVO.getNomeMae() == null || alunoVO.getNomeMae().lenght() == 0){
            mensagemErros+="\n Nome da mãe não pode ser vazio";

        }
        if (alunoVO.getNomePai() == null || alunoVO.getNomePai().lenght() == 0){
            mensagemErros+="\n Nome da pai não pode ser vazio";
        }
        if (alunoVO.getSexo() == null){
            mensagemErros += "\nSexo não pode ser nulo";
        }
        if (alunoVO.getEndereco().getLogradouro()== null || alunoVO.getEndereco().getLogradouro().lenght() == 0){
            mensagemErros +="\n Logradouro não pode ser vazio";
        }
        if(alunoVO.getEndereco().getNumero <=0){
            mensagemErros +="\n Numero deve ser maior que zero";
        }
        if (alunoVO.getEndereco().getBairro() == null || alunoVO.getEndereco().getBairro().lenght() == 0){
            mensagemErros +="\n Bairro não pode ser vazio";
        }
        if (alunoVO.getEndereco().getCidade() == null || alunoVO.getEndereco().getCidade.lenght() == 0){
            mensagemErros +="\n Cidade não pode ser vazio";

        }
        if (alunoVO.getEndereco().getUf == null){
            mensagemErros +="\n UF não pode ser vazio";
        }

        //Adicionado por conta.
        if (mensagemErros == null){
            return "Dados validados com sucesso!";
        }else{
            return mensagemErros;
        }
    }
}
