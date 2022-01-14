package com.liusp.util;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class BaseDao<T> {
    static Connection con;
    static ResultSet rs;
    static PreparedStatement sta;
    private Class<T> clz;


    {
        getClz();
    }

    public Class<T> getClz(){
        if(clz==null){
            clz = (Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
        }
        return clz;
    }

    /**
     * 增删改通用方法
     * @param sql
     * @return
     */
    public int update(String sql,Object [] o) {
        int row=0;
        try {
            con=JDBCUtil.getConnection();
            sta=con.prepareStatement(sql);
            //参数的绑定
            for(int i=0;i<o.length;i++){
                sta.setObject(i+1, o[i]);
            }
            row = sta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtil.closeConnection(con, sta,rs);
        }
        return row;
    }


    /**
     * 查询结果返回单个实体类对象
     * @param sql
     * @return
     */
    public T load(String sql,Object []o) {
        T t=null;
        try {
            con=JDBCUtil.getConnection();
            sta=con.prepareStatement(sql);
            //参数绑定
            for(int i=0;i<o.length;i++){
                sta.setObject(i+1, o[i]);
            }
            rs=sta.executeQuery();
            Field []field=clz.getDeclaredFields();

            if(rs.next()){
                t = clz.newInstance();
                for(Field f:field){
                    f.setAccessible(true);
                    if(!(f.getName().endsWith("list"))){
                        try {
                            String str= ""+f.getType();
//								System.out.println("属性类型为："+str);

                            if(str.equals("int")){
                                f.set(t, rs.getInt(f.getName()));
                            }else if(str.equals("double")){
                                f.set(t, rs.getDouble(f.getName()));
                            }else if(str.equals("class java.sql.Date")){
                                f.set(t, rs.getDate(f.getName()));
                            }else if(str.equals("float")){
                                f.set(t, rs.getFloat(f.getName()));
                            }else if(str.equals("short")){
                                f.set(t, rs.getShort(f.getName()));
                            }else{//字符串类型
                                f.set(t, rs.getObject(f.getName()));
                            }
                        } catch (Exception e) {
                            System.out.println(f.getName()+"列不存在");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtil.closeConnection(con, sta,rs);
        }
        return t;
    }
    /**
     * 查询所有返回一个集合
     */
    public List<T> list(String sql,Object []o) {
        List<T> list = new ArrayList<T>();
        T t=null;
        try {
            con=JDBCUtil.getConnection();
            sta=con.prepareStatement(sql);
            //参数绑定
            for(int i=0;i<o.length;i++){
                sta.setObject(i+1, o[i]);
            }
            rs=sta.executeQuery();
            Field []field=clz.getDeclaredFields();
            while (rs.next()) {
                t = clz.newInstance();
                for(Field f:field){
                    f.setAccessible(true);
                    if(!(f.getName().endsWith("list"))){
                        try {
                            String str= ""+f.getType();
//									System.out.println("属性类型为："+str);

                            if(str.equals("int")){
                                f.set(t, rs.getInt(f.getName()));
                            }else if(str.equals("double")){
                                f.set(t, rs.getDouble(f.getName()));
                            }else if(str.equals("class java.sql.Date")){
                                f.set(t, rs.getDate(f.getName()));
                            }else if(str.equals("float")){
                                f.set(t, rs.getFloat(f.getName()));
                            }else if(str.equals("short")){
                                f.set(t, rs.getShort(f.getName()));
                            }else{//字符串类型
                                f.set(t, rs.getObject(f.getName()));
                            }
                        } catch (Exception e) {
                            System.out.println(f.getName()+"列不存在");
                        }
                    }
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtil.closeConnection(con, sta,rs);
        }
        return list;
    }
}