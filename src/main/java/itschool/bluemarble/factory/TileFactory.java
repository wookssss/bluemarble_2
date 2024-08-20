package itschool.bluemarble.factory;

import itschool.bluemarble.entity.Tile;

import java.util.ArrayList;
import java.util.Arrays;

public class TileFactory {
    private static ArrayList<Tile> cityList = new ArrayList<Tile>();
    private static GoldenKeys goldenKeys = GoldenKeys.getInstance();

    static {
        cityList.addAll(Arrays.asList(
                /*new Special("시작"), // index 0
                new City("타이베이"), // index 1
                goldenKeys, // index 2
                new City("베이징"), // index 3
                new City("마닐라"), // index 4
                new City("제주도"), // index 5
                new City("싱가포르"), // index 6
                goldenKeys, // index 7
                new City("카이로"), // index 8
                new City("이스탄불"), // index 9
                new Special("무인도"), // index 10

                new City("아테네"), // index 11
                goldenKeys, // index 12
                new City("코펜하겐"), // index 13
                new City("스톡홀름"), // index 14
                new Vehicle("콩코드여객기"), // index 15
                new City("베른"), // 전 취리히 // index 16
                goldenKeys, // index 17
                new City("베를린"), // index 18
                new City("오타와"), // 전 몬트리올 // index 19

                new Special("사회복지기금접수"), // index 20
                new City("부에노스아이레스"), // index 21
                goldenKeys, // index 22
                new City("상파울루"), // index 23
                new City("시드니"), // index 24
                new City("부산"), // index 25
                new City("하와이"), // index 26
                new City("리스본"), // index 27
                new Vehicle("퀸엘리자베스호"), // index 28
                new City("마드리드"), // index 29

                new City("우주여행"), // index 30
                new City("도쿄"), // index 31
                new Vehicle("컬럼비아호"), // index 32
                new City("파리"), // index 33
                new City("로마"), // index 34
                goldenKey, // index 35
                new City("런던"), // index 36
                new City("뉴욕"), // index 37
                new Special("사회복지기금수령"), // index 38
                new City("서울")*/ // index 39
        ));
    }
}
