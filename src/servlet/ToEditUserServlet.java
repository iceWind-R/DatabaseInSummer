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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/toEditUserServlet",urlPatterns = "/toEditUserServlet")
public class ToEditUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //flag 判断，为1是添加，为2是修改
        int flag = Integer.parseInt(request.getParameter("flag"));
        UserService service = new UserService();

        if(flag == 2) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = service.findUserByNo(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/editUser.jsp").forward(request, response);
        }else if (flag == 1){
            response.sendRedirect("/insertUser.jsp");
        }else if (flag == 3){ // 如果是用户自己查看个人信息
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int id = user.getId();
            User user1 = service.findUserByNo(id);
            request.setAttribute("user", user1);
            System.out.println("传输给用户自己查看的个人信息："+user);
            request.getRequestDispatcher("/editUserByUser.jsp").forward(request, response);

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
