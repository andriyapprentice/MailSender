package ua.com.owu.servsice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ua.com.owu.entity.User;
import ua.com.owu.servsice.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    public JavaMailSender javaMailSender;

    @Override
    public void sendEmail(User user) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);

        try {
            helper.setTo(user.getEmail());
            helper.setText("<h3>hello my friend</h3>"+user.getName()+user.getAvatar(),true);
            helper.setFrom("ponizhay@gmail.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
javaMailSender.send(mimeMessage);
    }
}
