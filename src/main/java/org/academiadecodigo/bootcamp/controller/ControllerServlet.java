package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.app.Attribute;
import org.academiadecodigo.bootcamp.authenticate.Authenticator;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by codecadet on 08/12/16.
 */
public class ControllerServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(ControllerServlet.class.getName());
    private Authenticator authenticator;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        authenticator = (Authenticator) getServletContext().getAttribute(Attribute.AUTH_SERVICE);
        userService = (UserService) getServletContext().getAttribute(Attribute.USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher indexDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        indexDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("formName");
        String pass = req.getParameter("formPassword");
        String email = req.getParameter("formEmail");

        if (name == null || name.isEmpty() || pass == null || pass.isEmpty() || email == null || email.isEmpty()) {
            resp.sendRedirect("/loginmvc");
            return;
        }

        if (authenticator.register(new User(name, pass, email))) {

            req.setAttribute("userMap", userService.findAll());
            RequestDispatcher mainDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/main.jsp");
            mainDispatcher.forward(req, resp);

        } else {
            resp.sendRedirect("/loginmvc");
        }
    }
}
