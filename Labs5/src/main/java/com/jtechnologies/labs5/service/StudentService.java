package com.jtechnologies.labs5.service;

import com.jtechnologies.labs5.exception.StudentConflictException;
import com.jtechnologies.labs5.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class StudentService{

    @PersistenceContext(unitName = "persistence/scheduler")
    EntityManager em;


    public List<Student> getStudents() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }


    public Student getStudentById(int id) {
        return em.find(Student.class,id);
    }


    public void addStudent(Student student) throws StudentConflictException {

        List<Student> results = em.createNamedQuery("Student.findStudentByName",Student.class)
                .setParameter("name", student.getName())
                .getResultList();

        for(Student result: results) {
            if(result.getName().equals(student.getName())) {
                throw new StudentConflictException("Student with name " +
                        student.getName() + " already exists in the database");
            }
        }

        em.persist(student);
    }


    public void removeStudentById(int id) {
        Student studentFromDb = em.find(Student.class,id);

        if(studentFromDb == null) {
            return;
        }
        em.remove(studentFromDb);
    }

    public void getStudentExams(int id) {

    }

    public int updateStudent(int id,String name) {
        Student studentFromDb = em.find(Student.class, id);

        if(studentFromDb == null) {
            return -1;
        }

        em.createNamedQuery("Student.updateStudent", Student.class)
                .setParameter("name",name)
                .setParameter("studentId",id)
                .executeUpdate();

        return 0;
    }
}
