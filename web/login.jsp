
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <style>
        /*.login{*/
            /*width: 300px;*/
            /*height: 400px;*/
            /*background-color: indianred;*/
        /*}*/
        /*form{*/
            /*width: 200px;*/
            /*height: 200px;*/
            /*border: 1px solid black;*/
            /*margin: auto;*/
            /*margin-top: 50px;*/

        /*}*/
        /*a{*/
            /*text-decoration: none;*/
            /*border: 1px solid indianred;*/
            /*padding: 5px;*/
            /*border-radius: 10%;*/
            /*!*background-color: indianred;*!*/
        /*}*/
        /*a:hover{*/
            /*background-color: red;*/
        /*}*/
    </style>
</head>
<body>
<%
    Cookie []cookies = request.getCookies();

    String uname = "";
    String pwd = "";
    if (cookies != null){
        for (int i = 0 ;i < cookies.length;i++){
            Cookie c = cookies[i];
            if(c.getName().equals("uname")){
                uname = c.getValue();
            }
            if(c.getName().equals("pwd")){
                pwd = c.getValue();
            }
        }
    }
%>
<div align="center" class="login">
    <form action="userInfoLoginController.do" method="post">
        用户名：<input type="text" name="uname"/>
        <br/>
        密   码：<input type="password" name="pwd"/> <br/>
        <input type="checkbox" name="jzmm" value="1">记住密码 <br>
        <input type="submit" value="登录">

    </form>
    <a href="./register.jsp">注册</a>
</div>

</body>

</html>
