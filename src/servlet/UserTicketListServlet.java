package servlet;

import domain.UserTicketList;
import service.UserTicketListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/userTicketListServlet",urlPatterns = "/userTicketListServlet")
public class UserTicketListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserTicketListService service = new UserTicketListService();
        List<UserTicketList> lists = service.findAllTicket();

        request.setAttribute("lists",lists);

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
