package ru.oskin_di.homework_5;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        FlywayMigration.start();
        StudentDao studentDao = new StudentDaoImpl(ConfigurationHibernate.getSessionFactory());

        /** Добавляем в список имён имена из файла*/
        List<String> names = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(Objects.requireNonNull(Main.class.getResource("/names.txt")).toURI())));
        String line = reader.readLine();
        while (line != null) {
            names.add(line);
            line = reader.readLine();
        }


        /** Генератор 1000 случайных студентов*/
        for (int i = 0; i < 1000; i++) {
            Student student = new Student();
            student.setName(names.get((int) (Math.random() * (names.size()))));
            student.setMark((int) (Math.random() * 5 + 1));
            studentDao.addStudent(student);
        }

        /** Пример работы с БД*/
        System.out.println(studentDao.getAllStudents());

        Student student = studentDao.getStudentById(50);
        System.out.println(student);

        studentDao.createMarkStudent(student,5);

        System.out.println(studentDao.getStudentById(50));

        studentDao.removeStudent(student);

        System.out.println(studentDao.getAllStudents());
        System.out.println(studentDao.getStudentById(50));

    }
}
