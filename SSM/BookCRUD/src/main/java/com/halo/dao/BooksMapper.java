package com.halo.dao;

import com.halo.entity.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Books)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-19 14:16:15
 */
public interface BooksMapper {

    /**
     * 新增数据,增加一本书
     *
     * @param books 实例对象
     * @return 影响行数
     */
    int addBook(Books books);

    /**
     * 通过主键删除数据,删除一本书
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteBookById(@Param("bookID") int id);

    /**
     * 修改数据,更新一本书
     *
     * @param books 实例对象
     * @return 影响行数
     */
    int updateBook(Books books);


    /**
     * 通过ID查询单条数据,查询一本书
     *
     * @param id 主键
     * @return 实例对象
     */
    Books queryBookById(@Param("bookID") int id);


    /**
     * 查询全部书
     *
     * @return 对象列表
     */
    List<Books> queryAllBooks();

    /**
     * 通过书名查找
     *
     * @param bookName 书名
     * @return Books对象
     */
    Books queryBookByName(@Param("bookName") String bookName);

}
