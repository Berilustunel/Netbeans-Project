/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.hastalik;
import entity.hastatani;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class hastataniDAO extends dbConnection {
    
    private hastalikDAO lDao;

    public hastalikDAO getlDao() {
        if( lDao == null)
            this.lDao = new hastalikDAO();
        return lDao;
    }

    public void setlDao(hastalikDAO lDao) {
        this.lDao = lDao;
    }

    public void create(hastatani h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into hasta (hasta_id,hastalik_id,ad,soyad,yas) "
                    + "values('" + h.getHasta_id() + "','" + h.getHastalik().getHastalik_id()+ "','" + h.getAd() + "','" + h.getSoyad() + "','" + h.getYas() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<hastatani> read() {
        List<hastatani> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from hasta order by hasta_id asc");
            while (rs.next()) {
                hastalik l = this.getlDao().getById(rs.getInt("hastalik_id"));
                hastatani tmp = new hastatani(rs.getInt("hasta_id"),l, rs.getString("ad"), rs.getString("soyad"), rs.getInt("yas"));
                list.add(tmp);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(hastatani h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("update hasta set ad='" + h.getAd() + "',soyad='" + h.getSoyad() + "',yas='" + h.getYas() + "',soyad='" + h.getHastalik().getHastalik_id()+ "' where hasta_id=" + h.getHasta_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(hastatani h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from hasta where hasta_id=" + h.getHasta_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
