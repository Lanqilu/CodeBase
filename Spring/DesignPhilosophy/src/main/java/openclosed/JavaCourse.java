package openclosed;

/**
 * @author Halo
 * @date Created in 2020/07/30  12:55
 * @description Java课程
 */
public class JavaCourse implements ICourse {
    private Integer Id;
    private String name;
    private Double price;

    public JavaCourse(Integer Id, String name, Double price) {
        this.Id = Id;
        this.name = name;
        this.price = price;
    }


    public Integer getId() {
        return this.Id;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }
}
