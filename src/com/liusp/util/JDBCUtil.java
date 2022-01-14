package com.liusp.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.sql.*;
import java.util.Iterator;

/**
 * @author 刘双平
 * @create 2021-06-08 10:52
 */
public class JDBCUtil {
    static Connection con;
    static String driver;
    static String url;
    static String username;
    static String password;
    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        getPath();
        Connection connection=null;
        //第一步：加载驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭数据库连接资源
     * @param conn
     * @param sta
     * @param rs
     */
    public static void closeConnection(Connection conn, Statement sta, ResultSet rs){
        try {
            //第六步关闭资源
            if (rs!=null){
                rs.close();
            }
            if (sta!=null){
                sta.close();
            }
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析XML获取连接数据库的字符串
     */
    public static  void getPath(){
        try {
            //接通读取文件的管道
            SAXReader reader = new SAXReader();
            //Document是文档对象
            Document document = reader.read(new File(JDBCUtil.class.getClassLoader().getResource("application.xml").getPath()));
            //获取文档的根节点
            Element rootElement = document.getRootElement();
            //获取根节点下的所有子节点
            Iterator i = rootElement.elementIterator();
            //循环获取子节点
            for (;i.hasNext();) {
                //得到每一个子节点Element
                Element element = (Element) i.next();
                if(element.getName().equals("driver")){
                    driver=element.getStringValue();
                }
                if(element.getName().equals("url")){
                    url=element.getStringValue();
                }
                if(element.getName().equals("username")){
                    username=element.getStringValue();
                }
                if(element.getName().equals("password")){
                    password=element.getStringValue();
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
