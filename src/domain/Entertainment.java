package domain;

public class Entertainment {
    private int id;
    private String name;
    private double ticket;
    private double cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTicket() {
        return ticket;
    }

    public void setTicket(double ticket) {
        this.ticket = ticket;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
