package itschool.bluemarble.model.entity.construction.abs;

public abstract class Construction {
    protected int toll;

    public Construction() {}

    public int getToll() {
        return toll;
    }

    public void setToll(int toll) {
        this.toll = toll;
    }
}
