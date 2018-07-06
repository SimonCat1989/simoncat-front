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
@Table(name = "book_price")
public class BookPriceDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    @NonNull
    private BookSellerDto seller;
    
    @NonNull
    private String advertisement;
    
    @NonNull
    private Double price;
    
    @NonNull
    private String link;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="book_id")
    @NonNull
    private BookDto book;
}
