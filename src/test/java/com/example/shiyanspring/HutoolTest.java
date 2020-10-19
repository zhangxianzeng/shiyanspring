package com.example.shiyanspring;


import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileAppender;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Console;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.net.multipart.UploadFile;
import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.word.Word07Writer;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HutoolTest {
    public void A(){
//    int a=12;
//    String str1= Convert.toStr(a);
//        long[] b = {1,2,3,4,5};
//        String str2=Convert.toStr(b);
//    System.out.println(str1);
//    System.out.println(str2);
//    String l= SecureUtil.md5("zhangxian11");
//    System.out.println(l);
//        String result1= HttpUtil.get("https://www.baidu.com");
//
//System.out.println(result1);
//        HashMap<String, Object> paramMap = new HashMap<>();
////文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
//        paramMap.put("file", FileUtil.file("/Users/zhangxianzeng/Desktop/吴萍.jpg"));
//
//        String result= HttpUtil.post("https://www.baidu.com", paramMap);
//        System.out.println(result);
//        String fileUrl = "http://mirrors.sohu.com/centos/7.3.1611/isos/x86_64/CentOS-7-x86_64-DVD-1611.iso";
//
////将文件下载后保存在E盘，返回结果为下载文件大小
//        long size = HttpUtil.downloadFile(fileUrl, FileUtil.file("e:/"));
//        System.out.println("Download size: " + size);
//        BufferedInputStream in = FileUtil.getInputStream("/Users/zhangxianzeng/Downloads/jt.sql");
//        BufferedOutputStream out = FileUtil.getOutputStream("/Users/zhangxianzeng/Downloads/jt1.sql");
//        long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
        //读取文件内容
//        FileReader fileReader = new FileReader("/Users/zhangxianzeng/Downloads/1.xml");
//        String result = fileReader.readString();
//        System.out.println(result);
        //写入文件内容
//        FileWriter fileWriter=new FileWriter("/Users/zhangxianzeng/Downloads/1.xml");
//        fileWriter.write("张现增是时间");
        //文件内容追加
//        FileAppender appender = new FileAppender(new File("/Users/zhangxianzeng/Downloads/1.xml"), 16, true);
//        appender.append("123");
//        appender.append("abc");
//        appender.append("xyz");
//
//        appender.flush();
//        appender.toString();

//        String str = ResourceUtil.readUtf8Str("/Users/zhangxianzeng/Downloads/1.xml");
//        System.out.println(str);
//        ClassPathResource resource = new ClassPathResource("application2.yml");
//        Properties properties = new Properties();
//        try {
//            properties.load(resource.getStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Console.log("Properties: {}", properties);
//        String str = RuntimeUtil.execForStr("java -jar /Users/zhangxianzeng/Downloads/optaplanner/1.jar /Users/zhangxianzeng/Downloads/optaplanner/roster_9.xml");
//        System.out.println(str);

//        String content = "ZZZaaabbbccc中文1234";
//        Pattern pattern = Pattern.compile("([\\u4e00-\\u9fa5]+)", Pattern.DOTALL);
//        Matcher matcher = pattern.matcher(content);
//        if (matcher.find()) {
//            String result= matcher.group();
//            System.out.println(result);
//        }

//        String [] a={"1","s","d"};
//
//        Console.log(a);

        String ID_18 = "37070419960805062X";
        String ID_15 = "372928199102166311";

//是否有效
//        boolean valid = IdcardUtil.isValidCard(ID_18);
//        boolean valid15 = IdcardUtil.isValidCard(ID_15);
//        Console.log(valid);
//        Console.log(valid15);
        //年龄
//        DateTime date = DateUtil.parse("2020-7-20");
//
//        int age = IdcardUtil.getAgeByIdCard(ID_18, date);
//        System.out.println(age);
//
//        int age1 = IdcardUtil.getAgeByIdCard(ID_15, date);
//        System.out.println(age1);

//        String province = IdcardUtil.getProvinceByIdCard(ID_18);
//        if(province=="上海"){
//            System.out.println(province);
//        }else {
//            System.out.println("你输入的有误");
//        }

//        List<TreeNode<String>> nodeList = CollUtil.newArrayList();
//
//        nodeList.add(new TreeNode<>("1", "0", "系统管理", 5));
//        nodeList.add(new TreeNode<>("11", "1", "用户管理", 222222));
//        nodeList.add(new TreeNode<>("111", "11", "用户添加", 0));
//        nodeList.add(new TreeNode<>("2", "0", "店铺管理", 1));
//        nodeList.add(new TreeNode<>("21", "2", "商品管理", 44));
//        nodeList.add(new TreeNode<>("221", "2", "商品管理2", 2));
//        List<Tree<String>> treeList = TreeUtil.build(nodeList, "0");
//        Console.log(treeList);

     //   ImgUtil.gray(FileUtil.file("/Users/zhangxianzeng/Downloads/吴萍.jpg"), FileUtil.file("/Users/zhangxianzeng/Downloads/吴萍.jpg"));

//        String buildUrl = UrlBuilder.create()
//                .setScheme("https")
//                .setHost("www.hutool.cn")
//                .addPath("/aaa").addPath("bbb")
//                .addQuery("ie", "UTF-8")
//                .addQuery("wd", "test")
//                .build();
//        System.out.println(buildUrl);
     //   String urlStr = "https://mp.weixin.qq.com/s?__biz=MzI5NjkyNTIxMg==&amp;mid=100000465&amp;idx=1";
//        UrlBuilder builder = UrlBuilder.ofHttp(urlStr, CharsetUtil.CHARSET_UTF_8);
//
//// https://mp.weixin.qq.com/s?__biz=MzI5NjkyNTIxMg==&mid=100000465&idx=1
//        Console.log(builder.build());

//        Cache<String,String> fifoCache = CacheUtil.newFIFOCache(3);
//        Console.log(fifoCache);
      //  Cache<String,String> fifoCache = CacheUtil.newFIFOCache(3);

//加入元素，每个元素可以设置其过期时长，DateUnit.SECOND.getMillis()代表每秒对应的毫秒数，在此为3秒
//        fifoCache.put("key1", "value1", DateUnit.SECOND.getMillis() * 3);
//        fifoCache.put("key2", "value2", DateUnit.SECOND.getMillis() * 3);
//        fifoCache.put("key3", "value3", DateUnit.SECOND.getMillis() * 3);
//
////由于缓存容量只有3，当加入第四个元素的时候，根据FIFO规则，最先放入的对象将被移除
//        fifoCache.put("key4", "value4", DateUnit.SECOND.getMillis() * 3);
//
////value1为null
//        String value1 = fifoCache.get("key2");
//        Console.log(value1);
//        String result1= HttpUtil.get("127.0.0.1:8080/hutool/findlist");
//        System.out.println(result1);
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("name", "zhang");
//
//        String result3= HttpUtil.post("127.0.0.1:8080/n/name1", paramMap);
//        System.out.println(result3);
        //请求列表页
//        String listContent = HttpUtil.get("https://blog.csdn.net/cmqwan/article/details/83032011");
////使用正则获取所有标题
//        List<String> titles = ReUtil.findAll("<span class=\"text-ellipsis\">(.*?)</span>", listContent, 1);
//        for (String title : titles) {
//            //打印标题
//            Console.log(title);

//        HttpUtil.createServer(8888)
//                .addAction("/file", (request, response) -> {
//                            final UploadFile file = request.getMultipart().getFile("/Users/zhangxianzeng/Downloads/1.xml");
//                            // 传入目录，默认读取HTTP头中的文件名然后创建文件
//                            file.write("/Users/zhangxianzeng/Downloads/abc");
//                            response.write("OK!", ContentType.TEXT_PLAIN.toString());
//                        }
//                )
//                .start();

//定义图形验证码的长、宽、验证码字符数、干扰元素个数
//        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
////CircleCaptcha captcha = new CircleCaptcha(200, 100, 4, 20);
////图形验证码写出，可以写出到文件，也可以写出到流
//        System.out.println(captcha);
//        captcha.write("/Users/zhangxianzeng/Downloads/circle.png");
////验证图形验证码的有效性，返回boolean值
//      boolean a=  captcha.verify("1234");
//      System.out.println(a);

      //  ExcelReader reader = ExcelUtil.getReader(FileUtil.file("/Users/zhangxianzeng/Downloads/users (1).xls"));
//        ExcelReader reader = ExcelUtil.getReader("/Users/zhangxianzeng/Downloads/users (1).xls");
//        List<List<Object>> readAll = reader.read();
//        Console.log(readAll);

        Word07Writer writer = new Word07Writer();

//// 添加段落（标题）
//        writer.addText(new Font("方正小标宋简体", Font.PLAIN, 22), "我是第一部分", "我是第二部分");
//// 添加段落（正文）
//        writer.addText(new Font("宋体", Font.PLAIN, 22), "我是正文第一部分", "我是正文第二部分");
//// 写出到文件
//        writer.flush(FileUtil.file("/Users/zhangxianzeng/Downloads/wordWrite.docx"));
//// 关闭
//        writer.close();
    }

    public static void main(String[] args) {
        HutoolTest hutoolTest=new HutoolTest();
        hutoolTest.A();
    }
}
