package pl.nullpointerexception.shop.order.service.mapper;

import pl.nullpointerexception.shop.order.model.Order;

import java.time.format.DateTimeFormatter;

public class OrderEmailMessageMapper {
    public static String createEmailMessage(Order order) {
        return "Your order with id:: " + order.getId() +
                "\nDate: " + order.getPlaceDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                "\nValue: " + order.getGrossValue() + " EUR" +
                "\n\n" +
                "\nPayment: " + order.getPayment().getName() +
                (order.getPayment().getNote() !=null ? "\n" + order.getPayment().getNote() : "") +
                "\n\nThank you for shopping.";
    }
}
