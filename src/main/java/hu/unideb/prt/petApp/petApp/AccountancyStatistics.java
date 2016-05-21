/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp;

import hu.unideb.prt.petApp.petApp.entity.AccountancyEntity;
import java.util.List;
/**
 *
 * @author Bali
 */
public class AccountancyStatistics {
    
    
    
    
    public static Integer calcIncome(List<AccountancyEntity> list){
       
        Integer i = 0;
        for (AccountancyEntity accountancyEntity : list) {
            if(accountancyEntity.getIn_out().equals("Bevétel"))
                i += accountancyEntity.getSumm();
        }
        
        
        return i;
    }
    
    public static Integer calcOutgo(List<AccountancyEntity> list){
        
        Integer i =  0;
        for (AccountancyEntity accountancyEntity : list) {
            if(accountancyEntity.getIn_out().equals("Kiadás"))
                i += accountancyEntity.getSumm();
        }
        
        
        return i;
    }
    
    
    public static Integer calcProfit(List<AccountancyEntity> list){
        return calcIncome(list)-calcOutgo(list);
        
    }
    
    
    
    
}
