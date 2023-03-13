package org.example.dao;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.example.dto.Animals;
import org.example.dto.Info;
import org.example.entity.Cat;
import org.example.entity.Fish;
import org.example.entity.Test;
import org.example.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

@Repository
public class UserDaoHiber implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void saveUser(String name, String lastName, int age) {
        sessionFactory.getCurrentSession().save(new User(name, lastName, age));
    }

    @Transactional
    public void saveCat(String name) {
        Cat cat = new Cat("CatTest","white");
        cat.setType("Cat");
        cat.setName(name);
        sessionFactory.getCurrentSession().save(cat);
    }

    @Transactional
    public void saveFish(String name) {
        Fish fish = new Fish("TestFish", "hrga");
        fish.setType("Fish");
        fish.setName(name);
        sessionFactory.getCurrentSession().save(fish);
    }

    @Transactional
    public void saveTest() {
        List<String> list = Arrays.asList("Test1", "Test2", "Test3");
        Test test = new Test("Test", Info.PLAYER, Info.INFO,new Date(2019,12,12) , list);
        sessionFactory.getCurrentSession().save(test);
    }

    @Transactional
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Transactional
    public User getUserById(long id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional
    public List<Animals> getAllAnimals() {
        return sessionFactory.getCurrentSession().createQuery("from Animals").getResultList();
    }
}
