package com.jtechnologies.labs5.repositories;

import com.jtechnologies.labs5.exception.StudentConflictException;
import com.jtechnologies.labs5.exception.StudentNotFoundException;
import com.jtechnologies.labs5.models.Exam;
import com.jtechnologies.labs5.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class StudentRepository implements DataRepositoryInterface<Exam,Integer> {

    @PersistenceContext(unitName = "persistence/scheduler")
    EntityManager em;


    public List<Student> getStudents() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }


    public Student getStudentById(int id) throws StudentNotFoundException {
        Student studentFromDb = em.find(Student.class,id);

        if(studentFromDb == null) {
            throw new StudentNotFoundException("Student with id " + id + "cannot be found!");
        }

        return studentFromDb;
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


    public void removeStudentById(int id) throws StudentNotFoundException{
        Student studentFromDb = em.find(Student.class,id);

        if(studentFromDb == null) {
            throw new StudentNotFoundException("Student with id " + id + "cannot be found in the database");
        }
        em.remove(studentFromDb);
    }


    public void updateStudent(int id,String name) throws StudentConflictException {

        List<Student> results = em.createNamedQuery("Student.findStudentByName",Student.class)
                .setParameter("name", name)
                .getResultList();

        for(Student result: results) {
            if(result.getName().equals(name)) {
                throw new StudentConflictException("Student with name " +
                        name + " already exists in the database");
            }
        }

        em.createNamedQuery("Student.updateStudent", Student.class)
                .setParameter("name",name)
                .setParameter("studentId",id)
                .executeUpdate();

    }

    @Override
    public Exam save(Exam obj) {
        return null;
    }

    @Override
    public Exam findById(Class<Exam> examClass, Integer integer) {
        return null;
    }

    @Override
    public void deleteById(Class<Exam> examClass, Integer integer) {

    }

    @Override
    public void delete(Exam obj) {

    }

    @Override
    public void update(Exam obj) {

    }

    @Override
    public long count() {
        return 0;
    }
}
