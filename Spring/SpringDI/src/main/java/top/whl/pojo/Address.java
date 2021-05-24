package top.whl.pojo;

/**
 * @Date: 2020年06月11日  22:14
 * @Description: Student类的应用对象
 **/
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
