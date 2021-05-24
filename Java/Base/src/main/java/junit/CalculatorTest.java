package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @Date : 2020/2/22  20:33
 * @Author: Halo
 * @File : CalculatorTest
 * @Version : v1.0
 * @Description: 计算测试类
 **/
public class CalculatorTest {

    //初始化方法
    @BeforeEach


    @Test
    public void testAdd() {
        //1. 创建对象
        Calculator calculator = new Calculator();
        //2. 调用方法
        int result = calculator.add(1, 2);
        //3.断言
        assertEquals(3,result);
    }

    @Test
    public void testSub() {
        //1. 创建对象
        Calculator calculator = new Calculator();
        //2. 调用方法
        int result = calculator.sub(1, 2);
        //3.断言
        assertEquals(-1,result);
    }
}
