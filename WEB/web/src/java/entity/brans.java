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
public class brans {
    private int brans_id;
    private String bolumler;

    public brans() {
    }
    
    public brans(int brans_id, String bolumler) {
        this.brans_id = brans_id;
        this.bolumler = bolumler;
    }

    public int getBrans_id() {
        return brans_id;
    }

    public void setBrans_id(int brans_id) {
        this.brans_id = brans_id;
    }

    public String getBolumler() {
        return bolumler;
    }

    public void setBolumler(String bolumler) {
        this.bolumler = bolumler;
    }
    
    
    
}
