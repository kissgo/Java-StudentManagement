package com.liusp.dao.impl;

import com.liusp.bean.UserInfo;
import com.liusp.dao.UserInfoDao;
import com.liusp.util.BaseDao;
import com.liusp.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author 刘双平
 * @create 2021-09-17 15:15
 *编写链接数据库代码
 */
public class UserInfoDaoImpl3 extends BaseDao<UserInfo> implements UserInfoDao {
    public List<UserInfo> findUserInfoALL(){
        String sql="SELECT * FROM userinfo";
        Object []o={};
        return this.list(sql,o);
    }

    /**
     * 添加用户信息
     */
    public  int insertUserInfo(UserInfo userInfo){
     String sql = "INSERT  INTO userinfo (`uname`,`password`,`phone`,`sex`,`address`) VALUE (?,?,?,?,?)";
        Object []o={userInfo.getUname(),userInfo.getPassword(),userInfo.getPhone(),userInfo.getSex(),userInfo.getAddress()};
        return this.update(sql,o);
    }

    /**
     * 通过ID查询用户信息
     */
    public UserInfo findUserInfoByID(String id){
     String sql = "SELECT * FROM userinfo WHERE uid=?";
     Object []o = {id};

        return this.load(sql,o);
    }

    /**
     * 多条件查询
     */
    public List<UserInfo> findUserInfoByArgs(Map map) {
        Object []o = new Object[map.size()];
        String sql="SELECT * FROM userinfo WHERE";
        int i = 0;
        int j=0;
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while(entries.hasNext()){
            if(i++!=0){
                sql += " AND ";
            }
            Map.Entry<String, String> entry = entries.next();
            String key = entry.getKey();
            String value = entry.getValue();
            sql = sql + " "+key + " = ?";
            o[j++] = value;

        }
        System.out.println(sql);
        //第七步：返回结果集
        return this.list(sql,o);
    }

    /**
     * 通过ID删除用户
     */
    public int delUserInfoByID(String id) {
    String sql = "DELETE FROM userinfo WHERE uid =?";
    Object []o = {id};

        return this.update(sql,o);
    }

    /**
     * 通过ID修改用户信息
     */
    public int updateUserInfo(UserInfo userInfo) {
     String sql = "UPDATE userinfo SET uname=?,phone=?,sex=?,address=?, password=? WHERE uid=?";
    Object []o = {
            userInfo.getUname(),
            userInfo.getPhone(),
            userInfo.getSex(),
            userInfo.getAddress(),
            userInfo.getPassword(),
            userInfo.getUid()

    };
        return this.update(sql,o);
    }


    /**
     * 通过用户名称和密码查询用户信息
     */
    public UserInfo findUserInfoByUnameAndPwd(UserInfo userInfo){
      String sql="SELECT * FROM userinfo WHERE uname=? AND PASSWORD=?";
        Object []o={userInfo.getUname(),userInfo.getPassword()};
        return this.load(sql,o);
    }

    /**
     * 修改用户信息
     *
     */
    public int updateUserInfoByUid(UserInfo userInfo){
      String sql="UPDATE  userinfo SET PASSWORD=? WHERE uid=?";
      Object[] o={userInfo.getPassword(),userInfo.getUid()};
        return this.update(sql,o);
    }

}
