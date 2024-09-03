package itschool.bluemarble.model.entity.construction;

import itschool.bluemarble.model.entity.construction.abs.Construction;

public class Building extends Construction {
    public Building(int price) {
        super(price);
    }

    @Override
    public String toString() {
        return "빌딩";
    }
}
