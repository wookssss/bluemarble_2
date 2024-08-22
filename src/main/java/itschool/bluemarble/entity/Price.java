package itschool.bluemarble.entity;

import itschool.bluemarble.enumclass.Color;

// 홍민경
public class Price {
    private int villa;
    private int building;
    private int hotel;

    public Price() {}

    public Price(int villa, int building, int hotel) {
        this.villa = villa;
        this.building = hotel;
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
    // 1. 플레이어에게 도착한 지역의 건물별 가격을 안내할 때 사용 가능하다,
    // 2. getStructurePrice() 메소드 안에서 사용한다.
    public static Price getColorPrice(City city) {
        Color color = city.getColor();

        Price price = new Price();

        switch (color) {
            case PINK :
                price = new Price(50000, 150000, 250000);
                break;
            case GREEN :
                price = new Price(100000, 300000, 500000);
                break;
            case BROWN :
                price = new Price(150000, 450000, 750000);
                break;
            case NAVY :
                price = new Price(200000, 600000, 1000000);
                break;
        }

        return price;
    }

    // City의 structure[] 속 건물 여부를 확인 후 알맞은 구매가를 리턴 (지역을 구매하지 않으면 0원 리턴)
    public static int getStructurePrice(City city) {
        Price price = getColorPrice(city);

        if(city.getStructure()[0]) { // 지역을 구매하는가?
            
            if(city.getStructure()[1]) { // 지역을 구매 + 빌라를 건설하는가?
                return city.getPrice() + price.getVilla(); 

            } else if(city.getStructure()[2]) { // 지역을 구매 + 빌딩을 건설하는가?
                return city.getPrice() + price.getBuilding();

            } else if(city.getStructure()[3]) { // 지역을 구매 + 호텔을 건설하는가?
                return city.getPrice() + price.getHotel();

            } else { // 지역만 구매
                return city.getPrice();
            }
        }

        return 0;
    }
}
