<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <title>会员注册信息</title>
    <%
        //设置编码格式，此方法只对post提交起作用，
        //当使用get提交是tomcat则会以ISO8859-1的编码格式来进行编码		 request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String gen = request.getParameter("gen");
        //通过getParameterValues()方法获取字符串数组
        String[] likes = request.getParameterValues("like");
    %>
</head>
<body>
<div align="center">您输入的注册信息
    <table border="0" align="center">
        <tr>
            <td width="100" height="20">用户名：</td>
            <td><%=name%></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><%=pwd%></td>
        </tr>
        <tr>
            <td>电子邮箱：</td>
            <td><%=email%></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><%=gen%></td>
        </tr>
        <tr>
            <td>爱好：</td>
            <td >
                <%
                    if (likes != null) {
                        for (int i = 0; i < likes.length; i++) {
                            out.print(likes[i]+"&nbsp;");
                        }
                    }
                %>
            </td>
        </tr>
    </table>
</div>

<br/>
<%--<%--%>
    <%--/* 获取所有参数的名字 */--%>
    <%--Enumeration pNames=request.getParameterNames();--%>
    <%--while(pNames.hasMoreElements()){--%>
        <%--String name1=(String)pNames.nextElement();--%>
        <%--String value=request.getParameter(name1);--%>
        <%--out.print(name1 + "=" + value+"<br/>");--%>
    <%--}--%>
<%--%>--%>
</body>
</html>