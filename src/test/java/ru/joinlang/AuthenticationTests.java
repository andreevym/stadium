package ru.joinlang;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.joinlang.config.SecurityConfiguration;

import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class AuthenticationTests {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilters(springSecurityFilterChain)
                .build();
    }

    @Test
    public void requiresAuthentication() throws Exception {
        mvc
                .perform(get("/"))
                .andExpect(status().isFound());
    }

    @Test
    public void authenticationSuccess() throws Exception {
        mvc
                .perform(formLogin().user("admin").password("secret"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/index.html"))
                .andExpect(authenticated().withUsername("admin"));
    }

    @Test
    public void authenticationFailed() throws Exception {
        mvc
                .perform(formLogin().user("admin").password("invalid"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/login?error"))
                .andExpect(unauthenticated());
    }


    @Configuration
    @PropertySource("classpath:/ldap.properties")
    static class Config extends SecurityConfiguration {

    }
}
