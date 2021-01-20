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
public class doktor {
    private int doktor_id;
    private String doktor_ad;
    private String doktor_soyad;
    private int doktor_yas;
    private int klinik_id;
    private int brans_id;

    public doktor() {
    }

    public doktor(int doktor_id, String doktor_ad, String doktor_soyad, int doktor_yas, int klinik_id, int brans_id) {
        this.doktor_id = doktor_id;
        this.doktor_ad = doktor_ad;
        this.doktor_soyad = doktor_soyad;
        this.doktor_yas = doktor_yas;
        this.klinik_id = klinik_id;
        this.brans_id = brans_id;
    }

    public int getDoktor_id() {
        return doktor_id;
    }

    public void setDoktor_id(int doktor_id) {
        this.doktor_id = doktor_id;
    }

    public String getDoktor_ad() {
        return doktor_ad;
    }

    public void setDoktor_ad(String doktor_ad) {
        this.doktor_ad = doktor_ad;
    }

    public String getDoktor_soyad() {
        return doktor_soyad;
    }

    public void setDoktor_soyad(String doktor_soyad) {
        this.doktor_soyad = doktor_soyad;
    }

    public int getDoktor_yas() {
        return doktor_yas;
    }

    public void setDoktor_yas(int doktor_yas) {
        this.doktor_yas = doktor_yas;
    }

    public int getKlinik_id() {
        return klinik_id;
    }

    public void setKlinik_id(int klinik_id) {
        this.klinik_id = klinik_id;
    }

    public int getBrans_id() {
        return brans_id;
    }

    public void setBrans_id(int brans_id) {
        this.brans_id = brans_id;
    }
    
    
}
