<%@ page import="com.liusp.bean.UserInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据库信息</title>
</head>
<body>
<%
    UserInfo userInfo= (UserInfo) session.getAttribute("ui");
%>
<%

%>
session 中存储的当前登录的用户：
<%
//    if(userInfo!=null){
//        out.println(userInfo.getUname());
//    }else{
//        //如果session中没有登录用户的信息，就提示用于需要登录跳转到登录页面
//        response.sendRedirect("login.jsp");
//    }
%>
<table border="1" >
    <tr>
        <td>ID</td>
        <td>用户名称</td>
        <td>密码</td>
        <td>地址</td>
        <td>电话</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <%
        //查询所有用户信息
        List<UserInfo> userInfoALL =(List<UserInfo>) request.getAttribute("userlist");
        for (UserInfo u: userInfoALL) {
    %>
    <tr>
        <td><%=u.getUid()%></td>
        <td><%=u.getUname()%></td>
        <td><%=u.getPassword()%></td>
        <td><%=u.getAddress()%></td>
        <td><%=u.getPhone()%></td>
        <td><a href="userInfoEditController.do?id=<%=u.getUid()%>">编辑</a></td>
        <td><a href="userInfoDelController.do?id=<%=u.getUid()%>">删除</a></td>

    </tr>
    <%
        }
    %>

</table>
<%

%>
</body>
</html>
