/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.gecmis;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class gecmisDAO extends dbConnection {
    
    public gecmis getById(int id){
        gecmis g = null;
        try{
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from gecmis where durum_id="+id );
            rs.next();
            g = new gecmis (rs.getInt("hasta_id"), rs.getInt("doktor_id"), rs.getInt("durum_id"), rs.getDate("muayene_tarih"), rs.getString("hasta_gecmis"), rs.getString("hasta_durum"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return g;
    }

    public void create(gecmis h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into gecmis (hasta_id, doktor_id, durum_id, muayene_tarih, hasta_gecmis, hasta_durum) "
                    + "values('" + h.getHasta_id()+ "','" + h.getDoktor_id()+ "', '" + h.getDurum_id()+ "', '" + h.getMuayene_tarih()+ "', '" + h.getHasta_gecmis()+ "', '" + h.getHasta_durum()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<gecmis> read() {
        List<gecmis> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from gecmis order by durum_id asc");
            while (rs.next()) {
                gecmis tmp = new gecmis (rs.getInt("hasta_id"), rs.getInt("doktor_id"), rs.getInt("durum_id"), rs.getDate("muayene_tarih"), rs.getString("hasta_gecmis"), rs.getString("hasta_durum"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(gecmis h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update gecmis set hasta_durum='" + h.getHasta_durum()+ "'where durum_id=" + h.getDurum_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(gecmis h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from gecmis where durum_id=" + h.getDurum_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
