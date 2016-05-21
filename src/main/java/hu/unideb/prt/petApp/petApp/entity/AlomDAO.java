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
public class AlomDAO {

    public static EntityManager em;

    public static void createAlom(AlomEntity ae) {
        em.getTransaction().begin();
        em.persist(ae);
        em.getTransaction().commit();
    }

    public static List<AlomEntity> readAllAlom() {
        em.getTransaction().begin();
        List<AlomEntity> l = em.createQuery("Select a FROM AlomEntity a", AlomEntity.class).getResultList();
        em.getTransaction().commit();
        return l;
    }

    public static void removeAlom(AlomEntity ae) {
        em.getTransaction().begin();
        em.remove(ae);
        em.getTransaction().commit();
    }
    
    public static AlomEntity readAlomById(int id){
        return em.find(AlomEntity.class, id);
    }

}
