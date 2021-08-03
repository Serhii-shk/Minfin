package com.minfin.Minfin.ui.dto;

import com.minfin.Minfin.ui.enums.ExchangeProsAndCons;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Review {

    private int id;
    private int rating;
    private List<ExchangeProsAndCons> excellentService;
    private String review;
    private String imagePath;
    private int availabilityRating;
    private int currencyRateRating;
    private int qualityRating;
    private int safetyRating;

}
