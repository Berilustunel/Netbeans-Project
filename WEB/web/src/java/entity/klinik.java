/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Beril
 */
public class klinik {
    private int klinik_id;
    private String ad;

    public klinik() {
    }

    public klinik(int klinik_id, String ad) {
        this.klinik_id = klinik_id;
        this.ad = ad;
    } 

    public int getKlinik_id() {
        return klinik_id;
    }

    public void setKlinik_id(int klinik_id) {
        this.klinik_id = klinik_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
    
    
    
    
}
