package montp.services;

import montp.data.dao.UserDAO;
import montp.data.model.Group;
import montp.data.model.User;
import montp.tools.Tools;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class UserService extends GenericService<User, UserDAO> {

    public List<User> getUsers() {
        return dao.getUsers();
    }

    public UserService() {
    }

    public User getFromUsername(String username) {
        return dao.getFromUsername(username.toLowerCase().trim());
    }

    public Group getGroup(String groupname) {
        return dao.getGroup(groupname.toUpperCase().trim());
    }

    @Transactional
    public void insert(User user) {
        if (user.getGroups() == null) {
            List<Group> groupes = new LinkedList<>();
            groupes.add(getGroup("USER"));
            user.setGroups(groupes);
        }
        user.setMdp(Tools.digestSHA256Hex(user.getMdp().trim()));
        user.setAdresseMail(user.getAdresseMail().toLowerCase().trim());
        super.insert(user);
    }

    public boolean checkIfExists(String username) {
        return getFromUsername(username) != null;
    }
}
