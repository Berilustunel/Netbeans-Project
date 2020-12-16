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
    
    public hastatani getById(int id){
        hastatani h = null;
        
        try{
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from hasta where hasta_id= " + id);
            rs.next();
            
            h = new hastatani(rs.getInt("hasta_id"), rs.getInt("hastalik_id"), rs.getString("ad"), rs.getString("soyad"), rs.getInt("yas"), rs.getInt("ilac_id"), rs.getInt("muayene_id"));
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return h;
    }


    public void create(hastatani h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into hasta (hasta_id,hastalik,ad,soyad,yas, ilac_id, muayene_id) "
                    + "values('" + h.getHasta_id() + "','" + h.getHastalik_id()+ "','" + h.getAd() + "','" + h.getSoyad() + "','" + h.getYas() + "', '" + h.getIlac_id()+ "', '" + h.getMuayene_id()+ "')");
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
                hastatani tmp = new hastatani(rs.getInt("hasta_id"), rs.getInt("hastalik_id"), rs.getString("ad"), rs.getString("soyad"), rs.getInt("yas"), rs.getInt("ilac_id"), rs.getInt("muayene_id"));
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
            st.execute("update hasta set hasta_id='" + h.getHasta_id()+ "'hastalik_id='" + h.getHastalik_id()+ "'ad='" + h.getAd()+ "'soyad='" + h.getSoyad() + "'yas='" + h.getYas() + "'ilac_id='" + h.getIlac_id()+ "'muayene_id='" + h.getMuayene_id()+ "' where hasta_id=" + h.getHasta_id());

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
