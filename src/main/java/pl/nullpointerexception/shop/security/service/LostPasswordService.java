package pl.nullpointerexception.shop.security.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.nullpointerexception.shop.common.mail.EmailClientService;
import pl.nullpointerexception.shop.security.model.User;
import pl.nullpointerexception.shop.security.model.dto.ChangePassword;
import pl.nullpointerexception.shop.security.model.dto.EmailObject;
import pl.nullpointerexception.shop.security.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LostPasswordService {

    private final UserRepository userRepository;
    private final EmailClientService emailClientService;
    @Value("${app.serviceAddress}")
    private String serviceAddress;

    @Transactional
    public void sendLostPasswordLink(EmailObject email) {
        User user = userRepository.findByUsername(email.getEmail())
                .orElseThrow(() -> new RuntimeException("This email doesn't exist"));
        String hash = generateHashForLostPassword(user);
        user.setHash(hash);
        user.setHashDate(LocalDateTime.now());
        emailClientService.getInstance()
                .send(email.getEmail(), "Reset your password", createMessage(createLink(hash)));
    }

    private String generateHashForLostPassword(User user) {
        String toHash = user.getId() + user.getUsername() + user.getPassword() + LocalDateTime.now();
        return DigestUtils.sha256Hex(toHash);
    }

    private String createLink(String hash) {
        return serviceAddress + "/lostPassword/" + hash;
    }

    private String createMessage(String hashLink) {
        return "We have generated a link for you to change your password" +
                "\n\nClick on the link to reset your password: " +
                "\n" + hashLink +
                "\n\nThank you.";
    }

    @Transactional
    public void changePassword(ChangePassword changePassword) {
        if(!Objects.equals(changePassword.getPassword(),
                changePassword.getRepeatPassword())) {
            throw new RuntimeException("The passwords are not the same");
        }
        User user = userRepository.findByHash(changePassword.getHash())
                .orElseThrow(() -> new
                        RuntimeException("Invalid link"));
        if(user.getHashDate().plusMinutes(10)
                .isAfter(LocalDateTime.now())){
            user.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(changePassword.getPassword()));
            user.setHash(null);
            user.setHashDate(null);
        } else {
            throw new RuntimeException("The link has expired");
        }
    }

}
