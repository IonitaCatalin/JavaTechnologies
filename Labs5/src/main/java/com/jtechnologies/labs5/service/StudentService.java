package com.jtechnologies.labs5.service;

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


    public void addStudent(Student student) {
        em.persist(student);
    }


    public int removeStudentById(int id) {
        Student studentFromDb = em.find(Student.class,id);

        if(studentFromDb == null) {
            return -1;
        }
        em.remove(studentFromDb);
        return 0;
    }

    public void getStudentExams(int id) {

    }

    public int updateStudent(int id,String fullName) {
        Student studentFromDb = em.find(Student.class, id);

        if(studentFromDb == null) {
            return -1;
        }

        em.createNamedQuery("Student.updateStudent", Student.class)
                .setParameter("fullName",fullName)
                .setParameter("studentId",id)
                .executeUpdate();

        return 0;
    }
}
