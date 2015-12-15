package ru.joinlang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfiguration {

    @Autowired
    Environment env;

    @Value("${ldap.url}")
    String ldapUrl;

    @Value("${ldap.base}")
    String ldapBase;

    @Value("${ldap.user}")
    String ldapUser;

    @Value("${ldap.password}")
    String ldapPassword;

    /**
     * for @Value with properties
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public LdapContextSource ldapContextSource() {
        LdapContextSource ldapContextSource = new LdapContextSource();
        ldapContextSource.setUrl(ldapUrl);
        ldapContextSource.setBase(ldapBase);
        ldapContextSource.setUserDn(ldapUser);
        ldapContextSource.setPassword(ldapPassword);
        ldapContextSource.afterPropertiesSet();
        return ldapContextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate(){
        return new LdapTemplate(ldapContextSource());
    }
}