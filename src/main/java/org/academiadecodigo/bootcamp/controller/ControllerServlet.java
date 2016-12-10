package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.authenticate.Authenticator;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.MockUserService;
import org.academiadecodigo.bootcamp.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by codecadet on 08/12/16.
 */
public class ControllerServlet extends HttpServlet {

    private UserService userService;
    private boolean noobProof;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userService = new MockUserService();
        RequestDispatcher indexDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        indexDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("formName");
        String pass = req.getParameter("formPassword");
        String email = req.getParameter("formEmail");

        noobProof = true;

        if (name == null || name.isEmpty() || pass == null || pass.isEmpty() || email == null || email.isEmpty()) {
            noobProof = false;
        }

        if (noobProof && Authenticator.register(userService, new User(name, pass, email))) {


            req.setAttribute("userMap", ((MockUserService) userService).getUserMap());

            RequestDispatcher mainDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/main.jsp");
            mainDispatcher.forward(req, resp);

        } else {
            resp.sendRedirect("/loginmvc");
        }
    }
}
