//package com.example.shiyanspring;
//
//import com.example.shiyanspring.Service.UserService;
//import com.example.shiyanspring.pojo.User1;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ssss {
//@Autowired
//private UserService userService;
//    @Test
//    public void testBatchUpdate(){
//        List<User1> list = new ArrayList();
//
//        User1 userInfo1 = new User1();
//        userInfo1.setName("Liang4");
//        userInfo1.setId(101);
//
//        list.add(userInfo1);
//
//        User1 userInfo2 = new User1();
//        userInfo2.setName("Liang5");
////        userInfo2.setAge(30);
//        userInfo2.setId(100);
//
//        list.add(userInfo2);
//
//        int a = userService.batchUpdate(list);
//        // 查看返回值
//        System.out.println("a: "+ a );
//    }//批量更新成功，注意application.yml数据库设置要加上&allowMultiQueries=true
//}
