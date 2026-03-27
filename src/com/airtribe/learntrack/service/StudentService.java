package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;


import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private static List<Student> studentList = new ArrayList<>();

    public static void addStudent(String firstName, String lastName, String batch)
    {
        Student stu = new Student(firstName, lastName, batch);
        studentList.add(stu);
        System.out.println("Student added : "+"\n");
        System.out.println(stu.toString());
    }

    public static void addStudent(String firstName, String lastName,String emailId, String batch)
    {
        Student stu = new Student(firstName, lastName, emailId,batch);
        studentList.add(stu);
        System.out.println("Student added : "+"\n");
        System.out.println(stu.toString());
    }

    public static void removeStudent(int id)
    {
        try
        {
            Student stu = getStudentFromList(id);
            studentList.remove(stu);
            System.out.println("Student with id "+ id +" removed from records.");
        }
        catch(EntityNotFoundException ex)
        {
            System.out.println("Student with id "+ id +" not found in the records.");
        }

    }

    public static void viewAllStudents()
    {
        System.out.println("*********************List of Students*********************");
        for (Student stu:studentList)
        {
            System.out.println(stu.toString());
            System.out.println("**********************************************************");
        }

    }

    public static void lookUpStudent(int id)
    {
        System.out.println("Searching student with id: "+id);
        try
        {
            Student stu = getStudentFromList(id);

            System.out.println("Student with id "+ id +" found. Details below:"+"\n");
            System.out.println(stu.toString());
        }
        catch(EntityNotFoundException ex)
        {
            System.out.println("Student with id "+ id +" not found in the records.");
        }
    }

    public static void deActivateStudent(int id)
    {
        System.out.println("Searching student with id: "+id);
        try
        {
            Student stu = getStudentFromList(id);
            stu.deActivate();
            System.out.println("Student with id "+ id +" found. Student deactivated. Details below:"+"\n");
            System.out.println(stu.toString());
        }
        catch(EntityNotFoundException ex)
        {
            System.out.println("Student with id "+ id +" not found in the records.");
        }
    }

    public static Student getStudentFromList(int id) throws  EntityNotFoundException {
        Student student=null;
        for (Student stu:studentList)
        {
            if(stu.getId()==id)
            {
                student = stu;
                break;
            }
        }
        if(student==null)
        {
            throw new EntityNotFoundException();
        }
        return student;
    }
}
