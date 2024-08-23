package itschool.bluemarble.factory;

import itschool.bluemarble.entity.*;
import itschool.bluemarble.enumclass.Color;

import java.util.ArrayList;
import java.util.Arrays;

public class TileFactory {
    private static ArrayList<Tile> TILES = new ArrayList<Tile>();
    private static GoldenKeyTile goldenKeyTile = GoldenKeyTile.getInstance();

    static {
        TILES.addAll(Arrays.asList(
                new Tile("시작"),                                                   // index 0, Special
                new City("타이베이", 50_000),                                // index 1
                goldenKeyTile,                                                             // index 2
                new City("베이징", 80_000),                                  // index 3
                new City("마닐라", 80_000),                                  // index 4
                new SpecialCity("제주도", 200_000, 300_000),            // index 5
                new City("싱가포르", 100_000),                               // index 6
                goldenKeyTile,                                                             // index 7
                new City("카이로", 100_000),                                 // index 8
                new City("이스탄불", 120_000),                               // index 9
                new Island(),                                                              // index 10,  Special
                new City("아테네", 140_000),                                 // index 11
                goldenKeyTile,                                                             // index 12
                new City("코펜하겐", 160_000),                               // index 13
                new City("스톡홀름", 160_000),                               // index 14
                new SpecialVehicle("콩코드여객기", 200_000, 300_000),   // index 15
                new City("베른", 180_000),                                   // index 16, 전 취리히
                goldenKeyTile,                                                             // index 17
                new City("베를린", 180_000),                                 // index 18
                new City("오타와", 200_000),                                 // index 19, 전 몬트리올
                new GiveDonation(),                                                        // index 20, Special
                new City("부에노스아이레스", 220_000),                       // index 21
                goldenKeyTile,                                                             // index 22
                new City("상파울루", 240_000),                               // index 23
                new City("시드니", 240_000),                                 // index 24
                new SpecialCity("부산", 500_000, 600_000),              // index 25
                new City("하와이", 260_000),                                 // index 26
                new City("리스본", 260_000),                                 // index 27
                new SpecialVehicle("퀸엘리자베스호", 300_000, 250_000), // index 28, Vehicle
                new City("마드리드", 280_000),                               // index 29
                new City("우주여행", 0),                                     // index 30
                new City("도쿄", 300_000),                                   // index 31
                new SpecialVehicle("컬럼비아호", 450_000, 400_000),     // index 32,  Vehicle
                new City("파리", 320_000),                                   // index 33
                new City("로마", 320_000),                                   // index 34
                goldenKeyTile,                                                             // index 35
                new City("런던", 350_000),                                   // index 36
                new City("뉴욕", 350_000),                                   // index 37
                DonationParty.getInstance(),                                               // index 38,  Special
                new SpecialCity("서울", 1_000_000, 2_000_000)           // index 39
        ));
    }

    public static ArrayList<Tile> getTiles() {
        return TILES;
    }
}
