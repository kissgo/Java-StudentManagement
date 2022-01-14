package com.liusp.test;

import com.liusp.bean.UserInfo;
import com.liusp.dao.impl.UserInfoDaoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘双平
 * @create 2021-09-17 15:31
 */
public class UserInfoTest {
    public static void main(String[] args) {
        UserInfoDaoImpl userInfoDao=new UserInfoDaoImpl();


        System.out.println("=========添加新用户============");
        UserInfo inserNewUser = new UserInfo();

        inserNewUser.setUname("wen");
        inserNewUser.setPassword("999");
        inserNewUser.setPhone("120");
        inserNewUser.setSex("nan");
        inserNewUser.setAddress("gd");
        int inusernum = userInfoDao.insertUserInfo(inserNewUser);
        System.out.println("添加了："+inusernum+"位用户数据");
        System.out.println("新用户数据为：名字："+inserNewUser.getUname()+",电话："+inserNewUser.getPhone()+",性别："+inserNewUser.getSex()+"地址："+inserNewUser.getAddress());

        System.out.println("=========查询所有用户============");
        //查询所有用户信息
        List<UserInfo> userInfoALL = userInfoDao.findUserInfoALL();
        System.out.println(userInfoALL);

        System.out.println("=========通过ID查询用户信息============");
        UserInfo  IDuserInfo= new UserInfo();
        IDuserInfo = userInfoDao.findUserInfoByID("1");
        System.out.println(IDuserInfo);

        System.out.println("=========多条件查询============");
        Map map = new HashMap();
        map.put("uid","33");
        map.put("uname","wen");
        List<UserInfo> ALL = userInfoDao.findUserInfoByArgs(map);
        System.out.println(ALL);

//        System.out.println("=============通过用户名称和密码查询用户数据=============");
//        UserInfo userInfo=new UserInfo();
//        userInfo.setUname("feifei");
//        userInfo.setPassword("123");
//        UserInfo user = userInfoDao.findUserInfoByUnameAndPwd(userInfo);
//        System.out.println("当前登录的用户为："+user);

        System.out.println("=========通过ID删除用户信息============");
        int delNum = userInfoDao.delUserInfoByID("30");
        System.out.println("成功删除"+delNum+"位用户");

        System.out.println("=========通过ID修改用户信息============");
        UserInfo u=new UserInfo();
        u.setPassword("888");
        u.setUid(17);
        int i = userInfoDao.updateUserInfoByUid(u);
        System.out.println("数据库影响的行数："+i);


    }
}
