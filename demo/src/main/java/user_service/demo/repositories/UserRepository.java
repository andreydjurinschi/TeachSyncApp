/*
package user_service.demo.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import user_service.demo.entities.User;

import java.util.List;

@Repository
public class UserRepository {


    @PersistenceContext
    private EntityManager em;

    */
/**
     * Метод, возвращающий список пользователй, включая их роли
     * @return
     *//*

    public List<User> getUsers() {
        String hql = "From User join fetch User.role";
        return em.createQuery(hql, User.class).getResultList();
    }
}
*/
