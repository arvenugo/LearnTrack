package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.CommonConstants;


public class Person {

    private String firstName;

    private String lastName;

    private String emailId;

    private  int id;

    /**
     * Constr.
     * Currently constr is protected , as there is no rqt to be able to create a person object directly
     * @param firstName
     * @param lastName
     */
    protected Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId= AppConstants.FIELD_NOT_SET;
    }

    /**
     * Constr.
     * Currently constr is protected , as there is no rqt to be able to create a person object directly
     * @param firstName
     * @param lastName
     * @param emailId
     */
    protected Person(String firstName, String lastName,String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }


    public int getId() {
        return id;
    }

    public String getDisplayName()
    {
        return firstName+ CommonConstants.SPACE+lastName;
    }

    protected void setId(int id) {
        this.id = id;
    }
}
