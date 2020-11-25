/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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

    public void create(hastatani h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into hastatani (hasta_id) values ('" + h.getHasta_id() + "')");
            st.executeUpdate("insert into hastatani (ad) values ('" + h.getAd() + "')");
            st.executeUpdate("insert into hastatani (soyad) values ('" + h.getSoyad() + "')");
            st.executeUpdate("insert into hastatani (yas) values ('" + h.getYas() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<hastatani> read() {
        List<hastatani> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from hastatani order by hasta_id asc");
            while (rs.next()) {
                hastatani tmp = new hastatani(rs.getInt("hasta_id"), rs.getString("ad"), rs.getString("soyad"), rs.getInt("yas"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(hastatani h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into hastatani (hasta_id) values ('" + h.getHasta_id() + "')");
            st.executeUpdate("update hastatani set ad='" + h.getAd() + "' where hasta_id=" + h.getHasta_id());
            st.executeUpdate("update hastatani set soyad='" + h.getSoyad() + "' where hasta_id=" + h.getHasta_id());
            st.executeUpdate("update hastatani set yas='" + h.getYas() + "' where hasta_id=" + h.getHasta_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(hastatani h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from hastatani where hasta_id=" + h.getHasta_id());
            st.executeUpdate("delete from hastatani where ad=" + h.getAd());
            st.executeUpdate("delete from hastatani where soyad=" + h.getSoyad());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
