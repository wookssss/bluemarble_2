package itschool.bluemarble.factory;

import itschool.bluemarble.entity.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class TileFactory {
    private static ArrayList<Tile> cityList = new ArrayList<Tile>();
    private static GoldenKeys goldenKey = GoldenKeys.getInstance();

    static {
        cityList.addAll(Arrays.asList(
                /*new Special("시작"),
                new City("타이베이"),
                goldenKey,
                new City("베이징"),
                new City("마닐라"),
                new City("제주도"),
                new City("싱가포르"),
                goldenKey,
                new City("카이로"),
                new City("이스탄불"),
                new Special("무인도"),

                new City("아테네"),
                goldenKey,
                new City("코펜하겐"),
                new City("스톡홀름"),
                new Vehicle("콩코드여객기"),
                new City("베른"), // 전 취리히
                goldenKey,
                new City("베를린"),
                new City("오타와"), // 전 몬트리올

                new Special("사회복지기금접수"),
                new City("부에노스아이레스"),
                goldenKey,
                new City("상파울루"),
                new City("시드니"),
                new City("부산"),
                new City("하와이"),
                new City("리스본"),
                new Vehicle("퀸엘리자베스호"),
                new City("마드리드"),

                new City("우주여행"),
                new City("도쿄"),
                new Vehicle("컬럼비아호"),
                new City("파리"),
                new City("로마"),
                goldenKey,
                new City("런던"),
                new City("뉴욕"),
                new Special("사회복지기금수령"),
                new City("서울")*/
        ));
    }
}
