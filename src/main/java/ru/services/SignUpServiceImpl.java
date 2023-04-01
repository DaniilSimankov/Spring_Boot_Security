package ru.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dto.SignUpForm;
import ru.models.Account;
import ru.repositories.AccountsRepository;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final JavaMailSender mailSender;

    private final PasswordEncoder passwordEncoder;
    private final AccountsRepository accountsRepository;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void signUp(SignUpForm form) {
        Account account = Account.builder()
                .email(form.getEmail().toLowerCase(Locale.ROOT))
                .fistName(form.getFirstName())
                .lastName(form.getLastName())
                .password(passwordEncoder.encode(form.getPassword()))
                .role(Account.Role.USER)
                .state(Account.State.NOT_CONFIRMED)
                .build();

        sendMail("<h1>Вы Зарегестрированы</h1>", "Регистрация", from, account.getEmail());
        accountsRepository.save(account);
    }

    private void sendMail(String text, String subject, String from, String to){
        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setText(text, true);
            messageHelper.setTo(to);
            messageHelper.setFrom(from);
            messageHelper.setSubject(subject);
        };

        mailSender.send(preparator);
    }
}
