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
public class AlomDAOImpl implements AlomDAO {

    private EntityManager em;

    public AlomDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void createAlom(AlomEntity ae) {
        em.getTransaction().begin();
        em.persist(ae);
        em.getTransaction().commit();
    }

    @Override
    public List<AlomEntity> readAllAlom() {
        em.getTransaction().begin();
        List<AlomEntity> l = em.createQuery("Select a FROM AlomEntity a", AlomEntity.class).getResultList();
        em.getTransaction().commit();
        return l;
    }

    @Override
    public void removeAlom(AlomEntity ae) {
        em.getTransaction().begin();
        em.remove(ae);
        em.getTransaction().commit();
    }

    @Override
    public AlomEntity readAlomById(int id) {
        return em.find(AlomEntity.class, id);
    }

   
    
    public List<AlomEntity> ReadAlomByTeId(int id){
    
       em.getTransaction().begin();
        List<AlomEntity> l = em.createQuery("Select a FROM AlomEntity a  WHERE a.te_id='" + id + "'", AlomEntity.class).getResultList();
        em.getTransaction().commit();
        return l;
    }

    @Override
    public void UpdateAlom(AlomEntity ae, int alomszam, int elhullas, String leiras, String datum) {
//      em.getTransaction().begin();
//        u.setUsername(username);
//        u.setPassword(password);
//        em.getTransaction().commit();
        em.getTransaction().begin();
        ae.setAlomszam(alomszam);
        ae.setElhullas(elhullas);
        ae.setLeiras(leiras);
        ae.setDatee(datum);
       // em.merge(ae);
        em.getTransaction().commit();
    }

}
