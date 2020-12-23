/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.klinikDAO;
import entity.klinik;
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
public class klinikBean implements Serializable {

    private klinikDAO dao;
    private klinik entity;

    
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new klinik();
        return "/klinik/list";
    }
    
    public klinik getById(int id){
        return this.getDao().getById(id);
    }

    public List<klinik> getRead() {
        return this.getDao().read();

    }

    public String updateForm(klinik h) {
        this.entity = h;
        return "/klinik/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new klinik();
        return "/klinik/list";
    }

    public void delete(klinik h) {
        this.getDao().delete(h);
    }

    public klinikBean() {
    }

    public klinikDAO getDao() {
        if (this.dao == null) {
            this.dao = new klinikDAO();
        }
        return dao;
    }

    public void setDao(klinikDAO dao) {
        this.dao = dao;
    }

    public klinik getEntity() {
        if (this.entity == null) {
            this.entity = new klinik();
        }
        return entity;
    }

    public void setEntity(klinik entity) {
        this.entity = entity;
    }

}
