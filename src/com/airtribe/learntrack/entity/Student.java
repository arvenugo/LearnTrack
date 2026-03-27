package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.CommonConstants;
import com.airtribe.learntrack.util.IDGenerator;

public class Student extends Person{

    private String batch;

    private Boolean active ;

    public Student(String firstName, String lastName, String batch)
    {
        super(firstName, lastName);
        setId(IDGenerator.getNextStudentId());
        this.batch = batch;
        this.active = true;
    }

    public Student(String firstName, String lastName,String emailId, String batch)
    {
        super(firstName, lastName,emailId);
        setId(IDGenerator.getNextStudentId());
        this.batch = batch;
        this.active = true;
    }




    public String getBatch() {
        return batch;
    }

    public Boolean isActive() {
        return active;
    }

    public String getDisplayName()
    {
        return AppConstants.STUDENT+CommonConstants.COLON+super.getDisplayName();
    }

    public void deActivate()
    {
        this.active = false;
    }

   public String toString()
   {
       StringBuilder str= new StringBuilder();
       str.append(AppConstants.NAME_FIELD_NAME);
       str.append(super.getDisplayName());
       str.append("\n");
       str.append(AppConstants.ID_FIELD_NAME);
       str.append(getId());
       str.append("\n");
       str.append(AppConstants.BATCH_FIELD_NAME);
       str.append(batch);
       str.append("\n");
       str.append(AppConstants.EMAILID_FIELD_NAME);
       str.append(getEmailId());
       str.append("\n");
       str.append(AppConstants.ACTIVE_FIELD_NAME);
       str.append(active);
       str.append("\n");
       return str.toString();
   }
}
