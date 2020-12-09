/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.hastalik;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class hastalikDAO extends dbConnection {
    
    public hastalik getById(int id){
        hastalik l = null;
        
        try{
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from hastalik where hastalik_id= " + id);
            rs.next();
            
            l = new hastalik(rs.getInt("hastalik_id"),rs.getString("ad"));
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    

    public void create(hastalik h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into hastalik (hastalik_id,ad) "
                    + "values('" + h.getHastalik_id()+ "','" + h.getAd() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<hastalik> read() {
        List<hastalik> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from hastalik order by hastalik_id asc");
            while (rs.next()) {
                hastalik tmp = new hastalik(rs.getInt("hastalik_id"), rs.getString("ad"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(hastalik h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("update hastalik set ad='" + h.getAd()+"')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(hastalik h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from hastalik where hastalik_id=" + h.getHastalik_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
