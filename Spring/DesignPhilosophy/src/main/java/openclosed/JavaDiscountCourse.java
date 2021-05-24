package openclosed;

/**
 * @author Halo
 * @date Created in 2020/07/30  13:00
 * @description 在不改变源代码的情况下实现优惠功能
 */
public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer Id, String name, Double price) {
        super(Id, name, price);
    }
    public Double getOriginPrice(){
        return super.getPrice();
    }
    @Override
    public Double getPrice(){
        return super.getPrice() * 0.61;
    }
}
