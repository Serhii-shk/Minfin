package com.minfin.Minfin.api.model.minfin.api.user.register;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    String email;
    String password;
    String login;
    boolean privacy;
    boolean rules;
    int check;
    String firstName;
    String phone;
}
