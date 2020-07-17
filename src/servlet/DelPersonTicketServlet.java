package servlet;

import domain.User;
import service.PersonTicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "/delPersonTicketServlet", urlPatterns = "/delPersonTicketServlet")
public class DelPersonTicketServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int enid = Integer.parseInt(request.getParameter("id"));
        PersonTicketService service = new PersonTicketService();

        HttpSession session = request.getSession();
        int userid = ((User) session.getAttribute("user")).getId();
        String date = request.getParameter("date");
        service.delByEnid(userid, enid,date);

        response.setContentType("utf-8");
        response.sendRedirect("personTicketServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
