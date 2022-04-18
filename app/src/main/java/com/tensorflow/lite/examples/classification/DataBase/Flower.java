package com.tensorflow.lite.examples.classification.DataBase;

public class Flower {
    private String hobby;
    private String type;
    int id;

    public Flower() {
    }

    public Flower(String hobby, String type) {
        this.hobby = hobby;
        this.type = type;
    }

    public Flower(String hobby, String type, int id) {
        this.hobby = hobby;
        this.type = type;
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
