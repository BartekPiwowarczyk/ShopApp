package pl.nullpointerexception.shop.admin.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nullpointerexception.shop.admin.order.model.AdminOrder;
import pl.nullpointerexception.shop.common.mail.EmailClientService;
import pl.nullpointerexception.shop.common.model.OrderStatus;

import static pl.nullpointerexception.shop.admin.order.service.AdminOrderEmailMessage.*;

@Service
@RequiredArgsConstructor
class EmailNotificationForStatusChange {

    private final EmailClientService emailClientService;
    void sendEmailNotification(OrderStatus newStatus, AdminOrder adminOrder) {
        if(newStatus == OrderStatus.PROCESSING) {
            sendEmail(adminOrder.getEmail(),
                    "Zamówienie " + adminOrder.getId() + " zmieniło status na: " + newStatus.getValue(),
                    createProcessingEmailMessage(adminOrder.getId(), newStatus));
        }else if (newStatus == OrderStatus.COMPLETED) {
            sendEmail(adminOrder.getEmail(),
                    "Zamówienie " + adminOrder.getId() + " zostało zrealizowane",
                    createCompletedEmailMessage(adminOrder.getId(), newStatus));
        } else if ((newStatus == OrderStatus.REFUND)) {
            sendEmail(adminOrder.getEmail(),
                    "Zamówienie " + adminOrder.getId() + " zostało zwrócone",
                    createRefundEmailMessage(adminOrder.getId(), newStatus));
        }
    }

    private void sendEmail(String email, String subject, String message) {
        emailClientService.getInstance().send(email,subject,message);
    }
}
