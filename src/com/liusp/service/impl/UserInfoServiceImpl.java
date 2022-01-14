package com.liusp.service.impl;

import com.liusp.bean.UserInfo;
import com.liusp.dao.UserInfoDao;
import com.liusp.dao.impl.UserInfoDaoImpl3;
import com.liusp.service.UserInfoService;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {

    //定义数据访问从的对象
//    private UserInfoDao userInfoDao=new UserInfoDaoImpl3();
    private UserInfoDao userInfoDao = new UserInfoDaoImpl3();
    @Override
    public List<UserInfo> findUserInfoALL() {
        return userInfoDao.findUserInfoALL();
    }

    @Override
    public UserInfo findUserInfoByUnameAndPwd(UserInfo userInfo) {
        return userInfoDao.findUserInfoByUnameAndPwd(userInfo);
    }

    @Override
    public int updateUserInfoByUid(UserInfo userInfo) {

        return userInfoDao.updateUserInfoByUid(userInfo);
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }
}
