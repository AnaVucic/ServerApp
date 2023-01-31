/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.session;

import commonlib.domain.GenericEntity;
import commonlib.domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Session {
    
    private static Session instance;
    List<User> users;

    public Session() {
        users = new ArrayList<>();
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public void addUser(GenericEntity entity) {
        if (entity instanceof User) {
            if (!users.contains(entity)) {
                users.add((User) entity);
            }
        }

    }

    public List<User> getAllUsers() {
        return users;
    }
    
    public int getNumberOfUsersOnline(){
        return users.size();
    }

    public boolean removeUser(GenericEntity entity) {
        boolean success = false;
        User user = (User) entity;

        if (users.contains(user)) {
            users.remove(user);
            success = true;
        }
        return success;
    }

    public void logoutAllUsers() {
        users = new ArrayList<>();
    }
    
}
