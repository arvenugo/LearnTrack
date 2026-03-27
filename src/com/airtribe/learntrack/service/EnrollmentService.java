package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnrollmentService {

    private static List<Enrollment> enrollmentList = new ArrayList<>();

    public static void enrollStudent(int courseId, int studentId , Date enrollmentDate)
    {

        if(!validateStudent(studentId) && !validateCourse(courseId))
        {
            return;
        }
        Enrollment enrollment=new Enrollment(courseId, studentId, enrollmentDate);
        enrollmentList.add(enrollment);
        System.out.println("New enrollment added:\n"+enrollment.toString());
    }

   public static void viewAllEnrollmentsOfStudent(int studentId)
   {
       if(!validateStudent(studentId))
       {
           return;
       }


       boolean enrollFound = false;
             System.out.println("Fetching enrollments...");
             for(Enrollment iter:enrollmentList)
             {
                 if(iter.getStudentId()==studentId)
                 {
                     enrollFound = true;
                     System.out.println(iter.toString());
                     System.out.println("\n******************************************");
                 }
             }
             if(!enrollFound)
             {
                 System.out.println("No enrollments Found !!!");
             }

   }

    private static boolean validateStudent(int studentId) {
        boolean isValid = true;
        try
        {
            System.out.println("Validating student id...");
            Student stu=StudentService.getStudentFromList(studentId);
            System.out.println("Student found: "+stu.getDisplayName());
        } catch (EntityNotFoundException e) {
            isValid = false;
            System.out.println("Student with id "+ studentId +" does not exist !!!");
        }
        return isValid;
    }

    private static boolean validateCourse(int courseID) {
        boolean isValid = true;
        try
        {
            System.out.println("Validating course id...");
            Course cr=CourseService.getCourseFromList(courseID);
            System.out.println("Course found: "+cr.toString());
        } catch (EntityNotFoundException e) {
            isValid = false;
            System.out.println("Course with id "+ courseID +" does not exist !!!");
        }
        return isValid;
    }

    private static Enrollment getEnrollment(int id) throws EntityNotFoundException
   {
       Enrollment enrollment=null;
       for (Enrollment iter:enrollmentList)
       {
           if(iter.getCourseId()==id)
           {
               enrollment = iter;
               break;
           }
       }
       if(enrollment==null)
       {
           throw new EntityNotFoundException();
       }
       return enrollment;
   }

    public static void completeEnrollment(int id)
    {
        try
        {
            Enrollment enroll=getEnrollment(id);
            enroll.setEnrollmentStatus(EnrollmentStatus.COMPLETED);
            System.out.println("Enrollment details after completion \n"+enroll.toString());
        } catch (EntityNotFoundException e) {
            System.out.println("Enrollment with id "+id+" not found in records.");
        }
    }

    public static void cancelEnrollment(int id)
    {
        try
        {
            Enrollment enroll=getEnrollment(id);
            enroll.setEnrollmentStatus(EnrollmentStatus.CANCELLED);
            System.out.println("Enrollment details after cancellation \n"+enroll.toString());
        } catch (EntityNotFoundException e) {
            System.out.println("Enrollment with id "+id+" not found in records.");
        }
    }
}
