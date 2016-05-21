/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bali
 */
public class AccountancyDAOFactory implements AutoCloseable {

    private static AccountancyDAOFactory instance;
    private static EntityManager em;
    private static EntityManagerFactory f;
    

    static {
        instance = new AccountancyDAOFactory();
        f = Persistence.createEntityManagerFactory("org.petApp.jpa");
        em = f.createEntityManager();

    }

    private AccountancyDAOFactory() {

    }

    public static AccountancyDAOFactory getInstance() {
        return instance;
    }
    
    public AccountancyDAO createAccountancyDAO(){
    
        return new AccountancyDAOImpl(em);
    }

    @Override
    public void close() throws Exception {
        em.close();
        f.close();

    }

}
