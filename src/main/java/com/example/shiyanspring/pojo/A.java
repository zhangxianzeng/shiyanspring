package com.example.shiyanspring.pojo;

import java.util.List;

public class A {
    private String name;
    private  String sex;
    private List<B> b;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<B> getB() {
        return b;
    }

    public void setB(List<B> b) {
        this.b = b;
    }
}
