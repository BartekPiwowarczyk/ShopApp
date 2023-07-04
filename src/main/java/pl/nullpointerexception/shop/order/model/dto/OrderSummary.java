package pl.nullpointerexception.shop.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.nullpointerexception.shop.order.model.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class OrderSummary {
    private Long id;
    private LocalDateTime placeDate;
    private OrderStatus status;
    private BigDecimal grossValue;

}