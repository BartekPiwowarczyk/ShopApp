package pl.nullpointerexception.shop.admin.order.service;

import pl.nullpointerexception.shop.common.model.OrderStatus;

public class AdminOrderEmailMessage {
    public static String createProcessingEmailMessage(Long id, OrderStatus newStatus) {
        return "Your order with id: " + id + " is being processed" +
                "\nStatus has been changed to " + newStatus.getValue() +
                "\nour order is being processed by our staff" +
                "\nAfter completion, we will immediately send them for shipment" +
                "\n\nGreetings" +
                "\nShop";

    }

    public static String createCompletedEmailMessage(Long id, OrderStatus newStatus) {
        return "Your order with id: " + id + " has been processed." +
                "\nYour order status has been changed to: " + newStatus.getValue() +
                "\n\nThank you for shopping and we invite you again" +
                "\nShop";
    }

    public static String createRefundEmailMessage(Long id, OrderStatus newStatus) {
        return "Your order with id:" + id + " has been returned." +
                "\nYour order status has been changed to: " + newStatus.getValue() +
                "\n\nGreetings\"" +
                "\nShop";
    }
}
