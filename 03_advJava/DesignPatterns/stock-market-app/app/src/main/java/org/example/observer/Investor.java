package org.example.observer;

public class Investor implements Oberserver{
    private String investorName;

    public Investor(String investorName) {
        this.investorName = investorName;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    @Override
    public void update(String stock, double price) {
        System.out.println(investorName + "Notified: " + stock + " changed to " + price);
    }
}
