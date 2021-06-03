package com.minfin.Minfin.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

    private String login;
    private String email;
    private String password;
    private String role;

}
