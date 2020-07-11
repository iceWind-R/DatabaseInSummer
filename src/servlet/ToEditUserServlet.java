package servlet;

import domain.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toEditUserServlet")
public class ToEditUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //flag 判断，为1是添加，为2是修改
        int flag = Integer.parseInt(request.getParameter("flag"));

        if(flag == 2) {
            int id = Integer.parseInt(request.getParameter("id"));
            UserService service = new UserService();
            User user = service.findUserByNo(id);
            //2.将list存入request域
            request.setAttribute("user", user);
            //3.转发到list.jsp
            request.getRequestDispatcher("/editUser.jsp").forward(request, response);
        }else {
            response.sendRedirect("/insertUser.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
