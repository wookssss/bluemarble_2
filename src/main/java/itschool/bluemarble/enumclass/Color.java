package itschool.bluemarble.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Color {
    PINK(0, 50_000, 150_000, 250_000),
    GREEN(1, 100_000, 300_000, 500_000),
    BROWN(2, 150_000, 450_000, 750_000),
    NAVY(3, 200_000, 600_000, 1_000_000);

    private int id;
    private int villaPrice;
    private int buildingPrice;
    private int hotelPrice;
}