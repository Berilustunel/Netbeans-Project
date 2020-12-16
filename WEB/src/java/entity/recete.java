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
public class recete {
    private int recete_id;
    private Date recete_tarih;
    private Time recete_saat;
    private int ilac_id;

    public recete() {
    }

    public recete(int recete_id, Date recete_tarih, Time recete_saat, int ilac_id) {
        this.recete_id = recete_id;
        this.recete_tarih = recete_tarih;
        this.recete_saat = recete_saat;
        this.ilac_id = ilac_id;
    }

    public int getRecete_id() {
        return recete_id;
    }

    public void setRecete_id(int recete_id) {
        this.recete_id = recete_id;
    }

    public Date getRecete_tarih() {
        return recete_tarih;
    }

    public void setRecete_tarih(Date recete_tarih) {
        this.recete_tarih = recete_tarih;
    }

    public Time getRecete_saat() {
        return recete_saat;
    }

    public void setRecete_saat(Time recete_saat) {
        this.recete_saat = recete_saat;
    }

    public int getIlac_id() {
        return ilac_id;
    }

    public void setIlac_id(int ilac_id) {
        this.ilac_id = ilac_id;
    }
    
    
}
