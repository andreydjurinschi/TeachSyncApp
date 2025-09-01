package teachsync.demo.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import org.springframework.stereotype.Repository;
import teachsync.demo.exceptions.CreateUpdateEntityException;
import teachsync.demo.entities.User;
import teachsync.demo.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public List<User> getUsers() {
        String hql = "From User";
        return em.createQuery(hql, User.class).getResultList();
    }

    public User getUser(UUID id) throws NotFoundException {
        try{
            String hql = "From User u where u.id = :id";
            return em.createQuery(hql, User.class).setParameter("id", id).getSingleResult();
        }catch(NoResultException e){
            throw new NotFoundException("Entity not found");
        }
    }


    public void createUser(User user) {
        try{
            em.persist(user);
        }catch(PersistenceException e){
            throw new CreateUpdateEntityException(e.getMessage());
        }
    }


    public void updateUser(User user) {
        try{
            em.merge(user);
        }catch(PersistenceException e){
            throw new CreateUpdateEntityException(e.getMessage());
        }
    }


    public void deleteUser(UUID id) throws NotFoundException {
        try{
            User user = getUser(id);
            em.remove(user);
        }catch(NoResultException e){
            throw new NotFoundException("User not found");
        }
    }

}
