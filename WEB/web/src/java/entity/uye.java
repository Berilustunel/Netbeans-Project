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
public class uye {
    
    private int uye_id;
    private String kullanici_id;
    private String sifre;

    public uye() {
    }

    public uye(int uye_id, String kullanici_id, String sifre) {
        this.uye_id = uye_id;
        this.kullanici_id = kullanici_id;
        this.sifre = sifre;
    }

    public int getUye_id() {
        return uye_id;
    }

    public void setUye_id(int uye_id) {
        this.uye_id = uye_id;
    }

    public String getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(String kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    
    
    
    
}
