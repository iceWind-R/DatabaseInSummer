package dao;

import domain.Manager_3;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class ManagerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public boolean findBynameAndPwd(String username, String password) {
        String sql = "select * from manager where username = ? and password = ?";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


    public List<Manager_3> manager_3() {

        String sql = "SELECT U.id userid, username, E.id enid, name, nums, date, ticket, nums*ticket total from user U join \n" +
                "ticketbuy T on U.id = T.userid join entertainment E ON T.enid = E.id ORDER BY date";
        List<Manager_3> manager_3 = null;
        try {
            manager_3 = template.query(sql, new BeanPropertyRowMapper<Manager_3>(Manager_3.class));
            return manager_3;
        }
        catch (Exception e){
            return null;
        }
    }

}