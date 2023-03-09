package org.example.dao;

import java.util.Collections;
import java.util.List;
import org.example.Config;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import static org.hibernate.resource.transaction.spi.TransactionStatus.ACTIVE;
import static org.hibernate.resource.transaction.spi.TransactionStatus.MARKED_ROLLBACK;

public class UserDaoHiber implements UserDao {

    public void createUsersTable() {
        Transaction transaction = null;
        try (Session session = Config.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("CREATE TABLE IF NOT EXISTS users(id int primary key auto_increment, " +
                    "name varchar(40), lastName varchar(40), age int );");
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE
                    || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = Config.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE IF EXISTS users;");
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE
                    || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    public void saveUser(String name, String lastName, int age) {
        Transaction transaction = null;
        try (Session session = Config.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE
                    || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = Config.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete User where id = :param");
            query.setParameter("param", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE
                    || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    public List<User> getAllUsers() {
        List<User> users = Collections.emptyList();
        Transaction transaction = null;
        try (Session session = Config.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery("from User");
            users = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE
                    || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
        return users;
    }


    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = Config.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("TRUNCATE TABLE users");
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE
                    || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }
}
