package com.example.shiyanspring.Dao;


import com.example.shiyanspring.pojo.*;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface UserDao{
    List<User1> findAll1();
//当只有一个参数时可以不使用@Param，@Param的作用是在传递多个参数时用来在sql进行区分传给那个参数
   List<User1> findAll2(@Param("name") String name);
   public int addAll(User1 user);
    public int deleteAll(@Param("id") Integer id);
    public int updateAll(User1 user);
    List<A> findAB();
    List<E> findAB1();
  public int zhuce(User user);
    List<User> chuxun(@Param("username") String username);
    List<User> denglu(@Param("username") String username,@Param("password") String password);
    //登录用户添加到表中用来规范某个账号到数据增加
    public int addUser(User user);
    //多条数据删除
    public int deleteAllduo(@Param("id") String id);

    public void addAll1(User1 user);

    public int zhuce1(@Param("password") String password,@Param("username") String username);
    public List<User1> findall();
    public int addE(Integer id1, Integer id2);

    public int addUsers(User2 user);
    public List<User2> findallUser(String  username);

    public int addshuju(ShuJu shuju);
    public List<ShuJu> findshuju();


    String chazhao(@Param("username") String username,@Param("password") String password);
//批量添加
    public int addList(List<User1> user);

    //批量修改
    int batchUpdate(List<User1> list);//批量更新
//批量删除
    int batchDelete(List<Integer> id);
    //分页查询
    Page<User> findWithBLOBsByPage();

    //多参数验证
    public List<User1> duocanshu(@Param("id") int id,@Param("name") String name);


    //实验表添加
    public int addShiyan(Shiyan shiyan);
//实验表查询
    List<Shiyan> shiyanfind(@Param("id") int id,@Param("name") String name);

    //实验表添加
    public int addShiyanbufen(@Param("id") int id,@Param("name") String name);


    User1 findstring(Integer id);

//定时任务实验
    void adddingshi(User1 user1);

    /**
     * 动态sql测试
     */
    //新增
    int adddongtai(Dongtaisql dongtaisql);
    //更新
    int updatedongtai(Dongtaisql dongtaisql);

}
