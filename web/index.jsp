<%@ page import="domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.UserTicketList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>游乐场主页面</title>
    <link rel="stylesheet" href="css/01.css" type="text/css">
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="header" id="head">
    <div class="title">欢迎光临游乐场售票主页</div>
</div>

<div class="wrap" id="wrap">
    <div class="container">
        <h3 style="text-align: center">游乐场门票列表</h3>

        <div style="float: left;">

            <form class="form-inline">
                <div class="form-group">
                    <label for="exampleInputName2" style="color: #95fcff;">娱乐名</label>
                    <input type="text" class="form-control" id="exampleInputName2">
                </div>
                <div class="form-group">
                    <label for="exampleInputName3" style="color: #cd5cff;">娱乐种类</label>
                    <input type="text" class="form-control" id="exampleInputName3">
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>

        </div>


        <div style="float:right ;margin: 5px;">
            <span>欢迎您，<%=((User)session.getAttribute("user")).getUsername()%>！&nbsp;&nbsp;&nbsp;</span>
            <a class="btn btn-primary" href="login.html">退出登录</a>
            <a class="btn btn-primary" href="toEditUserServlet?flag=3">个人信息</a>
            <a class="btn btn-primary" href="personTicketServlet">订单查询</a>
        </div>


        <table border="1" class="table table-bordered table-hover" style="background-color: snow">
            <tr class="success">
                <th>编号</th>
                <th>项目名</th>
                <th>娱乐种类</th>
                <th>门票金额</th>
                <th>门票总数</th>
                <th>剩余门票</th>
                <th>备注</th>
                <th>购买数量</th>
                <th>操作</th>
            </tr>

            <%
                @SuppressWarnings("unchecked")
                ArrayList<UserTicketList> lists = (ArrayList<UserTicketList>) request.getAttribute("lists");
                for (UserTicketList bi : lists) {
                    int id = bi.getId();
            %>
            <tr>
                <td><%=id%></td>
                <td><%=bi.getName()%></td>
                <td><%=bi.getSpecies()%></td>
                <td><%=bi.getTicket()%></td>
                <td><%=bi.getTotal()%></td>
                <td><%=bi.getRemaining()%></td>
                <td><%=bi.getNote()%></td>
                <td>
                    <select name="<%="nums" + id%>">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </td>
                <td>
                    <a href="buyTicketServlet?id=<%=id%>">确认购买</a>
                </td>
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