package dao;

import domain.PersonTicket;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class PersonTicketDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<PersonTicket> findTickets(int userid) {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "SELECT id,name,species,ticket,note,nums,ticket*nums total,date FROM entertainment E \n" +
                "JOIN ticketbuy T on E.id = T.enid where userid=? ORDER BY date";
        List<PersonTicket> users = template.query(sql, new BeanPropertyRowMapper<PersonTicket>(PersonTicket.class),userid);

        return users;
    }


    public void del(int userid, int enid, String date) {
        String sql = "delete from ticketBuy where userid=? and enid=? and date=?";
        template.update(sql, userid, enid, date);
    }
}
