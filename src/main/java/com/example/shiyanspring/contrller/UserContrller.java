package com.example.shiyanspring.contrller;


import com.example.shiyanspring.Service.UserService;

import com.example.shiyanspring.common.util.PageInfo;
import com.example.shiyanspring.pojo.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

//swagger访问地址ip+端口/swagger-ui.html
@RestController
//swagger框架整体
@Api(value = "/",description = "这是所有的接口文档")
@RequestMapping("/n")
public class UserContrller extends BaseContrller{
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/name",method = RequestMethod.GET)
    @ApiOperation(value="这是返回字符串的get方法",httpMethod = "GET")
    public List<User1> findName(){
        return  userService.findName();
    }
    @RequestMapping(value = "/name1",method = RequestMethod.POST)
    @ApiOperation(value="已name为条件查询出所有符合的数据",httpMethod = "POST")

    //加@RequestBody注解的单参数形式
//    public List<User1> findName1(@RequestBody Map<String,String> data1){
//        return  userService.findName1(data1.get("name"));
//    }
    //不加@RequestBody注解的单参数形式
    public List<User1> findName1(String name){
        return  userService.findName1(name);
    }
    @RequestMapping(value = "/add",method =RequestMethod.POST)
    @ApiOperation(value="新增数据到数据库",httpMethod = "POST")
    public String findName2(@RequestBody  User1 user){
       int a= userService.addAll(user);
        return  "新增了"+a+"数据";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value="根据id删除数据",httpMethod = "POST")
    public String deleteName2(Integer id){
        int a= userService.deleteAll(id);
        return  "删除了"+a+"数据";
    }
    @RequestMapping(value = "/update",method =RequestMethod.POST)
    @ApiOperation(value="更改数据",httpMethod = "POST")
    public  String updateAll(User1 user){
        int a=userService.updateAll(user);
        if(a>=1){
            return "修改成功";
        }
        return "修改失败";
    }
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ApiOperation(value="多表联查查询所有数据",httpMethod = "GET")
    public List<A> findAB(){

        return  userService.findAB();
    }
    @RequestMapping(value = "/select1",method = RequestMethod.GET)
    @ApiOperation(value="多表联查查询所有数据1",httpMethod = "GET")
    public List<E> findAB1(){

        return  userService.findAB1();
    }
    @RequestMapping(value = "zhuce",method = RequestMethod.POST)
    @ApiOperation(value="注册用户数据",httpMethod = "POST")
    public Result regist(User user){

        return userService.zhuce(user);
    }

//    @CheckParams({
//
//            @CheckParam(argName = "username",msg = "参数名称username有问题"),
//            @CheckParam(argName = "password",msg = "参数名称password有问题"),
//            @CheckParam(value = Check.NotEmpty, argName = "username", msg = "用户名不能为空"),
//            @CheckParam(value = Check.NotNull, argName = "username", msg = "用户名不能为空"),
//            @CheckParam(value = Check.NotEmpty, argName = "password", msg = "密码不能为空"),
//            @CheckParam(value = Check.NotNull, argName = "password", msg = "密码不能为空")
//    })
//    @RequestMapping(value = "zhuce1",method = RequestMethod.POST)
//    @ApiOperation(value="注册用户数据1",httpMethod = "POST")
//    public Result regist1(String username,String password){
//
//        return userService.zhuce1(username,password);
//    }
    //根据当前登录的信息进行查询
    @RequestMapping(value = "chaxun",method = RequestMethod.POST)
    @ApiOperation(value="根据当前登录的信息进行查询登录后数据存入到session",httpMethod = "POST")
    public Result chaxun(){
        String username=getUser().getUsername();
        Result result=new Result();
        result.setMsg("查询成功");
        result.setSuccess(true);
        result.setDetail(userService.chuxun(username));
        return result;
    }
    @RequestMapping(value = "denglu",method = RequestMethod.POST)
    //这是swagger管理的接口
    @ApiOperation(value="这是登录接口",httpMethod = "POST")
    //登录接口在service层将登录信息存入到session，这样就可以利用session中到登录信息得到登录用户的数据
    public Result login(User user,HttpServletRequest request, HttpServletResponse response){
//        String pwd=	MD5Util.string2MD5(user.getPassword());
//
//        user.setPassword(pwd);

        return userService.denglu(user,request,response);
    }
    @RequestMapping("test")
    @ApiOperation(value="判断是否存在cookie",httpMethod = "GET")
    public String test(HttpServletRequest request, HttpServletResponse response){
        String cookieName="custom_global_session_id";
       // String encodeString="UTF-8";
        String cookieValue=CookieUtils.getCookieValue(request,cookieName);
        if(null==cookieValue || "".equals(cookieValue.trim())){
            System.out.println("无cookie，生产新的cookie");
         String   cookieValue1="ddddd";
            CookieUtils.setCookie(request,response,cookieName,cookieValue1);
        }

        return CookieUtils.getCookieValue(request,"custom_global_session_id");
    }

