package servlet;

import com.mysql.cj.Session;
import domain.User;
import domain.UserTicketList;
import service.TicketBuyService;
import service.UserTicketListService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "/buyTicketServlet",urlPatterns = "/buyTicketServlet")
public class BuyTicketServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int enid = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        int userid = ((User)session.getAttribute("user")).getId();

        int nums = 1; // 从前台提交购票数量未能实现，此处使用假数据

        TicketBuyService service = new TicketBuyService();
        service.ticketPurchase(userid, enid, nums);

        response.setContentType( "text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<script>alert('购买成功');</script>");

        UserTicketListService service1 = new UserTicketListService();
        List<UserTicketList> lists = service1.findAllTicket();

        request.setAttribute("lists",lists);

        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
