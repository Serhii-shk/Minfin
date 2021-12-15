package com.minfin.Minfin.service.api.products.v1.list;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CardsDataPathParameters {
    private List<Integer> ids;
    private String locale;
    private int active;
}
