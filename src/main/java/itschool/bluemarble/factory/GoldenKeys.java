package itschool.bluemarble.factory;

import itschool.bluemarble.GoldenKey.TollFreePassKey;
import itschool.bluemarble.entity.Tile;
import itschool.bluemarble.ifs.GoldenKey;
import itschool.bluemarble.ifs.InstantKey;
import itschool.bluemarble.ifs.HoldableKey;

import java.util.ArrayList;
import java.util.Arrays;

public class GoldenKeys extends Tile {
    // 싱글톤 시작
    private static GoldenKeys instance = new GoldenKeys();

    public static GoldenKeys getInstance() {
        return instance;
    }

    private GoldenKeys() {
        super("황금열쇠");
    }
    // 싱글톤 끝

    private ArrayList<GoldenKey> goldenKeyList = new ArrayList<GoldenKey>();

    // 인스턴스 초기화 블록
    {
        goldenKeyList.addAll(Arrays.asList(
                (InstantKey) ((player) -> player.moveByRelativeValue(-2)), // 뒤로 2칸 이동
                (InstantKey) ((player) -> player.moveByRelativeValue(-3)), // 뒤로 3칸 이동
                // (HoldableKey) // 뭐가 있을까?
                new TollFreePassKey() // 통행료 면제
        ));
    }

}