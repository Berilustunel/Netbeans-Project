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

public class hasta_uyeBean extends dbConnection implements Serializable {

    private String hasta_username;
    private String hasta_password;

    public hasta_uyeBean() {
    }

    public hasta_uyeBean(String hasta_username, String hasta_password) {
        this.hasta_username = hasta_username;
        this.hasta_password = hasta_password;
    }

    public String getHasta_username() {
        return hasta_username;
    }

    public void setHasta_username(String hasta_username) {
        this.hasta_username = hasta_username;
    }

    public String getHasta_password() {
        return hasta_password;
    }

    public void setHasta_password(String hasta_password) {
        this.hasta_password = hasta_password;
    }

    

    

    

    

    /*Connection con = null;
    ResultSet resultSet = null;
    PreparedStatement preaparedStatement = null;*/

    public boolean bilgileriOnayla(String gelenKullanici_adi, String gelenSifre) {
        try {
            
            Statement st = this.connect().createStatement();
            ResultSet resultSet = st.executeQuery("select hasta_username, hasta_password from hasta_uye where hasta_username='" +gelenKullanici_adi+ "' and hasta_password='"+ gelenSifre +"'");
            
            
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
        if(bilgileriOnayla(hasta_username, hasta_password)){
            return "hasta_basarili";
            
        }
        else
            return "hasta_basarisiz";
        
    }

    public String uyeCikisiniDenetle() {

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        request.getSession(false).invalidate();

        return "hasta_uyecikisi?faces-redirect=true";
    }
    
    

}
