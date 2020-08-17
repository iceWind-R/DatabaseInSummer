package dao;

import domain.TicketBuy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketBuyDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public boolean findOne() {
        String sql = "select * from ticketBuy";
        TicketBuy ticketBuy = null;
        try {
            ticketBuy = template.queryForObject(sql, new BeanPropertyRowMapper<TicketBuy>(TicketBuy.class));
            System.out.println(ticketBuy);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void insert(int userid, int enid, int nums) {

        Date dat = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dat);

        //查找今天日期的记录是否存在
        String sql = "select * from ticketBuy where userid=? and enid=? and date=?";
        TicketBuy ticketBuy = null;
        try {
            ticketBuy = template.queryForObject(sql, new BeanPropertyRowMapper<TicketBuy>(TicketBuy.class), userid,enid,date);
        }
        catch (Exception e){
            System.out.println(date);
        }

        if (ticketBuy == null){ // 说明没查到，即不存在，此时insert语句
            sql = "insert into ticketbuy VALUES (?,?,?,?)";
            template.update(sql, userid,enid,date,nums);
        } else { // 执行update语句
            sql = "update ticketbuy set nums = nums + ? where userid=? and enid = ? and date=?";
            template.update(sql, nums,userid,enid,date);
        }

    }


}
