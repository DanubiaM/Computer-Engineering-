/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetointroducaojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;
import org.hibernate.jpa.HibernatePersistenceProvider;

/**
 *
 * @author franc
 */
public class ContextoPersistencia{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try{
            emf = Persistence.createEntityManagerFactory("UnidadeBDPostgres");
            //PersistenceProvider provider = new HibernatePersistenceProvider();
            //EntityManagerFactory emf = provider.createEntityManagerFactory("UnidadeBDPostgres");
            
            em = emf.createEntityManager();
            System.out.println("Contexto de presistencia criado com sucesso");
        }catch(Exception ex){
            System.out.println(ex.toString());
            System.out.println("Conexao de persistencia não foi criado - "+ex.getMessage());
            
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
