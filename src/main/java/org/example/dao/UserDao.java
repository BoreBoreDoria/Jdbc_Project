package org.example.dao;

import java.util.List;
import org.example.entity.User;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, int age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
