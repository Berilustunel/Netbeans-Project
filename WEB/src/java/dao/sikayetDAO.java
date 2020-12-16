/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.sikayet;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class sikayetDAO extends dbConnection {

    public void create(sikayet h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into sikayet (sikayet_id, belirtiler) "
                    + "values('" + h.getSikayet_id()+ "','" + h.getBelirtiler()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<sikayet> read() {
        List<sikayet> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from sikayet order by sikayet_id asc");
            while (rs.next()) {
                sikayet tmp = new sikayet(rs.getInt("sikayet_id"), rs.getString("belirtiler"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(sikayet h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("update sikayet set belirtiler='" + h.getBelirtiler());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(sikayet h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from sikayet where sikayet_id='" + h.getSikayet_id()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
    

