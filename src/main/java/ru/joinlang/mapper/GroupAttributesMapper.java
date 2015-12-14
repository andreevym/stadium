package ru.joinlang.mapper;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.support.AbstractContextMapper;
import ru.joinlang.model.Group;
import ru.joinlang.model.User;

public class GroupAttributesMapper extends AbstractContextMapper<Group> {

    @Override
    protected Group doMapFromContext(DirContextOperations context) {
        Group group = new Group();
        group.setName(context.getStringAttribute("cn"));
        return group;
    }
}