
 
package entity;

import java.sql.Date;

// @author Beril
 
public class randevu {

    private int id_randevu;
    private int hasta_id;
    private int doktor_id;
    private int klinik_id;
    private Date randevu_tarih;

    public randevu() {
    }

    public randevu(int id_randevu, int hasta_id, int doktor_id, int klinik_id, Date randevu_tarih) {
        this.id_randevu = id_randevu;
        this.hasta_id = hasta_id;
        this.doktor_id = doktor_id;
        this.klinik_id = klinik_id;
        this.randevu_tarih = randevu_tarih;
    }

    public int getId_randevu() {
        return id_randevu;
    }

    public void setId_randevu(int id_randevu) {
        this.id_randevu = id_randevu;
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

    public int getKlinik_id() {
        return klinik_id;
    }

    public void setKlinik_id(int klinik_id) {
        this.klinik_id = klinik_id;
    }

    public Date getRandevu_tarih() {
        return randevu_tarih;
    }

    public void setRandevu_tarih(Date randevu_tarih) {
        this.randevu_tarih = randevu_tarih;
    }
    
    

    @Override
    public String toString() {
        return "randevu{" + "id_randevu=" + id_randevu + ", hasta_id=" + hasta_id + ", doktor_id=" + doktor_id + ", klinik_id=" + klinik_id + ", randevu_tarih=" + randevu_tarih + '}';
    }

    
    
}
