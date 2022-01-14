package com.liusp.controller;

import com.liusp.bean.UserInfo;
import com.liusp.dao.impl.UserInfoDaoImpl3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserInfoEditController", urlPatterns = ("/userInfoEditController.do"))
public class UserInfoEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int ID = Integer.parseInt(request.getParameter("uid"));
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("password");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        System.out.println(uname);

        UserInfoDaoImpl3 userInfoDao=new UserInfoDaoImpl3();
        UserInfo u=new UserInfo();
        u.setUid(ID);
        u.setPassword(pwd);
        u.setUname(uname);
        u.setPhone(phone);
        u.setSex(sex);
        u.setAddress(address);
        int i = userInfoDao.updateUserInfo(u);
        System.out.println(i);
        if(i == 1){
            System.out.println("<div>成功修改ID:"+ID+"的用户信息</div>");
        }else{
            System.out.println("<div>修改失败</div>");
        }
        response.sendRedirect("userInfoFindAllController.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("id");
        UserInfoDaoImpl3 userInfoDao=new UserInfoDaoImpl3();
        UserInfo IDuserInfo= new UserInfo();
        IDuserInfo = userInfoDao.findUserInfoByID(userID);

        request.setAttribute("editUser",IDuserInfo);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }
}
