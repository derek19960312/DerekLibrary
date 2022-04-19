package com.dereklibrary.controller;

import com.dereklibrary.entity.Book;
import com.dereklibrary.generator.BookGen;
import com.dereklibrary.repo.BookRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private BookRepo bookRepo;

    private static final String url_patten_book = "/books";

    /**
     * test create
     */
    @Test
    public void createBook() throws Exception {
        Book book = BookGen.book1;
        book.setId(null);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .post(url_patten_book)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(book));

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated());
    }
    /**
     * test get
     */
    @Test
    public void getBooks() throws Exception {
        List<Book> list = new ArrayList<Book>(){{
            add(BookGen.book1);
            add(BookGen.book2);
            add(BookGen.book3);
        }};

        Mockito.when(bookRepo.findAll()).thenReturn(list);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .get(url_patten_book)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].name").value(BookGen.book3.getName()));
    }

    /**
     * test replace
     */
    @Test
    public void replaceBook() throws Exception {

        Book book = BookGen.book2;
        Mockito.when(bookRepo.save(any(Book.class))).thenReturn(book);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .put(url_patten_book)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(book));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name").value(book.getName()));
    }

    /**
     * test delete
     */
    @Test
    public void deleteBook() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
                .delete(url_patten_book + "/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }
}
