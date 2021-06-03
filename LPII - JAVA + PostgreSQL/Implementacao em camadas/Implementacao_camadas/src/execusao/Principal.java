
package execusao;

import java.util.List;
import javax.swing.JOptionPane ;
import negocio.AlunoNegocio;
import negocio.NegocioException ;

import vo.AlunoVO;
import vo.EnumSexo;
import vo.EnumUF;

public class Principal {
    private static AlunoNegocio alunoNegocio;

    public static void main(String[] args){

        try{
           alunoNegocio = new AlunoNegocio();
        }catch (NegocioException ex){
            System.out.println("Camada de negocio e presistencia não iniciada - " +ex.getMessage());
        }
        
        if (alunoNegocio != null){
            EnumMenu opcao = EnumMenu.Sair;
        
            do {
                try{
                    opcao = exibirMenu();
                    switch (opcao){
                        case IncluirAluno:
                            incluirAluno();
                            break;
                        case AlterarAluno:
                            alterarAluno();
                            break;
                        case ExcluirAluno:
                            excluirAluno();
                            break;
                        case PesqMatricula:
                            pesquisarPorMatricula();
                            break;
                        case PesqNome:
                            pesquisarPorNome();
                    }
                }catch (NegocioException ex){
                    System.out.println("Operacao nao realizada corretamente - "+ex.getMessage());
                }

            }while (opcao != EnumMenu.Sair);
            System.exit(0);
        }
    }

