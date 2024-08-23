/*
package itschool.bluemarble.model.entity.construction;

import itschool.bluemarble.model.entity.tile.City;
import itschool.bluemarble.model.enumclass.Color;

// 홍민경
public class Price {
    private int villa;
    private int building;
    private int hotel;

    private Price() {
    }

    private Price(int villa, int building, int hotel) {
        this.villa = villa;
        this.building = building;
        this.hotel = hotel;
    }

    private int getVilla() {
        return villa;
    }

    private int getBuilding() {
        return building;
    }

    private int getHotel() {
        return hotel;
    }

    // City의 color별 건물의 가격을 Price객체로 리턴
    // 1. 플레이어에게 도착한 지역의 건물별 가격을 안내할 때 사용 가능하다.
    // 2. getStructurePrice() 메소드 안에서 사용한다.
    public static Price getColorPrice(City city) {
        Color color = city.getColor();

        Price price = new Price();

        switch (color) {
            case PINK:
                price = new Price(50000, 150000, 250000);
                break;
            case GREEN:
                price = new Price(100000, 300000, 500000);
                break;
            case BROWN:
                price = new Price(150000, 450000, 750000);
                break;
            case NAVY:
                price = new Price(200000, 600000, 1000000);
                break;
        }

        return price;
    }

    // 지역 주인이 없을 때 건물에 따라 구매가를 리턴 (지역을 구매하지 않으면 0원 리턴)
    public static int cityPrice(City city) {
        Price price = getColorPrice(city);

        if (city.getStructure()[0]) {

            if (city.getStructure()[1]) { // 지역 + 빌라 구매가
                return city.getPrice() + price.getVilla();

            } else if (city.getStructure()[2]) { // 지역 + 빌딩 구매가
                return city.getPrice() + price.getBuilding();

            } else if (city.getStructure()[3]) { // 지역 + 호텔 구매가
                return city.getPrice() + price.getHotel();

            } else { // 지역만 구매할 때 구매가
                return city.getPrice();
            }
        }

        // 지역을 구매하지 않을 때 0원
        return 0;
    }

    // 지역 주인이 있을 때의 통행료 리턴
    public static int cityToll(City city) {
        if (city.getStructure()[0]) { // 지역 주인이 있을 때

            if (city.getStructure()[1]) { // 빌라가 있을 때
                return city.getToll()[1];

            } else if (city.getStructure()[2]) { // 빌딩이 있을 때
                return city.getToll()[2];

            } else if (city.getStructure()[3]) { // 호텔이 있을 때
                return city.getToll()[3];

            } else { // 지역만 있을 때
                return city.getToll()[0];
            }
        }
        
        // 지역 주인이 없을 때 0원
        return 0;
    }

    // 스페셜 지역 주인이 없을 때 구매가를 리턴 (스페셜 지역을 구매하지 않으면 0원 리턴)


    // 스페셜 지역 주인이 있을 때의 통행료 리턴

}
*/
