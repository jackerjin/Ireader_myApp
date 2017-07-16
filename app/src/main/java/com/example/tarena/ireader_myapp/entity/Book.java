package com.example.tarena.ireader_myapp.entity;

/**
 * Created by tarena on 2017/6/5.
 */

public class Book {
    private String key;
    private String name;
    private String type;
    private int skip;
    private int finish;

    public Book() {
    }

    public Book(String key, String name, String type, int skip, int finish) {
        this.key = key;
        this.name = name;
        this.type = type;
        this.skip = skip;
        this.finish = finish;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Book{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", skip=" + skip +
                ", finish=" + finish +
                '}';
    }
}
