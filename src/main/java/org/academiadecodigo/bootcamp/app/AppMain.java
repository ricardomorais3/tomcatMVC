package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.bootcamp.authenticate.Authenticator;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.MockUserService;
import org.academiadecodigo.bootcamp.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by codecadet on 12/12/16.
 */
public class AppMain implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext context = servletContextEvent.getServletContext();

        UserService userService = new MockUserService();
        Authenticator authenticator = new Authenticator();
        authenticator.setUserService(userService);

        authenticator.register(new User("Pedro Antoninho", "pedro", "pedro.antoninho@academiadecodigo.org"));
        authenticator.register(new User("Sérgio Gouveia", "sergio", "sergio.gouveia@academiadecodigo.org"));
        authenticator.register(new User("Jorge Antunes", "jorge", "jorge.antunes@academiadecodigo.org"));

        // Make services available to the whole app
        context.setAttribute(Attribute.AUTH_SERVICE, authenticator);
        context.setAttribute(Attribute.USER_SERVICE, userService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
