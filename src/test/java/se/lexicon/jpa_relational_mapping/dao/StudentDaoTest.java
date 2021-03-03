package se.lexicon.jpa_relational_mapping.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_relational_mapping.entity.Address;
import se.lexicon.jpa_relational_mapping.entity.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class StudentDaoTest {
    @Autowired // field dependency injection
    StudentDao testObject;


    @BeforeEach
    public void setup(){

    }

    @Test
    @DisplayName("Test1 : Save Student")
    public void test1(){
        // todo: implement unit test for student + address
        Address mainAddress= new Address();
        mainAddress.setProvince("Kronoberg");
        mainAddress.setCity("Vaxjo");
        mainAddress.setStreet("Teleborg");
        mainAddress.setZipCode("35252");

        Student student= new Student();
        student.setFirstName("Mehrdad");
        student.setLastName("Javan");
        student.setEmail("mehrdad.javan@lexicon.se");
        student.setBirthDate(LocalDate.parse("1989-02-27"));
        student.setRegisterDate(LocalDateTime.now());
        student.setAddress(mainAddress);

        Student createdStudent = testObject.save(student);
        Assertions.assertEquals(1,createdStudent.getId());
        Assertions.assertEquals("mehrdad.javan@lexicon.se",createdStudent.getEmail());

    }

    @Test
    @DisplayName("Test2: save, delete, fineById")
    public void test2(){
        test1();
        System.out.println("-------------------");
        testObject.delete(1);
        Assertions.assertNull(testObject.findById(1));
    }


}
