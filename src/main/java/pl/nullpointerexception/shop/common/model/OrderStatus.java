package pl.nullpointerexception.shop.common.model;

public enum OrderStatus {
    NEW("New"),
    PAID("Paid"),
    PROCESSING("Processing"),
    WAITING_FOR_DELIVERY("Waitting for delivery"),
    COMPLETED("Completed"),
    CANCELED("Canceled"),
    REFUND("Refund");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
