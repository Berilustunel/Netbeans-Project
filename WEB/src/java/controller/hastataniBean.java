/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.hastataniDAO;
import entity.hastatani;
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
public class hastataniBean implements Serializable {

    private hastataniDAO dao;
    private hastatani entity;

    /*private int hasta_id;
    private String ad;
    private String soyad;
    private int yas;*/
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new hastatani();
        return "index";
    }

    public List<hastatani> getRead() {
        return this.getDao().read();

    }

    public String updateForm(hastatani h) {
        this.entity = h;
        return "update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new hastatani();
        return "index";
    }

    public void delete(hastatani h) {
        this.getDao().delete(h);
    }

    public hastataniBean() {
    }

    public hastataniDAO getDao() {
        if (this.dao == null) {
            this.dao = new hastataniDAO();
        }
        return dao;
    }

    public void setDao(hastataniDAO dao) {
        this.dao = dao;
    }

    public hastatani getEntity() {
        if (this.entity == null) {
            this.entity = new hastatani();
        }
        return entity;
    }

    public void setEntity(hastatani entity) {
        this.entity = entity;
    }

}
