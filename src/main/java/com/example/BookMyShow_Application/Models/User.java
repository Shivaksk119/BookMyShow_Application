package com.example.BookMyShow_Application.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="user")
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId; // if Id is not created --> it will create new Id
                        // if ID is created --> Update the value associated with the ID

    private String name;

    @Column(unique = true)
    private String emailId;

    @Column(unique = true)
    private String mobNo;

    private Integer age;

    @OneToMany(mappedBy = "user", cascade =  CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();
}
