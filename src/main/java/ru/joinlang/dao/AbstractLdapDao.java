package ru.joinlang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;

import java.util.List;

/**
 * Created by user on 14.12.2015.
 */
public abstract class AbstractLdapDao <T, M> {

    protected String BASE_DN = ""; // application.properties: ldap.base=ou=system

    @Autowired
    protected LdapTemplate ldapTemplate;

    public abstract List<T> getAll();
}
