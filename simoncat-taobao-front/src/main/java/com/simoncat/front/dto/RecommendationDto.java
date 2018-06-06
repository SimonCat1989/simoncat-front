package com.simoncat.front.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "RECOMMENDATION")
public class RecommendationDto implements Serializable {

    private static final long serialVersionUID = -6811441059854077830L;

    public static final RecommendationDto EMPTY = new RecommendationDto(-1, "", "", "", "", "", "", "", 0, 0, 0, 0, "",
            "");

    private int id;
    private String title;
    private String author;
    private String authorAvatar;
    private String createMonth;
    private String createMonthSuffix;
    private String createDay;
    private String createYear;
    private int comment;
    private int heart;
    private int twitter;
    private int facebook;
    private String keyword;
    private String description;

    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
    public int getId() {
        return id;
    }

    @Column(name = "TITLE", nullable = false, length = 60)
    public String getTitle() {
        return title;
    }

    @Column(name = "AUTHOR", nullable = false, length = 60)
    public String getAuthor() {
        return author;
    }

    @Column(name = "AUTHOR_AVATAR", nullable = false, length = 100)
    public String getAuthorAvatar() {
        return authorAvatar;
    }

    @Column(name = "CREATE_MONTH", nullable = false, length = 5)
    public String getCreateMonth() {
        return createMonth;
    }

    @Column(name = "CREATE_MONTH_SUFFIX", nullable = false, length = 1)
    public String getCreateMonthSuffix() {
        return createMonthSuffix;
    }

    @Column(name = "CREATE_DAY", nullable = false, length = 2)
    public String getCreateDay() {
        return createDay;
    }

    @Column(name = "CREATE_YEAR", nullable = false, length = 5)
    public String getCreateYear() {
        return createYear;
    }

    @Column(name = "COMMENT", nullable = false)
    public int getComment() {
        return comment;
    }

    @Column(name = "HEART", nullable = false)
    public int getHeart() {
        return heart;
    }

    @Column(name = "TWITTER", nullable = false)
    public int getTwitter() {
        return twitter;
    }

    @Column(name = "FACEBOOK", nullable = false)
    public int getFacebook() {
        return facebook;
    }

    @Column(name = "KEYWORD", nullable = false, length = 100)
    public String getKeyword() {
        return keyword;
    }

    @Column(name = "DESCRIPTION", nullable = false, length = 2000)
    public String getDescription() {
        return description;
    }
}
