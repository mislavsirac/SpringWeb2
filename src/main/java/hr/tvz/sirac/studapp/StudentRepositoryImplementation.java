package hr.tvz.sirac.studapp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImplementation implements StudentRepository{
    private List<Student> students = new ArrayList<>();
    Date date = new Date(2000-12-12);
    public StudentRepositoryImplementation() {
        students.add(new Student("Mislav", "Sirac" , date, "123133", 151) );
        students.add(new Student("Zdenko", "Sirac" , date, "123131", 131) );
    }

    @Override
    public void delete(Optional<Student> studentOptional) {
        studentOptional.ifPresent(student -> students.remove(student));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        return students.stream()
                .filter(student -> student.getJMBAG().equals(JMBAG))
                .findFirst();
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }


}
