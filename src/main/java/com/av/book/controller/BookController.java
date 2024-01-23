package com.av.book.controller;

import com.av.book.dto.BookDto;
import com.av.book.exception.ErrorBody;
import com.av.book.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("book")
@Slf4j
public class BookController {

    @Autowired
    @Qualifier("BookService")
    private BookService bookService;

    @Operation(summary = "Получить книгу по id")
    @GetMapping(path = "/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class)))
    })
    @ResponseBody
    public BookDto getBook(@PathVariable("id") Long id){
        log.debug("getBook id={}", id);
        return bookService.getBook(id);
    }

    @Operation(summary = "Получить все книги")
    @GetMapping
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class)))
    })
    @ResponseBody
    public List<BookDto> getAllBooks(){
        log.debug("getAllBooks");
        return bookService.getAllBooks();
    }

    @Operation(summary = "Добавить книгу")
    @PostMapping
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class)))
    })
    @ResponseBody
    public BookDto addBook(@Valid @RequestBody BookDto bookDto){
        log.debug("addBook");
        return bookService.addBook(bookDto);
    }

    @Operation(summary = "Обновить книгу")
    @PutMapping
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class)))
    })
    @ResponseBody
    public BookDto updateBook(@RequestBody BookDto bookDto){
        log.debug("updateBook");
        return bookService.addBook(bookDto);
    }


    @Operation(summary = "Взять книгу")
    @PutMapping(path = "/action/take-book/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class)))
    })
    @ResponseBody
    public BookDto updateTakeBook(@PathVariable("id") Long id){
        log.debug("updateTakeBook id={}", id);
        return bookService.takeBook(id);
    }

    @Operation(summary = "Вернуть книгу")
    @PutMapping(path = "/action/return-book/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class)))
    })
    @ResponseBody
    public BookDto updateReturnBook(@PathVariable("id") Long id){
        log.debug("updateReturnBook id={}", id);
        return bookService.returnBook(id);
    }


    @Operation(summary = "Удалить книгу")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(
                    schema=@Schema(implementation = ErrorBody.class)))
    })
    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public BookDto deleteBook(@PathVariable("id") Long id){
        log.debug("deleteBook id={}", id);
        return bookService.deleteBook(id);
    }
}

