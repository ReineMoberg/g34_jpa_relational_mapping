package se.lexicon.jpa_relational_mapping.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_relational_mapping.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class StudentDaoImpl implements StudentDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    public Student findById(int studentId) {
        return entityManager.find(Student.class,studentId);
    }

    //... other CRUD operations
}
