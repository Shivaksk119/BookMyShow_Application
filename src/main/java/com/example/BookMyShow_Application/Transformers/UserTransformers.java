package com.example.BookMyShow_Application.Transformers;

import com.example.BookMyShow_Application.Models.User;
import com.example.BookMyShow_Application.RequestDtos.AddUserRequest;

public class UserTransformers {

    public static User convertAddUserReqToUserEntity(AddUserRequest userRequest) {
        User userObj = User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .emailId(userRequest.getEmailId())
                .mobNo(userRequest.getMobNo())
                .build();

        return userObj;
    }
}
