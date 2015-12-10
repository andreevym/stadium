package ru.joinlang.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Service
public class LDAPService {

    private static final String LDAP_HOST = "ldap://localhost:10389";
    private static final String LOGIN = "uid=admin,ou=system";
    private static final String PASSWORD = "secret";

    /**
     * http://docs.oracle.com/javase/tutorial/jndi/ldap/auth_mechs.html
     * <p>
     * simple	Use weak authentication (clear-text password)
     */
    private static final String AUTHENTICATION_TYPE = "simple";

    private LdapContext ldapContext;

    public LDAPService() {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, AUTHENTICATION_TYPE);
        env.put(Context.PROVIDER_URL, LDAP_HOST);
        env.put(Context.SECURITY_PRINCIPAL, LOGIN);
        env.put(Context.SECURITY_CREDENTIALS, PASSWORD);
        try {
            ldapContext = new InitialLdapContext(env, null);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllUsersString(){
        List<String> users = new ArrayList<>();
        try {
            NamingEnumeration<NameClassPair> list = ldapContext.list("ou=system");

            while (list.hasMore()) {
                NameClassPair nc = list.next();
                users.add(nc.toString());
            }

        } catch (NamingException e) {
            e.printStackTrace();
        }

        return users;
    }
}
