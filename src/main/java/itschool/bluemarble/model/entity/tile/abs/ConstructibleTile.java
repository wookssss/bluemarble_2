package itschool.bluemarble.model.entity.tile.abs;

import itschool.bluemarble.model.entity.construction.Building;
import itschool.bluemarble.model.entity.construction.Hotel;
import itschool.bluemarble.model.entity.construction.Villa;
import itschool.bluemarble.model.entity.construction.abs.Construction;
import itschool.bluemarble.model.enumclass.Color;

public abstract class ConstructibleTile extends PurchasableTile {

    private Construction construction = null; // 현재 건물
    
    private Villa villa;
    private Building building;
    private Hotel hotel;
    private Color color;
    
    public ConstructibleTile(String name, int price) {
        super(name, price);
    }

    // 초기화 블록
    {
        // 색깔 정의
        switch (name) {
            case "타이베이":
            case "베이징":
            case "마닐라":
            case "싱가포르":
            case "카이로":
            case "이스탄불":
                color = Color.PINK;
                break;
            case "아테네":
            case "코펜하겐":
            case "스톡홀름":
            case "베른":
            case "베를린":
            case "오타와":
                color = Color.GREEN;
                break;
            case "부에노스아이레스":
            case "상파울루":
            case "시드니":
            case "하와이":
            case "리스본":
            case "마드리드":
                color = Color.BROWN;
                break;
            case "도쿄":
            case "파리":
            case "로마":
            case "런던":
            case "뉴욕":
                color = Color.NAVY;
                break;
        }

        // 건물 가격 정의 및 객체 생성
        villa = new Villa(color.getVillaPrice());
        building = new Building(color.getBuildingPrice());
        hotel = new Hotel(color.getHotelPrice());

        // 통행료 정의
        switch (name) {
            case "타이베이":
                toll = 2000;
                villa.setToll(10_000);
                building.setToll(90_000);
                hotel.setToll(250_000);
                break;
            case "베이징":
            case "마닐라":
                toll = 4000;
                villa.setToll(20_000);
                building.setToll(180_000);
                hotel.setToll(450_000);
                break;
            case "싱가포르":
            case "카이로":
                toll = 6000;
                villa.setToll(30_000);
                building.setToll(270_000);
                hotel.setToll(550_000);
                break;
            case "이스탄불":
                toll = 8000;
                villa.setToll(40_000);
                building.setToll(300_000);
                hotel.setToll(600_000);
                break;
            case "아테네":
                toll = 10000;
                villa.setToll(50_000);
                building.setToll(450_000);
                hotel.setToll(750_000);
                break;
            case "코펜하겐":
            case "스톡홀름":
                toll = 12000;
                villa.setToll(60_000);
                building.setToll(500_000);
                hotel.setToll(900_000);
                break;
            case "베른":
            case "베를린":
                toll = 14000;
                villa.setToll(70_000);
                building.setToll(500_000);
                hotel.setToll(950_000);
                break;
            case "오타와":
                toll = 16000;
                villa.setToll(80_000);
                building.setToll(550_000);
                hotel.setToll(1_000_000);
                break;
            case "부에노스아이레스":
                toll = 18000;
                villa.setToll(90_000);
                building.setToll(700_000);
                hotel.setToll(1_050_000);
                break;
            case "상파울루":
            case "시드니":
                toll = 20000;
                villa.setToll(100_000);
                building.setToll(750_000);
                hotel.setToll(1_100_000);
                break;
            case "하와이":
            case "리스본":
                toll = 22000;
                villa.setToll(110_000);
                building.setToll(800_000);
                hotel.setToll(1_150_000);
                break;
            case "마드리드":
                toll = 24000;
                villa.setToll(120_000);
                building.setToll(850_000);
                hotel.setToll(1_200_000);
                break;
            case "도쿄":
                toll = 26000;
                villa.setToll(130_000);
                building.setToll(900_000);
                hotel.setToll(1_270_000);
                break;
            case "파리":
            case "로마":
                toll = 28000;
                villa.setToll(150_000);
                building.setToll(1_000_000);
                hotel.setToll(1_400_000);
                break;
            case "런던":
            case "뉴욕":
                toll = 35000;
                villa.setToll(170_000);
                building.setToll(1_100_000);
                hotel.setToll(1_500_000);
                break;
        }
    }
    // 건물을 산다 (이미 있는 경우에는 판 다음에 살 수 있다)

    // 건물을 판다

}