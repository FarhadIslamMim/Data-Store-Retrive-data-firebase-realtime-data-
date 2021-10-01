package com.example.stordataapp;

public class People {
    private String name;
    private String age;
    private String phnnumber;

    public People()
    {

    }

    public People(String naem, String age, String phnnumber) {
        this.name = naem;
        this.age = age;
        this.phnnumber = phnnumber;
    }

    public String getNaem() {
        return name;
    }

    public void setNaem(String naem) {
        this.name = naem;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhnnumber() {
        return phnnumber;
    }

    public void setPhnnumber(String phnnumber) {
        this.phnnumber = phnnumber;
    }
}

