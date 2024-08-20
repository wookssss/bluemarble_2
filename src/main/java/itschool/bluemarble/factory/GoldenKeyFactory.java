package itschool.bluemarble.factory;

import itschool.bluemarble.ifs.GoldenKey;

import java.util.ArrayList;

public class GoldenKeyFactory {
    private static ArrayList<GoldenKey> GoldenKeyList = new ArrayList<GoldenKey>();

    static {
        GoldenKeyList.add((player) -> player.moveByRelativeValue(-2)); // 뒤로 2칸 이동

    }
}
