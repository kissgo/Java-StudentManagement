package com.liusp.controller;

import com.liusp.bean.UserInfo;
import com.liusp.service.UserInfoService;
import com.liusp.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserInfoFindAllController", urlPatterns = ("/userInfoFindAllController.do"))
public class UserInfoFindAllController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询所有用户信息
        UserInfoService userInfoService=new UserInfoServiceImpl();
        List<UserInfo> userInfoALL = userInfoService.findUserInfoALL();
        request.setAttribute("userlist",userInfoALL);
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
