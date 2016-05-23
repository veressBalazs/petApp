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
public interface TeDAO {
    
    public void createTe(TeEntity te);
    
    public List<TeEntity> readAllTe();
    
    public void removeTe(TeEntity te);
    
    public TeEntity readTe(int id);
    
}
