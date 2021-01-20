/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ilacDAO;
import entity.ilac;
import entity.ilac;
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
public class ilacBean implements Serializable {

    private ilacDAO dao;
    private ilac entity;

    /*private int hasta_id;
    private String ad;
    private String soyad;
    private int yas;*/
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new ilac();
        return "/ilac/list";
    }

    public ilac getById(int id){
        return this.getDao().getById(id);
    }
    
    public List<ilac> getRead() {
        return this.getDao().read();

    }

    public String updateForm(ilac h) {
        this.entity = h;
        return "/ilac/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new ilac();
        return "/ilac/list";
    }

    public void delete(ilac h) {
        this.getDao().delete(h);
    }

    public ilacBean() {
    }

    public ilacDAO getDao() {
        if (this.dao == null) {
            this.dao = new ilacDAO();
        }
        return dao;
    }

    public void setDao(ilacDAO dao) {
        this.dao = dao;
    }

    public ilac getEntity() {
        if (this.entity == null) {
            this.entity = new ilac();
        }
        return entity;
    }

    public void setEntity(ilac entity) {
        this.entity = entity;
    }

}

