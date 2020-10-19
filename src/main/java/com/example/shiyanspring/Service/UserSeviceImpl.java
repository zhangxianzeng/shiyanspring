package com.example.shiyanspring.Service;


import com.example.shiyanspring.Dao.UserDao;
import com.example.shiyanspring.contrller.BaseContrller;
import com.example.shiyanspring.pojo.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.nio.cs.US_ASCII;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserSeviceImpl extends BaseContrller implements UserService {
@Autowired
private UserDao userDao;
    @Override
    public List<User1> findName() {
        return userDao.findAll1();
    }

    @Override
    public List<User1> findName1(String name) {
        return userDao.findAll2(name);
    }

    @Override
    public int addAll(User1 user) {

        return userDao.addAll(user);
    }

    @Override
    public int deleteAll(Integer id) {
        return userDao.deleteAll(id);
    }

    @Override
    public int updateAll(User1 user) {
        return userDao.updateAll(user);
    }

    @Override
    public List<A> findAB() {
        return userDao.findAB();
    }

    @Override
    public List<E> findAB1() {
        List<E> result = userDao.findAB1();
        return result;
    }

    @Override
    public Result zhuce(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            if(user.getUsername()!=null && user.getPassword()!=null&&user.getUsername()!=""&&user.getPassword()!="") {
                List<User> existUser = userDao.chuxun(user.getUsername());
                if (existUser.isEmpty()) {
                    String pwd=	MD5Util.string2MD5(user.getPassword());
                    user.setPassword(pwd);
                    userDao.zhuce(user);
                    //System.out.println(user.getId());
                    result.setMsg("注册成功");
                    result.setSuccess(true);
                    result.setDetail(user);


                } else {

                    //如果用户名已存在
                    result.setMsg("用户名已存在");
                }
            }else{
                result.setMsg("用户名或密码不能为空");
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();

        }
        return result;
    }

    @Override
    public List<User> chuxun(String username) {
        return userDao.chuxun(username);
    }

    @Override
    public Result denglu(User user, HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {


            if(user.getUsername()!=null&&user.getPassword()!=null&&user.getUsername()!=""&&user.getPassword()!="") {
                String pwd = MD5Util.string2MD5(user.getPassword());

                user.setPassword(pwd);
                List<User> user1 = userDao.denglu(user.getUsername(), user.getPassword());
                if (user1.isEmpty()) {
                    result.setMsg("用户名或密码错误");
                } else {
                    User user2 = new User();
                    user2.setUsername(user.getUsername());
                    user2.setPassword(user.getPassword());
                    //将登录信息存储到session中，BaseContrller类就是存储session的工具类
                    setUser(user2);
                    result.setMsg("登录成功");
                    result.setSuccess(true);
                    //将登录信息存储到cookie中,CookieUtils就是存储cookie和查询cookie的工具类
                    CookieUtils.setCookie(request, response, "JT_TICKET", user2.getUsername());
                    System.out.println(user.getUsername());
                    result.setDetail(user2);
                }
            }else{
                result.setMsg("用户名或密码不能为空");
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    //新增
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }
//多选删除
    @Override
    public int deleteAllduo(String id) {
        return userDao.deleteAllduo(id);
    }

    @Override
    public void addAll1(User1 user) {
userDao.addAll1(user);
    }

    @Override
    public List<User1> findall() {
        return userDao.findall();
    }

    @Override
    public int addE(Integer id1, Integer id2) {
        return userDao.addE(id1,id2);
    }

    @Override
    public int addUsers(User2 user) {
        return userDao.addUsers(user);
    }

    @Override
    public List<User2> findallUser(String username) {
        return userDao.findallUser(username);
    }

    @Override
    public int addshuju(ShuJu shuju) {
        return userDao.addshuju(shuju);
    }

    @Override
    public List<ShuJu> findshuju() {
        return userDao.findshuju();
    }

    @Override
    public Result chazhao(User user) {
        Result result=new Result();
        result.setMsg("茶灶");
        result.setSuccess(true);
        result.setDetail(userDao.chazhao(user.getUsername(),user.getPassword()));
        return result;
    }

    @Override
    public String KKK(String name) {
        return name+"pppp";
    }

    @Override
    public Page<User> findWithBLOBsByPage(Integer pageNum, Integer pageSize) {
        //PageHelper.startPage(pageNum,pageSize);
        return userDao.findWithBLOBsByPage();
    }

    @Override
    public int addList(List<User1> user) {

        return userDao.addList(user);
    }
//批量修改
@Override
public int batchUpdate(List<User1> list) {
    return userDao.batchUpdate(list);
}

//批量删除
    @Override
    public int batchDelete(List<Integer> id) {
        return userDao.batchDelete(id);
    }


    //多参数传递
    @Override
    public List<User1> duocanshu(int id, String name) {
        return userDao.duocanshu(id,name);
    }

    @Override
    public int addShiyan(Shiyan shiyan) {
        return userDao.addShiyan(shiyan);
    }

    @Override
    public List<Shiyan> shiyanfind(int id, String name) {
        return userDao.shiyanfind(id,name);
    }

    @Override
    public int addShiyanbufen(int id, String name) {
        return userDao.addShiyanbufen(id,name);
    }

    @Override
    public User1 findstring(Integer id) {
        return userDao.findstring(id);
    }
    //定时任务实验
    @Override
    public void adddingshi(User1 user1) {
      userDao.adddingshi(user1);
    }

    @Override
    public int adddongtai(Dongtaisql dongtaisql) {
        return userDao.adddongtai(dongtaisql);
    }

    @Override
    public int updatedongtai(Dongtaisql dongtaisql) {
        return userDao.updatedongtai(dongtaisql);
    }

//    @Override
//    public Result zhuce1(String username, String password) {
//        Result result = new Result();
//        result.setSuccess(false);
//        result.setDetail(null);
//        try {
//
//                List<User> existUser = userDao.chuxun(username);
//                if (existUser.isEmpty()) {
//                     password=	MD5Util.string2MD5(password);
//
//                    userDao.zhuce1(username,password);
//                    //System.out.println(user.getId());
//                    User user=new User();
//                    user.setUsername(username);
//                    user.setPassword(password);
//                    result.setMsg("注册成功");
//                    result.setSuccess(true);
//                    result.setDetail(user);
//
//
//                } else {
//
//                    //如果用户名已存在
//                    result.setMsg("用户名已存在");
//                }
//
//        } catch (Exception e) {
//            result.setMsg(e.getMessage());
//            e.printStackTrace();
//        }
//        return result;
//    }
}
