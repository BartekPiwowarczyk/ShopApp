package pl.nullpointerexception.shop.order.service.mapper;

import pl.nullpointerexception.shop.order.model.Order;
import pl.nullpointerexception.shop.order.model.dto.OrderListDto;

import java.util.List;

public class OrderDtoMapper {


    public static List<OrderListDto> mapToOrderListDto(List<Order> orders) {
        return orders.stream()
                .map(order -> OrderListDto.builder()
                        .id(order.getId())
                        .placeDate(order.getPlaceDate())
                        .orderStatus(order.getOrderStatus().getValue())
                        .grossValue(order.getGrossValue())
                        .build())
                .toList();
    }
}
