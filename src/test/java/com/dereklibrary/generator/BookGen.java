package com.dereklibrary.generator;

import com.dereklibrary.entity.Book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookGen {

    public List bookDatas = new ArrayList<Book>(){{
        add(book1);

    }};

    public static Book book1 = Book.builder()
            .id(1L)
            .name("哈利波特. 1, 神秘的魔法石(繁體中文版20週年紀念)")
            .author("J.K.羅琳(J. K. Rowling)")
            .isbn("9789573335566")
            .translator("彭倩文")
            .publisher("皇冠")
            .publicationDate(LocalDate.of(2020, 8, 5))
            .price(new BigDecimal(420))
            .build();

    public static Book book2 = Book.builder()
            .id(2L)
            .name("射鵰英雄傳. 1, 大漠風沙(大字版)")
            .author("金庸")
            .isbn("9789573281139")
            .translator("")
            .publisher("遠流")
            .publicationDate(LocalDate.of(2017, 10, 5))
            .price(new BigDecimal(380))
            .build();

    public static Book book3 = Book.builder()
            .id(3L)
            .name("Java程式設計寶典")
            .author("陳明")
            .isbn("9789576154706")
            .translator("")
            .publisher("經瑋文化")
            .publicationDate(LocalDate.of(2021, 6, 5))
            .price(new BigDecimal(680))
            .build();

}
