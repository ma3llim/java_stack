package EcommerceOrderProcessor.Order;

import EcommerceOrderProcessor.models.Order;
import EcommerceOrderProcessor.utils.OrderStatus;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public List<Order> getOrderStatus(OrderStatus orderStatus){
        Predicate<Order> statusPredicate = order -> order.getStatus() == orderStatus;

        return orders.stream().filter(statusPredicate).collect(Collectors.toList());
    }
}
