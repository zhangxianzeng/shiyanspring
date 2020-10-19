package com.example.shiyanspring.Service;

import com.example.shiyanspring.Dao.HutoolDao;
import com.example.shiyanspring.pojo.Hutool;
import com.example.shiyanspring.pojo.JemteTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HutoolServiceImpl implements HutoolService{
    @Autowired
    HutoolDao hutoolDao;
    @Override
    public List<Hutool> findlist() {
        return hutoolDao.findlist();
    }

    @Override
    public int addall(JemteTest jemteTest) {
        return hutoolDao.addall(jemteTest);
    }
}
