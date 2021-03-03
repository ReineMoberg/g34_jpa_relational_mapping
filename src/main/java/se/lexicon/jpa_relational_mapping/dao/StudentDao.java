package se.lexicon.jpa_relational_mapping.dao;

import se.lexicon.jpa_relational_mapping.entity.Student;

public interface StudentDao {

    Student save(Student student);

    void delete(int id);

    Student findById(int studentId);

}
