package dao;

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
}

class Test_1{
    public static void main(String[] args) {
        ManagerDao dao = new ManagerDao();
        if (dao.findBynameAndPwd("admin","admin"))
            System.out.println("管理员");
    }
}