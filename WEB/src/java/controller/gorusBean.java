/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.gorusDAO;
import entity.gorus;
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
public class gorusBean implements Serializable {

    private gorusDAO dao;
    private gorus entity;

    
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new gorus();
        return "/gorus/list";
    }
    
    public gorus getById(int id){
        return this.getDao().getById(id);
    }

    public List<gorus> getRead() {
        return this.getDao().read();

    }

    public String updateForm(gorus h) {
        this.entity = h;
        return "/gorus/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new gorus();
        return "/gorus/list";
    }

    public void delete(gorus h) {
        this.getDao().delete(h);
    }

    public gorusBean() {
    }

    public gorusDAO getDao() {
        if (this.dao == null) {
            this.dao = new gorusDAO();
        }
        return dao;
    }

    public void setDao(gorusDAO dao) {
        this.dao = dao;
    }

    public gorus getEntity() {
        if (this.entity == null) {
            this.entity = new gorus();
        }
        return entity;
    }

    public void setEntity(gorus entity) {
        this.entity = entity;
    }

}
