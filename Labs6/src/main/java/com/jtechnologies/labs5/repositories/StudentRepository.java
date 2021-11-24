package com.jtechnologies.labs5.repositories;

import com.jtechnologies.labs5.exception.StudentConflictException;
import com.jtechnologies.labs5.exception.StudentNotFoundException;
import com.jtechnologies.labs5.models.Student;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudentRepository implements DataRepositoryInterface<Student,Integer> {

    @PersistenceContext(unitName = "persistence/scheduler")
    EntityManager em;


    public List<Student> getStudents() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
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
    public Student save(Student student) throws StudentConflictException {
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
        return student;
    }

    @Override
    public Student findById(Integer id) throws StudentNotFoundException {
        Student studentFromDb = em.find(Student.class,id);

        if(studentFromDb == null) {
            throw new StudentNotFoundException("Student with id " + id + "cannot be found in the database");
        }
        return studentFromDb;
    }

    @Override
    public void deleteById(Integer id) throws StudentNotFoundException {
        Student studentFromDb = em.find(Student.class,id);

        if(studentFromDb == null) {
            throw new StudentNotFoundException("Student with id " + id + "cannot be found in the database");
        }
        em.remove(studentFromDb);
    }

    @Override
    public void delete(Student student) throws StudentNotFoundException {
        Student studentFromDb = em.find(Student.class,student.getId());

        if(studentFromDb == null) {
            throw new StudentNotFoundException("Student with id " + student.getId() + "cannot be found in the database");
        }
        em.remove(studentFromDb);
    }


    @Override
    public long count() {
        return 0;
    }
}
