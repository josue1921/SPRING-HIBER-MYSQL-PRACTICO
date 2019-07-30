package com.app;

import com.app.ibatis.controller.CORSResponseFilter;
import com.app.ibatis.controller.UserController;
import com.app.ibatis.controller.ContactController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(CORSResponseFilter.class);
        register(UserController.class);
        register(ContactController.class);
    }

}

