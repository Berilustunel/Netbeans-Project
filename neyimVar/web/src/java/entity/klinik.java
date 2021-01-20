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
    private int hastalik_id;

    public klinik() {
    }

    public klinik(int klinik_id, String ad, int hastalik_id) {
        this.klinik_id = klinik_id;
        this.ad = ad;
        this.hastalik_id = hastalik_id;
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

    public int getHastalik_id() {
        return hastalik_id;
    }

    public void setHastalik_id(int hastalik_id) {
        this.hastalik_id = hastalik_id;
    }

}
