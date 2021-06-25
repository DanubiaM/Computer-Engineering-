
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

    //metodo auxiliar
    public String validarDados(DisciplinaVO disciplina){
        String mensagemErros = "";
        if(disciplina.getNome() == null || disciplina.getNome().length() == 0){
            mensagemErros += "Nome da disciplina nao pode ser vazio";
        }
        if (disciplina.getSemestre() == null || disciplina.getSemestre() == 0){
            mensagemErros += "Semestre da disciplina nao pode ser vazio";
        }
        if (disciplina.getCargaHoraria() == null || disciplina.getCargaHoraria() == 0){
            mensagemErros += "Carga horaria da disciplina nao pode ser vazio";
        }
        if(disciplina.getCurso() == null || disciplina.getCurso().length() == 0){
            mensagemErros += "Nome do curso nao pode ser vazio";
        }
        return mensagemErros;

    }
}
