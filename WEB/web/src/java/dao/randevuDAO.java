
 
package dao;

import entity.randevu;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;


 
public class randevuDAO extends dbConnection {

    public void create(randevu h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into randevu (id_randevu,id_hasta,id_doktor,id_klinik,randevu_tarih) "
                    + "values('" + h.getId_randevu() + "','" + h.getId_hasta()+ "','" + h.getId_doktor() + "','" + h.getId_klinik() + "', '" +h.getRandevu_tarih()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<randevu> read() {
        List<randevu> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from randevu order by id_randevu asc");
            while (rs.next()) {
                randevu tmp = new randevu(rs.getInt("id_randevu"),rs.getInt("id_hasta"),rs.getInt("id_doktor"),rs.getInt("id_klinik"),rs.getDate("randevu_tarih") );
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(randevu h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("update randevu set id_randevu='" +h.getId_randevu()  + "',id_hasta='" + h.getId_hasta()+ "',id_doktor='" + h.getId_doktor()+ "',id_klinik='" +h.getId_klinik()  + "',randevu_tarih='" +h.getRandevu_tarih()  + "' where hasta_id=" + h.getId_randevu());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(randevu h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from randevu where id_randevu=" + h.getId_randevu());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
    

