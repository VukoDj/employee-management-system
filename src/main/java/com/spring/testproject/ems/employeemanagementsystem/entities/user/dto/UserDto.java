package com.spring.testproject.ems.employeemanagementsystem.entities.user.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String role;
}
