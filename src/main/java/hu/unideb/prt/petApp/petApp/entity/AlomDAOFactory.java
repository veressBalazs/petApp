/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sun.security.jca.GetInstance;

/**
 *
 * @author Bali
 */
public class AlomDAOFactory implements AutoCloseable{
    
    
    private static AlomDAOFactory instance;
    private static EntityManager em;
    private static EntityManagerFactory f;
    
    static{
        instance = new AlomDAOFactory();
        f = Persistence.createEntityManagerFactory("org.petApp.jpa");
        em = f.createEntityManager();
    }

    private AlomDAOFactory() {
    }

    public static AlomDAOFactory getInstance() {
        return instance;
    }
    
    public AlomDAO createAlomDAO(){
    
        return new AlomDAOImpl(em);
    }
    
    
    @Override
    public void close() throws Exception {
       
    
    
    
    }
    
}
