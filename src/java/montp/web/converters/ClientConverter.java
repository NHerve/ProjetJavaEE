package montp.web.converters;

import montp.data.dao.ClientDAO;
import montp.data.model.Client;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("client")
public class ClientConverter implements Converter {

    private ClientDAO clientDAO = CDI.current().select(ClientDAO.class).get();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return clientDAO.get(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Client)value).getId().toString();
    }
}
