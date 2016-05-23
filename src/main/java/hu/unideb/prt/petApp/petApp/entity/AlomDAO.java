/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.entity;

import java.util.List;

/**
 *
 * @author Bali
 */
public interface AlomDAO {
    
    public void createAlom(AlomEntity ae);
    
    public List<AlomEntity> readAllAlom();
    
    public void removeAlom(AlomEntity ae);
    
    public AlomEntity readAlomById(int id);
    
    public void UpdateAlom(AlomEntity ae);
}
