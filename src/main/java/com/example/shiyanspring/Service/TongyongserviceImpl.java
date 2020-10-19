package com.example.shiyanspring.Service;

import com.example.shiyanspring.Dao.Tongyongmapper;
import com.example.shiyanspring.pojo.Usertongyong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TongyongserviceImpl implements Tongyongservice{
@Autowired
    Tongyongmapper tongyongmapper;
    @Override
    public List<Usertongyong> findall() {
        return tongyongmapper.selectAll();
    }
}
