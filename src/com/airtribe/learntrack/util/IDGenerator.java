package com.airtribe.learntrack.util;

public class IDGenerator {

    private static int studentIdCounter =1;

    private static int courseIdCounter =1;

    private static int enrollmentIdCounter =1;

    static public int getNextStudentId()
    {

        if(studentIdCounter ==Integer.MAX_VALUE)
        {
            studentIdCounter =0;
        }
        return studentIdCounter++;

    }

    static public int getNextCourseId()
    {

        if(courseIdCounter ==Integer.MAX_VALUE)
        {
            courseIdCounter =0;
        }
        return courseIdCounter++;

    }

    static public int getNextEnrollmentId()
    {

        if(enrollmentIdCounter ==Integer.MAX_VALUE)
        {
            enrollmentIdCounter =0;
        }
        return enrollmentIdCounter++;

    }
}
