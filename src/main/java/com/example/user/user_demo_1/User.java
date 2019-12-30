package com.example.user.user_demo_1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tblUser")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String email;

    private String password;
}
