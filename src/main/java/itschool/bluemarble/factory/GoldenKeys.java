package itschool.bluemarble.factory;

import itschool.bluemarble.entity.Tile;
import itschool.bluemarble.ifs.GoldenKey;

import java.util.ArrayList;
import java.util.Arrays;

public class GoldenKeys extends Tile {
    // 싱글톤 시작
    private static GoldenKeys instance = new GoldenKeys();

    private GoldenKeys() {
        super("황금열쇠");
    }

    public static GoldenKeys getInstance() {
        return instance;
    }
    // 싱글톤 끝

    private ArrayList<GoldenKey> goldenKeyList = new ArrayList<GoldenKey>();

    {
        goldenKeyList.addAll(Arrays.asList(
                (player) -> player.moveByRelativeValue(-2), // 뒤로 2칸 이동
                (player) -> player.moveByRelativeValue(-3) // 뒤로 3칸 이동
        ));
    }
}