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
@Table(name = "Book")
public class BookDto implements Serializable {

    private static final long serialVersionUID = -4652832953722967602L;

    private int id;
    private String name;
    private String author;
    private String image;
    private String content;

    @Id
    @Column(name = "id", unique = true, nullable = false, precision = 5, scale = 0)
    public int getId() {
        return id;
    }

    @Column(name = "name", nullable = false, length = 60)
    public String getName() {
        return name;
    }

    @Column(name = "author", nullable = false, length = 60)
    public String getAuthor() {
        return author;
    }

    @Column(name = "cover_img", nullable = false, length = 100)
    public String getImage() {
        return image;
    }

    @Column(name = "description", nullable = false, length = 1000)
    public String getContent() {
        return content;
    }
}
