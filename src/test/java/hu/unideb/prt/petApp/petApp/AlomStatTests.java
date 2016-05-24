/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp;

import static hu.unideb.prt.petApp.petApp.AlomStatistics.alomszamAtlag;
import static hu.unideb.prt.petApp.petApp.AlomStatistics.legnagyobbAlom;
import static hu.unideb.prt.petApp.petApp.AlomStatistics.osszesSzaporulat;
import hu.unideb.prt.petApp.petApp.entity.AlomEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Bali
 */
public class AlomStatTests extends TestCase {
    
    public AlomStatTests(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAlomszam(){
        LocalDate date = LocalDate.MAX;
        List<AlomEntity> ae = new ArrayList<>();
        AlomEntity a1 = new AlomEntity(1, 2, 0, "", date.toString());
        AlomEntity a2 = new AlomEntity(1, 5, 1, "", date.toString());
        AlomEntity a3 = new AlomEntity(1, 5, 1, "", date.toString());
        ae.add(a1);
        ae.add(a2);
        ae.add(a3);
        
        assertEquals(Integer.valueOf(4), alomszamAtlag(ae));
        
        List<AlomEntity> ae1 = new ArrayList<>();
        a1 = new AlomEntity(1, 1, 0, "", date.toString());
        a2 = new AlomEntity(1, 1, 1, "", date.toString());
        a3 = new AlomEntity(1, 5, 1, "", date.toString());
        ae1.add(a1);
        ae1.add(a2);
        ae1.add(a3);
        
        
        assertEquals(Integer.valueOf(2), alomszamAtlag(ae1));
    }
    
    
    public void testOsszesSzap(){
        LocalDate date = LocalDate.MAX;
        List<AlomEntity> ae = new ArrayList<>();
        AlomEntity a1 = new AlomEntity(1, 2, 0, "", date.toString());
        AlomEntity a2 = new AlomEntity(1, 5, 1, "", date.toString());
        AlomEntity a3 = new AlomEntity(1, 5, 1, "", date.toString());
        ae.add(a1);
        ae.add(a2);
        ae.add(a3);
        
         assertEquals(Integer.valueOf(12), osszesSzaporulat(ae));
         
        List<AlomEntity> ae1 = new ArrayList<>();
        a1 = new AlomEntity(1, 1, 0, "", date.toString());
        a2 = new AlomEntity(1, 1, 1, "", date.toString());
        a3 = new AlomEntity(1, 5, 1, "", date.toString());
        ae1.add(a1);
        ae1.add(a2);
        ae1.add(a3);
        
        
        assertEquals(Integer.valueOf(7), osszesSzaporulat(ae1));
    
    
    }
    
    public void testLegnagyobbAlom(){
        LocalDate date = LocalDate.MAX;
        List<AlomEntity> ae = new ArrayList<>();
        AlomEntity a1 = new AlomEntity(1, 2, 0, "", date.toString());
        AlomEntity a2 = new AlomEntity(1, 5, 1, "", date.toString());
        AlomEntity a3 = new AlomEntity(1, 5, 1, "", date.toString());
        ae.add(a1);
        ae.add(a2);
        ae.add(a3);
        
         assertEquals(Integer.valueOf(5), legnagyobbAlom(ae));
         
        List<AlomEntity> ae1 = new ArrayList<>();
        a1 = new AlomEntity(1, 1, 0, "", date.toString());
        a2 = new AlomEntity(1, 1, 1, "", date.toString());
        a3 = new AlomEntity(1, 11, 1, "", date.toString());
        ae1.add(a1);
        ae1.add(a2);
        ae1.add(a3);
        
        
        assertEquals(Integer.valueOf(11), legnagyobbAlom(ae1));         
    
    
    }
    
    
}
