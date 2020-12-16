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
public class sikayet {
    private int sikayet_id;
    private String belirtiler;

    public sikayet() {
    }

    public sikayet(int sikayet_id, String belirtiler) {
        this.sikayet_id = sikayet_id;
        this.belirtiler = belirtiler;
    }
    
    public int getSikayet_id() {
        return sikayet_id;
    }

    public void setSikayet_id(int sikayet_id) {
        this.sikayet_id = sikayet_id;
    }

    public String getBelirtiler() {
        return belirtiler;
    }

    public void setBelirtiler(String belirtiler) {
        this.belirtiler = belirtiler;
    }
    
    
}
