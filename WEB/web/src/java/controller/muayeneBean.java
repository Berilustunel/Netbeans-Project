/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.muayeneDAO;
import entity.muayene;
import entity.muayene;
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
public class muayeneBean implements Serializable {

    private muayeneDAO dao;
    private muayene entity;

    /*private int hasta_id;
    private String ad;
    private String soyad;
    private int yas;*/
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new muayene();
        return "/muayene/list";
    }
    
    public muayene getById(int id){
        return this.getDao().getById(id);
    }

    public List<muayene> getRead() {
        return this.getDao().read();

    }

    public String updateForm(muayene h) {
        this.entity = h;
        return "/muayene/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new muayene();
        return "/muayene/list";
    }

    public void delete(muayene h) {
        this.getDao().delete(h);
    }

    public muayeneBean() {
    }

    public muayeneDAO getDao() {
        if (this.dao == null) {
            this.dao = new muayeneDAO();
        }
        return dao;
    }

    public void setDao(muayeneDAO dao) {
        this.dao = dao;
    }

    public muayene getEntity() {
        if (this.entity == null) {
            this.entity = new muayene();
        }
        return entity;
    }

    public void setEntity(muayene entity) {
        this.entity = entity;
    }

}

