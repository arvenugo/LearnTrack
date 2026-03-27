package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;


import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private static  List<Course> courseList = new ArrayList<>();

    public static void addCourse(int duration ,String name , String desc)
    {
        Course course = new Course(duration,desc,name);
        courseList.add(course);
        System.out.println("Course added. Details below:\n");
        System.out.println(course.toString());
    }

    public static void listAllCourses()
    {
        System.out.println("*********************List of Courses*********************");
        for (Course course:courseList)
        {
            System.out.println(course.toString());
            System.out.println("**********************************************************");
        }
    }

    public static void activeOrDeactivateCourse(int id, boolean activate)
    {
        try
        {
            Course course=getCourseFromList(id);
            course.setActive(activate);
            System.out.println("Course details after activation or deactivation \n"+course.toString());
        } catch (EntityNotFoundException e) {
            System.out.println("Course with id "+id+" not found in records.");
        }
    }

    public static Course getCourseFromList(int id) throws EntityNotFoundException
    {
        Course course=null;
        for (Course iter:courseList)
        {
            if(iter.getCourseId()==id)
            {
                course = iter;
                break;
            }
        }
        if(course==null)
        {
            throw new EntityNotFoundException();
        }
        return course;
    }
}
