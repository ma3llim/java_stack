package EcommerceOrderProcessor.models;

import EcommerceOrderProcessor.utils.Category;
import EcommerceOrderProcessor.utils.OrderStatus;

import java.time.LocalDate;

public class Order {
    private int orderId;
    private String productName;
    private Category category;
    private int quantity;
    private double price;
    private OrderStatus status;
    private LocalDate date;

    public Order(int orderId, String productName, Category category, int quantity, double price, OrderStatus status, LocalDate date) {
        this.orderId = orderId;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalValue(){
        return price * quantity;
    }

    @Override
    public String toString() {
        String totalValue = String.format("$%,.2f", getTotalValue());
        String formattedPrice = String.format("$%,.2f", price);
        String statusSymbol = status == OrderStatus.COMPLETED ? "✓" : "⏳";

        return String.format("""
            ═══════════════════════════════════════
              ORDER #%d
            ═══════════════════════════════════════
              Product    : %s
              Category   : %s
              Quantity   : %d
              Price      : %s
              Total      : %s
              Status     : %s %s
              Date       : %s
            ═══════════════════════════════════════
            """,
                orderId, productName, category, quantity,
                formattedPrice, totalValue,
                status, statusSymbol, date
        );
    }
}
