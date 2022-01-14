package com.liusp.controller;

import com.liusp.dao.impl.UserInfoDaoImpl3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserInfoDelController", urlPatterns = ("/userInfoDelController.do"))
public class UserInfoDelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
//        out.println("<div>正在删除id:"+id+"的用户信息</div>");
        UserInfoDaoImpl3 delUserInfoDao=new UserInfoDaoImpl3();
        int delNum = delUserInfoDao.delUserInfoByID(id);
        if (delNum != 0){
            System.out.println("<div>成功删除"+delNum+"位用户</div>");
        }else{
            System.out.println("<div>删除失败</div>");
        }
        response.sendRedirect("userInfoFindAllController.do");
//        response.setHeader("Refresh","3;admin.jsp");
    }
}
