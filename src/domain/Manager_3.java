package domain;

public class Manager_3 {
    private int userid;
    private String username;
    private int enid;
    private String name;
    private int nums;
    private String date;
    private double ticket;
    private double total;

    @Override
    public String toString() {
        return "Manager_3{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", enid=" + enid +
                ", name='" + name + '\'' +
                ", nums=" + nums +
                ", date='" + date + '\'' +
                ", ticket=" + ticket +
                ", total=" + total +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEnid() {
        return enid;
    }

    public void setEnid(int enid) {
        this.enid = enid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTicket() {
        return ticket;
    }

    public void setTicket(double ticket) {
        this.ticket = ticket;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
