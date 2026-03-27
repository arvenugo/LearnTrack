package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.util.IDGenerator;

public class Course {

    private int courseId;

    private String courseName;

    private String description;

    private int durationInWeeks;

    private boolean active = false;

    public Course( int durationInWeeks, String description, String courseName) {
        this.courseId = IDGenerator.getNextCourseId();
        this.active = true;
        this.durationInWeeks = durationInWeeks;
        this.description = description;
        this.courseName = courseName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public boolean isActive() {
        return active;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

   public String toString()
   {
       StringBuilder str= new StringBuilder();
       str.append(AppConstants.COURSE_FIELD_NAME);
       str.append(courseName);
       str.append("\n");
       str.append(AppConstants.COURSE_ID_FIELD_NAME);
       str.append(courseId);
       str.append("\n");
       str.append(AppConstants.COURSE_DESC_FIELD_NAME);
       str.append(description);
       str.append("\n");
       str.append(AppConstants.DURATION_FIELD_NAME);
       str.append(durationInWeeks);
       str.append("\n");
       str.append(AppConstants.ACTIVE_FIELD_NAME);
       str.append(active);
       str.append("\n");
       return str.toString();
   }
}
