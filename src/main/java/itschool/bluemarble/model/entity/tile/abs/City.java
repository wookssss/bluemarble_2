package itschool.bluemarble.model.entity.tile.abs;

import itschool.bluemarble.exception.violation.PlayerHasNoMoneyViolation;
import itschool.bluemarble.model.entity.Player;
import itschool.bluemarble.model.entity.construction.Building;
import itschool.bluemarble.model.entity.construction.Hotel;
import itschool.bluemarble.model.entity.construction.Villa;
import itschool.bluemarble.model.enumclass.Color;
import itschool.bluemarble.model.enumclass.ConstructionType;
import itschool.bluemarble.progress.GameByConsole;
import lombok.Getter;

import java.util.Scanner;

@Getter
public class City extends PurchasableTile {

    protected ConstructionType constructionType = null; // 현재 건물

    protected Villa villa = new Villa();
    protected Building building = new Building();
    protected Hotel hotel = new Hotel();
    protected Color color;
    
    // 생성자
    public City(String name) {
        super(name);
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

        /*// 건물 가격 정의 및 객체 생성
        villa = new Villa(color.getVillaPrice());
        building = new Building(color.getBuildingPrice());
        hotel = new Hotel(color.getHotelPrice());*/

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

    // isPurchasable() 메소드 실행 후 리턴값이 false 일 때 실행하는 메소드
    @Deprecated
    public void isCity(Player player) {
        Scanner sc = new Scanner(System.in);

        if(super.owner == player) {
            if(constructionType == null) {
                boolean foo1 = true;
                boolean foo2 = true;
                do {
                    System.out.println("내 땅에 도착했습니다!! 건물을 구매하시겠습니까? ( 예 : Y | 아니오 : N )");
                    String str = sc.next();
                    if(str.equals("Y") || str.equals("y")) {
                        foo1 = false;
                        do {
                            System.out.println("건설한 건물을 선택하세요. ( 빌라 : V | 빌딩 : B | 호텔 : H )");
                            str = sc.next();
                            switch (str) {
                                case "V": case "v":
                                    isVillaPrice(player);
                                    foo2 = true;
                                    break;
                                case "B": case "b":
                                    isBuildingPrice(player);
                                    foo2 = true;
                                    break;
                                case "H": case "h":
                                    isHotelPrice(player);
                                    foo2 = true;
                                    break;
                            }
                        } while (foo2);

                    } else if(str.equals("N") || str.equals("n")) {
                        foo1 = false;
                        // 건물을 구매하지 않아 반응없이 넘어감
                    }
                } while(foo1);
            } // 이미 건물이 존재하여 반응없이 넘어감
        } else {
            System.out.println(super.owner.getName() + "님 땅에 도착했습니다ㅠㅠ 통행료를 지불합니다.");
            // 통행료 지불하는 메소드
            if(constructionType == null) { // 건물이 없을 때
                player.payAmountTo(super.owner, this.toll);
            } else { // 건물이 존재할 때
                if(constructionType == ConstructionType.VILLA) {
                    player.payAmountTo(super.owner, villa.getToll());

                } else if(constructionType == ConstructionType.BUILDING) {
                    player.payAmountTo(super.owner, building.getToll());

                } else if(constructionType == ConstructionType.HOTEL) {
                    player.payAmountTo(super.owner, hotel.getToll());
                }
            }
        }
    }

    // isCity() 메소드에서 활용
    // VILLA 구매
    public void isVillaPrice(Player player) throws PlayerHasNoMoneyViolation {
        player.payAmountToBank(color.getVillaPrice());
        constructionType = ConstructionType.VILLA;
    }

    // BUILDING 구매
    public void isBuildingPrice(Player player) throws PlayerHasNoMoneyViolation {
        player.payAmountToBank(color.getBuildingPrice());
        constructionType = ConstructionType.BUILDING;
    }

    // HOTEL 구매
    public void isHotelPrice(Player player) throws PlayerHasNoMoneyViolation {
        player.payAmountToBank(color.getHotelPrice());
        constructionType = ConstructionType.HOTEL;
    }


    @Override
    public int getToll() throws RuntimeException {
        if(constructionType == ConstructionType.VILLA) {
            return villa.getToll();
        } else if(constructionType == ConstructionType.BUILDING) {
            return building.getToll();
        } else if(constructionType == ConstructionType.HOTEL) {
            return hotel.getToll();
        }

        return toll;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "(");
        sb.append((constructionType != null)? constructionType.name() + "有/" : "");
        sb.append(GameByConsole.formatWithCommas(price) + ", " + GameByConsole.formatWithCommas(toll) + ")");

        return sb.toString();
    }
}