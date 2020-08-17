package dao;

import domain.Entertainment;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<User> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    public User findUserByname(String username) {
        String sql = "select * from user where username = ?";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
            return user;
        }
        catch (Exception e){
            return null;
        }
    }

    public boolean insertUser(User user) {
        String sql = "insert into user values(null,?,?,?,?)";
        //2.执行sql
        int update = template.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getPhone());
        if (update > 0) return true;
        else return false;
    }

    public User findUserByNo(int id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);

        return user;
    }

    public void updateUser(User user) {
        String sql = "update user set username = ?,password = ?, email = ?, phone = ? where id = ?";
        template.update(sql, user.getUsername(),user.getPassword(), user.getEmail(), user.getPhone(), user.getId());
    }

    public void delUser(int id) {
        //1.定义sql
        String sql = "delete from user where id = ?";
        //2.执行sql
        template.update(sql, id);
    }

    public boolean findUserBynameAndPwd(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
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
class Test{
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        if (dao.findUserBynameAndPwd("dongao","dongao"))
            System.out.println("1");
        else
            System.out.println("2");
    }
}