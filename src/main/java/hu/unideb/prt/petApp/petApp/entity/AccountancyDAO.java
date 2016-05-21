/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.entity;

import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bali
 */
public interface AccountancyDAO {
    public void createEntry(AccountancyEntity ae);
    
    public List<AccountancyEntity> readAllEntry();
    
    public  AccountancyEntity readEntry(int id);
    
    public void removeEntry(AccountancyEntity ae) ;
    
}
