
package execusao;
import java.util.List;
import javax.swing.JOptionPane ;

import negocio.DisciplinaNegocio;
import negocio.NegocioException ;

import vo.DisciplinaVO;

/**
 *
 * @author danub
 */
public class MenuDisciplina {
    private static DisciplinaNegocio disciplinaNegocio;

    public static int iniciaCamada(){
       int retorno =0;
       try{
            disciplinaNegocio = new DisciplinaNegocio();
            retorno =1;
        }catch(NegocioException ex){
            System.out.println("Camada de negocio e presistencia não iniciada - " +ex.getMessage());
        }
        return retorno;
    }

    public void iniciaMenuDisciplina(){
        if (disciplinaNegocio != null){
            EnumMenuDisciplina opcao = EnumMenuDisciplina.Sair;
        
            do {
                try{
                    opcao = exibirMenu();
                    switch (opcao){
                        case IncluirDisciplina:
                            incluirDisciplina();
                            break;
                        case AlterarDisciplina:
                            alterarDisciplina();
                            break;
                        case ExcluirDisciplina:
                            excluirDisciplina();
                            break;
                        case PesqCodigo:
                            pesquisarPorCodigo();
                            break;
                        case PesqNome:
                            pesquisarPorNome();
                            break;
                        case ListaDisciplinas:
                            listarDisciplinas();
                    }
                }catch (NegocioException ex){
                    System.out.println("Operacao nao realizada corretamente - "+ex.getMessage());
                }

            }while (opcao != EnumMenuDisciplina.Sair);
            
        }        
    }
    
    private void incluirDisciplina() throws NegocioException{
        DisciplinaVO disciplinaVO = lerDados();
     
        disciplinaNegocio.inserir(disciplinaVO);
    }

    private void alterarDisciplina() throws NegocioException{
        
        int codigo = 0;       
        try{
            
            codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o codigo da Disciplina ", "Leitura de Dados",JOptionPane.QUESTION_MESSAGE));

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - "+ex.getMessage());
        }
        DisciplinaVO disciplinaVO = disciplinaNegocio.pesquisaCodigo(codigo);
        if (disciplinaVO != null){
            DisciplinaVO disciplinaTemp = lerDados(disciplinaVO);
            disciplinaNegocio.alterar(disciplinaTemp);
        }else{
            JOptionPane.showMessageDialog(null, "Disciplina não localizada");

        }   
    }

    private void excluirDisciplina() throws NegocioException{
        int codigo = 0;
        try{
            codigo= Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca o codigo da Disciplina", "Leitura de Dados",
            JOptionPane.QUESTION_MESSAGE));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - "+ex.getMessage());
        }
        DisciplinaVO disciplinaTemp = disciplinaNegocio.pesquisaCodigo(codigo);

        if (disciplinaTemp != null){
            disciplinaNegocio.excluir(disciplinaTemp.getCodigo());
        }else{
            JOptionPane.showMessageDialog(null, "Disciplina não localizada");
        }
    }
    private void pesquisarPorCodigo() throws NegocioException{        
        int codigo = 0;
        try{
            codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o codigo da Disciplina", "Leitura de Dados",JOptionPane.QUESTION_MESSAGE));
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - "+ex.getMessage());
        }
        DisciplinaVO disciplinaTemp = disciplinaNegocio.pesquisaCodigo(codigo);
        if (disciplinaTemp != null ){
            mostrarDados(disciplinaTemp);
        }else{
            JOptionPane.showMessageDialog(null, "Disciplina não localizada");
        }
    }

    private void pesquisarPorNome() throws NegocioException{  

        String nome = JOptionPane.showInputDialog(null,"Digite o nome da Disciplina","Leitura de Dados", JOptionPane.QUESTION_MESSAGE);
        if (nome != null){

            List <DisciplinaVO> listaDisciplina = disciplinaNegocio.pesquisaParteNome(nome);
            if(listaDisciplina.size() > 0){
                for(DisciplinaVO disciplinaVO : listaDisciplina){
                    mostrarDados(disciplinaVO);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Disciplina não localizada");
            }
        }else{
           JOptionPane.showMessageDialog(null, "Nome nao pode ser nulo");
        }
    }  

    


    /* Criando Métodos Auxiliares de leitra e impressao de dados*/

    //leitura de dados
    private DisciplinaVO lerDados(){
        DisciplinaVO disciplinaTemporario = new DisciplinaVO();

        return lerDados(disciplinaTemporario);
    }

    private DisciplinaVO lerDados(DisciplinaVO disciplinaTemp){
        String nome, curso;
        int cargahoraria, semestre;
        try{
            nome = JOptionPane.showInputDialog("Forneca o nome da Disciplina", disciplinaTemp.getNome().trim());
            disciplinaTemp.setNome(nome);           

            semestre = Integer.parseInt(JOptionPane.showInputDialog("Forneca o semestre da disciplina" , disciplinaTemp.getSemestre()));
            disciplinaTemp.setSemestre(semestre);

            cargahoraria = Integer.parseInt(JOptionPane.showInputDialog("Forneca a carga horaria da disciplina" , disciplinaTemp.getCargaHoraria()));
            disciplinaTemp.setCargaHoraria(cargahoraria);
            

            curso = JOptionPane.showInputDialog("Forneca a descricao do curso", disciplinaTemp.getCurso().trim());
            disciplinaTemp.setCurso(curso);
            
        }catch (Exception ex){
            System.out.println("Digitacao inconsistente - " +ex.getMessage());
        }
        return disciplinaTemp;
    }

    //Impressao de Dados
    public void mostrarDados(DisciplinaVO disciplinaVO){
        if(disciplinaVO != null){
            System.out.println("Código.....................:"+ disciplinaVO.getCodigo());
            System.out.println("Nome da Disciplina.........:"+ disciplinaVO.getNome());
            System.out.println("Semestre...................:"+ disciplinaVO.getSemestre());
            System.out.println("Carga Horaria..............:"+ disciplinaVO.getCargaHoraria());
            System.out.println("Curso......................:"+ disciplinaVO.getCurso());
            System.out.println("-------------------------------------------------");

        }
    }

    public void listarDisciplinas()throws NegocioException{
        List<DisciplinaVO> listaDisciplina = disciplinaNegocio.listaTodasDisciplinas();      

        if (listaDisciplina.size() > 0 ){
            System.out.println("LISTA DE DISCIPLINAS CADASTRADAS");
            for( DisciplinaVO disciplinaVO : listaDisciplina){

                System.out.println("Codigo...............:"+disciplinaVO.getCodigo());
                System.out.println("Nome.................:"+disciplinaVO.getNome());
                System.out.println("Semestre.............:"+disciplinaVO.getSemestre());
                System.out.println("Carga Horária.............:"+disciplinaVO.getCargaHoraria());
                System.out.println("----------------------------------------");                      
            }            
        }else{
            System.out.println("Não foi possivel obter lista de alunos cadastrados");
        }       
    }

    
     private static EnumMenuDisciplina exibirMenu(){
        EnumMenuDisciplina opcao;
        
        opcao = (EnumMenuDisciplina) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Menu", JOptionPane.QUESTION_MESSAGE, null, EnumMenuDisciplina.values(),
        EnumMenuDisciplina.values()[0]);
        
        if (opcao == null){
            JOptionPane.showMessageDialog(null, "Nenhuma opcao escolhida");
            opcao = EnumMenuDisciplina.Sair;
        }
        return opcao;
    }
}