    //获取当前用户
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ApiOperation(value="获取session中的当前用户的信息",httpMethod = "GET")
    public String getUser1() {
return getUser().getUsername();
    }

    //新增某个商品信息到登录账号中
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value="新增某个商品信息到登录账号中",httpMethod = "POST")
    public String addUser(String password){
        User user=new User();
        user.setUsername(getUser().getUsername());
        user.setPassword(password);
        int a=userService.addUser(user);
        if(a>=1){

            return "新增成功";
        }else {
return "新增失败";
        }

    }
    //退出登录删除session
    @RequestMapping(value = "/longout",method = RequestMethod.GET)
    @ApiOperation(value="退出登录",httpMethod = "GET")
    public String longout(HttpSession session){
        session.invalidate();    // 获取session信息，使session信息失效，直接返回登录界面，并连接跳转。
        return "退出成功请重新登录";

    }
    //登录时将登录信息存入到cookie，这样就可以得到cookie
    @RequestMapping(value = "/cookie",method = RequestMethod.GET)
    @ApiOperation(value = "得到cookie中存入到信息",httpMethod = "GET")
    public String getCookie(HttpServletRequest request,HttpServletResponse response){
        return CookieUtils.getCookieValue(request,"JT_TICKET");
    }
//多选删除
    @RequestMapping(value = "/duodelete",method = RequestMethod.POST)
    @ApiOperation(value = "多选删除数据",httpMethod = "POST")
    public Result deleteduo(String id){
        Result result=new Result();
        if(id !=null && id.length() != 0){
            String[] list=id.split(",");
            for(int i=0;i<list.length;i++){
                userService.deleteAllduo(list[i]);
            }
            result.setSuccess(true);
            result.setMsg("成功");

        }
        else{
result.setSuccess(false);
result.setMsg("失败");
        }
        return result;
    }
