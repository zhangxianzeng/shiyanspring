package com.example.shiyanspring.Service;


import com.example.shiyanspring.pojo.*;
import com.github.pagehelper.Page;
import org.springframework.data.repository.query.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {
     List<User1> findName();
     List<User1> findName1(String name);
     int addAll(User1 user);
     int deleteAll(Integer id);
     int updateAll(User1 user);
      List<A> findAB();
     List<E> findAB1();
     Result zhuce(User user);
     List<User> chuxun(String username);
     Result denglu(User user, HttpServletRequest request, HttpServletResponse response);
     public int addUser(User user);
     //多选删除
     public int deleteAllduo(String id);

     public void addAll1(User1 user);

     public List<User1> findall();

    // Result zhuce1(String username,String password);
    public int addE(Integer id1, Integer id2);
     public int addUsers(User2 user);
    public List<User2> findallUser(String  username);
    public int addshuju(ShuJu shuju);
    public List<ShuJu> findshuju();

    Result chazhao(User user);

    String KKK(String name);

    //分页
    public Page<User> findWithBLOBsByPage(Integer pageNum, Integer pageSize);

//批量新增
    public int addList(List<User1> user);
//批量修改
int batchUpdate(List<User1> list);//批量更新

    //批量删除
    int batchDelete(List<Integer> id);


    //多参数传输
    public List<User1> duocanshu(int id, String name);


    //实验表添加
    public int addShiyan(Shiyan shiyan);

    List<Shiyan> shiyanfind(int id,String name);
    //部分增加
    public int addShiyanbufen(int id,String name);


    User1 findstring(Integer id);
    //定时任务实验
    void adddingshi(User1 user1);
    /**
     * 动态sql
     */
    //新增
    int adddongtai(Dongtaisql dongtaisql);
//更新
    int updatedongtai(Dongtaisql dongtaisql);
}
