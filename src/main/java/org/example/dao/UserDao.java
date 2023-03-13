package org.example.dao;

import java.util.List;
import org.example.dto.Animals;
import org.example.entity.User;

public interface UserDao {

    void saveUser(String name, String lastName, int age);

    List<User> getAllUsers();

    User getUserById(long id);

    List<Animals> getAllAnimals();

    void saveCat(String name);
    void saveFish(String name);
    void saveTest();
}
