package itschool.bluemarble.entity.abs;

import itschool.bluemarble.entity.Building;
import itschool.bluemarble.entity.Hotel;
import itschool.bluemarble.entity.Villa;
import itschool.bluemarble.enumclass.Color;

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
        // 통행료 정의
        switch (name) {
            case "타이베이":
                toll = new int[]{2000, 10000, 90000, 250000};
                break;
            case "베이징":
                toll = new int[]{4000, 20000, 180000, 450000};
                break;
            case "마닐라":
                toll = new int[]{4000, 20000, 180000, 450000};
                break;
            case "싱가포르":
                toll = new int[]{6000, 30000, 270000, 550000};
                break;
            case "카이로":
                toll = new int[]{6000, 30000, 270000, 550000};
                break;
            case "이스탄불":
                toll = new int[]{8000, 40000, 300000, 600000};
                break;
            case "아테네":
                toll = new int[]{10000, 50000, 450000, 750000};
                break;
            case "코펜하겐":
                toll = new int[]{12000, 60000, 500000, 900000};
                break;
            case "스톡홀름":
                toll = new int[]{12000, 60000, 500000, 900000};
                break;
            case "베른":
                toll = new int[]{14000, 70000, 500000, 950000};
                break;
            case "베를린":
                toll = new int[]{14000, 70000, 500000, 950000};
                break;
            case "오타와":
                toll = new int[]{16000, 80000, 550000, 1000000};
                break;
            case "부에노스아이레스":
                toll = new int[]{18000, 90000, 700000, 1050000};
                break;
            case "상파울루":
                toll = new int[]{20000, 100000, 750000, 1100000};
                break;
            case "시드니":
                toll = new int[]{20000, 100000, 750000, 1100000};
                break;
            case "하와이":
                toll = new int[]{22000, 110000, 800000, 1150000};
                break;
            case "리스본":
                toll = new int[]{22000, 110000, 800000, 1150000};
                break;
            case "마드리드":
                toll = new int[]{24000, 120000, 850000, 1200000};
                break;
            case "도쿄":
                toll = new int[]{26000, 130000, 900000, 1270000};
                break;
            case "파리":
                toll = new int[]{28000, 150000, 1000000, 1400000};
                break;
            case "로마":
                toll = new int[]{28000, 150000, 1000000, 1400000};
                break;
            case "런던":
                toll = new int[]{35000, 170000, 1100000, 1500000};
                break;
            case "뉴욕":
                toll = new int[]{35000, 170000, 1100000, 1500000};
                break;
        }

        // 색깔 정의
        switch(name) {
            case "타이베이": case "베이징": case "마닐라": case "싱가포르": case "카이로": case "이스탄불":
                color = Color.PINK;
                break;
            case "아테네": case "코펜하겐": case "스톡홀름": case "베른": case "베를린": case "오타와":
                color = Color.GREEN;
                break;
            case "부에노스아이레스": case "상파울루": case "시드니": case "하와이": case "리스본": case "마드리드":
                color = Color.BROWN;
                break;
            case "도쿄": case "파리": case "로마": case "런던": case "뉴욕":
                color = Color.NAVY;
                break;
        }
    }

    // 건물을 산다 (이미 있는 경우에는 판 다음에 살 수 있다)

    // 건물을 판다

}
