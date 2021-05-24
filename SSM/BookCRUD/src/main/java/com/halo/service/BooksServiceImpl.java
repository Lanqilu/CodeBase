package com.halo.service;


import com.halo.dao.BooksMapper;
import com.halo.entity.Books;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Books)表服务实现类
 *
 * @author makejava
 * @since 2020-12-19 14:16:16
 */
@Service
public class BooksServiceImpl implements BooksService {

    /**
     * service调dao层
     */
    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public int addBook(Books books) {
        return booksMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return booksMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return booksMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return booksMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBooks() {
        return booksMapper.queryAllBooks();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return booksMapper.queryBookByName(bookName);
    }
}
