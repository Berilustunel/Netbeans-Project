/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.receteDAO;
import entity.recete;
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
public class receteBean implements Serializable {

    private receteDAO dao;
    private recete entity;

    /*private int hasta_id;
    private String ad;
    private String soyad;
    private int yas;*/
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new recete();
        return "/recete/list";
    }

    public List<recete> getRead() {
        return this.getDao().read();

    }

    public String updateForm(recete h) {
        this.entity = h;
        return "/recete/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new recete();
        return "/recete/list";
    }

    public void delete(recete h) {
        this.getDao().delete(h);
    }

    public receteBean() {
    }

    public receteDAO getDao() {
        if (this.dao == null) {
            this.dao = new receteDAO();
        }
        return dao;
    }

    public void setDao(receteDAO dao) {
        this.dao = dao;
    }

    public recete getEntity() {
        if (this.entity == null) {
            this.entity = new recete();
        }
        return entity;
    }

    public void setEntity(recete entity) {
        this.entity = entity;
    }

}

