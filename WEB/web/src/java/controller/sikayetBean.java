/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.sikayetDAO;
import entity.sikayet;
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
public class sikayetBean implements Serializable {

    private sikayetDAO dao;
    private sikayet entity;

    /*private int hasta_id;
    private String ad;
    private String soyad;
    private int yas;*/
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new sikayet();
        return "/sikayet/list";
    }

    public List<sikayet> getRead() {
        return this.getDao().read();

    }

    public String updateForm(sikayet h) {
        this.entity = h;
        return "/sikayet/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new sikayet();
        return "/sikayet/list";
    }

    public void delete(sikayet h) {
        this.getDao().delete(h);
    }

    public sikayetBean() {
    }

    public sikayetDAO getDao() {
        if (this.dao == null) {
            this.dao = new sikayetDAO();
        }
        return dao;
    }

    public void setDao(sikayetDAO dao) {
        this.dao = dao;
    }

    public sikayet getEntity() {
        if (this.entity == null) {
            this.entity = new sikayet();
        }
        return entity;
    }

    public void setEntity(sikayet entity) {
        this.entity = entity;
    }

}

