/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.gecmisDAO;
import entity.gecmis;
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
public class gecmisBean implements Serializable {

    private gecmisDAO dao;
    private gecmis entity;

    
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new gecmis();
        return "/gecmis/list";
    }
    
    public gecmis getById(int id){
        return this.getDao().getById(id);
    }

    public List<gecmis> getRead() {
        return this.getDao().read();

    }

    public String updateForm(gecmis h) {
        this.entity = h;
        return "/gecmis/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new gecmis();
        return "/gecmis/list";
    }

    public void delete(gecmis h) {
        this.getDao().delete(h);
    }

    public gecmisBean() {
    }

    public gecmisDAO getDao() {
        if (this.dao == null) {
            this.dao = new gecmisDAO();
        }
        return dao;
    }

    public void setDao(gecmisDAO dao) {
        this.dao = dao;
    }

    public gecmis getEntity() {
        if (this.entity == null) {
            this.entity = new gecmis();
        }
        return entity;
    }

    public void setEntity(gecmis entity) {
        this.entity = entity;
    }

}
