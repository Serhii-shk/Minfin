package com.minfin.Minfin.api.model.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminProfile {
    String accessToken;
    String refreshToken;

}
