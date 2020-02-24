package com.iamaki.springboot.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

/**
 * Java Mail Component
 *
 * @author Ankit Aggarwal
 */
@Component
public class JavaMailComponent {

  @Autowired private JavaMailSender javaMailSender;

  public void sendEmail() {
    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo("to_@gmail.com");
    msg.setSubject("Testing from Spring Boot");
    msg.setText("Hello World \n Spring Boot Email");
    javaMailSender.send(msg);
  }

  public void sendEmailWithAttachment() throws MessagingException, IOException {
    MimeMessage msg = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(msg, true);
    helper.setTo("to_@gmail.com");
    helper.setSubject("Testing from Spring Boot");
    helper.setText("<h1>Check attachment for image!</h1>", true);
    helper.addAttachment("tenor.gif", new ClassPathResource("tenor.gif"));
    javaMailSender.send(msg);
  }
}
