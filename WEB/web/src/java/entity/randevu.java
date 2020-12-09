
 
package entity;

import java.sql.Date;

// @author Beril
 
public class randevu {

    private int id_randevu;
    private int id_hasta;
    private int id_doktor;
    private int id_klinik;
    private Date randevu_tarih;

    public randevu() {
    }

    public randevu(int id_randevu, int id_hasta, int id_doktor, int id_klinik, Date randevu_tarih) {
        this.id_randevu = id_randevu;
        this.id_hasta = id_hasta;
        this.id_doktor = id_doktor;
        this.id_klinik = id_klinik;
        this.randevu_tarih = randevu_tarih;
    }

    public int getId_randevu() {
        return id_randevu;
    }

    public void setId_randevu(int id_randevu) {
        this.id_randevu = id_randevu;
    }

    public int getId_hasta() {
        return id_hasta;
    }

    public void setId_hasta(int id_hasta) {
        this.id_hasta = id_hasta;
    }

    public int getId_doktor() {
        return id_doktor;
    }

    public void setId_doktor(int id_doktor) {
        this.id_doktor = id_doktor;
    }

    public int getId_klinik() {
        return id_klinik;
    }

    public void setId_klinik(int id_klinik) {
        this.id_klinik = id_klinik;
    }

    public Date getRandevu_tarih() {
        return randevu_tarih;
    }

    public void setRandevu_tarih(Date randevu_tarih) {
        this.randevu_tarih = randevu_tarih;
    }

    @Override
    public String toString() {
        return "randevu{" + "id_randevu=" + id_randevu + ", id_hasta=" + id_hasta + ", id_doktor=" + id_doktor + ", id_klinik=" + id_klinik + ", randevu_tarih=" + randevu_tarih + '}';
    }
    
}
