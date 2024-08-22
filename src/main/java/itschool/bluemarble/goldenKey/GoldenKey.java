package itschool.bluemarble.goldenKey;

import itschool.bluemarble.goldenKey.ifs.Function;
import lombok.Getter;

@Getter
public class GoldenKey {
    private String name;

    private Function function;

    public GoldenKey(String name, Function function) {
        this.name = name;
        this.function = function;
    }
}
