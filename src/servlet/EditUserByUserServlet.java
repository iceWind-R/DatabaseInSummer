package servlet;

import domain.User;
import domain.UserTicketList;
import service.UserService;
import service.UserTicketListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "/editUserByUserServlet", urlPatterns = "/editUserByUserServlet")
public class EditUserByUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);

        UserService service = new UserService();
        service.updateUser(user);



        UserTicketListService service1 = new UserTicketListService();
        List<UserTicketList> lists = service1.findAllTicket();

        request.setAttribute("lists",lists);


        response.setContentType( "text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<script>alert('修改个人信息成功');</script>");

        request.getRequestDispatcher("/index.jsp").forward(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
