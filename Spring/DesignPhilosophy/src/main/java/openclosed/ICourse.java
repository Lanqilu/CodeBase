package openclosed;

/**
 * @author Halo
 * @date Created in 2020/07/30  12:52
 * @description 课程接口
 */
public interface ICourse {
    /**
     * 获取ID
     * @return id
     */
    Integer getId();

    /**
     * 获取姓名
     * @return name
     */
    String getName();

    /**
     * 获取价格
     * @return prince
     */
    Double getPrice();

}
