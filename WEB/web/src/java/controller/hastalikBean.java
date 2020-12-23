/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.hastalikDAO;
import entity.hastalik;
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
public class hastalikBean implements Serializable {

    private hastalikDAO dao;
    private hastalik entity;

    /*private int hasta_id;
    private String ad;
    private String soyad;
    private int yas;*/
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new hastalik();
        return "/hastalik/list";
    }
    
    public hastalik getById(int id){
        return this.getDao().getById(id);
    }

    public List<hastalik> getRead() {
        return this.getDao().read();

    }

    public String updateForm(hastalik h) {
        this.entity = h;
        return "/hastalik/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new hastalik();
        return "/hastalik/list";
    }

    public void delete(hastalik h) {
        this.getDao().delete(h);
    }

    public hastalikBean() {
    }

    public hastalikDAO getDao() {
        if (this.dao == null) {
            this.dao = new hastalikDAO();
        }
        return dao;
    }

    public void setDao(hastalikDAO dao) {
        this.dao = dao;
    }

    public hastalik getEntity() {
        if (this.entity == null) {
            this.entity = new hastalik();
        }
        return entity;
    }

    public void setEntity(hastalik entity) {
        this.entity = entity;
    }

}
