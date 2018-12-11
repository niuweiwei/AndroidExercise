package cn.edu.hebtu.software.taobao.Bean;

public class BuyButton {
    private int imageId;
    private String name;

    public BuyButton(int item, String name) {
        this.imageId = item;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int item) {
        this.imageId = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
