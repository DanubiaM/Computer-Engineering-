/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointroducaojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import vo.GrupoProdutoVO;


public class Alterar1 {
    public static void main(String args[]){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        GrupoProdutoVO grupoVO = null;
        
        try{
            emf = Persistence.createEntityManagerFactory("UnidadeBDPostgres");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            String pNome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto a ser localizado");
            
            Query consulta = em.createQuery("SELECCT gp FROM GrupoProdutoVO gp WHERE UPPER(gp.nome) = :pNome");
            consulta.setParameter("pNome", pNome.toUpperCase());
            
            List <GrupoProdutoVO> lista = consulta.getResultList();
            if(lista.size()>0){
                grupoVO = lista.get(0);
                String nome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto", grupoVO.getNome());
                float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual da margem de lucro do grupo de produto", grupoVO.getMargemLucro()));
                float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de promocao do grupo de produto", grupoVO.getPromocao()));
                grupoVO.setNome(nome);
                grupoVO.setMargemLucro(margem);
                grupoVO.setPromocao(promocao);
                em.merge(grupoVO);
                em.getTransaction().commit();
                System.out.println("Alteracao realizada com sucesso");
            }else{
                System.out.println("Grupo de Produto nao localizado");
            }           
        }catch(Exception ex){
            System.out.println("Alteracao nao realizada - "+ex.getMessage());
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
