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
public class hastalik_content {
    private int idhastalik_content;
    private String hastalik_content_ad;
    private String hastalik_icerik;

    public hastalik_content() {
    }

    public hastalik_content(int idhastalik_content, String hastalik_content_ad, String hastalik_icerik) {
        this.idhastalik_content = idhastalik_content;
        this.hastalik_content_ad = hastalik_content_ad;
        this.hastalik_icerik = hastalik_icerik;
    }

    public int getIdhastalik_content() {
        return idhastalik_content;
    }

    public void setIdhastalik_content(int idhastalik_content) {
        this.idhastalik_content = idhastalik_content;
    }

    public String getHastalik_content_ad() {
        return hastalik_content_ad;
    }

    public void setHastalik_content_ad(String hastalik_content_ad) {
        this.hastalik_content_ad = hastalik_content_ad;
    }

    public String getHastalik_icerik() {
        return hastalik_icerik;
    }

    public void setHastalik_icerik(String hastalik_icerik) {
        this.hastalik_icerik = hastalik_icerik;
    }

}
