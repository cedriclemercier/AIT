package com.example.midterm.service;

import com.example.midterm.dao.UserJPADao;
import com.example.midterm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserJPADao userdao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    private EmailService emailService;

    @Override
    public void save(User user) {
        System.out.println("here");
        String hashedPassword = bcryptEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setActive(true);
        userdao.save(user);

        // Send email in case of successful registration
        SimpleMailMessage emailMsg = new SimpleMailMessage();
        emailMsg.setTo(user.getEmail());
        emailMsg.setText("You are registered!");
        emailMsg.setSubject("Registration successful!");
        emailMsg.setFrom("admin@random.asia");

        try {
            emailService.sendEmail(emailMsg);
            System.out.println("Successful");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public User findByUsername(String username) {
        return userdao.findByUsername(username);
    }
}
