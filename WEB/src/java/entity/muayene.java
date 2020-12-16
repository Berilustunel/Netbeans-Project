/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Beril
 */
public class muayene {
    private int muayene_id;
    private Date muayene_tarih;
    private Time muayene_saat;

    public muayene() {
    }

    public muayene(int muayene_id, Date muayene_tarih, Time muayene_saat) {
        this.muayene_id = muayene_id;
        this.muayene_tarih = muayene_tarih;
        this.muayene_saat = muayene_saat;
    }

    public int getMuayene_id() {
        return muayene_id;
    }

    public void setMuayene_id(int muayene_id) {
        this.muayene_id = muayene_id;
    }

    public Date getMuayene_tarih() {
        return muayene_tarih;
    }

    public void setMuayene_tarih(Date muayene_tarih) {
        this.muayene_tarih = muayene_tarih;
    }

    public Time getMuayene_saat() {
        return muayene_saat;
    }

    public void setMuayene_saat(Time muayene_saat) {
        this.muayene_saat = muayene_saat;
    }
    
    
}
