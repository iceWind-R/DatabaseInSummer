<%@ page import="domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 管理员后台查看所有用户的信息表 -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/01.css" type="text/css">
</head>
<body>
<div class="header" id="head">
    <div class="title">管理员后台管理</div>
</div>

<div class="wrap" id="wrap">
    <div class="register">
        <div style="font-size: 30px;text-align: center; color: #2aabd2;padding-top: 10px;padding-bottom: 10px">
            <a href="toEditUserServlet?flag=1"  style="text-decoration: none;">添加用户信息</a>
        </div>
        <table class="table11_6"; width="100%">
            <tr>
                <th>用户编号</th>
                <th>用户账号</th>
                <th>用户密码</th>
                <th>操作</th>
            </tr>
            <%
                @SuppressWarnings("unchecked")
                ArrayList<User> list = (ArrayList<User>) request.getAttribute("users");
                for (User bi : list) {
                    int id = bi.getId();
            %>
            <tr>
                <td><%=id%></td>
                <td><%=bi.getUsername()%></td>
                <td><%=bi.getPassword()%></td>
                <td><a href="toEditUserServlet?id=<%=id%>&flag=2">修改/查看</a> &nbsp;&nbsp;&nbsp;
                    <a href="deleteUserServlet?id=<%=id%>" onclick="if(confirm('确认删除吗？')==false)return false;">删除</a></td>
            </tr>
            <%
                }
            %>

        </table>
    </div>
</div>

<div class="footer" id="foot">
    <div class="copyright">
        <p>Copyright © 2020</p>
        <div class="img">
            <i class="icon"></i><span>联系邮箱：thorine612@gmail.com</span>
        </div>
        <div class="img">
            <i class="icon1"></i><span>联系地址：石家庄铁道大学</span>
        </div>
    </div>
</div>
</body>
</html>
