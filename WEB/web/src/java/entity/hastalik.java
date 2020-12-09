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
public class hastalik {
    private int hastalik_id;
    private String ad;

    public hastalik() {
    }

    public hastalik(int hastalik_id, String ad) {
        this.hastalik_id = hastalik_id;
        this.ad = ad;
    }

    public int getHastalik_id() {
        return hastalik_id;
    }

    public void setHastalik_id(int hastalik_id) {
        this.hastalik_id = hastalik_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.hastalik_id;
        return hash;
    }
    //Converter sınıfı için
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
        final hastalik other = (hastalik) obj;
        if (this.hastalik_id != other.hastalik_id) {
            return false;
        }
        return true;
    }
    
    
    
}
