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
public class hastatani {

    private int hasta_id;
    private String ad;
    private String soyad;
    private int yas;

    public hastatani() {

    }

    public hastatani(int hasta_id, String ad, String soyad, int yas) {
        this.hasta_id = hasta_id;
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
    }

    public int getHasta_id() {
        return hasta_id;
    }

    public void setHasta_id(int hasta_id) {
        this.hasta_id = hasta_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    @Override
    public String toString() {
        return "[{" + "hasta_id=" + hasta_id + ", ad=" + ad + ", soyad=" + soyad + ", yas=" + yas + ']';
    }

}
