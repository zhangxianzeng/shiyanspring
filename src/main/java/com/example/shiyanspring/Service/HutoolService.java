package com.example.shiyanspring.Service;

import com.example.shiyanspring.pojo.Hutool;
import com.example.shiyanspring.pojo.JemteTest;

import java.util.List;

public interface HutoolService {
    List<Hutool> findlist();
    int addall(JemteTest jemteTest);
}
