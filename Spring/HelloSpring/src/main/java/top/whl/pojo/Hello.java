package top.whl.pojo;

/**
 * @Date: 2020年06月09日  19:31
 * @Description:
 **/
public class Hello {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
