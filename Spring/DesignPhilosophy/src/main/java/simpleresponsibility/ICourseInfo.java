package simpleresponsibility;

/**
 * @author Halo
 * @date Created in 2020/07/30  13:55
 * @description
 */
public interface ICourseInfo {
    /**
     * 获取课程名
     *
     * @return CourseName
     */
    String getCourseName();

    /**
     * 获取视频
     *
     * @return 视频流
     */
    byte[] getCourseVideo();

}
