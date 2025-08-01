
package course_service.course_service.repository;

import course_service.course_service.entities.Course;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CourseRepositoryImpl implements CourseRepositoryCustom {

    @PersistenceContext
    private EntityManager em;


    /**
     * Gets a list of all Courses
     *
     * @return courses list {@link Course}
     */
    public List<Course> getAllCourses(){
        return em.createQuery("From Course", Course.class).getResultList();
    }

    public Course getCourseById(UUID id){
        try{
            return em.createQuery("From Course where id = :id", Course.class).setParameter("id", id).getSingleResult();
        }catch (NoResultException e) {
            throw new EntityNotFoundException("Course with id = " + id + " not found");
        }
    }

    public void createCourse(Course course){
        try{
            em.persist(course);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    public void updateCourse(Course course){
        try{
            em.merge(course);
        }catch(EntityNotFoundException e){
            throw new EntityNotFoundException(e.getMessage());
        }
        catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    public void deleteCourse(UUID id){
        try{
            Course course = getCourseById(id);
            em.remove(course);
        }catch(NoResultException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    /**
     * Метод, заменяющий преподавателя на лругого в сущности {@link Course}
     *
     * @param courseId {@link Course} - идентификатор курса
     * @param teacherId {@link Course} - идентификатор нового учителя
     */
    @Override
    public void changeTeacherForCourse(UUID courseId, UUID teacherId) {
        String hql = "Update Course set teacherId = :teacherId where id = :id";
        em.createQuery(hql)
                .setParameter("teacherId", teacherId)
                .setParameter("id", courseId)
                .executeUpdate();
    }

    /**
     * Метод, убирающий учителя с курса
     *
     * @param courseId {@link Course} - идентификатор курса
     */
    @Override
    public void removeTeacherFromCourse(UUID courseId) {
        em.createQuery("Update Course set teacherId = null where id = :courseId")
                .setParameter("courseId", courseId)
                .executeUpdate();
        ;
    }
}

