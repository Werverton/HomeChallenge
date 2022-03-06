package com.homechallenge.QikServe;


public class UserID {

    private String id;

    public UserID(String id) {
        this.id = id;
    }

    public String value() {
        return id;
    }

    

    @Override
    public String toString() {
        return "UserID{" +
                "id='" + id + '\'' +
                '}';
    }
}
