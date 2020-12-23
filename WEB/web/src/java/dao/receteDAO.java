package dao;

import entity.recete;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class receteDAO extends dbConnection {

    public void create(recete h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into recete (recete_id, recete_tarih, recete_saat, ilac_id) "
                    + "values('" + h.getRecete_id()+ "','" + h.getRecete_tarih()+ "', '" + h.getRecete_saat()+ "', '" + h.getIlac_id()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<recete> read() {
        List<recete> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from recete order by recete_id asc");
            while (rs.next()) {
                recete tmp = new recete(rs.getInt("recete_id"), rs.getDate("recete_tarih"), rs.getTime("recete_saat"), rs.getInt("ilac_id"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(recete h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update recete set recete_tarih='" + h.getRecete_tarih()+ "'where recete_id=" + h.getRecete_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(recete h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from recete where recete_id=" + h.getRecete_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}