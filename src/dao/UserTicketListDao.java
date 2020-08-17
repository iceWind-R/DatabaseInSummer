package dao;

import domain.Entertainment;
import domain.UserTicketList;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class UserTicketListDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<UserTicketList> findAllTicket() {
        String sql = "select id,name,species,ticket,ticketNums total,ticketNums-SUM(nums) remaining,note from entertainment E join ticketbuy T on E.id=T.enid GROUP BY id";
        List<UserTicketList> lists = null;
        try {
            lists = template.query(sql, new BeanPropertyRowMapper<UserTicketList>(UserTicketList.class));
            return lists;
        }
        catch (Exception e){
            return null;
        }
    }

    public static void main(String[] args) {
        UserTicketListDao dao = new UserTicketListDao();
        List<UserTicketList> all = dao.findAllTicket();
        for (int i = 0 ;i<all.size();i++)
            System.out.println(all.get(i));
    }
}
