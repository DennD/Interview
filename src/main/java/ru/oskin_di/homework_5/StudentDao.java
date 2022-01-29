package ru.oskin_di.homework_5;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student);

    void removeStudent(Student student);

    void createMarkStudent(Student student, int mark);

    Student getStudentById(int id);

    List<Student> getAllStudents();

}
