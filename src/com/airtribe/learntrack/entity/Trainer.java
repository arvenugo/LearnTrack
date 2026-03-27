package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.CommonConstants;

public class Trainer extends Person{


    public Trainer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Trainer(String firstName, String lastName, String emailId) {
        super(firstName, lastName, emailId);
    }

    public String getDisplayName()
    {
        return AppConstants.TRAINER+ CommonConstants.COLON+super.getDisplayName();
    }
}
