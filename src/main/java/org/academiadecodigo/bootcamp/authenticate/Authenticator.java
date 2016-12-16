package org.academiadecodigo.bootcamp.authenticate;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.UserService;

/**
 * Created by codecadet on 08/12/16.
 */
public class Authenticator {

    private UserService userService;

    public boolean authenticate(String username, String password) {
        boolean toReturn = false;
        if (userService.authenticate(username, password)) {
            toReturn = true;
        }
        return toReturn;
    }

    public boolean register(User user) {

        if (userService.findByName(user.getUsername()) == null) {
            userService.addUser(user);
            return true;
        }
        return false;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
