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
public class gorus {
    
    private int gorus_id;
    private int hasta_id;
    private int doktor_id;
    private String yorumlar;

    public gorus() {
    }

    public gorus(int gorus_id, int hasta_id, int doktor_id, String yorumlar) {
        this.gorus_id = gorus_id;
        this.hasta_id = hasta_id;
        this.doktor_id = doktor_id;
        this.yorumlar = yorumlar;
    }

    public int getGorus_id() {
        return gorus_id;
    }

    public void setGorus_id(int gorus_id) {
        this.gorus_id = gorus_id;
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

    public String getYorumlar() {
        return yorumlar;
    }

    public void setYorumlar(String yorumlar) {
        this.yorumlar = yorumlar;
    }
    
    
    
}
