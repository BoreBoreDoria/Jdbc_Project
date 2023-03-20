package org.example.dao;

import java.util.List;
import org.example.entity.User;

public interface UserDao {

    void saveUser(String name, String lastName, int age);

    List<User> getAllUsers();

    User getUserById(long id);

}
