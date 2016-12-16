package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by codecadet on 08/12/16.
 */
public class MockUserService implements UserService{

    private Map<String, User> userMap;

    public MockUserService() {
        userMap = new HashMap<>();
    }

    @Override
    public boolean authenticate(String username, String password) {
        User tempUser;
        return ((tempUser = findByName(username)) != null) && tempUser.getPassword().equals(password);
    }

    @Override
    public void addUser(User user) {
        //Logger byName = LogManager.getLogger(MockUserService.class.getName());
        //byName.trace("Adicionei o user "+user.getUsername());
        userMap.put(user.getUsername(), user);
    }

    @Override
    public void deleteUser(String username){
        userMap.remove(username);
    }

    @Override
    public User findByName(String username) {
        return userMap.get(username);
    }

    @Override
    public Map<String, User> findAll() {
        return userMap;
    }

    @Override
    public int count() {
        return userMap.size();
    }

    @Override
    public void erase(){
        userMap.clear();
    }
}
