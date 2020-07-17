package domain;

import java.sql.Date;

public class TicketBuy {
    private int userid;
    private int enid;
    private String date;
    private int nums;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getEnid() {
        return enid;
    }

    public void setEnid(int enid) {
        this.enid = enid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "TicketBuyService{" +
                "userid=" + userid +
                ", enid=" + enid +
                ", date=" + date +
                ", nums=" + nums +
                '}';
    }
}
