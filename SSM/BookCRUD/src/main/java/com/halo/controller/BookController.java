package com.halo.controller;

import com.halo.entity.Books;
import com.halo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


/**
 * @author lanqilu
 * @date Created in 2020/12/19  15:48
 * @description
 */
@Controller
@RequestMapping("/book")
public class BookController {
    /**
     * controller调service
     */
    @Autowired
    @Qualifier("BooksServiceImpl")
    private BooksService booksService;

    /**
     * 查询全部书籍,并且返回到一个书籍展示页面
     */
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> books = booksService.queryAllBooks();
        model.addAttribute("list", books);
        return "allBook";
    }

    /**
     * 跳转到增加书籍页面
     */
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    /**
     * 添加书籍的请求
     */
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println("addBook = " + books);
        booksService.addBook(books);
        return "redirect:/book/allBook";
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id, Model model) {
        Books book = booksService.queryBookById(id);
        model.addAttribute("QueryBook", book);
        return "updateBook";
    }

    /**
     * 修改书籍
     */
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println("updateBook = " + books);
        int i = booksService.updateBook(books);
        if (i > 0) {
            System.out.println("更新成功");
        }
        return "redirect:/book/allBook";
    }

    /**
     * 删除数据
     */
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id) {
        booksService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    /**
     * 查询一本书
     */
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        Books books = booksService.queryBookByName(queryBookName);
        System.out.println("查询到书籍 = " + books);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        if (books == null) {
            list = booksService.queryAllBooks();
            model.addAttribute("error", "未查到");
        }
        model.addAttribute("list", list);
        return "allBook";
    }

}
