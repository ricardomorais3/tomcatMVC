package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by codecadet on 08/12/16.
 */
public class MockUserService implements UserService{

    private Map<String, User> userMap;

    public MockUserService() {
        userMap = new HashMap<>();
        addUser(new User("Pedro Antoninho", "pedro", "pedro.antoninho@academiadecodigo.org"));
        addUser(new User("Sérgio Gouveia", "sergio", "sergio.gouveia@academiadecodigo.org"));
        addUser(new User("Jorge Antunes", "jorge", "jorge.antunes@academiadecodigo.org"));
    }

    @Override
    public boolean authenticate(String username, String password) {
        User tempUser;
        return ((tempUser = findByName(username)) != null) && tempUser.getPassword().equals(password);
    }

    @Override
    public void addUser(User user) {
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
    public int count() {
        return userMap.size();
    }

    @Override
    public void erase(){
        userMap.clear();
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }
}
