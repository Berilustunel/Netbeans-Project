/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.gorus;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class gorusDAO extends dbConnection {
    
    public gorus getById(int id){
        gorus g = null;
        try{
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from gorus where gorus_id="+id );
            rs.next();
            g = new gorus (rs.getInt("gorus_id"), rs.getInt("hasta_id"), rs.getInt("doktor_id"), rs.getString("yorumlar"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return g;
    }

    public void create(gorus h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into gorus (gorus_id, hasta_id, doktor_id, yorumlar) "
                    + "values('" + h.getGorus_id()+ "','" + h.getHasta_id()+ "', '" + h.getDoktor_id()+ "', '" + h.getYorumlar()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<gorus> read() {
        List<gorus> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from gorus order by gorus_id asc");
            while (rs.next()) {
                gorus tmp = new gorus (rs.getInt("gorus_id"), rs.getInt("hasta_id"), rs.getInt("doktor_id"), rs.getString("yorumlar"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(gorus h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update gorus set yorumlar='" + h.getYorumlar()+ "'where gorus_id=" + h.getGorus_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(gorus h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from gorus where gorus_id=" + h.getGorus_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
 
