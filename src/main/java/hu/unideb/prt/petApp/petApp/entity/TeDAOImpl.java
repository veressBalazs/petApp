/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.entity;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Bali
 */
public class TeDAOImpl implements TeDAO{
        private EntityManager em;

    public TeDAOImpl(EntityManager em) {
        this.em = em;
    }
        
        
        
        @Override
        public void createTe(TeEntity te){
            em.getTransaction().begin();
            em.persist(te);
            em.getTransaction().commit();
        }
        
        
        @Override
        public List<TeEntity> readAllTe(){ 
            em.getTransaction().begin();
            List<TeEntity> l = em.createQuery("Select t FROM TeEntity t",TeEntity.class).getResultList();
            em.getTransaction().commit();
               
               return l;
        }
        
        @Override
        public void removeTe(TeEntity te){
            em.getTransaction().begin();
            em.remove(te);
            em.getTransaction().commit();
        }
        
        @Override
        public TeEntity readTe(int id){
            
            return em.find(TeEntity.class, id);
        }
    
}
