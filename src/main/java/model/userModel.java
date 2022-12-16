package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class userModel {
    public String ID;
    public String Name;
    public String Gender;
    public int Age;

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getGender() {
        return Gender;
    }

    public int getAge() {
        return Age;
    }
}
