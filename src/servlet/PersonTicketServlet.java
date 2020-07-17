package servlet;

import domain.PersonTicket;
import domain.User;
import service.PersonTicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/personTicketServlet", urlPatterns = "/personTicketServlet")
public class PersonTicketServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userid = ((User) session.getAttribute("user")).getId();

        PersonTicketService service = new PersonTicketService();
        List<PersonTicket> lists = service.findTickets(userid);

        request.setAttribute("lists",lists);
        //3.转发到list.jsp
        request.getRequestDispatcher("/person_ticket.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
