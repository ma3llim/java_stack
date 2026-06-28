package EcommerceOrderProcessor.Order;

import EcommerceOrderProcessor.models.Order;

import java.util.LinkedList;
import java.util.List;

public class OrderService {
    List<Order> orders = new LinkedList<>();

    public OrderService(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
