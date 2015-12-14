package ru.joinlang.mapper;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.support.AbstractContextMapper;
import ru.joinlang.model.User;

public class UserAttributesMapper extends AbstractContextMapper<User> {

    @Override
    protected User doMapFromContext(DirContextOperations context) {
        User user = new User();
        user.setId(context.getStringAttribute("uid"));
        user.setFullName(context.getStringAttribute("cn"));
        user.setLastName(context.getStringAttribute("sn"));
        user.setEmail(context.getStringAttribute("mail"));
        user.setMemberOf(context.getStringAttribute("memberOf"));
        user.setDescription(context.getStringAttribute("description"));
        return user;
    }
}