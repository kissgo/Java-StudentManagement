<%@ page import="com.liusp.dao.impl.UserInfoDaoImpl3" %>
<%@ page import="com.liusp.bean.UserInfo" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户信息</title>
</head>
<body>
<%
    UserInfo IDuserInfo = (UserInfo) request.getAttribute("editUser");
%>
<form action="userInfoEditController.do" method="post">
    ID：<input type="text" name="uid"  value="<%= IDuserInfo.getUid()%>" ></br>
    用户名：<input type="text" name="uname" value="<%= IDuserInfo.getUname()%>"></br>
    密码：<input type="password" name="password" value="<%= IDuserInfo.getPassword()%>">
    电话：<input type="number" name="phone" value="<%= IDuserInfo.getPhone()%>"></br>
    性别：<input type="radio" name="sex" value="男" <%=IDuserInfo.getSex().equals("男")?"checked":""%>>男
    <input type="radio" name="sex" value="女" <%=IDuserInfo.getSex().equals("女")?"checked":""%> >女</br>
    地址：<input type="text" name="address" value="<%= IDuserInfo.getAddress()%>"></br>
    <input type="submit" value="更新">
</form>
</body>
</html>
