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

@WebServlet(name = "UserInfoLoginContor", urlPatterns = "/userInfoLoginController.do")
public class UserInfoLoginContor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第一步：获取表单提交过来的数据
        request.setCharacterEncoding("UTF-8");
        String uname=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        String []jzmms=request.getParameterValues("jzmm");

        //第二步：通过获取到的账号信息查询数据库，此处我么模拟账号登录的过程
        // （如果账号是admin admin 就登录成功，否则登陆失败回到登录页面，）
        UserInfoService userInfoService=new UserInfoServiceImpl();
        UserInfo userInfo=new UserInfo();
        userInfo.setUname(uname);
        userInfo.setPassword(pwd);
        UserInfo userInfo1 = userInfoService.findUserInfoByUnameAndPwd(userInfo);
        if(userInfo1!=null){

            //将登录的用户对象存储到服务器上的session中

//            session.setAttribute("ui",userInfo1);
//
////        1 在用户登录成功，并且复选框记住密码被选中了，就将账号信息存入cookie中
//            if(jzmms!=null){
//                Cookie cookie=new Cookie("uname",uname);
//                cookie.setMaxAge(100);
//                Cookie cookie1=new Cookie("pwd",pwd);
//                cookie1.setMaxAge(100);
//                response.addCookie(cookie);
//                response.addCookie(cookie1);
//            }else{
//                //当没有选中记住密码，就要忘记密码
//                Cookie cookie=new Cookie("uname",uname);
//                cookie.setMaxAge(0);
//                Cookie cookie1=new Cookie("pwd",pwd);
//                cookie1.setMaxAge(0);
//                response.addCookie(cookie);
//                response.addCookie(cookie1);
//            }

            //第三步跳转到相应的首页面 admin.jsp
            System.out.println("登陆成功");
            response.sendRedirect("userInfoFindAllController.do"); //重定向跳转页面
//        request.getRequestDispatcher("admin.jsp").forward(request,response);//转发跳转页面
        }else{
            //登录失败回到登录页面
            System.out.println("登陆失败");
            response.sendRedirect("login.jsp"); //重定向跳转页面
//        request.getRequestDispatcher("login.jsp").forward(request,response);//转发跳转页面
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
