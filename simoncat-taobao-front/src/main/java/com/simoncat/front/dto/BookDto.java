package com.simoncat.front.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "book")
public class BookDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;
    @NonNull
    private String author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    @NonNull
    private BookTypeDto type;

    @NonNull
    private String cover;
    @NonNull
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "essayCommentId.book")
    private Set<EssayCommentDto> comments;
}
