
 
package dao;


import entity.randevu;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;


 
public class randevuDAO extends dbConnection {
    
    public randevu getById(int id){
        randevu r = null;
        try{
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from randevu where id_randevu="+id );
            rs.next();
            r = new randevu(rs.getInt("id_randevu"),rs.getInt("hasta_id"), rs.getInt("doktor_id"),rs.getInt("klinik_id"),rs.getDate("randevu_tarih") );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return r;
    }
    
  
    public void create(randevu h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into randevu (id_randevu, hasta_id, doktor_id, klinik_id, randevu_tarih) "
                    + "values('" + h.getId_randevu()+ "','" + h.getHasta_id()+ "', '" + h.getDoktor_id()+ "', '" + h.getRandevu_tarih()+ "')");
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
                
                randevu tmp = new randevu(rs.getInt("id_randevu"),rs.getInt("hasta_id"),rs.getInt("doktor_id"),rs.getInt("klinik_id"),rs.getDate("randevu_tarih") );
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
            st.executeUpdate("update randevu set hasta_id='" +h.getHasta_id()+ "'where id_randevu=" + h.getId_randevu());

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
    

