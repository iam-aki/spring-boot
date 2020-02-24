package com.iamaki.springboot;

import com.iamaki.springboot.mail.JavaMailComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Spring Boot Application
 *
 * @author Ankit Aggarwal
 */
@SpringBootApplication
public class SpringBootEmailDemoApplication implements CommandLineRunner {

  @Autowired private JavaMailComponent component;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootEmailDemoApplication.class, args);
  }

  @Override
  public void run(String... args) {
    System.out.println("Sending Email");
    try {
      component.sendEmail();
      component.sendEmailWithAttachment();
    } catch (MessagingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Done");
  }
}
