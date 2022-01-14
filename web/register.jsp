
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>

<form action="userInfoRegisterController.do" method="post">
    用户名： <input type="text" name="uname"></br>
    密码：<input type="password" name="password"></br>
    电话：<input type="number" name="phone"></br>
    性别：<input type="radio" name="sex" value="男">男<input type="radio" name="sex" value="女">女</br>
    地址：<input type="text" name="address">
    <input type="submit" value="提交">
</form>
</body>
</html>
