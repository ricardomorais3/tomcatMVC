package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

import java.util.Map;

/**
 * Created by codecadet on 08/12/16.
 */
public interface UserService {

    boolean authenticate(String username, String password);

    void addUser(User user);

    void deleteUser(String username);

    User findByName(String username);

    Map<String, User> findAll();

    int count();

    void erase();

}
