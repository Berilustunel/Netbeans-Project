/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.hastataniDAO;
import entity.hastatani;
import entity.ilac;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
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

    /*public void searchStringValueChanged(ValueChangeEvent vce) {
        searchByTitle((String) vce.getNewValue());
    }*/

    /*@Inject //CDI-hastalikBean i inject etmek, erişmek için 
    private hastalikBean hastalikBean;
    
    private int selectedHastalik;//geçici değişkende hastalığın id si tutulur, oluşturulmak istenen hastanın nesnesine nesne olarak gönderilir.  

    public int getSelectedHastalik() {
        return selectedHastalik;
    }

    public void setSelectedHastalik(int selectedHastalik) {
        this.selectedHastalik = selectedHastalik;
    }*/

 /*private int hasta_id;
    private String ad;
    private String soyad;
    private int yas;*/
    //CRUD İŞLEMLERİ
    public String create() {
        //hastalik l = hastalikBean.getDao().getById(selectedHastalik);
        //entity.setHastalik(l);
        this.getDao().create(entity);
        this.entity = new hastatani();
        return "/hasta/list";
    }

    public hastatani getById(int id) {
        return this.getDao().getById(id);
    }

    public List<hastatani> getRead() {
        return this.getDao().read();

    }

    public String updateForm(hastatani h) {
        this.entity = h;
        //this.selectedHastalik = h.getHastalik().getHastalik_id();
        return "/hasta/update";
    }

    public String update() {
        //hastalik l = hastalikBean.getDao().getById(selectedHastalik);
        //entity.setHastalik(l);
        this.getDao().update(entity);
        this.entity = new hastatani();
        return "/hasta/list";
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

    /*private void searchByTitle(String string) {
        this.entity.getAd() = entity.ad.searchByTitle(title);
        //To change body of generated methods, choose Tools | Templates.
    }*/

}
