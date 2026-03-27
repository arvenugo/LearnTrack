package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.util.IDGenerator;

import java.util.Date;

public class Enrollment {

    private int id;

    private int courseId;

    private int studentId;

    private Date enrollmentDate;



    private EnrollmentStatus enrollmentStatus;


    public Enrollment( int courseId, int studentId, Date enrollmentDate) {
        this.id = IDGenerator.getNextEnrollmentId();
        this.courseId = courseId;
        this.studentId = studentId;
        this.enrollmentDate = enrollmentDate;
        this.enrollmentStatus = EnrollmentStatus.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public EnrollmentStatus getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public String toString ()
    {
        StringBuilder str= new StringBuilder();
        str.append(AppConstants.ENROLL_ID_FIELD_NAME);
        str.append(id);
        str.append("\n");
        str.append(AppConstants.COURSE_ID_FIELD_NAME);
        str.append(courseId);
        str.append("\n");
        str.append(AppConstants.ID_FIELD_NAME);
        str.append(studentId);
        str.append("\n");
        str.append(AppConstants.ENROLL_DATE_FIELD_NAME);
        str.append(enrollmentDate);
        str.append("\n");
        str.append(AppConstants.ENROLL_STATUS_FIELD_NAME);
        str.append(enrollmentStatus);
        str.append("\n");
        return str.toString();

    }
}
