/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointroducaojpa;

import vo.GrupoProdutoVO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import vo.GrupoProdutoVO;
/**
 *
 * @author franc
 */
public class Incluir1 {
    public static void main(String args[]){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        GrupoProdutoVO grupoVO = new GrupoProdutoVO();
        
        try{
            String nome = JOptionPane.showInputDialog("Forneca o nome do grupo produto");
            float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual da margem de lucro do grupo de produto"));
            float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de promocao do grupo de produto"));
           grupoVO.setNome(nome);
           grupoVO.setMargemLucro(margem);
           grupoVO.setPromocao(promocao);
           emf = Persistence.createEntityManagerFactory("UnidadeBDPostgres");
           em = emf.createEntityManager();
           em.getTransaction().begin();
           em.persist(grupoVO);
           em.getTransaction().commit();
           System.out.println("Inclusao realizada com sucesso");
        }catch (Exception ex){
            System.out.println("Inclusão não realizada  - "+ex.getMessage());
        }finally{
            if (em != null){
                em.close();
            }
            if (emf != null){
                emf.close();
            }
        }
        
    }
}
