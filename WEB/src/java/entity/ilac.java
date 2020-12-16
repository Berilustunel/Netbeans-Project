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
public class ilac {
    private int ilac_id;
    private String ilac_ad;
    private int ilac_ucret;
    private Date ilac_tarih;

    public ilac() {
    }

    public ilac(int ilac_id, String ilac_ad, int ilac_ucret, Date ilac_tarih) {
        this.ilac_id = ilac_id;
        this.ilac_ad = ilac_ad;
        this.ilac_ucret = ilac_ucret;
        this.ilac_tarih = ilac_tarih;
    }

    public int getIlac_id() {
        return ilac_id;
    }

    public void setIlac_id(int ilac_id) {
        this.ilac_id = ilac_id;
    }

    public String getIlac_ad() {
        return ilac_ad;
    }

    public void setIlac_ad(String ilac_ad) {
        this.ilac_ad = ilac_ad;
    }

    public int getIlac_ucret() {
        return ilac_ucret;
    }

    public void setIlac_ucret(int ilac_ucret) {
        this.ilac_ucret = ilac_ucret;
    }

    public Date getIlac_tarih() {
        return ilac_tarih;
    }

    public void setIlac_tarih(Date ilac_tarih) {
        this.ilac_tarih = ilac_tarih;
    }
    
    
}