@RequestMapping(value = "/addAll1",method = RequestMethod.POST)
@ApiOperation(value = "无return",httpMethod = "POST")
    public void addAll1(User1 user){
        userService.addAll1(user);
    }

    @RequestMapping( value= "/findall",method = RequestMethod.GET)
    @ApiOperation(value = "返回数据到result",httpMethod = "GET")
    public Result findall(){
        Result result =new Result();
        result.setSuccess(true);
        result.setDetail(userService.findall());
        return result;
    }

    @RequestMapping(value="/idu",method = RequestMethod.POST)
    @ApiOperation(value = "id12",httpMethod = "POST")
    public int addE(Integer id1,Integer id2){
      return userService.addE(id1,id2);
    }
    @RequestMapping(value="/addusers",method = RequestMethod.POST)
    @ApiOperation(value = "新增用户信息并且返回用户姓名",httpMethod = "POST")
    public Result addUsers(User2 user){
        int a=userService.addUsers(user);
        Result result =new Result();
        if(a>=1){
            result.setMsg("新增成功");
            result.setSuccess(true);
            result.setDetail(user);
            return result;
        }else {
            result.setMsg("新增失败");
            result.setSuccess(false);
           return result;

        }
    }

    @RequestMapping(value="/findalluser",method = RequestMethod.POST)
    @ApiOperation(value = "利用addusers新增到username进行查询",httpMethod = "POST")
    public Result addUsers(String username){
        List<User2> usernamefind=userService.findallUser(username);
        Result result =new Result();
        result.setMsg("查询成功");
        result.setSuccess(true);
        result.setDetail(usernamefind);
        return result;
    }

    @RequestMapping(value="/addshuju",method = RequestMethod.POST)
    @ApiOperation(value = "新增数据表数据",httpMethod = "POST")
    public Result addshuju(ShuJu shuju){
        int a=userService.addshuju(shuju);
        Result result =new Result();
        if(a>=1){
            result.setMsg("新增成功");
            result.setSuccess(true);
            result.setDetail(shuju);
            return result;
        }else {
            result.setMsg("新增失败");
            result.setSuccess(false);
            return result;

        }
    }
    @RequestMapping(value="/findshuju",method = RequestMethod.POST)
    @ApiOperation(value = "根据刚刚新增到数据id查询出整个新增数据",httpMethod = "POST")
    public Result findshuju(){
        Result result=new Result();
        result.setMsg("查询成功");
        result.setSuccess(true);
        result.setDetail(userService.findshuju());
        return result;
    }


    @RequestMapping(value="/chazhao",method = RequestMethod.POST)
    @ApiOperation(value = "chazao",httpMethod = "POST")
    public Result chazhao(User user){
        return userService.chazhao(user);
    }


    //分页查询
    @RequestMapping(value="/fenye",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询",httpMethod = "POST")
    //初始化默认是第一页每页十条
    public PageInfo<User> findWithBLOBsByPage(@RequestParam(defaultValue = "1",value = "currentPage") Integer pageNum,
                                              @RequestParam(defaultValue = "10",value = "pageSize") Integer pageSize) {
        //规定页码和每页显示的数量
        PageHelper.startPage(pageNum,pageSize);
        Page<User> users = userService.findWithBLOBsByPage(pageNum, pageSize);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @RequestMapping(value="/shi",method = RequestMethod.POST)
    @ApiOperation(value = "验证",httpMethod = "POST")
    public String KKK(String name){
        return userService.KKK(name);
    }


    @RequestMapping(value="/piliangadd",method = RequestMethod.POST)
    @ApiOperation(value = "批量插入",httpMethod = "POST")
    //只要是前端输入的条件是以raw形式输入的那么就要用@RequestBody注解
    public Result addList(@RequestBody List<User1> user){
        Result result=new Result();
        int a=userService.addList(user);
        if(a>=1){
            result.setMsg("插入成功");
        }
        return result;
    }

    @RequestMapping(value="/piliangupdate",method = RequestMethod.POST)
    @ApiOperation(value = "批量修改",httpMethod = "POST")
    //只要是前端输入的条件是以raw形式输入的那么就要用@RequestBody注解
    public Result updateList(@RequestBody List<User1> user){
        Result result=new Result();
        int a=userService.batchUpdate(user);
        if(a>=1){
            result.setMsg("修改成功");
        }
        return result;
    }

    @RequestMapping(value="/piliangdelete",method = RequestMethod.POST)
    @ApiOperation(value = "批量删除",httpMethod = "POST")
    //只要是前端输入的条件是以raw形式输入的那么就要用@RequestBody注解

    public Map<String, Object> deletes(String id) {

        //replaceAll() 方法使用给定的参数 replacement 替换字符串所有匹配给定的正则表达式的子字符串。
        //regex -- 匹配此字符串的正则表达式. newChar -- 用来替换每个匹配项的字符串  也叫后者代替前者
        String t = id.replaceAll("\\\"", "");

        // String replaceAll = t.replace("[", "").replace("]", "");

        Map<String,Object> resultMap = new HashMap<>();
        String[] str = t.split(",");
        List<Integer> list = new ArrayList<>();
        for (String l : str) {
            Integer i = Integer.valueOf(l);
            list.add(i);
        }
        Integer map =  userService.batchDelete(list);
        System.out.println("map = " + map);
        if (map == 0){
            resultMap.put("code", "0001");
            resultMap.put("message", "您删除的数据中，有不存在的数据");

        }else {
            resultMap.put("code", "0000");
            resultMap.put("message", "删除成功");

        }
        return resultMap;

    }


    //多参数传递
    @RequestMapping(value="/duocanshu",method = RequestMethod.POST)
    @ApiOperation(value = "多参数传递",httpMethod = "POST")
    public List<User1> duocanshu(String name,int id){
        return userService.duocanshu(id,name);
    }



    //实验表添加
    @RequestMapping(value="/shiyanbiaoadd",method = RequestMethod.POST)
    @ApiOperation(value = "实验表实验添加",httpMethod = "POST")
    public Result addShiyan(@RequestBody Shiyan shiyan){
        Result result=new Result();
        int a=userService.addShiyan(shiyan);
        if (a>=1){
            result.setMsg("添加数据成功");
            result.setSuccess(true);
            result.setDetail(a);
        }
        return result;

    }
    @RequestMapping(value="/shiyanbiaofind",method = RequestMethod.POST)
    @ApiOperation(value = "实验表实验查询",httpMethod = "POST")
    public  Result shiyanfind(@RequestBody Shiyanvo vo){
        Result result=new Result();
        result.setMsg("查询成功");
        result.setSuccess(true);
        result.setDetail(userService.shiyanfind(vo.getId(),vo.getName()));
        return result;
    }

    //实验表添加
    @RequestMapping(value="/shiyanbiaoaddbufen",method = RequestMethod.POST)
    @ApiOperation(value = "实验表实验部分增加",httpMethod = "POST")
    public Result addShiyan(@RequestBody Shiyanvo shiyanvo){
        Result result=new Result();
        int a=userService.addShiyanbufen(shiyanvo.getId(),shiyanvo.getName());
        if (a>=1){
            result.setMsg("添加数据成功");
            result.setSuccess(true);
            result.setDetail(a);
        }
        return result;

    }

    @RequestMapping(value="/stringjieshou",method = RequestMethod.POST)
    @ApiOperation(value = "string类型接收",httpMethod = "POST")
    public Result findstring(Integer id){
        Result result=new Result();
        result.setMsg("查询成功");
        result.setSuccess(true);
        result.setDetail(userService.findstring(id));
        return result;
    }

    /**
     * 动态sql
     */
    //新增
    @RequestMapping(value="/dongtaiadd",method = RequestMethod.POST)
    @ApiOperation(value = "动态sql新增",httpMethod = "POST")
    public Result dongtaiadd(Dongtaisql dongtaisql){
        Result result=new Result();
        int a=userService.adddongtai(dongtaisql);
        if(a>=1){
            result.setMsg("插入成功");
            result.setSuccess(true);
            result.setDetail(a);
        }else {
            result.setMsg("插入失败");
            result.setSuccess(false);
            result.setDetail(a);
        }
        return result;
    }
    //更新
    @RequestMapping(value="/dongtaiupdate",method = RequestMethod.POST)
    @ApiOperation(value = "动态sql更新",httpMethod = "POST")
    public Result updatedongtai(Dongtaisql dongtaisql){
        Result result=new Result();
        int b=userService.updatedongtai(dongtaisql);
        if(b>=1){
            result.setMsg("更新成功");
            result.setSuccess(true);
            result.setDetail(b);
        }else {
            result.setMsg("更新失败");
            result.setSuccess(false);
            result.setDetail(b);
        }
        return result;
    }
//定时任务
//    @Scheduled(cron = "*/3 * * * * ?")
//    public void DDD(){
//        System.out.println("张现增");
//    }
   // 定时任务
    @Scheduled(cron = "*/3 * * * * ?")
    public void adddingshi(){

        User1 user1=new User1();
        user1.setId(1024);
        user1.setName("holleword");
        userService.adddingshi(user1);
        System.out.println("定时任务的方法中不能带参数那么就new对象添加参数把");


    }
}
