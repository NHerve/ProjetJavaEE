package montp.web.controllers;

import montp.data.dao.UserDAO;
import montp.data.model.User;
import montp.tools.Tools;
import montp.web.FacesTools;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@RequestScoped
@Named
public class ProfilCtrl implements Serializable {

    @Inject
    private UserDAO userDAO;
    private User user = new  User();

    @PostConstruct
    public void init(){
        if(FacesTools.getRequest().getUserPrincipal().getName() != null){
            user = userDAO.getFromUsername(FacesTools.getRequest().getUserPrincipal().getName());
        }
    }

    public void save(){
        userDAO.update(user);
        FacesTools.addMessage(FacesMessage.SEVERITY_INFO,
                "Informations mise a jour");
        init();
    }

    public void saveMdp(){
        user.setMdp(Tools.digestSHA256Hex(user.getMdp().trim()));
        userDAO.update(user);
        FacesTools.addMessage(FacesMessage.SEVERITY_INFO,
                "Informations mise a jour");
        init();
    }

    //region SetteGetter
    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //endregion
}
