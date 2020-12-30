package controller;

import dao.doktorDAO;
import entity.doktor;
import entity.doktor;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Beril
 */
@Named
@SessionScoped
public class doktorBean implements Serializable {

    private doktorDAO dao;
    private doktor entity;

    /*private int hasta_id;
    private String ad;
    private String soyad;
    private int yas;*/
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new doktor();
        return "/doktor/list";
    }
    
    public doktor getById(int id){
        return this.getDao().getById(id);
    }

    public List<doktor> getRead() {
        return this.getDao().read();

    }

    public String updateForm(doktor h) {
        this.entity = h;
        return "/doktor/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new doktor();
        return "/doktor/list";
    }

    public void delete(doktor h) {
        this.getDao().delete(h);
    }

    public doktorBean() {
    }

    public doktorDAO getDao() {
        if (this.dao == null) {
            this.dao = new doktorDAO();
        }
        return dao;
    }

    public void setDao(doktorDAO dao) {
        this.dao = dao;
    }

    public doktor getEntity() {
        if (this.entity == null) {
            this.entity = new doktor();
        }
        return entity;
    }

    public void setEntity(doktor entity) {
        this.entity = entity;
    }

}
