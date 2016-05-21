/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.entity;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Bali
 */
@Entity
@Table(name = "alom")
public class AlomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @Column(name = "te_id")
    int te_id;

    @Column(name = "alomszam")
    int alomszam;

    @Column(name = "elhullas")
    int elhullas;

    @Column(name = "leiras")
    String leiras;

    @Column(name = "datee")
    String datee;

    public AlomEntity() {
    }

    public AlomEntity(int te_id, int alomszam, int elhullas, String leiras, String datee) {
        this.id = 0;
        this.te_id = te_id;
        this.alomszam = alomszam;
        this.elhullas = elhullas;
        this.leiras = leiras;
        this.datee = datee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTe_id() {
        return te_id;
    }

    public void setTe_id(int te_id) {
        this.te_id = te_id;
    }

    public int getAlomszam() {
        return alomszam;
    }

    public void setAlomszam(int alomszam) {
        this.alomszam = alomszam;
    }

    public int getElhullas() {
        return elhullas;
    }

    public void setElhullas(int elhullas) {
        this.elhullas = elhullas;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    @Override
    public String toString() {
        return "AlomEntity{" + "id=" + id + ", te_id=" + te_id + ", alomszam=" + alomszam + ", elhullas=" + elhullas + ", leiras=" + leiras + ", datee=" + datee + '}';
    }

}
