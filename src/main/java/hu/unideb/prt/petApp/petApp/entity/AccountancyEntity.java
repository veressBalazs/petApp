/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.prt.petApp.petApp.entity;
import hu.unideb.prt.petApp.petApp.*;
import java.time.LocalDate;
import javax.persistence.Column;
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
@Table(name = "accountancy")
public class AccountancyEntity {

    @Column(name = "type")
    String type;

    @Column(name = "amount")
    int amount;

    @Column(name = "in_out")
    String in_out;

    @Column(name = "description")
    String description;

    @Column(name = "summ")
    int summ;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    
    @Column(name = "datee")
    String datee;
    
    

    public AccountancyEntity() {
    }

    public AccountancyEntity(String type, int amount, String in_out, String description, int summ,String datee) {
        this.type = type;
        this.amount = amount;
        this.in_out = in_out;
        this.description = description;
        this.summ = summ;
        this.id = 0;
        this.datee = datee;
    }
    public AccountancyEntity(String type, int amount, String in_out, String description, int summ,int id,String datee) {
        this.type = type;
        this.amount = amount;
        this.in_out = in_out;
        this.description = description;
        this.summ = summ;
        this.id = 0;
        this.datee = datee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getIn_out() {
        return in_out;
    }

    public void setIn_out(String in_out) {
        this.in_out = in_out;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    
    

    @Override
    public String toString() {
        return "AccountancyEntity{" + "type=" + type + ", amount=" + amount + ", in_out=" + in_out + ", description=" + description + ", summ=" + summ + ", id=" + id + '}';
    }



}
