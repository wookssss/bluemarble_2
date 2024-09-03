package itschool.bluemarble.model.entity.construction;

import itschool.bluemarble.model.entity.construction.abs.Construction;

public class Hotel extends Construction {
    public Hotel(int price) {
        super(price);
    }

    @Override
    public String toString() {
        return "호텔";
    }
}
