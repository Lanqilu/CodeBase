package top.whl.demo01;

/**
 * @Date: 2020年06月13日  20:47
 * @Description:
 **/
public class Proxy implements Rent {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        host.rent();
        fee();
        sign();
    }

    public void fee(){
        System.out.println("收小费");
    }

    public void sign(){
        System.out.println("签合同");
    }
}
