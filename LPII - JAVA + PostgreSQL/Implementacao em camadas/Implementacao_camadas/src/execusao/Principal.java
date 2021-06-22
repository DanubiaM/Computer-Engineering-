
package execusao;

import java.util.List;
import javax.swing.JOptionPane ;
import negocio.AlunoNegocio;
import negocio.NegocioException ;

import vo.AlunoVO;
import vo.EnumSexo;
import vo.EnumUF;

public class Principal {
    private static MenuAluno alunoMenu = new MenuAluno();
    private static MenuCurso cursoMenu = new MenuCurso();
    public static void main(String[] args){       
        
        if (alunoMenu.iniciaCamada() != 0 & cursoMenu.iniciaCamada() != 0){
            EnumMenuPrincipal opcao = EnumMenuPrincipal.Sair;
        
            do {
                
                    opcao = exibirMenu();
                    switch (opcao){
                        case Aluno:
                            alunoMenu.iniciaMenuAluno();
                            break;
                        case Curso:
                            cursoMenu.iniciaMenuCurso();
                            break;
                        case Disciplina:
                            //excluirAluno();
                                                 
                    }
                
            }while (opcao != EnumMenuPrincipal.Sair);
            System.exit(0);
        }
    }
      
 
    private static EnumMenuPrincipal exibirMenu(){
        EnumMenuPrincipal opcao;
        
        opcao = (EnumMenuPrincipal) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Menu", JOptionPane.QUESTION_MESSAGE, null, EnumMenuPrincipal.values(),
        EnumMenuPrincipal.values()[0]);
        
        if (opcao == null){
            JOptionPane.showMessageDialog(null, "Nenhuma opcao escolhida");
            opcao = EnumMenuPrincipal.Sair;
        }
        return opcao;
    }

}
