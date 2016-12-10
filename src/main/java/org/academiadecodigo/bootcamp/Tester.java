package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.MockUserService;

/**
 * Created by codecadet on 08/12/16.
 */
public class Tester {

    public static void main(String[] args) {
        MockUserService mockUserService = new MockUserService();
        mockUserService.addUser(new User("Richie","olabebe","ric"));
        mockUserService.addUser(new User("Richie9","olabebe","ricardo@hotmail.com"));
        mockUserService.addUser(new User("Richie99","olabebe","ricardo@hotmail.com"));
        System.out.println(mockUserService.count());
        System.out.println(mockUserService.authenticate("Richie9","bebe"));

        mockUserService.deleteUser("Richie99999");
        System.out.println(mockUserService.count());

        mockUserService.erase();
        System.out.println(mockUserService.count());
    }

}
