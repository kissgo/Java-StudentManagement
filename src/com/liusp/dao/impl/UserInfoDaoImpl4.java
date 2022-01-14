package com.liusp.dao.impl;

import com.liusp.bean.UserInfo;
import com.liusp.dao.UserInfoDao;
import com.liusp.util.BaseDao;

import java.util.List;

/**
 * @author 刘双平
 * @create 2021-09-17 15:15
 *编写链接数据库代码
 */
public class UserInfoDaoImpl4 extends BaseDao<UserInfo> implements UserInfoDao {
    public List<UserInfo> findUserInfoALL(){
        String sql="SELECT * FROM userinfo";
        Object []o={};
        return this.list(sql,o);
    }

    /**
     * 通过用户名称和密码查询用户信息
     * @param userInfo
     * @return
     */
    public UserInfo findUserInfoByUnameAndPwd(UserInfo userInfo){
      String sql="SELECT * FROM userinfo WHERE uname=? AND PASSWORD=?";
        Object []o={userInfo.getUname(),userInfo.getPassword()};
        return this.load(sql,o);
    }

    /**
     * 修改用户信息
     * 通过用于ID修改
     * @param userInfo
     * @return
     */
    public int updateUserInfoByUid(UserInfo userInfo){
      String sql="UPDATE  userinfo SET PASSWORD=? WHERE uid=?";
      Object[] o={userInfo.getPassword(),userInfo.getUid()};
        return this.update(sql,o);
    }

}
