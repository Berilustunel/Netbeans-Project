/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.klinik;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class klinikDAO extends dbConnection {
    
    public klinik getById(int id){
        klinik k = null;
        try{
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from klinik where klinik_id="+id );
            rs.next();
            k = new klinik (rs.getInt("klinik_id"), rs.getString("ad"), rs.getInt("hastalik_id"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return k;
    }

    public void create(klinik h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into klinik (klinik_id, ad, hastalik_id) "
                    + "values('" + h.getKlinik_id()+ "','" + h.getAd() + "', '" + h.getHastalik_id()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<klinik> read() {
        List<klinik> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from klinik order by klinik_id asc");
            while (rs.next()) {
                klinik tmp = new klinik(rs.getInt("klinik_id"), rs.getString("ad"), rs.getInt("hastalik_id"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(klinik h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update klinik set ad='" + h.getAd() + "'where klinik_id=" + h.getKlinik_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(klinik h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from klinik where klinik_id=" + h.getKlinik_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
