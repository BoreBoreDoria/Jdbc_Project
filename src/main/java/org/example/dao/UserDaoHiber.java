package org.example.dao;

import java.util.List;
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
}
