package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

/**
 * Created by codecadet on 08/12/16.
 */
public interface UserService {

    boolean authenticate(String username, String password);

    void addUser(User user);

    void deleteUser(String username);

    User findByName(String username);

    int count();

    void erase();

}
