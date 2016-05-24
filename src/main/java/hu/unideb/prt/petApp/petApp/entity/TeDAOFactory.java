/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.entity;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bali
 */
public class TeDAOFactory implements AutoCloseable{
    
    private static TeDAOFactory instance;
    private static EntityManager em;
    private static EntityManagerFactory f;
     
    static{
        instance = new TeDAOFactory();
        f=Persistence.createEntityManagerFactory("org.petApp.jpa");
        em = f.createEntityManager();
    
    
    }
    
    private TeDAOFactory(){
    }

    public static TeDAOFactory getInstance() {
        return instance;
    }
    
    
    public TeDAO createTeDAO(){
    
        return new TeDAOImpl(em);
    }
    
    
    
    @Override
    public void close() throws Exception {
        em.close();
        f.close();
    }
    
    
}
