
package controller;

import dao.randevuDAO;
import entity.randevu;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped

public class randevuBean implements Serializable {

    private randevuDAO dao;
    private randevu entity;

    private int hasta_id;
    private String ad;
    private String soyad;
    private int yas;
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new randevu();
        return "/randevu/list";
    }

    public List<randevu> getRead() {
        return this.getDao().read();

    }

    public String updateForm(randevu h) {
        this.entity = h;
        return "/randevu/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new randevu();
        return "/randevu/list";
    }

    public void delete(randevu h) {
        this.getDao().delete(h);
    }

    public randevuBean() {
    }

    public randevuDAO getDao() {
        if (this.dao == null) {
            this.dao = new randevuDAO();
        }
        return dao;
    }

    public void setDao(randevuDAO dao) {
        this.dao = dao;
    }

    public randevu getEntity() {
        if (this.entity == null) {
            this.entity = new randevu();
        }
        return entity;
    }

    public void setEntity(randevu entity) {
        this.entity = entity;
    }
}
    

