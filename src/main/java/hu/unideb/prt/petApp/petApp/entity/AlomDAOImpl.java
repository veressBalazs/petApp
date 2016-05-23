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

    @Override
    public void UpdateAlom(AlomEntity ae) {
        em.getTransaction().begin();
        em.remove(ae);
        em.persist(ae);
        em.getTransaction().commit();
    }

}
