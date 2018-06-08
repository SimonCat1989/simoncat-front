package com.simoncat.front.dto;

import java.io.Serializable;

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
@Table(name = "essay_comment")
@AssociationOverrides({
        @AssociationOverride(name = "essayCommentId.essay", joinColumns = @JoinColumn(name = "essay_id")),
        @AssociationOverride(name = "essayCommentId.book", joinColumns = @JoinColumn(name = "book_id")) })
public class EssayCommentDto {

    @EmbeddedId
    private EssayCommentId essayCommentId = new EssayCommentId();

    @NonNull
    private String comment;

    @Transient
    public EssayDto getEssay() {
        return this.getEssayCommentId().getEssay();
    }

    public void setEssay(EssayDto essay) {
        this.getEssayCommentId().setEssay(essay);
    }

    @Transient
    public BookDto getBook() {
        return this.getEssayCommentId().getBook();
    }

    public void setBook(BookDto book) {
        this.getEssayCommentId().setBook(book);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EssayCommentDto that = (EssayCommentDto) o;

        if (getEssayCommentId() != null ? !getEssayCommentId().equals(that.getEssayCommentId()) : that
                .getEssayCommentId() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getEssayCommentId() != null ? getEssayCommentId().hashCode() : 0);
    }

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class EssayCommentId implements Serializable {

        private static final long serialVersionUID = -3764132189941214593L;

        @ManyToOne
        private EssayDto essay;

        @ManyToOne
        private BookDto book;

        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            EssayCommentId that = (EssayCommentId) o;

            if (essay != null ? !essay.equals(that.essay) : that.essay != null)
                return false;
            if (book != null ? !book.equals(that.book) : that.book != null)
                return false;

            return true;
        }

        public int hashCode() {
            int result;
            result = (essay != null ? essay.hashCode() : 0);
            result = 31 * result + (book != null ? book.hashCode() : 0);
            return result;
        }
    }
}
