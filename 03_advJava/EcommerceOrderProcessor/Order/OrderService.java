package EcommerceOrderProcessor.Order;

import EcommerceOrderProcessor.models.Order;
import EcommerceOrderProcessor.utils.Category;
import EcommerceOrderProcessor.utils.OrderStatus;

import java.time.Month;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    public List<Order> getOrderStatus(OrderStatus orderStatus) {
        Predicate<Order> statusPredicate = order -> order.getStatus() == orderStatus;

        return orders.stream().filter(statusPredicate).collect(Collectors.toList());
    }

    public double totalRevenue() {
        return orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.COMPLETED)
                .map(order -> order.getPrice() * order.getQuantity())
                .reduce(0.0, (a, b) -> a + b);
    }

    public Map<Month, Double> monthlyRevenue() {
        return orders.stream().collect(
                Collectors.groupingBy(
                        order -> order.getDate().getMonth(),
                        Collectors.summingDouble(order -> order.getPrice() * order.getQuantity())
                ));
    }

    public Map<Category, List<Order>> groupingByCategory() {
        return orders.stream().collect(
                Collectors.groupingBy(Order::getCategory)
        );
    }


    public List<Order> mostExpensiveOrder() {
        return orders.stream()
                .sorted(Comparator.comparingDouble((Order o) -> o.getPrice() * o.getQuantity()))
                .limit(5).toList();
    }
}
