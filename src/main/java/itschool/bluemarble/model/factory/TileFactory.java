package itschool.bluemarble.model.factory;

import itschool.bluemarble.dao.CityDao;
import itschool.bluemarble.model.entity.goldenKey.GoldenKey;
import itschool.bluemarble.model.entity.goldenKey.GoldenKeyTile;
import itschool.bluemarble.model.entity.tile.*;
import itschool.bluemarble.model.entity.tile.abs.City;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TileFactory {
    private static ArrayList<Tile> TILES = new ArrayList<Tile>();
    private static CityDao cityDao = new CityDao();
    static {
        TILES.addAll(cityDao.selectCities());
        TILES.addAll(cityDao.selectFIxedTollCities());

        TILES.addAll(Arrays.asList(
                new Tile(0, "시작"),                      // index 0, Special

                new GoldenKeyTile(2),                                // index 2
                new GoldenKeyTile(7),                                // index 7
                new GoldenKeyTile(12),                                // index 12
                new GoldenKeyTile(17),                                // index 17
                new GoldenKeyTile(22),                                // index 22
                new GoldenKeyTile(35),                                // index 35

                new Island(10),                                 // index 10,  Special
                new SpaceTravel(),                  // index 30

                DonationParty.getInstance(),                 // index 20,  Special
                new GiveDonation()                           // index 38, Special
        ));

        TILES.sort((o1, o2) -> {
                if(o1.getIndex() > o2.getIndex()) return 1;
                else if(o1.getIndex() < o2.getIndex()) return -1;
                else return 0;
        });
    }

    public static ArrayList<Tile> getTiles() {
        return TILES;
    }
}
