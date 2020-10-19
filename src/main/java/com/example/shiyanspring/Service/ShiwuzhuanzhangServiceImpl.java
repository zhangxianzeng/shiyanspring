package com.example.shiyanspring.Service;

import com.example.shiyanspring.Dao.ShiwuzhuanzhuangDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShiwuzhuanzhangServiceImpl implements ShiwuzhuanzhangService{
    @Autowired
    ShiwuzhuanzhuangDao shiwuzhuanzhuangDao;
    @Transactional(value="transactionManager",propagation= Propagation.REQUIRED)
    @Override
    public void trade3(String outer, String inner, Integer money) {
   shiwuzhuanzhuangDao.out(outer,money);
  // int i=1/0;
   shiwuzhuanzhuangDao.in(inner,money);
    }
}
