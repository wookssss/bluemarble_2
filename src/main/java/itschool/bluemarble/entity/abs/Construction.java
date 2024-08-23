package itschool.bluemarble.entity.abs;

public abstract class Construction {
    protected int price;
    protected int toll;

    public Construction(int price) {
        this.price = price;
    }

    public Construction(int price, int toll) {
        this.price = price;
        this.toll = toll;
    }

    public void setToll(int toll) {
        this.toll = toll;
    }
}
