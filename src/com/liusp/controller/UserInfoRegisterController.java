package com.liusp.controller;

import com.liusp.bean.UserInfo;
import com.liusp.dao.impl.UserInfoDaoImpl3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserInfoRegisterController", urlPatterns = ("/userInfoRegisterController.do"))
public class UserInfoRegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String uname=request.getParameter("uname");
        String pwd=request.getParameter("password");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        System.out.println(uname+pwd+phone+sex+address);
        if(uname !=null && pwd !=null && phone != null && sex != null && address !=null){
            UserInfoDaoImpl3 userInfoDao=new UserInfoDaoImpl3();
            UserInfo inserNewUser = new UserInfo();
            inserNewUser.setUname(uname);
            inserNewUser.setPassword(pwd);
            inserNewUser.setPhone(phone);
            inserNewUser.setSex(sex);
            inserNewUser.setAddress(address);
            int inusernum = userInfoDao.insertUserInfo(inserNewUser);
            System.out.println("<div>新用户数据为：名字："+inserNewUser.getUname()+",电话："+inserNewUser.getPhone()+",性别："+inserNewUser.getSex()+"地址："+inserNewUser.getAddress()+"</div>");
            System.out.println("<div>注册成功，请登录</div>");
        }else{
            System.out.println("<div>您注册信息不齐全，请重新填写</div>");
        }
        response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
