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

@WebServlet(name = "/queryServlet", urlPatterns = "/queryServlet")
public class queryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String type = request.getParameter("type");

        System.out.println("查询的name：" + name +", type:"+ type);

        UserTicketListService service = new UserTicketListService();
        List<UserTicketList> lists = service.findTicketByUser(name, type);

        request.setAttribute("lists",lists);
        //3.转发到list.jsp
        request.getRequestDispatcher("/index_results.jsp").forward(request,response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
