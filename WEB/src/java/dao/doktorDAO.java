package dao;

import entity.doktor;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class doktorDAO extends dbConnection {

    public void create(doktor h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into doktor (doktor_id, doktor_ad, doktor_soyad, doktor_yas, klinik_id, brans_id) "
                    + "values('" + h.getDoktor_id()+ "','" + h.getDoktor_ad()+ "', '" + h.getDoktor_soyad()+ "', '" + h.getDoktor_yas()+ "', '" + h.getKlinik_id()+ "', '" + h.getBrans_id()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<doktor> read() {
        List<doktor> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from doktor order by doktor_id asc");
            while (rs.next()) {
                doktor tmp = new doktor(rs.getInt("doktor_id"), rs.getString("doktor_ad"),rs.getString("doktor_soyad"),rs.getInt("doktor_yas"),rs.getInt("klinik_id"), rs.getInt("brans_id"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(doktor h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("update doktor set doktor_ad='" + h.getDoktor_ad()+ /*"' doktor_soyad'"+ h.getDoktor_soyad() + "' doktor_yas'"+ h.getDoktor_yas() + "' klinik_id'"+ h.getKlinik_id()+*/ "'where doktor_id" + h.getDoktor_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(doktor h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from doktor where doktor_id=" + h.getDoktor_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}