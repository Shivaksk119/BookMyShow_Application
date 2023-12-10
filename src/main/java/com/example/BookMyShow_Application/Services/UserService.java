package com.example.BookMyShow_Application.Services;

import com.example.BookMyShow_Application.Models.User;
import com.example.BookMyShow_Application.Repository.UserRepository;
import com.example.BookMyShow_Application.RequestDtos.AddUserRequest;
import com.example.BookMyShow_Application.Transformers.UserTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    public String addUser(AddUserRequest userRequest) {

        //Need to create an user Object and  save it to DB
//        User user = new User();
//        user.setAge(userRequest.getAge());
//        user.setEmailId(userRequest.getEmailId());
//        user.setMobNo(userRequest.getMobNo());

        //obj creating using builder obj
        User userObj = UserTransformers.convertAddUserReqToUserEntity(userRequest);

        userRepository.save(userObj);   // if Id is not created --> it will create new Id
                                        // if ID is created --> Update the value associated with the ID
        //Sending Mail
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String body = "Hello "+userObj.getName() + "Your account has been succesfully created."+'\n'+"You can start booking shows now.";

        //sending Mails
        mailMessage.setFrom("springaccio@gmail.com");
        mailMessage.setTo(userObj.getEmailId());
        mailMessage.setSubject("Account Created");
        mailMessage.setText(body);

        mailSender.send(mailMessage);
        return "User added successfully";
    }
}
