package org.example.subject;

import org.example.observer.Oberserver;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject{
    private String stockName;
    private double price;
    private List<Oberserver> oberserverList;

    public Stock(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        this.oberserverList = new ArrayList<>();
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public List<Oberserver> getOberserverList() {
        return oberserverList;
    }

    public void setOberserverList(List<Oberserver> oberserverList) {
        this.oberserverList = oberserverList;
    }

    @Override
    public void subscribe(Oberserver oberserver) {
        oberserverList.add(oberserver);
    }

    @Override
    public void unsubscribe(Oberserver oberserver) {
        oberserverList.remove(oberserver);
    }

    @Override
    public void notifyObservers() {
        oberserverList.forEach(oberserver -> oberserver.update(stockName, price));
    }
}
