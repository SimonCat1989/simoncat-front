package com.simoncat.front.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Getter
@Setter
@Entity
@Table(name = "essay")
public class EssayDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private String authorAvatar;
    @NonNull
    private Date createAt;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "essayCommentId.essay", cascade = CascadeType.ALL)
    @Setter
    private Set<EssayCommentDto> essayComments;
}
