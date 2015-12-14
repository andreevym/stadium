package ru.joinlang.mapper;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.support.AbstractContextMapper;
import ru.joinlang.model.Group;

public class CnAttributesMapper extends AbstractContextMapper<String> {

    @Override
    protected String doMapFromContext(DirContextOperations context) {
        return context.getStringAttribute("cn");
    }
}