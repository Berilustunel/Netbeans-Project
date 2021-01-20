/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import util.dbConnection;

/**
 *
 * @author Beril
 */
@Named
@SessionScoped

public class doktor_uyeBean extends dbConnection implements Serializable {

    private String doktor_username;
    private String doktor_password;

    public doktor_uyeBean() {
    }

    public doktor_uyeBean(String doktor_username, String doktor_password) {
        this.doktor_username = doktor_username;
        this.doktor_password = doktor_password;
    }

    public String getDoktor_username() {
        return doktor_username;
    }

    public void setDoktor_username(String doktor_username) {
        this.doktor_username = doktor_username;
    }

    public String getDoktor_password() {
        return doktor_password;
    }

    public void setDoktor_password(String doktor_password) {
        this.doktor_password = doktor_password;
    }

    

    

    

    

    

    /*Connection con = null;
    ResultSet resultSet = null;
    PreparedStatement preaparedStatement = null;*/

    public boolean bilgileriOnayla(String gelenKullanici_adi, String gelenSifre) {
        try {
            
            Statement st = this.connect().createStatement();
            ResultSet resultSet = st.executeQuery("select doktor_username, doktor_password from doktor_uye where doktor_username='" +gelenKullanici_adi+ "' and doktor_password='"+ gelenSifre +"'");
            
            
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
        if(bilgileriOnayla(doktor_username, doktor_password)){
            return "doktor_basarili";
            
        }
        else
            return "doktor_basarisiz";
        
    }

    public String uyeCikisiniDenetle() {

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        request.getSession(false).invalidate();

        return "doktor_uyecikisi?faces-redirect=true";
    }
    
    

}

