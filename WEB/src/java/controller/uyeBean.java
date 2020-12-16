/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import entity.uye;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author Beril
 */
@Named
@SessionScoped

public class uyeBean implements Serializable{
    
    private int uye_id;
    private String kullanici_adi;
    private String sifre;

    public uyeBean() {
    }

    public uyeBean(int uye_id, String kullanici_id, String sifre) {
        this.uye_id = uye_id;
        this.kullanici_adi = kullanici_id;
        this.sifre = sifre;
    }

    public int getUye_id() {
        return uye_id;
    }

    public void setUye_id(int uye_id) {
        this.uye_id = uye_id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public String setKullanici_id(String kullanici_adi) {
        
        return this.kullanici_adi= kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    /*private String dbuyesifre;

    
        public String getDbuyesifre(){
            return dbuyesifre;
        }
    
    private String dbuyekullanici_adi;
        public String getDbuyekullanici_adi(){
            return dbuyekullanici_adi;
        }*/
        
    Connection con = null;
    ResultSet resultSet = null;
    PreparedStatement preaparedStatement = null;
    
    public void bilgileriOnayla(String kullanici_adi, String sifre){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastatani", "root", "");
            String kullaniciGirisSorgusu = "SELECT * FROM uye" + "WHERE kullanici_adi = ? AND sifre = ?";
            
            preaparedStatement = con.prepareStatement(kullaniciGirisSorgusu);
            preaparedStatement.setString(1, kullanici_adi);
            preaparedStatement.setString(2, sifre);
            
            resultSet = preaparedStatement.executeQuery();
            
            if(resultSet.next()){
                System.out.print("Kullanıcı adı ve sifre doğru.");
            } else {
                System.err.print("Giriş işlemi başarısız.");
            }
            
            /*dbuyekullanici_adi = resultSet.getString(2);
            dbuyesifre = resultSet.getString(3);*/
            
            uye_id = resultSet.getInt("uye_id");
            kullanici_adi = resultSet.getString("kullanici_adi");
            sifre = resultSet.getString("sifre");
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public String uyeGirisiniDenetle(){
        bilgileriOnayla(kullanici_adi, sifre);
        
        if(kullanici_adi.equalsIgnoreCase(kullanici_adi) && sifre.equals(sifre)){
            return "gecerli";
        } else {
            return "gecersiz";
        }
    }
    
    public String uyeCikisiniDenetle(){
        
        /*FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        final HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        request.getSession(false).invalidate();*/
        
        return "uyecikisi?faces-redirect=true";
    }

}
