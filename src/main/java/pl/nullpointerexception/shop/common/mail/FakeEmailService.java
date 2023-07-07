package pl.nullpointerexception.shop.common.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
public class FakeEmailService implements EmailSender{
    @Override
    public void send(String to, String subject, String msg) {
        log.info("Email send");
        log.info("To " + to);
        log.info("Subject " + subject);
        log.info("Message " + msg);
    }
}
