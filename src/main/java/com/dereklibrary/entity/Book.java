package com.dereklibrary.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //1.	名稱
    private String name;
    //2.	作者
    private String author;
    //3.	譯者(可選)
    private String translator;
    //4.	ISBN
    private String isbn;
    //5.	出版商
    private String publisher;
    //6.	出版日期
    private LocalDate publicationDate;
    //7.	定價
    @PositiveOrZero(message = "Price field error!")
    private BigDecimal price;

}
