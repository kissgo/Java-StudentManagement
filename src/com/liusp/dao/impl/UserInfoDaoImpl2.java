package com.liusp.dao.impl;

import com.liusp.bean.UserInfo;
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
public class UserInfoDaoImpl2 {

    /**
     * 添加用户信息
     *
     * @param userInfo
     * @return
     */
    public  int insertUserInfo(UserInfo userInfo){
        int i=0;
        Connection con=null;
        Statement sta=null;
        ResultSet rs=null;
        UserInfo user=null;
        //链接数据库分几步
        //第一步：加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            //第二步：获取数据库链接
            con = JDBCUtil.getConnection();
            //第三步：获取执行sql语句的对象
            sta = con.createStatement();
            //第四步：执行sql语句返回执行结果

            i = sta.executeUpdate("INSERT  INTO userinfo (`uname`,`password`,`phone`,`sex`,`address`) VALUE ('"+userInfo.getUname()+"','"+userInfo.getPassword()+"','"+userInfo.getPhone()+"','"+userInfo.getSex()+"','"+userInfo.getAddress()+"')");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //第六步：关闭资源
            JDBCUtil.closeConnection(con,sta,rs);

        }
        return i;
    }

    /**
     * 查询所有用户信息
     *
     * @param
     * @return
     */
    public List<UserInfo> findUserInfoALL(){
        List<UserInfo> list=new ArrayList<UserInfo>();
        Connection con=null;
        Statement sta=null;
        ResultSet rs=null;
        //链接数据库分几步

        try {
            //第二步：获取数据库链接
            con = JDBCUtil.getConnection();
            //第三步：获取执行sql语句的对象
             sta = con.createStatement();
            //第四步：执行sql语句返回执行结果
             rs = sta.executeQuery("SELECT * FROM userinfo");
            //第五步：循环遍历结果集封装数据到集合中
            while(rs.next()){
                UserInfo userInfo=new UserInfo();
                userInfo.setUid(rs.getInt("uid"));
                userInfo.setUname(rs.getString("uname"));
                userInfo.setPhone(rs.getString("phone"));
                userInfo.setAddress(rs.getString("address"));
                userInfo.setSex(rs.getString("sex"));
                userInfo.setPassword(rs.getString("password"));
                list.add(userInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //第六步：关闭资源
            JDBCUtil.closeConnection(con,sta,rs);

        }
        //第七步：返回结果集
        return list;
    }

    /**
     * 通过ID查询用户信息
     *
     * @param id
     * @return
     */
    public UserInfo findUserInfoByID(String id){
        Connection con=null;
        Statement sta=null;
        ResultSet rs=null;
        UserInfo userInfo =new UserInfo();
        //链接数据库分几步
        //第一步：加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            //第二步：获取数据库链接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb5?useUnicode=true&amp;characterEncoding=UTF-8", "root", "root");
            //第三步：获取执行sql语句的对象
            sta = con.createStatement();
            //第四步：执行sql语句返回执行结果
            rs = sta.executeQuery("SELECT * FROM userinfo WHERE uid='"+id+"'");

            while(rs.next()){

                userInfo.setUid(rs.getInt("uid"));
                userInfo.setUname(rs.getString("uname"));
                userInfo.setPhone(rs.getString("phone"));
                userInfo.setAddress(rs.getString("address"));
                userInfo.setSex(rs.getString("sex"));
                userInfo.setPassword(rs.getString("password"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //第五步：关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (sta != null) {
                    sta.close();
                }
                if (con != null) {
                    con.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        //第六步：返回结果集
        return userInfo;
    }

    /**
     * 多条件查询
     *
     * @param
     * @return
     */
    public List<UserInfo> findUserInfoByArgs(Map map) {
        List<UserInfo> list=new ArrayList<UserInfo>();
        Connection con=null;
        Statement sta=null;
        ResultSet rs=null;
        //链接数据库分几步
        //第一步：加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            //第二步：获取数据库链接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb5?useUnicode=true&amp;characterEncoding=UTF-8", "root", "root");
            //第三步：获取执行sql语句的对象
            sta = con.createStatement();
            //第四步：执行sql语句返回执行结果
            String str="";
            int i = 0;
            Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
            while(entries.hasNext()){
                if(i++!=0){
                    str=str+" AND ";
                }
                Map.Entry<String, String> entry = entries.next();
                String key = entry.getKey();
                String value = entry.getValue();
                str = str + key + " = '" + value+"'";
            }
            System.out.println(str);
            rs = sta.executeQuery("SELECT * FROM userinfo WHERE " + str);
            //第五步：循环遍历结果集封装数据到集合中
            while(rs.next()){
                UserInfo userInfo=new UserInfo();
                userInfo.setUid(rs.getInt("uid"));
                userInfo.setUname(rs.getString("uname"));
                userInfo.setPhone(rs.getString("phone"));
                userInfo.setAddress(rs.getString("address"));
                userInfo.setSex(rs.getString("sex"));
                userInfo.setPassword(rs.getString("password"));
                list.add(userInfo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //第六步：关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (sta != null) {
                    sta.close();
                }
                if (con != null) {
                    con.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        //第七步：返回结果集
        return list;
    }

    /**
     * 通过ID删除用户
     *
     * @param
     * @return
     */
    public int delUserInfoByID(String id) {
        Connection con=null;
        Statement sta=null;
        int i=0;
        UserInfo user=null;
        //链接数据库分几步
        //第一步：加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            //第二步：获取数据库链接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb5?useUnicode=true&amp;characterEncoding=UTF-8", "root", "root");
            //第三步：获取执行sql语句的对象
            sta = con.createStatement();
            //第四步：执行sql语句返回执行结果
            i=sta.executeUpdate("DELETE FROM userinfo WHERE uid ="+id);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //第五步：关闭资源
            try {
                if (sta != null) {
                    sta.close();
                }
                if (con != null) {
                    con.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        //第六步：返回结果集
        return i;
    }

    /**
     * 通过ID修改用户信息
     *
     * @param
     * @return
     */
    public int updateUserInfo(UserInfo userInfo) {
        Connection con=null;
        Statement sta=null;
        int i=0;
        UserInfo user=null;
        //链接数据库分几步
        //第一步：加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            //第二步：获取数据库链接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb5?useUnicode=true&amp;characterEncoding=UTF-8", "root", "root");
            //第三步：获取执行sql语句的对象
            sta = con.createStatement();
            //第四步：执行sql语句返回执行结果
            i=sta.executeUpdate("UPDATE userinfo SET uname='"+userInfo.getUname()+"',phone='"+userInfo.getPhone()+"',sex='"+userInfo.getSex()+"',address='"+userInfo.getAddress()+"' WHERE uid="+userInfo.getUid());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //第五步：关闭资源
            try {
                if (sta != null) {
                    sta.close();
                }
                if (con != null) {
                    con.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        //第六步：返回结果集
        return i;
    }



    /**
     * 通过用户名称和密码查询用户信息
     * @param userInfo
     * @return
     */
    public UserInfo findUserInfoByUnameAndPwd(UserInfo userInfo){
        Connection con=null;
        PreparedStatement sta = null;
        ResultSet rs=null;
        UserInfo user=null;
        //链接数据库分几步
        //第一步：加载驱动

        try {
            //第二步：获取数据库链接
            con = JDBCUtil.getConnection();
            //第三步：获取执行sql语句的对象
            sta = con.prepareStatement("SELECT * FROM userinfo WHERE uname=? AND PASSWORD=?");
            sta.setString(1,userInfo.getUname());
            sta.setString(2,userInfo.getPassword());
            //第四步：执行sql语句返回执行结果
//            rs = sta.executeQuery("SELECT * FROM userinfo WHERE uname='"+userInfo.getUname()+"' AND PASSWORD='"+userInfo.getPassword()+"'");
            rs = sta.executeQuery();
            //第五步：循环遍历结果集封装数据到集合中
            while(rs.next()){
                user=new UserInfo();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPhone(rs.getString("phone"));
                userInfo.setAddress(rs.getString("address"));
                user.setSex(rs.getString("sex"));
                user.setPassword(rs.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //第六步：关闭资源
            JDBCUtil.closeConnection(con,sta,rs);

        }
        //第七步：返回结果集
        return user;
    }

    /**
     * 修改用户信息
     * 通过用于ID修改
     * @param userInfo
     * @return
     */
    public int updateUserInfoByUid(UserInfo userInfo){
        int i=0;
        Connection con=null;
        Statement sta=null;
        ResultSet rs=null;
        UserInfo user=null;
        //链接数据库分几步
        //第一步：加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            //第二步：获取数据库链接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb5?useUnicode=true&amp;characterEncoding=UTF-8", "root", "root");
            //第三步：获取执行sql语句的对象
            sta = con.createStatement();
            //第四步：执行sql语句返回执行结果
            i = sta.executeUpdate("UPDATE  userinfo SET PASSWORD='"+userInfo.getPassword()+"' WHERE uid="+userInfo.getUid());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //第六步：关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (sta != null) {
                    sta.close();
                }
                if (con != null) {
                    con.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        return i;
    }
}
