package EcommerceOrderProcessor;

import EcommerceOrderProcessor.Order.OrderService;
import EcommerceOrderProcessor.models.Order;
import EcommerceOrderProcessor.utils.Category;
import EcommerceOrderProcessor.utils.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new java.util.ArrayList<>();
        orders.add(new Order(1, "Laptop", Category.ELECTRONICS, 2, 1200.00, OrderStatus.COMPLETED, LocalDate.of(2026, 1, 15)));
        orders.add(new Order(2, "T-Shirt", Category.CLOTHING, 5, 25.99, OrderStatus.PENDING, LocalDate.of(2026, 1, 20)));
        orders.add(new Order(3, "Rice Cooker", Category.HOME_APPLIANCES, 1, 89.99, OrderStatus.COMPLETED, LocalDate.of(2026, 2, 1)));
        orders.add(new Order(4, "iPhone", Category.ELECTRONICS, 1, 999.99, OrderStatus.COMPLETED, LocalDate.of(2026, 2, 10)));
        orders.add(new Order(5, "Novel", Category.BOOKS, 3, 15.50, OrderStatus.PENDING, LocalDate.of(2026, 2, 15)));
        orders.add(new Order(6, "Sofa", Category.HOME_APPLIANCES, 1, 450.00, OrderStatus.COMPLETED, LocalDate.of(2026, 3, 5)));
        orders.add(new Order(7, "Headphones", Category.ELECTRONICS, 3, 89.99, OrderStatus.COMPLETED, LocalDate.of(2026, 3, 12)));
        orders.add(new Order(8, "Jeans", Category.CLOTHING, 2, 45.50, OrderStatus.PENDING, LocalDate.of(2026, 3, 18)));
        orders.add(new Order(9, "Cookbook", Category.BOOKS, 1, 35.00, OrderStatus.COMPLETED, LocalDate.of(2026, 4, 2)));
        orders.add(new Order(10, "TV", Category.ELECTRONICS, 2, 799.99, OrderStatus.COMPLETED, LocalDate.of(2026, 4, 10)));
        orders.add(new Order(11, "Shoes", Category.CLOTHING, 1, 89.99, OrderStatus.PENDING, LocalDate.of(2026, 4, 20)));
        orders.add(new Order(12, "Blender", Category.HOME_APPLIANCES, 2, 59.99, OrderStatus.COMPLETED, LocalDate.of(2026, 5, 1)));
        orders.add(new Order(13, "Tablet", Category.ELECTRONICS, 1, 499.99, OrderStatus.COMPLETED, LocalDate.of(2026, 5, 10)));
        orders.add(new Order(14, "Jacket", Category.CLOTHING, 1, 120.00, OrderStatus.CANCELLED, LocalDate.of(2026, 5, 15)));
        orders.add(new Order(15, "Microwave", Category.HOME_APPLIANCES, 1, 299.99, OrderStatus.COMPLETED, LocalDate.of(2026, 6, 1)));
        OrderService orderService = new OrderService(orders);
        List<Order> orderByStatusPENDING = orderService.getOrderStatus(OrderStatus.PENDING);
        List<Order> orderByStatusCOMPLETED = orderService.getOrderStatus(OrderStatus.COMPLETED);
        List<Order> orderByStatusCANCELLED = orderService.getOrderStatus(OrderStatus.CANCELLED);

        System.out.println(orderService.monthlyRevenue());


    }
}
