package service;

import dao.PersonTicketDao;
import domain.PersonTicket;

import java.util.List;

public class PersonTicketService {
    private PersonTicketDao dao = new PersonTicketDao();


    public List<PersonTicket> findTickets(int userid) {
        return dao.findTickets(userid);
    }

    public void delByEnid(int userid, int enid, String date) {
        dao.del(userid, enid, date);
    }
}
