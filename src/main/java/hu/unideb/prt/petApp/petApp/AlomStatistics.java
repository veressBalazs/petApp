/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp;

import hu.unideb.prt.petApp.petApp.entity.AlomDAO;
import hu.unideb.prt.petApp.petApp.entity.AlomDAOFactory;
import hu.unideb.prt.petApp.petApp.entity.AlomEntity;
import java.util.List;

/**
 *
 * @author Bali
 */
public class AlomStatistics {

    static AlomDAOFactory daoFactory = AlomDAOFactory.getInstance();
    static AlomDAO ad = daoFactory.createAlomDAO();

    public static Integer alomszamAtlag(List<AlomEntity> alomEntitys) throws ArithmeticException{
        //List<AlomEntity> alomEntitys = ad.ReadAlomByTeId(teId);
        int osszeg = 0;
        for (AlomEntity alomEntity : alomEntitys) {
            osszeg += alomEntity.getAlomszam();
        }
        
        return osszeg/alomEntitys.size();

    }

    public static Integer osszesSzaporulat(List<AlomEntity> alomEntitys) {
        //List<AlomEntity> alomEntitys = ad.ReadAlomByTeId(teId);
        Integer osszeg = 0;
        for (AlomEntity alomEntity : alomEntitys) {
            osszeg += alomEntity.getAlomszam();
        }
        return osszeg;
    }
    
    public static Integer legnagyobbAlom(List<AlomEntity> alomEntitys){
        //List<AlomEntity> alomEntitys = ad.ReadAlomByTeId(teId);
        int max = 0;
        for (AlomEntity alomEntity : alomEntitys) {
            if (alomEntity.getAlomszam()> max)
                max = alomEntity.getAlomszam();
        }
        return max;
        
    }
    
   

}
