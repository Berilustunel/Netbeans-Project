package dao;

import entity.muayene;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class muayeneDAO extends dbConnection {
    
    public muayene getById(int id){
        muayene m = null;
        try{
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from muayene where muayene_id="+id );
            rs.next();
            m = new muayene(rs.getInt("muayene_id"), rs.getDate("muayene_tarih"), rs.getTime("muayene_saat"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return m;
    }

    public void create(muayene h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into muayene (muayene_id, muayene_tarih, muayene_saat) "
                    + "values('" + h.getMuayene_id()+ "','" + h.getMuayene_tarih()+ "', '" + h.getMuayene_saat()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<muayene> read() {
        List<muayene> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from muayene order by muayene_id asc");
            while (rs.next()) {
                muayene tmp = new muayene(rs.getInt("muayene_id"), rs.getDate("muayene_tarih"), rs.getTime("muayene_saat"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(muayene h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update muayene set muayene_tarih=" +h.getMuayene_tarih()+ "muayene_saat=" +h.getMuayene_saat()+ "where muayene_id=" +h.getMuayene_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(muayene h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from muayene where muayene_id=" + h.getMuayene_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}