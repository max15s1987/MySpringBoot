package com.example.myspringboot.dao;


import com.example.myspringboot.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    public User getUserById(Long id) {
        Query query = entityManager.createQuery("SELECT i from User i where i.id = :paramId");
        query.setParameter("paramId", id);
//        return entityManager.find(User.class, id);
        return (User) query.getSingleResult();
    }

    @Override
    public User findByLogin(String s) {
        Query query = entityManager.createQuery("SELECT e from User e where e.email = :paramEmail");
        query.setParameter("paramEmail", s);
        return (User) query.getSingleResult();
    }


    public boolean checkId(Long id) {
        Query query = entityManager.createQuery("SELECT i.id from User i where i.id = :paramId");
        query.setParameter("paramId", id);
        return query.getResultList().isEmpty();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User user) {

        User userUpdate = getUserById(id);

        userUpdate.setName(user.getName());
        userUpdate.setAge(user.getAge());
        userUpdate.setCity(user.getCity());
        userUpdate.setEmail(user.getEmail());

        entityManager.merge(userUpdate);
    }

    @Override
    public void remove(Long id) {
        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :paramId");
        query.setParameter("paramId", id).executeUpdate();
    }



}
