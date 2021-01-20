/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Beril
 */
public class gecmis {
    private int hasta_id;
    private int doktor_id;
    private int durum_id;
    private Date muayene_tarih;
    private String hasta_gecmis;
    private String hasta_durum;

    public gecmis() {
    }

    public gecmis(int hasta_id, int doktor_id, int durum_id, Date muayene_tarih, String hasta_gecmis, String hasta_durum) {
        this.hasta_id = hasta_id;
        this.doktor_id = doktor_id;
        this.durum_id = durum_id;
        this.muayene_tarih = muayene_tarih;
        this.hasta_gecmis = hasta_gecmis;
        this.hasta_durum = hasta_durum;
    }   

    public int getHasta_id() {
        return hasta_id;
    }

    public void setHasta_id(int hasta_id) {
        this.hasta_id = hasta_id;
    }

    public int getDoktor_id() {
        return doktor_id;
    }

    public void setDoktor_id(int doktor_id) {
        this.doktor_id = doktor_id;
    }

    public int getDurum_id() {
        return durum_id;
    }

    public void setDurum_id(int durum_id) {
        this.durum_id = durum_id;
    }

    public Date getMuayene_tarih() {
        return muayene_tarih;
    }

    public void setMuayene_tarih(Date muayene_tarih) {
        this.muayene_tarih = muayene_tarih;
    }
    
    

    public String getHasta_gecmis() {
        return hasta_gecmis;
    }

    public void setHasta_gecmis(String hasta_gecmis) {
        this.hasta_gecmis = hasta_gecmis;
    }

    public String getHasta_durum() {
        return hasta_durum;
    }

    public void setHasta_durum(String hasta_durum) {
        this.hasta_durum = hasta_durum;
    }
    
    
    
}
