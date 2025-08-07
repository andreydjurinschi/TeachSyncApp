package course_service.course_service.repository.topicRepository;

import course_service.course_service.entities.Topic;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TopicRepositoryImpl implements TopicRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Gets all topics created in system
     *
     * @return List of {@link Topic}
     */
    public List<Topic> findAll(){
        return entityManager.createQuery("From Topic", Topic.class).getResultList();
    }

    public Topic getTopic(UUID topicId){
        try{
            return entityManager.createQuery("From Topic where id = :id", Topic.class).setParameter("id", topicId).getSingleResult();
        }catch (NoResultException e){
            throw new EntityNotFoundException("Тема не была найдена");
        }

    }
}
