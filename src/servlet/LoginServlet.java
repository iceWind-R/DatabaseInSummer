package servlet;

import service.ManagerService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int role = Integer.parseInt(request.getParameter("role"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = new UserService();
        ManagerService managerService = new ManagerService();
        if (role == 1){ // 普通用户
            if (service.findUserBynameAndPwd(username, password)){
                System.out.println("登陆成功");
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
