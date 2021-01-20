/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import util.dbConnection;

/**
 *
 * @author Beril
 */
@Named
@SessionScoped

public class uyeBean extends dbConnection implements Serializable {

    private String kullanici_adi;
    private String sifre;

    public uyeBean() {
    }

    public uyeBean(String kullanici_adi, String sifre) {

        this.kullanici_adi = kullanici_adi;
        this.sifre = sifre;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    
    }    
    
    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    private String dbuyesifre;

    public String getDbuyesifre() {
        return dbuyesifre;
    }

    

    /*Connection con = null;
    ResultSet resultSet = null;
    PreparedStatement preaparedStatement = null;*/

    public boolean bilgileriOnayla(String gelenKullanici_adi, String gelenSifre) {
        try {
            
            Statement st = this.connect().createStatement();
            ResultSet resultSet = st.executeQuery("select kullanici_adi, sifre from uye where kullanici_adi='" +gelenKullanici_adi+ "' and sifre='"+ gelenSifre +"'");
            
            
            /*String kullaniciGirisSorgusu = ("select kullanici_adi, sifre from uye where kullanici_adi=" +gelenKullanici_adi+ " and sifre="+ gelenSifre +"");

            preaparedStatement = con.prepareStatement(kullaniciGirisSorgusu);
            preaparedStatement.setString(1, gelenKullanici_adi);
            preaparedStatement.setString(2, gelenSifre);
            
            resultSet = preaparedStatement.executeQuery();*/

            if (resultSet.next()) {
                System.out.print("Kullanıcı adı ve sifre doğru.");
                return true;

            }else{
                System.out.print("Giriş işlemi başarısız.");
                return false;
            }
            
            

            //dbuyekullanici_adi = resultSet.getString(1).toString();
            //dbuyesifre = resultSet.getString(2).toString();

            //kullanici_adi = resultSet.getString("kullanici_adi").toString();
            //sifre = resultSet.getString("sifre").toString();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public String uyeGirisiniDenetle() {

        String sonuc="";
        if(bilgileriOnayla(kullanici_adi, sifre)){
            return "yonetici_basarili";
            
        }
        else
            return "yonetici_basarisiz";
        
    }

    public String uyeCikisiniDenetle() {

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        request.getSession(false).invalidate();

        return "yonetici_uyecikisi?faces-redirect=true";
    }
    
    

}