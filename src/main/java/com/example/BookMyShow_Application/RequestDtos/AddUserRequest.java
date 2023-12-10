package com.example.BookMyShow_Application.RequestDtos;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    private String name;

    private String emailId;

    private String mobNo;

    private Integer age;

}
