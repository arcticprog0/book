package com.av.book.service;

import com.av.book.dto.BookDto;
import com.av.book.entity.BookEntity;
import com.av.book.exception.EnumException;
import com.av.book.exception.ExpectedException;
import com.av.book.mapper.BookMapper;
import com.av.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("BookService")
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Transactional
    public BookDto getBook(Long id){
        Optional<BookEntity> bookEntity = bookRepository.findById(id);
        if(bookEntity.isEmpty()){
            throw new ExpectedException(404, EnumException.BOOK_NOT_FOUND.getFormattedMessage(id));
        }

        return bookMapper.toDto(bookRepository.findById(id).orElse(null));
    }

    @Transactional
    public List<BookDto> getAllBooks(){
        List<BookEntity> bookEntities = bookRepository.getAll();
        if(bookEntities.isEmpty()){
            throw new ExpectedException(EnumException.BOOKS_NOT_FOUND);
        }
        return bookMapper.mapList(bookEntities, BookDto.class);
    }

    @Transactional
    public BookDto addBook(BookDto bookDto){
        return bookMapper.toDto(bookRepository.save(bookMapper.toEntity(bookDto)));
    }

    @Transactional
    public BookDto takeBook(Long id){
        BookEntity bookEntity = bookMapper.toEntity(getBook(id));
        if(bookEntity.getAvailable()) {
            bookEntity.setAvailable(false);
        } else {
            throw new ExpectedException(404, EnumException.BOOK_NOT_AVAILABLE.getFormattedMessage(id));
        }

        return bookMapper.toDto(bookRepository.save(bookEntity));
    }

    @Transactional
    public BookDto returnBook(Long id){
        BookEntity bookEntity = bookMapper.toEntity(getBook(id));
        if(!bookEntity.getAvailable()) {
            bookEntity.setAvailable(true);
        } else {
            throw new ExpectedException(404, EnumException.BOOK_ALREADY_AVAILABLE.getFormattedMessage(id));
        }

        return bookMapper.toDto(bookRepository.save(bookEntity));
    }

    @Transactional
    public BookDto deleteBook(Long id){
        BookDto bookDto = getBook(id);
        if(bookDto == null) {
            return null;
        }
        if(!bookDto.getAvailable()){
            throw new ExpectedException(404, EnumException.BOOK_DELETE_NOT_AVAILABLE.getFormattedMessage(id));
        }

        bookRepository.delete(bookMapper.toEntity(bookDto));
        return bookDto;
    }
}

