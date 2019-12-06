package montp.web.converters;

import montp.data.dao.ClientDAO;
import montp.data.dao.ProjetDAO;
import montp.data.model.Client;
import montp.data.model.Projet;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("projet")
public class ProjetConverter implements Converter {

    private ProjetDAO projetDAO = CDI.current().select(ProjetDAO.class).get();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return projetDAO.get(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Projet)value).getId().toString();
    }
}
