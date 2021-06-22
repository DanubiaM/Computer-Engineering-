/*
 * 
 */

package execusao;
import java.util.List;
import javax.swing.JOptionPane ;
import negocio.AlunoNegocio;
import negocio.NegocioException ;
import vo.CursoVO;
/**
 *
 * @author danub
 */
public class MenuCurso {
    private CursoNegocio  cursoNegocio;

    public void iniciaCamada(){
       int retorno =0;
       try{
            cursoNegocio = New CursoNegocio();
            retorno =1;
        }catch(NegocioException ex){
            System.out.println("Camada de negocio e presistencia não iniciada - " +ex.getMessage());
        }

    }

    public void iniciaMenuCurso(){
        if (cursoNegocio != null){
            EnumMenuCurso opcao = EnumMenuCurso.Sair;
        
            do {
                try{
                    opcao = exibirMenu();
                    switch (opcao){
                        case IncluirCurso:
                            incluirCurso();
                            break;
                        case AlterarCurso:
                            alterarCurso();
                            break;
                        case ExcluirCurso:
                            excluirCurso();
                            break;
                        case PesqCodigo:
                            pesquisarPorCodigo();
                            break;
                        case PesqNome:
                            pesquisarPorNome();
                            break;
                    }
                }catch (NegocioException ex){
                    System.out.println("Operacao nao realizada corretamente - "+ex.getMessage());
                }

            }while (opcao != EnumMenuCurso.Sair);
            
        }        
    }
    
    private void incluirCurso(){
        CursoVO cursoVO = lerDados();
     
        cursoNegocio.inserir(cursoVO);
    }

    private void alterarCurso(){
        
        int codigo;

       
        try{
            
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do curso ", JOptionPane.QUESTION_MESSAGE));

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - "+ex.getMessage());
        }
        CursoVO cursoVO = cursoNegocio.pesquisaCodigo(codigo);
        if (cursoVO != null){
            CursoVO cursoTemp = lerDados(cursoVO)
            cursoNegocio.alterar(cursoTemp);
        }else{
            JOptionPane.showMessageDialog(null, "Curso não localizado");

        }   
    }

    private int excluirCurso(){
        int codigo;
        try{
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do curso", JOptionPane.QUESTION_MESSAGE));
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - "+ex.getMessage());
        }
        CursoVO cursoTemp = pesquisaCodigo(codigo);

        if (cursoTemp != null){
            cusoNegocio.excluir(cursoTemp.getMatricula());
        }else{
            JOptionPane.showMessageDialog(null, "Curso não localizado");
        }
    }
    private void pesquisarPorCodigo(){        
        int codigo;
        try{
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do curso", JOptionPane.QUESTION_MESSAGE));
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - "+ex.getMessage());
        }
        CursoVO cursoTemp = cursoNegocio.pesquisaCodigo(codigo);
        if (cursoTemp != null ){
            mostrarDados(cursoTemp);
        }else{
            JOptionPane.showMessageDialog(null, "Curso não localizado");
        }
    }

    private void pesquisarPorNome(){
        String nome ;

        try{
            nome = JOptionPane.showInputDialog("Digite o nome do curso","Leitura de Dados", JOptionPane.QUESTION_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - "+ex.getMessage());
        }

        List <CursoVO> listaCurso = pesqiosaParteNome(nome);
        if(listaCurso.size() > 0){
            for(CursoVO cursoVO : listaCurso){
                mostrarDados(cursoVO);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Curso não localizado");
        }
    }  

    


    /* Criando Métodos Auxiliares de leitra e impressao de dados*/

    //leitura de dados
    private CursoVO lerDados(){
        CursoVO cursoTemporario = new CursoVO();

        return lerDados(cursoTemporario);
    }

    private CursoVO lerDados(CursoVO cursoTemp){
        String nome, descricao;
        try{
            nome = JOptionPane.showInputDialog("Forneca o nome do curso", cursoTemp.getNome().trim());
            cursoTemp.setNome(nome);

            descricao = JOptionPane.showInputDialog("Forneca a descricao do curso", cursoTemp.getDescricao().trim());
            cursoTemp.setDescricao(descricao);
        }catch (Exception ex){
            System.out.println("Digitacao inconsistente - " +ex.getMessage());
        }
        return cursoTemp;
    }

    //Impressao de Dados
    public void mostrarDados(CursoVO cursoVO){
        if(cursoVO != null){
            System.out.println("Código................:", cursoVO.getCodigo());
            System.out.println("Nome do curso.........:", cursoVo.getNome());
            System.out.println("Descricao.............:", cursoVO.getDescricao());
            System.out.println("-------------------------------------------------");

        }
    }
}
