import com.halo.entity.Books;
import com.halo.service.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author lanqilu
 * @date Created in 2020/12/19  16:08
 * @description
 */
public class Test1 {
    @Test
    public void testSpring() {
        System.out.println("hello");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService booksServiceImpl = (BooksService) context.getBean("BooksServiceImpl");
        for (Books books : booksServiceImpl.queryAllBooks()) {
            System.out.println(books);
        }
    }

}
