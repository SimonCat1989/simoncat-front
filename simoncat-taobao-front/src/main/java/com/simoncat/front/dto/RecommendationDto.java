package com.simoncat.front.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendationDto {

    public static final RecommendationDto EMPTY = new RecommendationDto("", "", "", "", "", "", "", "", 0, 0, 0, 0, "",
            "", "");

    private final String contentId;
    private final String title;
    private final String author;
    private final String authorAvatar;
    private final String createMonth;
    private final String createMonthSuffix;
    private final String createDay;
    private final String createYear;
    private final int comment;
    private final int heart;
    private final int twitter;
    private final int facebook;
    private final String image;
    private final String keyword;
    private final String description;
}
