/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.hastalik_content;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class hastalik_contentDAO extends dbConnection {


    public void create(hastalik_content h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into hastalik_content (idhastalik_content, hastalik_content_ad, hastalik_icerik) "
                    + "values('" + h.getIdhastalik_content()+ "','" + h.getHastalik_content_ad()+ "', '" + h.getHastalik_icerik()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<hastalik_content> read() {
        List<hastalik_content> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from hastalik_content order by idhastalik_content asc");
            while (rs.next()) {
                hastalik_content tmp = new hastalik_content(rs.getInt("idhastalik_content"), rs.getString("hastalik_content_ad"), rs.getString("hastalik_icerik"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(hastalik_content h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update hastalik_content set hastalik_icerik='" + h.getHastalik_icerik()+  "'where idhastalik_content =" + h.getIdhastalik_content());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(hastalik_content h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from hastalik_content where idhastalik_content=" + h.getIdhastalik_content());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}