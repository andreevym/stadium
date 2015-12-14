package ru.joinlang.dao;


import org.springframework.ldap.core.AttributesMapper;
import org.springframework.stereotype.Repository;
import ru.joinlang.mapper.CnAttributesMapper;
import ru.joinlang.mapper.UserAttributesMapper;
import ru.joinlang.model.User;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.List;

@Repository
public class UserDao extends AbstractLdapDao<User, UserAttributesMapper> {

    public List<String> findAllUserNames() {
        return ldapTemplate.search(
                BASE_DN, "(objectclass=person)",
                new CnAttributesMapper());
    }

    public User getByUsername(String username) {
        return ldapTemplate.lookup("cn=" + username, new UserAttributesMapper());
    }

    public List<User> getAll() {
        return ldapTemplate.search(BASE_DN, "(objectclass=person)", new UserAttributesMapper());
    }



    /*public void enableUser(String userName) {
        DirContextOperations userContextOperations = ldapTemplate.lookupContext(getDnFrom(userName));
        String userAccountControlStr = userContextOperations.getStringAttribute(USER_ACCOUNT_CONTROL_ATTR_NAME);
        int newUserAccountControl = Integer.parseInt(userAccountControlStr) & ~FLAG_TO_DISABLE_USER;
        userContextOperations.setAttributeValue(USER_ACCOUNT_CONTROL_ATTR_NAME, "" + newUserAccountControl);
        ldapTemplate.modifyAttributes(userContextOperations);
    }*/
}
