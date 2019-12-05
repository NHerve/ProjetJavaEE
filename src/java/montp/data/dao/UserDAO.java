package montp.data.dao;

import montp.data.model.Group;
import montp.tools.Tools;
import montp.data.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserDAO extends GenericDAO<User> {

    public UserDAO(){
        super(User.class);
    }
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return em.createQuery("SELECT u FROM User u ORDER BY u.userName")
                .getResultList();
    }

    public User getFromUsername(String adressemail) {
        User user = (User) em.createQuery("SELECT u FROM User u WHERE u.adresseMail=:adressemail")
                .setParameter("adressemail", adressemail)
                .getSingleResult();
        return user;
    }

    public Group getGroup(String groupname) {
        return em.find(Group.class, groupname);
    }


}
