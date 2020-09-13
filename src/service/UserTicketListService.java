package service;

import dao.UserTicketListDao;
import domain.UserTicketList;

import java.util.List;

public class UserTicketListService {

    private UserTicketListDao dao = new UserTicketListDao();

    public List<UserTicketList> findAllTicket() {
        return dao.findAllTicket();
    }

    public List<UserTicketList> findTicketByUser(String name, String type) {
        return dao.findTicketByUser(name, type);
    }
}
