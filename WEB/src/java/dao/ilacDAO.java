package dao;

import entity.ilac;
import entity.ilac;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.dbConnection;

/**
 *
 * @author Beril
 */
public class ilacDAO extends dbConnection {
    
    public ilac getById(int id){
        ilac i = null;
        try{
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ilac where ilac_id="+id );
            rs.next();
            i = new ilac (rs.getInt("ilac_id"),rs.getString("ilac_ad"), rs.getInt("ilac_ucret"), rs.getDate("ilac_tarih"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return i;
    }

    public void create(ilac h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("insert into ilac (ilac_id, ilac_ad, ilac_ucret, ilac_tarih) "
                    + "values('" + h.getIlac_id()+ "','" + h.getIlac_ad()+ "', '" + h.getIlac_ucret()+ "', '" + h.getIlac_tarih()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<ilac> read() {
        List<ilac> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ilac order by ilac_id asc");
            while (rs.next()) {
                ilac tmp = new ilac(rs.getInt("ilac_id"),rs.getString("ilac_ad"), rs.getInt("ilac_ucret"), rs.getDate("ilac_tarih"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void update(ilac h) {
        try {
            Statement st = this.connect().createStatement();
            st.execute("update ilac set ilac_ad='" + h.getIlac_ad() + "', ilac_ucret'"+ h.getIlac_ucret() + "' ilac_tarih'"+ h.getIlac_tarih() + "'where ilac_id'"+ h.getIlac_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(ilac h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from ilac where ilac_id=" + h.getIlac_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}