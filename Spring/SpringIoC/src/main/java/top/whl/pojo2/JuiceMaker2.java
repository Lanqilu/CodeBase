package top.whl.pojo2;

/**
 * @author Halo
 * @date Created in 2020/07/31  11:48
 * @description 被动创建对象
 */

public class JuiceMaker2 {
    private String beverageShop = null;
    private Source source = null;

    public String getBeverageShop() {
        return beverageShop;
    }

    public void setBeverageShop(String beverageShop) {
        this.beverageShop = beverageShop;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String makeJuice(){
        String juice = "这是一杯由" + beverageShop + "饮品店，提供的" + source.getSize() + source.getSugar() + source.getFruit();
        return juice;
    }
}
