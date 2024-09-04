package itschool.bluemarble.model.factory;

import itschool.bluemarble.model.entity.goldenKey.GoldenKeyTile;
import itschool.bluemarble.model.entity.tile.*;
import itschool.bluemarble.model.entity.tile.abs.City;

import java.util.ArrayList;
import java.util.Arrays;

public class TileFactory {
    private static ArrayList<Tile> TILES = new ArrayList<Tile>();
    private static GoldenKeyTile goldenKeyTile;

    static {
        goldenKeyTile = GoldenKeyTile.getInstance();

        TILES.addAll(Arrays.asList(
                new Tile("시작"),                      // index 0, Special
                new City("타이베이"),                  // index 1
                goldenKeyTile,                                // index 2
                new City("베이징"),                    // index 3
                new City("마닐라"),                    // index 4
                new FixedTollCity("제주도"),          // index 5
                new City("싱가포르"),                  // index 6
                goldenKeyTile,                                // index 7
                new City("카이로"),                    // index 8
                new City("이스탄불"),                  // index 9
                new Island(),                                 // index 10,  Special
                new City("아테네"),                    // index 11
                goldenKeyTile,                                // index 12
                new City("코펜하겐"),                  // index 13
                new City("스톡홀름"),                  // index 14
                new SpecialVehicle("콩코드여객기"),    // index 15
                new City("베른"),                      // index 16, 전 취리히
                goldenKeyTile,                                // index 17
                new City("베를린"),                    // index 18
                new City("오타와"),                    // index 19, 전 몬트리올
                new GiveDonation(),                           // index 20, Special
                new City("부에노스아이레스"),          // index 21
                goldenKeyTile,                                // index 22
                new City("상파울루"),                  // index 23
                new City("시드니"),                    // index 24
                new FixedTollCity("부산"),            // index 25
                new City("하와이"),                    // index 26
                new City("리스본"),                    // index 27
                new SpecialVehicle("퀸엘리자베스호"),  // index 28, Vehicle
                new City("마드리드"),                  // index 29
                new SpaceTravel("우주여행"),                  // index 30
                new City("도쿄"),                      // index 31
                new SpecialVehicle("컬럼비아호"),      // index 32,  Vehicle
                new City("파리"),                      // index 33
                new City("로마"),                      // index 34
                goldenKeyTile,                                // index 35
                new City("런던"),                      // index 36
                new City("뉴욕"),                      // index 37
                DonationParty.getInstance(),                  // index 38,  Special
                new FixedTollCity("서울")             // index 39
        ));
    }

    public static ArrayList<Tile> getTiles() {
        return TILES;
    }
}
