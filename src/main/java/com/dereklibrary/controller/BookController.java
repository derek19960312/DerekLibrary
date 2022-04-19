package com.dereklibrary.controller;

import com.dereklibrary.entity.Book;
import com.dereklibrary.exception.InvalidRequestException;
import com.dereklibrary.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepo bookRepo;

    /**
     * 列出所有書籍
     * @return
     */
    @GetMapping()
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    /**
     * 新增一本書籍
     * @param book
     * @return
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody @Valid Book book) {
        // 先確認該id有無紀錄
        // 有 -> 回覆錯誤
        // 無 -> 新增紀錄
        if(book.getId() != null) {
            throw new InvalidRequestException("Can not create with id!");
        }
        return bookRepo.save(book);
    }

    /**
     * 刪除一本書籍
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookRepo.deleteById(id);
    }

    /**
     * 更新一本書籍資料
     * @param newBook
     * @return
     */
    @PutMapping()
    public Book replaceBook(@RequestBody Book newBook) {
        return bookRepo.save(newBook);
    }
}
