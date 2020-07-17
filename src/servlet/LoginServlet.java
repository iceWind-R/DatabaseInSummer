package servlet;

import domain.User;
import service.ManagerService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/loginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (request.getParameter("yzm") != null) {
            if (request.getParameter("yzm").equals(session.getAttribute("yzm").toString()))
                System.out.println("111");
            else
                System.out.println(222);
        }else {
            System.out.println(333);
        }

        int role = Integer.parseInt(request.getParameter("role"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = new UserService();
        ManagerService managerService = new ManagerService();
        if (role == 1){ // 普通用户
            if (service.findUserBynameAndPwd(username, password)){ //登录成功
                User user = service.findUserByname(username);
                session.setAttribute("user",user); // 把当前登录用户的信息存入session

                //跳转到下一个servlet，加载页面的TicketList数据
                response.sendRedirect("userTicketListServlet");
            }else {
                response.setContentType( "text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script>alert('用户名或密码错误');location.href='login.html'</script>");
            }
        } else { //管理员
            if (managerService.findBynameAndPwd(username, password)){
                response.sendRedirect("manager.html");
            }else {
                response.setContentType( "text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script>alert('用户名或密码错误');location.href='login.html'</script>");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
