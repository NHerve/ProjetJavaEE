package montp.web.controllers;

import montp.web.FacesTools;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("app")
public class Application {

    public void logout() {
        FacesTools.getRequest().getSession().invalidate();
        FacesTools.redirect("app/index.xhtml");
    }
}
