package top.whl.pojo;

/**
 * @author Halo
 * @date 2020年06月09日  20:17
 * @description
 **/
public class User {
    private String name;

    public User(){
        System.out.println("User的无参构造");
    }

    public User(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name = " + name);
    }
}
