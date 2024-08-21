package itschool.bluemarble.factory;

import itschool.bluemarble.goldenKey.Goldenkey;
import itschool.bluemarble.entity.Tile;
import itschool.bluemarble.goldenKey.ifs.InstantFunction;

import java.util.ArrayList;
import java.util.Arrays;

public class GoldenKeys extends Tile {
    // 싱글톤 시작
    final private static GoldenKeys instance = new GoldenKeys();

    public static GoldenKeys getInstance() {
        return instance;
    }

    private GoldenKeys() {
        super("황금열쇠");
    }
    // 싱글톤 끝

    private ArrayList<Goldenkey> goldenKeyList = new ArrayList<>();

    // 인스턴스 초기화 블록
    {
        goldenKeyList.addAll(Arrays.asList(
                new Goldenkey("뒤로 2칸 이동", (InstantFunction) ((player) -> player.moveByRelativeValue(-2))//, // 뒤로 2칸 이동
                /*(InstantKey) ((player) -> player.moveByRelativeValue(-3)), // 뒤로 3칸 이동
                (InstantKey) ((player) -> player.moveByAbsoluteValue(39)), // 서울로 이동 황금열쇠
                // (HoldableKey) // 뭐가 있을까?
                new TollFreePassKey() // 통행료 면제*/
        )));
    }

}