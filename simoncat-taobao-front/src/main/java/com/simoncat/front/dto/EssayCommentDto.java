package com.simoncat.front.dto;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name = "essay_comment")
@AssociationOverrides({
        @AssociationOverride(name = "essayCommentId.essayId", joinColumns = @JoinColumn(name = "essay_id")),
        @AssociationOverride(name = "essayCommentId.bookId", joinColumns = @JoinColumn(name = "book_id")) })
public class EssayCommentDto {

    @EmbeddedId
    private EssayCommentId essayCommentId;

    @NonNull
    private String comment;

    @Transient
    @NonNull
    private EssayDto essay;

    @Transient
    @NonNull
    private BookDto book;

    @Embeddable
    @Data
    @AllArgsConstructor
    static class EssayCommentId {
        
        @ManyToOne
        private EssayDto essay;
        
        @ManyToOne
        private BookDto book;
    }
}