    //Incluindo um novo aluno na base de dados
    private static void incluirAluno() throws NegocioException{
        AlunoVO alunoTemp = lerDados();
        alunoNegocio.inserir(alunoTemp);

    }
    //Alerando dados de um aluno utilizando a matricula
    private static void alterarAluno() throws NegocioException{
        int matricula = 0;
        try{
            matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca a matricula do aluno","Leitura de Dados",
            JOptionPane.QUESTION_MESSAGE));
        
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - "+ex.getMessage());
        }

        AlunoVO alunoVO = alunoNegocio.pesquisaMatricula(matricula);
        if( alunoVO!=null){
            AlunoVO  alunoTemp = lerDados(alunoVO);
            alunoNegocio.alterar(alunoTemp);

        }else {
            JOptionPane.showMessageDialog(null, "Aluno não localizado");
        }

    }

    //Excluindo aluno pela matriculas
    private static void excluirAluno() throws NegocioException{
        int matricula = 0;

        try{
            matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca a matricula do aluno", "Leitura de Dados",
            JOptionPane.QUESTION_MESSAGE));
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - "+ ex.getMessage());
        }

        AlunoVO alunoVO = alunoNegocio.pesquisaMatricula(matricula);
        if (alunoVO != null){
            alunoNegocio.excluir(alunoVO.getMatricula());
        }else {
            JOptionPane.showMessageDialog(null, "Aluno não localizado");
        }

    }

    //Pesquisa por meio de matricula
    private static void pesquisarPorMatricula() throws NegocioException{
        int matricula = 0 ;
        try{
            matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneça a matricula do aluno", "Leitura de Dados",
             JOptionPane.QUESTION_MESSAGE));
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Digitaca inconsistente - "+ex.getMessage());
        }
        AlunoVO alunoVO = alunoNegocio.pesquisaMatricula(matricula);
        if(alunoVO != null){
            mostrarDados(alunoVO);
        }else{
            JOptionPane.showMessageDialog(null, "Aluno nao localizado ");
        }
    }

    //Procura aluno por parte do nome, caso nao possua valor de entrada, retorna os 10 primeiros ordenados pelo nome.
    private static void pesquisarPorNome() throws NegocioException{
        String nome = JOptionPane.showInputDialog(null, "Forneça o nome do aluno","Leitura de Dados", JOptionPane.QUESTION_MESSAGE);
        
        if (nome != null){
            List<AlunoVO> listaAlunoVO = alunoNegocio.pesquisaParteNome(nome);
            
            if (listaAlunoVO.size() > 0 ){
                for(AlunoVO alunoVO : listaAlunoVO){
                    mostrarDados(alunoVO);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Aluno nao localizado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nome nao pode ser nulo");

        }
    }
    
    //Exibir dados do aluno
    private static void mostrarDados(AlunoVO alunoVO){
        if(alunoVO != null){
            System.out.println("Matricula: " +alunoVO.getMatricula());
            System.out.println("Nome: "+alunoVO.getNome());
            System.out.println("Nome Pai: "+alunoVO.getNomePai());
            System.out.println("Nome Mãe: "+alunoVO.getNomeMae());
            System.out.println("Sexo: "+alunoVO.getSexo().name());
            if (alunoVO.getEndereco() != null){
                System.out.println("Logradouro: "+alunoVO.getEndereco().getLogradouro());
                System.out.println("Numero: "+alunoVO.getEndereco().getNumero());
                System.out.println("Bairro: "+alunoVO.getEndereco().getBairro());
                System.out.println("Cidade: "+alunoVO.getEndereco().getCidade());
                System.out.println("UF: "+alunoVO.getEndereco().getUf());
                System.out.println("---------------------------------------------------");

            }
        }
    }
    
    private static AlunoVO lerDados(AlunoVO alunoTemp){
        String nome, nomeMae, nomePai, logradouro, bairro, cidade;
        int numero;
        EnumSexo sexo;
        EnumUF uf;
        
        try{
s
            nome = JOptionPane.showInputDialog("Forneca o nome do aluno ", alunoTemp.getNome().trim());
            alunoTemp.setNome(nome);

            nomeMae = JOptionPane.showInputDialog("Forneca o nome da mae do aluno ", alunoTemp.getNomeMae().trim());
            alunoTemp.setNomeMae(nomeMae);

            nomePai = JOptionPane.showInputDialog("Forneca o nome do pai do aluno ", alunoTemp.getNomePai().trim());
            alunoTemp.setNomePai(nomePai);
            
            sexo = (EnumSexo) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Leitura de Dados", 
                    JOptionPane.QUESTION_MESSAGE, null, EnumSexo.values(), alunoTemp.getSexo());
            alunoTemp.setSexo(sexo);

            logradouro = JOptionPane.showInputDialog("Forneca o logradouro do endereco ",
             alunoTemp.getEndereco().getLogradouro().trim());
             alunoTemp.getEndereco().setLogradouro(logradouro);

             numero = Integer.parseInt(JOptionPane.showInputDialog("Forneca o numero no endereco" , alunoTemp.getEndereco().getNumero()));
             alunoTemp.getEndereco().setNumero(numero);

             bairro = JOptionPane.showInputDialog("Forneca o bairro no endereco ", alunoTemp.getEndereco().getBairro().trim());
             alunoTemp.getEndereco().setBairro(bairro);
             
             cidade = JOptionPane.showInputDialog("Forneca a cidade no endereco ", alunoTemp.getEndereco().getCidade().trim());
             alunoTemp.getEndereco().setCidade(cidade);

             uf = (EnumUF) JOptionPane.showInputDialog(null, " Escolha uma opcao", "Leitura de Dados",
             JOptionPane.QUESTION_MESSAGE, null, EnumUF.values(), alunoTemp.getEndereco().getUf());
             alunoTemp.getEndereco().setUf(uf);
        }catch (Exception ex){
            System.out.println("Digitacao inconsistente - " +ex.getMessage());
        }
        return alunoTemp;
    }

    private static AlunoVO lerDados(){
        AlunoVO alunoTemp = new AlunoVO();
        return lerDados(alunoTemp);
    }

    private static EnumMenu exibirMenu(){
        EnumMenu opcao;
        
        opcao = (EnumMenu) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Menu", JOptionPane.QUESTION_MESSAGE, null, EnumMenu.values(),
        EnumMenu.values()[0]);
        
        if (opcao == null){
            JOptionPane.showMessageDialog(null, "Nenhuma opcao escolhida");
            opcao = EnumMenu.Sair;
        }
        return opcao;
    }
}
