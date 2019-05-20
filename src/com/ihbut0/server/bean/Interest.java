package com.ihbut0.server.bean;


public class Interest {

    private String intentID;
    private String intentName;

    public Interest(String intentID, String intentName){
        this.intentID = intentID;
        this.intentName = intentName;
    }

    public String getIntentID() {
        return intentID;
    }

    public void setIntentID(String intentID) {
        this.intentID = intentID;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }
}
