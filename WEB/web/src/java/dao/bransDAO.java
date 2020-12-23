/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.brans;
import entity.brans;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class bransDAO extends dbConnection {
    
    public brans getById(int id){
        brans b = null;
        try{
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from brans where brans_id="+id );
            rs.next();
            b = new brans (rs.getInt("brans_id"), rs.getString("bolumler"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return b;
    }

    public void create(brans h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into brans (brans_id, bolumler) "
                    + "values('" + h.getBrans_id()+ "','" + h.getBolumler()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<brans> read() {
        List<brans> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from brans order by brans_id asc");
            while (rs.next()) {
                brans tmp = new brans(rs.getInt("brans_id"), rs.getString("bolumler"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(brans h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update brans set bolumler='" +h.getBolumler()+ "'where brans_id=" + h.getBrans_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(brans h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from brans where brans_id=" + h.getBrans_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
