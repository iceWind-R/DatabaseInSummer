package dao;

import domain.Profits;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class ProfitsDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Profits> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from profit";
        List<Profits> list = template.query(sql, new BeanPropertyRowMapper<Profits>(Profits.class));

        return list;
    }

    public static void main(String[] args) {
        ProfitsDao dao = new ProfitsDao();
        System.out.println(dao.findAll().get(0));
    }
}
