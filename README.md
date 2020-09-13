# DatabaseInSummer
————数据库开发的暑期综合训练
---
记录存在的问题：
1. 验证码的校验未能完成，显示验证码的<img>标签已经存在，添加验证码即可。（已完成，但形式不太好看，指定为黄色底色）
2. 忘记密码页
3. 用户登录后的个人信息修改和管理员的修改用户信息为同一个界面同一个Servlet，但我为方便都给复制了一份，即editUser.jsp和editUserByUser.jsp，editUserServlet和jsp和editUserByUserServlet几乎为重复代码。
    
    改善方案：
    - 用户的修改和管理员的修改权限不同，可改信息不同，增加数据库User表项。
4. profit利润计算：在用户购票时绑定的事件，即用户购买票，则profit增加或更新数据。暂时还未能实现删除票据时的事件监听。