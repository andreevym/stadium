package ru.joinlang.dao;

import org.springframework.stereotype.Repository;
import ru.joinlang.mapper.GroupAttributesMapper;
import ru.joinlang.model.Group;

import java.util.List;

@Repository
public class GroupDao extends AbstractLdapDao<Group, GroupAttributesMapper> {

    @Override
    public List<Group> getAll() {
        //groupOfUniqueNames (structural)
        return ldapTemplate.search(BASE_DN, "(objectclass=groupOfUniqueNames)", new GroupAttributesMapper());
    }
}
