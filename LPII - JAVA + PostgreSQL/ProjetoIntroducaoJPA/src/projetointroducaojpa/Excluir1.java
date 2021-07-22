/*

 */
package projetointroducaojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import vo.GrupoProdutoVO;

public class Excluir1 {
    public static void main(String args[]){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        GrupoProdutoVO grupoVO = null;
        
        try{
            emf = Persistence.createEntityManagerFactory("UnidadeBDPostgres");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String pNome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto a ser excluido");
            
            Query consulta = em.createQuery("SELECT gp FROM GrupoProdutoVO gp WHERE UPPER(gp.nome) = :pNome");
            consulta.setParameter("pNome", pNome.toUpperCase());
            List<GrupoProdutoVO> lista = consulta.getResultList();
            
            if (lista.size() > 0){
                grupoVO = lista.get(0);
                em.remove(grupoVO);
                em.getTransaction().commit();
                System.out.println("Exclusão realizada com sucesso");
            }else{
                System.out.println("Grupo de Produto não localziado");
            }
        }catch(Exception ex){
            System.out.println("Exclusao não realizada - "+ex.getMessage());
        }finally{
            if(em != null){
                em.close();
                
            }
            if (emf != null){
                emf.close();
            }
        }
    }
}
