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
    private int hastalik_id;
    private String ad;
    private String soyad;
    private int yas;
    private int ilac_id;
    private int muayene_id;
    

    public hastatani() {

    }

    public hastatani(int hasta_id, int hastalik_id, String ad, String soyad, int yas, int ilac_id, int muayene_id) {
        this.hasta_id = hasta_id;
        this.hastalik_id = hastalik_id;
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.ilac_id = ilac_id;
        this.muayene_id = muayene_id;
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

    public int getIlac_id() {
        return ilac_id;
    }

    public void setIlac_id(int ilac_id) {
        this.ilac_id = ilac_id;
    }

    public int getMuayene_id() {
        return muayene_id;
    }

    public void setMuayene_id(int muayene_id) {
        this.muayene_id = muayene_id;
    }
    
    public int getHastalik_id() {
        return hastalik_id;
    }

    public void setHastalik_id(int hastalik_id) {
        this.hastalik_id = hastalik_id;
    }
    
    @Override
    public String toString() {
        return "hastatani{" + "hasta_id=" + hasta_id + ", hastalik_id=" + hastalik_id + ", ad=" + ad + ", soyad=" + soyad + ", yas=" + yas + ", ilac_id=" + ilac_id + ", muayene_id=" + muayene_id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.hasta_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final hastatani other = (hastatani) obj;
        if (this.hasta_id != other.hasta_id) {
            return false;
        }
        return true;
    }

   
    
    
    

}
