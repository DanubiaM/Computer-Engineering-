package negocio;

import java.util.List;
import persistencia.AlunoDAO;
import persistencia.Conexaobd;
import persistencia.PersistenciaException;
import vo.AlunoVO;


public class AlunoNegocio {

    private AlunoDAO alunoDAO;

    public AlunoNegocio() throws NegocioException {
        try {
            this.alunoDAO = new AlunoDAO(Conexaobd.getInstancia());
        }catch (PersistenciaException ex ){
           throw new NegocioException("Erro ao iniciar a Persistencia - " + ex.getMessage());
        }
    }

    public void inserir(AlunoVO alunoVO) throws NegocioException {
        String mensagemErros = this.validarDados(alunoVO);
        if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }
        try {
            if(alunoDAO.incluir(alunoVO) == 0 ){
                throw new NegocioException("Inclusao nao realizada !!");
            }
        }catch (PersistenciaException ex){
            throw new NegocioException("AlunoNegocio: Erro ao incluir o aluno - " + ex.getMessage());
        }
    }

    public void alterar(AlunoVO alunoVO) throws NegocioException {
        String mensagemErros = this.validarDados(alunoVO);
        if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }
        try {
            if(alunoDAO.alterar(alunoVO) == 0 ){
                throw new NegocioException("Alteracao nao realizada !!");
            }
        }catch (PersistenciaException ex){
            throw new NegocioException("Erro ao alterar o aluno - " + ex.getMessage());
        }
    }

    public void excluir(int codigo) throws NegocioException {
        try {
            if(alunoDAO.excluir(codigo) == 0 ){
                throw new NegocioException("Exclusao nao realizada !!");
            }
        }catch (PersistenciaException ex){
            throw new NegocioException("Erro ao excluir o aluno - " + ex.getMessage());
        }
    }

    public List<AlunoVO> pesquisaParteNome(String parteNome) throws NegocioException {
        try{
           return alunoDAO.buscarPorNome(parteNome);
        }catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar o aluno - " + ex.getMessage());
        }
    }

    public AlunoVO pesquisaMatricula(int matricula) throws NegocioException {
        try{
            return alunoDAO.buscarPorMatricula(matricula);
        }catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao pesquisar o aluno - " + ex.getMessage());
        }
    }


    private String validarDados(AlunoVO alunoVO) {
        String mensagemErros = "";
        if(alunoVO.getNome() == null || alunoVO.getNome().length() == 0){
            mensagemErros += "Nome do aluno nao pode ser vazio";
        }
        if(alunoVO.getNomeMae() == null || alunoVO.getNomeMae().length() == 0){
            mensagemErros += "\n Nome da mae nao pode ser vazio";
        }
        if(alunoVO.getNomePai() == null || alunoVO.getNomePai().length() == 0) {
            mensagemErros += "\n Nome do pai nao pode ser vazio";
        }
        if(alunoVO.getSexo() == null) {
            mensagemErros += "\n Sexo nao pode ser vazio";
        }
        if(alunoVO.getEndereco().getLogradouro() == null || alunoVO.getEndereco().getLogradouro().length() == 0) {
            mensagemErros += "\n Logradouro nao pode ser vazio";
        }
        if(alunoVO.getEndereco().getNumero() <= 0) {
            mensagemErros += "\n Numero deve ser maior que zero";
        }
        if(alunoVO.getEndereco().getBairro() == null || alunoVO.getEndereco().getBairro().length() == 0) {
            mensagemErros += "\n Bairro nao pode ser vazio";
        }
        if(alunoVO.getEndereco().getCidade() == null || alunoVO.getEndereco().getCidade().length() == 0) {
            mensagemErros += "\n Cidade nao pode ser vazio";
        }
        if(alunoVO.getEndereco().getUf() == null) {
            mensagemErros += "\n UF nao pode ser vazio";
        }
        if (alunoVO.getCurso().length() ==0){
            mensagemErros += "\n Curso nao pode ser vazio";
        }
        
        return mensagemErros;
    }
}