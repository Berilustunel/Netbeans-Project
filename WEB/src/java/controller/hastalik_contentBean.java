/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.hastalik_contentDAO;
import entity.hastalik_content;
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
public class hastalik_contentBean implements Serializable {

    private hastalik_contentDAO dao;
    private hastalik_content entity;

    
    //CRUD İŞLEMLERİ
    public String create() {
        this.getDao().create(entity);
        this.entity = new hastalik_content();
        return "/hastalik_content/list";
    }
    

    public List<hastalik_content> getRead() {
        return this.getDao().read();

    }

    public String updateForm(hastalik_content h) {
        this.entity = h;
        return "/hastalik_content/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new hastalik_content();
        return "/hastalik_content/list";
    }

    public void delete(hastalik_content h) {
        this.getDao().delete(h);
    }

    public hastalik_contentBean() {
    }

    public hastalik_contentDAO getDao() {
        if (this.dao == null) {
            this.dao = new hastalik_contentDAO();
        }
        return dao;
    }

    public void setDao(hastalik_contentDAO dao) {
        this.dao = dao;
    }

    public hastalik_content getEntity() {
        if (this.entity == null) {
            this.entity = new hastalik_content();
        }
        return entity;
    }

    public void setEntity(hastalik_content entity) {
        this.entity = entity;
    }

}
