
package execusao;
import java.util.List;
import javax.swing.JOptionPane ;

import negocio.CursoNegocio;
import negocio.NegocioException ;

import vo.CursoVO;

/**
 *
 * @author danub
 */
public class MenuCurso {
    private static CursoNegocio  cursoNegocio;

    public static int iniciaCamada(){
       int retorno =0;
       try{
            cursoNegocio = new CursoNegocio();
            retorno =1;
        }catch(NegocioException ex){
            System.out.println("Camada de negocio e presistencia não iniciada - " +ex.getMessage());
        }
        return retorno;
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
                        case  ListaCursos:
                            listarCursos();
                    }
                }catch (NegocioException ex){
                    System.out.println("Operacao nao realizada corretamente - "+ex.getMessage());
                }

            }while (opcao != EnumMenuCurso.Sair);
            
        }        
    }
    
    private void incluirCurso() throws NegocioException{
        CursoVO cursoVO = lerDados();
     
        cursoNegocio.inserir(cursoVO);
    }

    private void alterarCurso() throws NegocioException{
        
        int codigo = 0;       
        try{
            
            codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o codigo do curso ", "Leitura de Dados",JOptionPane.QUESTION_MESSAGE));

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - "+ex.getMessage());
        }
        CursoVO cursoVO = cursoNegocio.pesquisaCodigo(codigo);
        if (cursoVO != null){
            CursoVO cursoTemp = lerDados(cursoVO);
            cursoNegocio.alterar(cursoTemp);
        }else{
            JOptionPane.showMessageDialog(null, "Curso não localizado");

        }   
    }

    private void excluirCurso() throws NegocioException{
        int codigo = 0;
        try{
            codigo= Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca o codigo do curso", "Leitura de Dados",
            JOptionPane.QUESTION_MESSAGE));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - "+ex.getMessage());
        }
        CursoVO cursoTemp = cursoNegocio.pesquisaCodigo(codigo);

        if (cursoTemp != null){
            cursoNegocio.excluir(cursoTemp.getCodigo());
        }else{
            JOptionPane.showMessageDialog(null, "Curso não localizado");
        }
    }
    private void pesquisarPorCodigo() throws NegocioException{        
        int codigo = 0;
        try{
            codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o codigo do curso", "Leitura de Dados",JOptionPane.QUESTION_MESSAGE));
        
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

    private void pesquisarPorNome() throws NegocioException{  

        String nome = JOptionPane.showInputDialog(null,"Digite o nome do curso","Leitura de Dados", JOptionPane.QUESTION_MESSAGE);
        if (nome != null){

            List <CursoVO> listaCurso = cursoNegocio.pesquisaParteNome(nome);
            if(listaCurso.size() > 0){
                for(CursoVO cursoVO : listaCurso){
                    mostrarDados(cursoVO);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Curso não localizado");
            }
        }else{
           JOptionPane.showMessageDialog(null, "Nome nao pode ser nulo");
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
            System.out.println("Código................:"+ cursoVO.getCodigo());
            System.out.println("Nome do curso.........:"+ cursoVO.getNome());
            System.out.println("Descricao.............:"+ cursoVO.getDescricao());
            System.out.println("-------------------------------------------------");

        }
    }
    public void listarCursos() throws NegocioException{
    List <CursoVO> lista = cursoNegocio.listaCursos();
    
        if (lista.size() > 0 ){
            System.out.println("LISTA DE CURSOS CADASTRADOS");
            for( CursoVO cursoVO : lista){

                System.out.println("Codigo............:"+cursoVO.getCodigo());
                System.out.println("Nome.................:"+cursoVO.getNome());                    
                System.out.println("----------------------------------------");                     
                 
            }       
                
        }else{
            System.out.println("Não foi possivel obter lista de cursos cadastrados");
        }
    

    }

     private static EnumMenuCurso exibirMenu(){
        EnumMenuCurso opcao;
        
        opcao = (EnumMenuCurso) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Menu", JOptionPane.QUESTION_MESSAGE, null, EnumMenuCurso.values(),
        EnumMenuCurso.values()[0]);
        
        if (opcao == null){
            JOptionPane.showMessageDialog(null, "Nenhuma opcao escolhida");
            opcao = EnumMenuCurso.Sair;
        }
        return opcao;
    }
}
