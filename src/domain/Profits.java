package domain;

public class Profits {
    private String date;
    private int enid;
    private String name;
    private int nums;

    @Override
    public String toString() {
        return "Profits{" +
                "date='" + date + '\'' +
                ", enid=" + enid +
                ", name='" + name + '\'' +
                ", nums=" + nums +
                ", profit=" + profit +
                '}';
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    private double profit;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
