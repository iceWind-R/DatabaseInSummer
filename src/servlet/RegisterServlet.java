package servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "/registerServlet", urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、判断用户名不重复
        UserService service = new UserService();
        String username = request.getParameter("username");

        // 如果找到，即username重复了
        if (service.findUserByname(username) != null){
            response.setContentType( "text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('用户名重复');location.href='register.html'</script>");
        }
        else {
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            if (service.insertUser(user)){
                response.setContentType( "text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script>alert('注册成功');location.href='register.html'</script>");
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
