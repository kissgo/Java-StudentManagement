package com.liusp.dao;

import com.liusp.bean.UserInfo;

import java.util.List;

/**
 * @author 刘双平
 * @create 2021-09-23 8:41
 */
public interface UserInfoDao {
    public List<UserInfo> findUserInfoALL();

    /**
     * 通过用户名称和密码查询用户信息
     * @param userInfo
     * @return
     */
    public UserInfo findUserInfoByUnameAndPwd(UserInfo userInfo);

    /**
     * 修改用户信息
     * 通过用于ID修改
     * @param userInfo
     * @return
     */
    public int updateUserInfoByUid(UserInfo userInfo);


}
