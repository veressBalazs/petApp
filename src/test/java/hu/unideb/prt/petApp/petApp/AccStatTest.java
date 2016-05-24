/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp;

import static hu.unideb.prt.petApp.petApp.AccountancyStatistics.calcIncome;
import static hu.unideb.prt.petApp.petApp.AccountancyStatistics.calcOutgo;
import static hu.unideb.prt.petApp.petApp.AccountancyStatistics.calcProfit;
import hu.unideb.prt.petApp.petApp.entity.AccountancyEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Bali
 */
public class AccStatTest extends TestCase {

    public AccStatTest(String testName) {
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

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    public void testKiad() {
        List<AccountancyEntity> lista = new ArrayList<>();
        LocalDate date = LocalDate.MAX;
        AccountancyEntity e1 = new AccountancyEntity("t1", 10, "Kiadás", "s", 100, date.toString());
        AccountancyEntity e2 = new AccountancyEntity("t1", 10, "Bevétel", "s", 200, date.toString());
        AccountancyEntity e3 = new AccountancyEntity("t1", 10, "Kiadás", "s", 100, date.toString());
        lista.add(e1);
        lista.add(e2);
        lista.add(e3);
        assertEquals(Integer.valueOf(200), calcOutgo(lista));

        e1 = new AccountancyEntity("t1", 10, "Kiadás", "s", 100, date.toString());
        e2 = new AccountancyEntity("t1", 10, "Bevétel", "s", 200, date.toString());
        e3 = new AccountancyEntity("t1", 10, "Bevétel", "s", 100, date.toString());
        List<AccountancyEntity> lista1 = new ArrayList<>();
        lista1.add(e1);
        lista1.add(e2);
        lista1.add(e3);
        assertEquals(Integer.valueOf(100), calcOutgo(lista1));

    }

    public void testbe() {
        List<AccountancyEntity> lista = new ArrayList<>();
        LocalDate date = LocalDate.MAX;
        AccountancyEntity e1 = new AccountancyEntity("t1", 10, "Kiadás", "s", 100, date.toString());
        AccountancyEntity e2 = new AccountancyEntity("t1", 10, "Bevétel", "s", 200, date.toString());
        AccountancyEntity e3 = new AccountancyEntity("t1", 10, "Kiadás", "s", 100, date.toString());
        lista.add(e1);
        lista.add(e2);
        lista.add(e3);

        assertEquals(Integer.valueOf(200), calcIncome(lista));

        e1 = new AccountancyEntity("t1", 10, "Kiadás", "s", 100, date.toString());
        e2 = new AccountancyEntity("t1", 10, "Bevétel", "s", 200, date.toString());
        e3 = new AccountancyEntity("t1", 10, "Bevétel", "s", 100, date.toString());
        List<AccountancyEntity> lista1 = new ArrayList<>();
        lista1.add(e1);
        lista1.add(e2);
        lista1.add(e3);
        assertEquals(Integer.valueOf(300), calcIncome(lista1));

    }

    public void testProfit() {
        List<AccountancyEntity> lista = new ArrayList<>();
        LocalDate date = LocalDate.MAX;
        AccountancyEntity e1 = new AccountancyEntity("t1", 10, "Kiadás", "s", 100, date.toString());
        AccountancyEntity e2 = new AccountancyEntity("t1", 10, "Bevétel", "s", 200, date.toString());
        AccountancyEntity e3 = new AccountancyEntity("t1", 10, "Kiadás", "s", 100, date.toString());
        lista.add(e1);
        lista.add(e2);
        lista.add(e3);
        
        assertEquals(Integer.valueOf(0), calcProfit(lista));

        e1 = new AccountancyEntity("t1", 10, "Kiadás", "s", 100, date.toString());
        e2 = new AccountancyEntity("t1", 10, "Bevétel", "s", 200, date.toString());
        e3 = new AccountancyEntity("t1", 10, "Bevétel", "s", 100, date.toString());
        List<AccountancyEntity> lista1 = new ArrayList<>();
        lista1.add(e1);
        lista1.add(e2);
        lista1.add(e3);
        
        assertEquals(Integer.valueOf(200), calcProfit(lista1));

    }

}
