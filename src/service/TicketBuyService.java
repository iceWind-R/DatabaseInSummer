package service;

import dao.TicketBuyDao;

public class TicketBuyService {
    private TicketBuyDao dao = new TicketBuyDao();

    public void ticketPurchase(int userid, int enid, int nums) {
        dao.insert(userid,enid,nums);
    }
}
