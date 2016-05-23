package hu.unideb.prt.petApp.petApp;

import hu.unideb.prt.petApp.petApp.entity.AccountancyDAOFactory;
import hu.unideb.prt.petApp.petApp.entity.AccountancyDAOImpl;
import static hu.unideb.prt.petApp.petApp.entity.AccountancyDAOImpl.*;
import static hu.unideb.prt.petApp.petApp.entity.TeDAOImpl.*;
import static hu.unideb.prt.petApp.petApp.entity.AlomDAOImpl.*;
//import static hu.unideb.prt.petApp.petApp.entity.AccountancyDAO.em;

import hu.unideb.prt.petApp.petApp.entity.AccountancyEntity;
import hu.unideb.prt.petApp.petApp.entity.AccountancyEntity;
import hu.unideb.prt.petApp.petApp.entity.AlomDAOImpl;
import hu.unideb.prt.petApp.petApp.entity.AlomEntity;
import hu.unideb.prt.petApp.petApp.entity.TeDAOImpl;
import hu.unideb.prt.petApp.petApp.entity.TeEntity;
import hu.unideb.prt.petApp.petApp.ui.AccountanceStarter;
import java.time.Clock;
import java.time.Instant;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    //private static EntityManager em;
    
     public static void main( String[] args ) throws Exception
    {
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.petApp.jpa");
//        AccountancyDAOImpl.em = emf.createEntityManager();
//        EntityManagerFactory emfTe = Persistence.createEntityManagerFactory("org.petApp.jpa");
//        TeDAOImpl.em = emfTe.createEntityManager();
//        EntityManagerFactory emfAlom = Persistence.createEntityManagerFactory("org.petApp.jpa");
//        AlomDAOImpl.em = emfAlom.createEntityManager();
        
        
        
         System.out.println( "Hello World! asd asdasdasdads" );
         
         //AlomEntity ae = new AlomEntity(1, 10, 1, "eross alom");
         //createAlom(ae);
         //LocalDate date = LocalDate.of(2010, Month.MARCH, 10);
         
//         AccountancyEntity acce = new AccountancyEntity("alma", 2, Boolean.TRUE, "asdasdasd", 10, date.toString());
//         createEntry(acce);
//    TeEntity proba = new TeEntity(2, "Hörcsög", "valami ven vagy leiras");
//         createTe(proba);
//         
//         System.out.println(readAllTe());
       // createEntry("tengerimalac", 4, Boolean.TRUE, "4 malac leadva", 2400, LocalDate.MAX,2);
      //createEntry("buza", 10, Boolean.FALSE, "10 kg buza veve", 600, 3);
       //System.out.println(readEntry(1));
      // AccountancyEntity a1 = new AccountancyEntity("nyul", 20, Boolean.TRUE, "nyulak eladva háztól", 20000,2131);
       //createEntry(a1);
       
       Application.launch(AccountanceStarter.class,args);
        //System.out.println(readAllEntry());
        //List<AccountancyEntity> p = readAllEntry();
        //System.out.println(p.get(0).getAmount());
        AccountancyDAOFactory.getInstance().close();
        
       
    }
    
    
    
    
    
}
