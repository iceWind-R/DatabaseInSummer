package dao;

import domain.Entertainment;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class EntertainmentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Entertainment> findAll() {

        // 该sql语句仍然存在问题
        String sql = "SELECT id, name, species, ticket, cost, note, ticketNums, ticketNums -  SUM(nums) remaining_nums\n" +
                " from entertainment E JOIN ticketbuy T on E.id = T.enid GROUP BY id";
        List<Entertainment> entertainments = template.query(sql, new BeanPropertyRowMapper<Entertainment>(Entertainment.class));

        return entertainments;

    }

    public List<Entertainment> findByUser(String name, String type) {

        // 该sql语句仍然存在问题
        String sql = "SELECT id, name, species, ticket, cost, note, ticketNums, ticketNums -  SUM(nums) remaining_nums from entertainment E JOIN ticketbuy T on E.id = T.enid where name LIKE '%"+ name +"%' OR species LIKE '%"+ type +"%' GROUP BY id ";
        List<Entertainment> entertainments = template.query(sql, new BeanPropertyRowMapper<Entertainment>(Entertainment.class));

        return entertainments;

    }

    public static void main(String[] args) {
        EntertainmentDao dao = new EntertainmentDao();
        List<Entertainment> all = dao.findByUser("摩", "");
        for (int i = 0; i<all.size(); i++)
            System.out.println(all.get(i));
    }
}
