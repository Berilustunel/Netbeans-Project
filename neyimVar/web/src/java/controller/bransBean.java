/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.bransDAO;
import entity.brans;
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
public class bransBean implements Serializable {

    private bransDAO dao;
    private brans entity;

    
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new brans();
        return "/brans/list";
    }
    
    public brans getById(int id){
        return this.getDao().getById(id);
    }

    public List<brans> getRead() {
        return this.getDao().read();

    }

    public String updateForm(brans h) {
        this.entity = h;
        return "/brans/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new brans();
        return "/brans/list";
    }

    public void delete(brans h) {
        this.getDao().delete(h);
    }

    public bransBean() {
    }

    public bransDAO getDao() {
        if (this.dao == null) {
            this.dao = new bransDAO();
        }
        return dao;
    }

    public void setDao(bransDAO dao) {
        this.dao = dao;
    }

    public brans getEntity() {
        if (this.entity == null) {
            this.entity = new brans();
        }
        return entity;
    }

    public void setEntity(brans entity) {
        this.entity = entity;
    }

}

