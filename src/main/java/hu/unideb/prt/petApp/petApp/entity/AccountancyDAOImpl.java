/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.entity;

import hu.unideb.prt.petApp.petApp.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

/**
 *
 * @author Bali
 */
public class AccountancyDAOImpl implements AccountancyDAO{

    private EntityManager em;

    public AccountancyDAOImpl(EntityManager em) {
        this.em = em;
    }

    
    
    

    
    @Override
    public void createEntry(AccountancyEntity ae) {
        em.getTransaction().begin();
        em.persist(ae);
        em.getTransaction().commit();

    }

    @Override
    public List<AccountancyEntity> readAllEntry() {
        em.getTransaction().begin();
        List<AccountancyEntity> l = em.createQuery("Select a FROM AccountancyEntity a ", AccountancyEntity.class).getResultList();
        em.getTransaction().commit();
        return l;
    }

    @Override
    public  AccountancyEntity readEntry(int id) {

        return em.find(AccountancyEntity.class, id);

    }

    @Override
    public void removeEntry(AccountancyEntity ae) {
        em.getTransaction().begin();
        em.remove(ae);
        em.getTransaction().commit();
    }
    
    

}
