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
@Table(name = "BOOK")
public class RecommendationDto implements Serializable {

    private static final long serialVersionUID = -6811441059854077830L;

    public static final RecommendationDto EMPTY = new RecommendationDto(-1, "", "", "", "", "", "", "", 0, 0, 0, 0, "",
            "", "");

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
    private String image;
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

    
    public String getCreateMonth() {
        return createMonth;
    }

    public String getCreateMonthSuffix() {
        return createMonthSuffix;
    }

    public String getCreateDay() {
        return createDay;
    }

    public String getCreateYear() {
        return createYear;
    }

    public int getComment() {
        return comment;
    }

    public int getHeart() {
        return heart;
    }

    public int getTwitter() {
        return twitter;
    }

    public int getFacebook() {
        return facebook;
    }

    public String getImage() {
        return image;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getDescription() {
        return description;
    }
}
