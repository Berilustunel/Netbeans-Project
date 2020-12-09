/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.hastalikDAO;
import entity.hastalik;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Beril
 */
@FacesConverter(value="hastalikConverter")
public class hastalikConvertor implements Converter {
    
    private hastalikDAO hlikDao;

    public hastalikDAO getHlikDao() {
        if (this.hlikDao == null){
            this.hlikDao = new hastalikDAO();
        }
        return hlikDao;
    }

    public void setHlikDao(hastalikDAO hlikDao) {
        this.hlikDao = hlikDao;
    }
    
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) { //gelen string i nesneye dönüştürecek olan method
        System.out.println("------------------------in getAsObject Method----------------------------");
        return this.getHlikDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("------------------------in getAsString Method----------------------------");
        hastalik l = (hastalik)value; //gelen nesneyi int dönüştürür.
        //return (l.equals(list[pos].getItemNumber()));
        //return l.getHastalik_id().toString();
        return String.valueOf(l.getHastalik_id());
    }
    
}
