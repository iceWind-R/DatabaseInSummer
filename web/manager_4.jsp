<%@ page import="domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.Manager_3" %>
<%@ page import="domain.Profits" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 管理员后台查看所有用户的信息表 -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/01.css" type="text/css">
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="header" id="head">
    <div class="title">管理员后台管理</div>
</div>

<div class="wrap" id="wrap">
    <div class="register">
        <div style="float: right;margin: 5px">
            <a class="btn btn-primary" onclick="JavaScript:history.go(-1)">返回</a>
        </div>
        <table class="table11_6"; width="100%" style="font-size: 16px">
            <tr>
                <th>日期</th>
                <th>项目ID</th>
                <th>项目名</th>
                <th>利润</th>
                <th>操作</th>
            </tr>
            <%
                @SuppressWarnings("unchecked")
                ArrayList<Profits> list = (ArrayList<Profits>) request.getAttribute("lists");
                for (Profits bi : list) {
                    int id = bi.getEnid();
            %>
            <tr>
                <td><%=bi.getDate()%></td>
                <td><%=id%></td>
                <td><%=bi.getName()%></td>
                <td><%=bi.getProfit()%></td>
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
