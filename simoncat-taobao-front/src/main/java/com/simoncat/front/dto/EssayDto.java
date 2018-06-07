package com.simoncat.front.dto;

import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
@Data
@Entity
@Table(name = "essay")
public class EssayDto {

    public static final EssayDto EMPTY = new EssayDto(-1, "", "", "", "", "", "", "", 0, 0, 0, 0, "", "",
            Collections.emptySet());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private String authorAvatar;
    @NonNull
    private String createMonth;
    @NonNull
    private String createMonthSuffix;
    @NonNull
    private String createDay;
    @NonNull
    private String createYear;
    @NonNull
    private Integer comment;
    @NonNull
    private Integer heart;
    @NonNull
    private Integer twitter;
    @NonNull
    private Integer facebook;
    @NonNull
    private String keyword;
    @NonNull
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "essayCommentId.essayId", cascade = CascadeType.ALL)
    private Set<EssayCommentDto> essayComments;
}
