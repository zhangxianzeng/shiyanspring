package com.example.shiyanspring.pojo;

import java.util.List;

public class E {
    private int a_id;
    private int p_id;
    //根据List查询出该类的数据,那个里面有list那个就作为mapper中的<resultMap type
    private C c;
    private D d;

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }
}

